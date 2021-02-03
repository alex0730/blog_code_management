package com.lee.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * <p>Description: [图片标签表model]</p>
 * Created on 2021年02月03日
 *
 * @author <a href="mailto: wuyingya@oristartech.com">吴迎亚</a>
 * @version 1.0
 */
@TableName("picture_tag")
public class PictureTagModel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键Id
     */
    private Integer id;
    /**
     * 业务主键Id
     */
    private String workId;
    /**
     * 标签名称
     */
    private String tagName;
    /**
     * 标签中文名称
     */
    private String tagCnName;
    /**
     * 标签描述
     */
    private String tagDesc;
    /**
     * 标签等级
     */
    private Integer tagLevel;

    // setter and getter

    /**
     * <p>Discription:[主键Id]</p>
     * Created on 2021年02月03日
     *
     * @return Integer
     * @author:吴迎亚
     */
    public Integer getId() {
        return id;
    }

    /**
     * <p>Discription:[主键Id]</p>
     * Created on 2021年02月03日
     *
     * @author:吴迎亚
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * <p>Discription:[业务主键Id]</p>
     * Created on 2021年02月03日
     *
     * @return String
     * @author:吴迎亚
     */
    public String getWorkId() {
        return workId;
    }

    /**
     * <p>Discription:[业务主键Id]</p>
     * Created on 2021年02月03日
     *
     * @author:吴迎亚
     */
    public void setWorkId(String workId) {
        this.workId = workId;
    }

    /**
     * <p>Discription:[标签名称]</p>
     * Created on 2021年02月03日
     *
     * @return String
     * @author:吴迎亚
     */
    public String getTagName() {
        return tagName;
    }

    /**
     * <p>Discription:[标签名称]</p>
     * Created on 2021年02月03日
     *
     * @author:吴迎亚
     */
    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    /**
     * <p>Discription:[标签中文名称]</p>
     * Created on 2021年02月03日
     *
     * @return String
     * @author:吴迎亚
     */
    public String getTagCnName() {
        return tagCnName;
    }

    /**
     * <p>Discription:[标签中文名称]</p>
     * Created on 2021年02月03日
     *
     * @author:吴迎亚
     */
    public void setTagCnName(String tagCnName) {
        this.tagCnName = tagCnName;
    }

    /**
     * <p>Discription:[标签描述]</p>
     * Created on 2021年02月03日
     *
     * @return String
     * @author:吴迎亚
     */
    public String getTagDesc() {
        return tagDesc;
    }

    /**
     * <p>Discription:[标签描述]</p>
     * Created on 2021年02月03日
     *
     * @author:吴迎亚
     */
    public void setTagDesc(String tagDesc) {
        this.tagDesc = tagDesc;
    }

    /**
     * <p>Discription:[标签等级]</p>
     * Created on 2021年02月03日
     *
     * @return Integer
     * @author:吴迎亚
     */
    public Integer getTagLevel() {
        return tagLevel;
    }

    /**
     * <p>Discription:[标签等级]</p>
     * Created on 2021年02月03日
     *
     * @author:吴迎亚
     */
    public void setTagLevel(Integer tagLevel) {
        this.tagLevel = tagLevel;
    }
}
