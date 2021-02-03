package com.lee.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.entity.PictureTagModel;
import com.lee.mapper.PictureTagMapper;
import com.lee.service.PictureTagService;
import org.springframework.stereotype.Service;

/**
 * Description: [图片标签表服务实现]
 * Created on 2021年02月03日
 *
 * @author <a href="mailto: wuyingya@oristartech.com">吴迎亚</a>
 * @version 1.0
 */
@Service("pictureTagService")
public class PictureTagServiceImpl extends ServiceImpl<PictureTagMapper, PictureTagModel> implements PictureTagService {

}