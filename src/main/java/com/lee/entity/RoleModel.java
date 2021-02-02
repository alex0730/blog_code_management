package com.lee.entity;

import java.io.Serializable;
/** 
 * <p>Description: [角色表model]</p>
 * Created on 2021年02月01日
 * @author  <a href="mailto: wuyingya@oristartech.com">吴迎亚</a>
 * @version 1.0
 */
public class RoleModel  implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
     * 主键
     */
	private Integer id;
	/**
     * 业务主键
     */
	private String workId;
	/**
     * 角色名称
     */
	private String roleName;
	/**
     * 角色状态(0：未激活；1：已激活)
     */
	private Integer roleStatus;
	
	// setter and getter
	/**
	* <p>Discription:[主键]</p>
	* Created on 2021年02月01日
	* @return Integer
    * @author:吴迎亚
    */
	public Integer getId(){
		return id;
	}
	/**
	* <p>Discription:[主键]</p>
	* Created on 2021年02月01日
	* @author:吴迎亚
	*/
	public void setId(Integer id){
		this.id = id;
	}
	/**
	* <p>Discription:[业务主键]</p>
	* Created on 2021年02月01日
	* @return String
    * @author:吴迎亚
    */
	public String getWorkId(){
		return workId;
	}
	/**
	* <p>Discription:[业务主键]</p>
	* Created on 2021年02月01日
	* @author:吴迎亚
	*/
	public void setWorkId(String workId){
		this.workId = workId;
	}
	/**
	* <p>Discription:[角色名称]</p>
	* Created on 2021年02月01日
	* @return String
    * @author:吴迎亚
    */
	public String getRoleName(){
		return roleName;
	}
	/**
	* <p>Discription:[角色名称]</p>
	* Created on 2021年02月01日
	* @author:吴迎亚
	*/
	public void setRoleName(String roleName){
		this.roleName = roleName;
	}
	/**
	* <p>Discription:[角色状态(0：未激活；1：已激活)]</p>
	* Created on 2021年02月01日
	* @return Integer
    * @author:吴迎亚
    */
	public Integer getRoleStatus(){
		return roleStatus;
	}
	/**
	* <p>Discription:[角色状态(0：未激活；1：已激活)]</p>
	* Created on 2021年02月01日
	* @author:吴迎亚
	*/
	public void setRoleStatus(Integer roleStatus){
		this.roleStatus = roleStatus;
	}
}
