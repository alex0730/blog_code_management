package com.lee.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Description: [数据权限表(可访问的页面、资源等)model]</p>
 * Created on 2021年02月01日
 *
 * @author <a href="mailto: wuyingya@oristartech.com">吴迎亚</a>
 * @version 1.0
 */
@TableName("menu")
public class MenuModel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键Id
     */
    private Integer id;
    /**
     * 业务主键
     */
    private String workId;
    /**
     * 中文名称
     */
    private String cnName;
    /**
     * 名称
     */
    private String name;
    /**
     * 描述
     */
    private String remark;
    /**
     * 父节点(0：为父节点)
     */
    private String parentId;
    /**
     * 父节点名称(0：为父节点)
     */
    private String parentName;

    /**
     * 菜单级别(一级菜单（父节点）：1；二级菜单：2；依次类推)
     */
    private Integer level;
    /**
     * 排序
     */
    private Integer orderId;
    /**
     * 菜单Url
     */
    private String menuUrl;
    /**
     * 菜单状态
     */
    private Integer status;
    /**
     * 子菜单
     */
    @TableField(exist = false)
    private List<MenuModel> sonMenus;

    // setter and getter


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public List<MenuModel> getSonMenus() {
        return sonMenus;
    }

    public void setSonMenus(List<MenuModel> sonMenus) {
        this.sonMenus = sonMenus;
    }

    /**
     * <p>Discription:[主键Id]</p>
     * Created on 2021年02月01日
     *
     * @return Integer
     * @author:吴迎亚
     */
    public Integer getId() {
        return id;
    }

    /**
     * <p>Discription:[主键Id]</p>
     * Created on 2021年02月01日
     *
     * @author:吴迎亚
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * <p>Discription:[业务主键]</p>
     * Created on 2021年02月01日
     *
     * @return String
     * @author:吴迎亚
     */
    public String getWorkId() {
        return workId;
    }

    /**
     * <p>Discription:[业务主键]</p>
     * Created on 2021年02月01日
     *
     * @author:吴迎亚
     */
    public void setWorkId(String workId) {
        this.workId = workId;
    }

    /**
     * <p>Discription:[中文名称]</p>
     * Created on 2021年02月01日
     *
     * @return String
     * @author:吴迎亚
     */
    public String getCnName() {
        return cnName;
    }

    /**
     * <p>Discription:[中文名称]</p>
     * Created on 2021年02月01日
     *
     * @author:吴迎亚
     */
    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    /**
     * <p>Discription:[名称]</p>
     * Created on 2021年02月01日
     *
     * @return String
     * @author:吴迎亚
     */
    public String getName() {
        return name;
    }

    /**
     * <p>Discription:[名称]</p>
     * Created on 2021年02月01日
     *
     * @author:吴迎亚
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * <p>Discription:[描述]</p>
     * Created on 2021年02月01日
     *
     * @return String
     * @author:吴迎亚
     */
    public String getRemark() {
        return remark;
    }

    /**
     * <p>Discription:[描述]</p>
     * Created on 2021年02月01日
     *
     * @author:吴迎亚
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * <p>Discription:[父节点(0：为父节点)]</p>
     * Created on 2021年02月01日
     *
     * @return String
     * @author:吴迎亚
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * <p>Discription:[父节点(0：为父节点)]</p>
     * Created on 2021年02月01日
     *
     * @author:吴迎亚
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}
