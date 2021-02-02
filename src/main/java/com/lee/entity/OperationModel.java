package com.lee.entity;

import java.io.Serializable;
/** 
 * <p>Description: [数据操作权限表(对数据或资源的增删改查等)model]</p>
 * Created on 2021年02月01日
 * @author  <a href="mailto: wuyingya@oristartech.com">吴迎亚</a>
 * @version 1.0
 */
public class OperationModel  implements Serializable {

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
	* <p>Discription:[中文名称]</p>
	* Created on 2021年02月01日
	* @return String
    * @author:吴迎亚
    */
	public String getCnName(){
		return cnName;
	}
	/**
	* <p>Discription:[中文名称]</p>
	* Created on 2021年02月01日
	* @author:吴迎亚
	*/
	public void setCnName(String cnName){
		this.cnName = cnName;
	}
	/**
	* <p>Discription:[名称]</p>
	* Created on 2021年02月01日
	* @return String
    * @author:吴迎亚
    */
	public String getName(){
		return name;
	}
	/**
	* <p>Discription:[名称]</p>
	* Created on 2021年02月01日
	* @author:吴迎亚
	*/
	public void setName(String name){
		this.name = name;
	}
	/**
	* <p>Discription:[描述]</p>
	* Created on 2021年02月01日
	* @return String
    * @author:吴迎亚
    */
	public String getRemark(){
		return remark;
	}
	/**
	* <p>Discription:[描述]</p>
	* Created on 2021年02月01日
	* @author:吴迎亚
	*/
	public void setRemark(String remark){
		this.remark = remark;
	}
}
