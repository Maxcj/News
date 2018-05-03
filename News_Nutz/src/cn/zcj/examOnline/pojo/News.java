package cn.zcj.examOnline.pojo;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;


/**
 * news
 * @author otom3
 * @date 2018-04-03
 */
 @Table("news")
public class News  {
	/**
	 * news
	 */
	 @Id
	private java.lang.Integer id;//新闻id
	 @Column
	private java.lang.String title;//标题
	 @Column
	private java.lang.String content;//内容
	 @Column
	private java.util.Date date;//发布时间
	 @Column
	private java.lang.String cruser;//创建人
	 @Column
	private java.lang.Integer hitnum;//点击量
	public java.lang.Integer getId(){
		return this.id;
	}
	public void setId(java.lang.Integer id){
		this.id	= id;
	}
	public java.lang.String getTitle(){
		return this.title;
	}
	public void setTitle(java.lang.String title){
		this.title	= title;
	}
	public java.lang.String getContent(){
		return this.content;
	}
	public void setContent(java.lang.String content){
		this.content	= content;
	}
	public java.util.Date getDate(){
		return this.date;
	}
	public void setDate(java.util.Date date){
		this.date	= date;
	}
	public java.lang.String getCruser(){
		return this.cruser;
	}
	public void setCruser(java.lang.String cruser){
		this.cruser	= cruser;
	}
	public java.lang.Integer getHitnum(){
		return this.hitnum;
	}
	public void setHitnum(java.lang.Integer hitnum){
		this.hitnum	= hitnum;
	}
}