package com.lee.controller.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description [菜单管理控制类]
 * @Author <a href="mailto: wuyingya@oristartech.com">吴迎亚</a>
 * @Date 2021/2/8 16:18
 **/
@Controller
@RequestMapping("/admin/interview")
public class InterviewController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

//    @Autowired
//    private MenuService menuService;

    @GetMapping("list")
    public String list() {
        return "admin/interview/list";
    }

    @GetMapping("begin")
    public String begin() {
        return "admin/interview/begin";
    }
//
//    /**
//     * 保存菜单信息
//     *
//     * @param request
//     * @return
//     */
//    @PostMapping("add")
//    @ResponseBody
//    public Message doAdd(@Validated MenuModel menuModel, HttpServletRequest request) {
//        try {
//            menuService.save(menuModel);
//        } catch (Exception e) {
//            logger.error("保存菜单信息异常：", e);
//            return Message.fail("保存失败！");
//        }
//        return Message.success("保存成功！");
//    }
//
//    /**
//     * 跳转新建图片页面
//     *
//     * @return
//     */
//    @GetMapping("add")
//    public String add(Model model) {
//        QueryWrapper<MenuModel> queryWrapper = new QueryWrapper();
//        queryWrapper.eq("parent_id", "0");
//        model.addAttribute("parentIds", menuService.list(queryWrapper));
//        return "admin/menu/add";
//    }
//
//    @PostMapping("/update")
//    @ResponseBody
//    public Message doUpdate(@Validated MenuModel model) {
//        try {
//            menuService.updateById(model);
//        } catch (Exception e) {
//            logger.error("菜单修改保存异常：", e);
//            return Message.fail("菜单修改保存异常，操作失败！");
//        }
//        return Message.success("菜单修改成功!");
//    }
//
//    @GetMapping("update/{id}")
//    public String update(@PathVariable Integer id, Model model) {
//        MenuModel menuModel = menuService.getById(id);
//        if (menuModel != null) {
//            model.addAttribute("menuModel", menuModel);
//        }
//        QueryWrapper<MenuModel> queryWrapper = new QueryWrapper();
//        queryWrapper.eq("parent_id", "0");
//        model.addAttribute("parentIds", menuService.list(queryWrapper));
//        return "admin/menu/update";
//    }
//
//    @PostMapping("/use")
//    @ResponseBody
//    public Message doUse(Integer id, Boolean flag) {
//        int status = 1;
//        try {
//            MenuModel menuModel = new MenuModel();
//            menuModel.setId(id);
//            if (flag) {
//                status = 0;
//            }
//            menuModel.setStatus(status);
//            menuService.updateById(menuModel);
//        } catch (Exception e) {
//            logger.error("菜单修改异常：", e);
//            return Message.fail("菜单状态修改失败！");
//        }
//        return Message.success("修改成功！");
//    }
//
//
//    /**
//     * 分页查询菜单列表
//     *
//     * @param jsonObject
//     * @return
//     */
//    @PostMapping("findList")
//    @ResponseBody
//    public DataGrid findList(@RequestBody JSONObject jsonObject) {
//        DataGrid result = new DataGrid();
//        try {
//            Map<String, Object> searchParams = (HashMap<String, Object>) jsonObject.get("search");
//            IPage<Map<String, Object>> page = menuService.getPageInfo(searchParams,
//                    StringUtils.isEmpty(jsonObject.getString("offset")) ? 0 : jsonObject.getIntValue("offset"),
//                    StringUtils.isEmpty(jsonObject.getString("limit")) ? 5 : jsonObject.getIntValue("limit"));
//            result.setTotal(page.getTotal());
//            result.setRows(page.getRecords());
//        } catch (Exception e) {
//            logger.error("分页查询菜单列表异常：", e);
//        }
//        return result;
//    }

}
