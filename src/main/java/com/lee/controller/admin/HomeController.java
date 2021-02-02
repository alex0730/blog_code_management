package com.lee.controller.admin;

import com.lee.service.ArticleService;
import com.lee.service.CommentService;
import com.lee.service.MemberService;
import com.lee.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

@Controller
@RequestMapping("/admin")
public class HomeController {

    private static final Logger logger = Logger.getLogger(HomeController.class.getName());

    @Autowired
    MemberService memberService;
    @Autowired
    ArticleService articleService;
    @Autowired
    CommentService commentService;
    @Autowired
    MenuService menuService;

    @RequestMapping("home")
    public String home(HttpServletRequest request, Model model) {
        try {
            // TODO https://blog.csdn.net/tianhongqiang/article/details/51016261
            model.addAttribute("menuList", request.getSession().getAttribute("menuList"));
            // 获取菜单权限
            // 获取操作权限
            int memberCount = memberService.count();
            int articleCount = articleService.count();
            int commentCount = commentService.count();
            model.addAttribute("memberCount", memberCount);
            model.addAttribute("articleCount", articleCount);
            model.addAttribute("commentCount", commentCount);
        } catch (Exception e) {
            return "跳转首页异常：" + e.getMessage();
        }
        return "admin/home";
    }

    /**
     * 退出管理
     *
     * @return
     */
    @RequestMapping("logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("admin");
        if (request.getSession().getAttribute("admin") != null) {
            //ToDO session清空失败，可以跳转到退出失败页面
        }
//        return "redirect:/admin/login";
        return "admin/login";
    }
}
