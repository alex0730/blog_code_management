package com.lee.service;

import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.Map;

/**
 * Description: [图片管理表服务]
 * Created on 2021年02月02日
 *
 * @author <a href="mailto: wuyingya@oristartech.com">吴迎亚</a>
 * @version 1.0
 */
public interface PictureService {
    
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
