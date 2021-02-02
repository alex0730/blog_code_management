package com.lee.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lee.entity.MenuModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>Description: [数据权限表(可访问的页面、资源等)dao]</p>
 * Created on 2021年02月01日
 *
 * @author <a href="mailto: wuyingya@oristartech.com">吴迎亚</a>
 * @version 1.0
 */
@Component
public interface MenuMapper extends BaseMapper<MenuModel> {

    List<MenuModel> queryMenuByUserName(@Param("username") String userName);

}
