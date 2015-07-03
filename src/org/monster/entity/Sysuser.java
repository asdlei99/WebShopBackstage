package org.monster.entity;

/**
 * Sysuser entity. @author MyEclipse Persistence Tools
 */

public class Sysuser implements java.io.Serializable {

	// Fields

	private Integer id;
	private String uname;
	private String upass;
	private String uqx;

	// Constructors

	/** default constructor */
	public Sysuser() {
	}

	/** full constructor */
	public Sysuser(String uname, String upass, String uqx) {
		this.uname = uname;
		this.upass = upass;
		this.uqx = uqx;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUname() {
		return this.uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpass() {
		return this.upass;
	}

	public void setUpass(String upass) {
		this.upass = upass;
	}

	public String getUqx() {
		return this.uqx;
	}

	public void setUqx(String uqx) {
		this.uqx = uqx;
	}

}