package com.lee.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.lee.entity.PictureModel;
import com.lee.mapper.PictureMapper;
import com.lee.service.PictureService;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
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
    private FastFileStorageClient storageClient;

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
    public PictureModel uploadFile(MultipartFile file, HttpServletRequest request) {
        PictureModel result = new PictureModel();
        try {
            // 上传图片
            InputStream inputStream = file.getInputStream();
            String picUrl = storageClient.uploadFile(
                    inputStream,
                    file.getSize(),
                    FilenameUtils.getExtension(file.getOriginalFilename()),
                    null).getFullPath();
            result.setPicUrl(picUrl);
            // 上传缩略图
            File thumbnailsFile = new File(file.getOriginalFilename());
            Thumbnails.of(file.getInputStream()).size(200, 200).toFile(thumbnailsFile);
            String thumbnailUrl = storageClient.uploadFile(
                    new FileInputStream(thumbnailsFile),
                    thumbnailsFile.length(),
                    FilenameUtils.getExtension(file.getOriginalFilename()),
                    null).getFullPath();
            result.setThumbnailUrl(thumbnailUrl);
        } catch (Exception e) {
            logger.error("上传文件失败：", e);
        }
        return result;
    }

    private static void inputStreamToFile(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
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