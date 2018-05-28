package cn.zcj.newsssm.entity;

import java.util.Date;

public class Comment {
	
	private Integer cid;
	private Integer id;
	private String username;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	private String ccontent;
	private Date cdate;
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCcontent() {
		return ccontent;
	}
	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}
	public Date getCdate() {
		return cdate;
	}
	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}
	@Override
	public String toString() {
		return "Comment [cid=" + cid + ", id=" + id + ", ccontent=" + ccontent
				+ ", cdate=" + cdate + "]";
	}
	

}
