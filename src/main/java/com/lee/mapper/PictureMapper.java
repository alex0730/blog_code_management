package com.lee.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lee.entity.PictureModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * <p>Description: [图片管理表dao]</p>
 * Created on 2021年02月02日
 *
 * @author <a href="mailto: wuyingya@oristartech.com">吴迎亚</a>
 * @version 1.0
 */
@Component
public interface PictureMapper extends BaseMapper<PictureModel> {

    List<Map<String, Object>> selectPictureModel(@Param("title") String title, @Param("tagCnName") String tagCnName,
                                                 @Param("pageNo") int pageNo, @Param("pageSize") int pageSize);

    int selectPictureModelCount(@Param("title") String title, @Param("tagCnName") String tagCnName);

}
