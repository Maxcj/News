package cn.zcj.examOnline.pojo;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

/**
 * cmenu
 * @author otom3
 * @date 2018-04-10
 */
 @Table("cmenu")
public class Cmenu  {
	/**
	 * cmenu
	 */
	 @Id
	private java.lang.Integer id;//栏目id
	 @Column
	private java.lang.Integer pid;//指定父类id
	 @Column
	private java.lang.String name;//栏目名称
	 @Column
	private java.lang.String url;//链接
	 @Column
	private java.lang.String permission;//权限标识
	public java.lang.Integer getId(){
		return this.id;
	}
	public void setId(java.lang.Integer id){
		this.id	= id;
	}
	public java.lang.Integer getPid(){
		return this.pid;
	}
	public void setPid(java.lang.Integer pid){
		this.pid	= pid;
	}
	public java.lang.String getName(){
		return this.name;
	}
	public void setName(java.lang.String name){
		this.name	= name;
	}
	public java.lang.String getUrl(){
		return this.url;
	}
	public void setUrl(java.lang.String url){
		this.url	= url;
	}
	public java.lang.String getPermission(){
		return this.permission;
	}
	public void setPermission(java.lang.String permission){
		this.permission	= permission;
	}
}