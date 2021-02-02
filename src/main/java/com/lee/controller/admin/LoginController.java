package com.lee.controller.admin;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.lee.common.Message;
import com.lee.entity.Admin;
import com.lee.entity.MenuModel;
import com.lee.service.AdminService;
import com.lee.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @Description [登录控制器]
 * @Author <a href="mailto: wuyingya@oristartech.com">吴迎亚</a>
 * @Date 2021/2/2 9:24
 **/
@Controller
@RequestMapping("/admin")
public class LoginController extends BasicController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AdminService sbAdminService;

    @Autowired
    private MenuService menuService;

    @GetMapping("login")
    public String login() {
        return "admin/login";
    }

    @PostMapping("/login")
    @ResponseBody
    public Message doLogin(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request) {
        Admin sbadmin = null;
        try {
            if (StringUtils.isEmpty(username)) {
                return Message.fail("用户名不能为空");
            }
            if (StringUtils.isEmpty(password)) {
                return Message.fail("密码不能为空");
            }
            sbadmin = sbAdminService.getInfoByUsernameAndPassword(username, password);
            if (sbadmin == null) {
                return Message.fail("用户不存在或用户名密码错误");
            }
            if (!sbadmin.getStatus().equals(0)) {
                return Message.fail("该账号已被禁用!");
            }
            request.getSession().setAttribute("admin", sbadmin);
            List<MenuModel> menuModels = menuService.queryMenuByUserName(username);
            if (CollectionUtils.isEmpty(menuModels)) {
                logger.info("用户名：{}数据权限为空", username);
            }
            request.getSession().setAttribute("menuList", getMenuModels(menuModels));
        } catch (Exception e) {
            logger.error("登录异常：", e);
            return Message.fail("登录异常");
        }
        return Message.success("登录成功!", sbadmin, "/admin/home");
    }

    /**
     * 递归遍历数据权限列表组装数据权限菜单
     *
     * @param models 数据权限列表
     * @return
     */
    private List<MenuModel> getMenuModels(List<MenuModel> models) {
        if (CollectionUtils.isEmpty(models)) {
            return new ArrayList<>();
        }
        try {
            // 将List装换为Map，key为父节点Id，value为菜单对象
            Multimap<String, MenuModel> typeMultimap = ArrayListMultimap.create(); //使用google guava 包 对以获取的分类按照父类Id进行组装
            for (int i = 0; i < models.size(); i++) {
                typeMultimap.put(models.get(i).getParentId(), models.get(i));
            }
            for (MenuModel model : models) {
                String workId = model.getWorkId();
                if (CollectionUtils.isEmpty(typeMultimap.get(workId))) {
                    continue;
                }
                Collection<MenuModel> trList = typeMultimap.get(workId);
                List<MenuModel> list = new ArrayList();
                for (Iterator<MenuModel> iterator = trList.iterator(); iterator.hasNext(); ) {
                    list.add(iterator.next());
                }
                model.setSonMenus(list);
            }
            for (Iterator<MenuModel> menuModelIterator = models.iterator(); menuModelIterator.hasNext(); ) {
                MenuModel model = menuModelIterator.next();
                if (!StringUtils.isEmpty(model.getParentId())
                        && !model.getParentId().equals("0")) {
                    menuModelIterator.remove();
                }
            }
        } catch (Exception e) {
            logger.error("递归遍历数据权限列表组装数据权限菜单异常：", e);
        }
        return models;
    }

}
