package com.lee.entity;

import java.io.Serializable;
/** 
 * <p>Description: [角色操作权限关系表（对数据或资源的增删改查等）model]</p>
 * Created on 2021年02月01日
 * @author  <a href="mailto: wuyingya@oristartech.com">吴迎亚</a>
 * @version 1.0
 */
public class RoleOperationModel  implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
     * 主键Id
     */
	private Integer id;
	/**
     * role表业务主键
     */
	private String roleWorkId;
	/**
     * menu表业务住家
     */
	private String operationWorkId;
	/**
     * 角色操作权限关系(0：启用；1：停用；默认：0)
     */
	private Integer roleOperationStatus;
	
	// setter and getter
	/**
	* <p>Discription:[主键Id]</p>
	* Created on 2021年02月01日
	* @return Integer
    * @author:吴迎亚
    */
	public Integer getId(){
		return id;
	}
	/**
	* <p>Discription:[主键Id]</p>
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
	* <p>Discription:[menu表业务住家]</p>
	* Created on 2021年02月01日
	* @return String
    * @author:吴迎亚
    */
	public String getOperationWorkId(){
		return operationWorkId;
	}
	/**
	* <p>Discription:[menu表业务住家]</p>
	* Created on 2021年02月01日
	* @author:吴迎亚
	*/
	public void setOperationWorkId(String operationWorkId){
		this.operationWorkId = operationWorkId;
	}
	/**
	* <p>Discription:[角色操作权限关系(0：启用；1：停用；默认：0)]</p>
	* Created on 2021年02月01日
	* @return Integer
    * @author:吴迎亚
    */
	public Integer getRoleOperationStatus(){
		return roleOperationStatus;
	}
	/**
	* <p>Discription:[角色操作权限关系(0：启用；1：停用；默认：0)]</p>
	* Created on 2021年02月01日
	* @author:吴迎亚
	*/
	public void setRoleOperationStatus(Integer roleOperationStatus){
		this.roleOperationStatus = roleOperationStatus;
	}
}
