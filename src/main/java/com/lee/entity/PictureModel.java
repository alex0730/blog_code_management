package com.lee.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * <p>Description: [图片管理表model]</p>
 * Created on 2021年02月02日
 *
 * @author <a href="mailto: wuyingya@oristartech.com">吴迎亚</a>
 * @version 1.0
 */
@TableName("picture")
public class PictureModel extends Model<PictureModel> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer id;
    /**
     * 标题
     */
    private String title;
    /**
     * 描述 （时间、地点、人物等等）
     */
    private String instructions;
    /**
     * 标签（可用于分类）
     */
    private String tags;
    /**
     * 备注
     */
    private String remark;
    /**
     * 是否推荐(0：不推荐；1：推荐；默认：0)
     */
    private Integer isRecommend;
    /**
     * 创建人（admin表主键Id）
     */
    private Integer adminId;
    /**
     * 浏览次数
     */
    private Integer viewNum;
    /**
     * 评论次数
     */
    private Integer commentNum;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 图片地址
     */
    private String picUrl;
    /**
     * 缩略图地址
     */
    private String thumbnailUrl;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 更新时间
     */
    private String updateTime;

    // setter and getter


    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * <p>Discription:[主键]</p>
     * Created on 2021年02月02日
     *
     * @return Integer
     * @author:吴迎亚
     */
    public Integer getId() {
        return id;
    }

    /**
     * <p>Discription:[主键]</p>
     * Created on 2021年02月02日
     *
     * @author:吴迎亚
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * <p>Discription:[标题]</p>
     * Created on 2021年02月02日
     *
     * @return String
     * @author:吴迎亚
     */
    public String getTitle() {
        return title;
    }

    /**
     * <p>Discription:[标题]</p>
     * Created on 2021年02月02日
     *
     * @author:吴迎亚
     */
    public void setTitle(String title) {
        this.title = title;
    }


    /**
     * <p>Discription:[标签（可用于分类）]</p>
     * Created on 2021年02月02日
     *
     * @return String
     * @author:吴迎亚
     */
    public String getTags() {
        return tags;
    }

    /**
     * <p>Discription:[标签（可用于分类）]</p>
     * Created on 2021年02月02日
     *
     * @author:吴迎亚
     */
    public void setTags(String tags) {
        this.tags = tags;
    }

    /**
     * <p>Discription:[备注]</p>
     * Created on 2021年02月02日
     *
     * @return String
     * @author:吴迎亚
     */
    public String getRemark() {
        return remark;
    }

    /**
     * <p>Discription:[备注]</p>
     * Created on 2021年02月02日
     *
     * @author:吴迎亚
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * <p>Discription:[是否推荐(0：不推荐；1：推荐；默认：0)]</p>
     * Created on 2021年02月02日
     *
     * @return Integer
     * @author:吴迎亚
     */
    public Integer getIsRecommend() {
        return isRecommend;
    }

    /**
     * <p>Discription:[是否推荐(0：不推荐；1：推荐；默认：0)]</p>
     * Created on 2021年02月02日
     *
     * @author:吴迎亚
     */
    public void setIsRecommend(Integer isRecommend) {
        this.isRecommend = isRecommend;
    }

    /**
     * <p>Discription:[创建人（admin表主键Id）]</p>
     * Created on 2021年02月02日
     *
     * @return Integer
     * @author:吴迎亚
     */
    public Integer getAdminId() {
        return adminId;
    }

    /**
     * <p>Discription:[创建人（admin表主键Id）]</p>
     * Created on 2021年02月02日
     *
     * @author:吴迎亚
     */
    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    /**
     * <p>Discription:[浏览次数]</p>
     * Created on 2021年02月02日
     *
     * @return Integer
     * @author:吴迎亚
     */
    public Integer getViewNum() {
        return viewNum;
    }

    /**
     * <p>Discription:[浏览次数]</p>
     * Created on 2021年02月02日
     *
     * @author:吴迎亚
     */
    public void setViewNum(Integer viewNum) {
        this.viewNum = viewNum;
    }

    /**
     * <p>Discription:[评论次数]</p>
     * Created on 2021年02月02日
     *
     * @return Integer
     * @author:吴迎亚
     */
    public Integer getCommentNum() {
        return commentNum;
    }

    /**
     * <p>Discription:[评论次数]</p>
     * Created on 2021年02月02日
     *
     * @author:吴迎亚
     */
    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

}
