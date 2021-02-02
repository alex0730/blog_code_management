package com.lee.entity;

import java.io.Serializable;
/** 
 * <p>Description: [用户角色关系表model]</p>
 * Created on 2021年02月01日
 * @author  <a href="mailto: wuyingya@oristartech.com">吴迎亚</a>
 * @version 1.0
 */
public class AdminRoleModel  implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
     * 主键
     */
	private Integer id;
	/**
     * role表业务主键
     */
	private String roleWorkId;
	/**
     * admin表主键
     */
	private Integer adminId;
	
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
	* <p>Discription:[role表业务主键]</p>
	* Created on 2021年02月01日
	* @return String
    * @author:吴迎亚
    */
	public String getRoleWorkId(){
		return roleWorkId;
	}
	/**
	* <p>Discription:[role表业务主键]</p>
	* Created on 2021年02月01日
	* @author:吴迎亚
	*/
	public void setRoleWorkId(String roleWorkId){
		this.roleWorkId = roleWorkId;
	}
	/**
	* <p>Discription:[admin表主键]</p>
	* Created on 2021年02月01日
	* @return Integer
    * @author:吴迎亚
    */
	public Integer getAdminId(){
		return adminId;
	}
	/**
	* <p>Discription:[admin表主键]</p>
	* Created on 2021年02月01日
	* @author:吴迎亚
	*/
	public void setAdminId(Integer adminId){
		this.adminId = adminId;
	}
}
