package com.lee.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.entity.MenuModel;
import com.lee.mapper.MenuMapper;
import com.lee.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description [菜单权限服务实现类]
 * @Author <a href="mailto: wuyingya@oristartech.com">吴迎亚</a>
 * @Date 2021/2/1 16:19
 **/
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, MenuModel> implements MenuService {

    @Autowired
    MenuMapper menuMapper;

    @Override
    public List<MenuModel> queryMenuByUserName(String userName) {
        List<MenuModel> result = new ArrayList<>();
        try {
            result = menuMapper.queryMenuByUserName(userName);
        } catch (Exception e) {
        }
        return result;
    }
}
