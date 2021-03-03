package com.lee.service.impl;

import com.alibaba.druid.support.json.JSONUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.entity.MenuModel;
import com.lee.mapper.MenuMapper;
import com.lee.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description [菜单权限服务实现类]
 * @Author <a href="mailto: wuyingya@oristartech.com">吴迎亚</a>
 * @Date 2021/2/1 16:19
 **/
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, MenuModel> implements MenuService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<MenuModel> queryMenuByUserName(String userName) {
        List<MenuModel> result = new ArrayList<>();
        try {
            result = menuMapper.queryMenuByUserName(userName);
            logger.info("菜单权限" + JSONUtils.toJSONString(result));
        } catch (Exception e) {
        }
        return result;
    }

    @Override
    public IPage<Map<String, Object>> getPageInfo(Map<String, Object> queryParam, int offset, int size) {
        IPage<Map<String, Object>> mapIpage = new Page<>();
        try {
            QueryWrapper<MenuModel> queryWrapper = new QueryWrapper<>();
            if (queryParam.get("cn_name") != null) {
                queryWrapper.like("cn_name", queryParam.get("cn_name"));
            }
            if (queryParam.get("status") != null) {
                queryWrapper.eq("status", queryParam.get("status"));
            }
            queryWrapper.orderByDesc("order_id");
            Page<MenuModel> page = new Page<>(offset / size + 1, size);
            mapIpage = menuMapper.selectMapsPage(page, queryWrapper);
        } catch (Exception e) {
            logger.error("分页菜单列表异常：", e);
        }
        return mapIpage;
    }

}
