package cn.zcj.newsssm.entity;


/**
 * Cmenu entity. @author MyEclipse Persistence Tools
 */


public class Cmenu{

	// Fields

	private Integer id;
	private Integer pid;
	private String name;
	private String url;
	private String permission;

	// Constructors

	

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPermission() {
		return this.permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

}