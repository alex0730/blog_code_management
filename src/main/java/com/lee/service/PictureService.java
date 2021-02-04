package com.lee.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lee.entity.PictureModel;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 * Description: [图片管理表服务]
 * Created on 2021年02月02日
 *
 * @author <a href="mailto: wuyingya@oristartech.com">吴迎亚</a>
 * @version 1.0
 */
public interface PictureService extends IService<PictureModel> {

    /**
     * 分页查询图片列表
     *
     * @param queryParam
     * @param offset
     * @param size
     * @return
     */
    IPage<Map<String, Object>> getPageInfo(Map<String, Object> queryParam, int offset, int size);

    /**
     * 文件上传
     *
     * @param file
     * @param request
     * @return
     */
    PictureModel uploadFile(MultipartFile file, HttpServletRequest request) throws IOException;


}
