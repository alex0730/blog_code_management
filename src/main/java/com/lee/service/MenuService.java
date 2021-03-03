package com.lee.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lee.entity.MenuModel;

import java.util.List;
import java.util.Map;

/**
 * Description: [数据权限表(可访问的页面、资源等)服务]
 * Created on 2021年02月01日
 *
 * @author <a href="mailto: wuyingya@oristartech.com">吴迎亚</a>
 * @version 1.0
 */
public interface MenuService extends IService<MenuModel> {

    List<MenuModel> queryMenuByUserName(String userName);

    /**
     * 分页查询图片列表
     *
     * @param queryParam
     * @param offset
     * @param size
     * @return
     */
    IPage<Map<String, Object>> getPageInfo(Map<String, Object> queryParam, int offset, int size);

}
