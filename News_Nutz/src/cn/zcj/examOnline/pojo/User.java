package cn.zcj.examOnline.pojo;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

/**
 * 存储用户信息表
 * @author 15436303 May丶乘剑
 * @date 2018-03-15
 */
 @Table("user")
public class User  {
	/**
	 * 存储用户信息表
	 */
	 @Name
	private java.lang.String uid;//学号
	 @Column
	private java.lang.String xm;//姓名
	 @Column
	private java.lang.String pwd;//密码
	 @Column
	private java.lang.String bj;//班级
	 @Column
	private java.lang.String role;//角色
	public java.lang.String getUid(){
		return this.uid;
	}
	public void setUid(java.lang.String uid){
		this.uid	= uid;
	}
	public java.lang.String getXm(){
		return this.xm;
	}
	public void setXm(java.lang.String xm){
		this.xm	= xm;
	}
	public java.lang.String getPwd(){
		return this.pwd;
	}
	public void setPwd(java.lang.String pwd){
		this.pwd	= pwd;
	}
	public java.lang.String getBj(){
		return this.bj;
	}
	public void setBj(java.lang.String bj){
		this.bj	= bj;
	}
	public java.lang.String getRole(){
		return this.role;
	}
	public void setRole(java.lang.String role){
		this.role	= role;
	}
}