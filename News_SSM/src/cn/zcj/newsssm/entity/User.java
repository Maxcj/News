package cn.zcj.newsssm.entity;

/**
 * User entity. @author MyEclipse Persistence Tools
 */


public class User{

	// Fields

	private String uid;
	private String xm;
	private String pwd;
	private String bj;
	private String role;
	

	// Property accessors

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getXm() {
		return this.xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getBj() {
		return this.bj;
	}

	public void setBj(String bj) {
		this.bj = bj;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", xm=" + xm + ", pwd=" + pwd + ", bj="
				+ bj + ", role=" + role + "]";
	}
	

}