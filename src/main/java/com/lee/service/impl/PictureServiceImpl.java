package com.lee.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.entity.PictureModel;
import com.lee.mapper.PictureMapper;
import com.lee.service.PictureService;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Map;

/**
 * Description: [图片管理表服务实现]
 * Created on 2021年02月02日
 *
 * @author <a href="mailto: wuyingya@oristartech.com">吴迎亚</a>
 * @version 1.0
 */
@Service
public class PictureServiceImpl extends ServiceImpl<PictureMapper, PictureModel> implements PictureService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final String filePath = "E:/blog_code_management/src/main/resources/static/admin/images";

    @Autowired
    private PictureMapper pictureMapper;

    /**
     * 文件上传方法
     *
     * @param file
     * @param request
     * @return
     */
    @Override
    public String uploadFile(MultipartFile file, HttpServletRequest request) {
        String imgFilePath = "";
        try {
            // TODO 根据“图片标签”表确定上传到哪个文件夹下
            imgFilePath = "/shanghai/" + file.getOriginalFilename();
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File(filePath + imgFilePath));
        } catch (Exception e) {
            logger.error("上传文件失败：", e);
        }
        return imgFilePath;
    }

    /**
     * 分页查询图片列表
     *
     * @param queryParam
     * @param offset
     * @param size
     * @return
     */
    @Override
    public IPage<Map<String, Object>> getPageInfo(Map<String, Object> queryParam, int offset, int size) {
        IPage<Map<String, Object>> mapIpage = new Page<>();
        try {
            QueryWrapper<PictureModel> queryWrapper = new QueryWrapper<>();
            if (queryParam.get("title") != null) {
                queryWrapper.like("title", queryParam.get("title"));
            }
            queryWrapper.orderByDesc("sort", "create_time");
            Page<PictureModel> page = new Page<>(offset / size + 1, size);
            mapIpage = pictureMapper.selectMapsPage(page, queryWrapper);
        } catch (Exception e) {
            logger.error("分页查询图片列表异常：", e);
        }
        return mapIpage;
    }
}