package com.eachwang.pg.bean;

/**
 * 用戶实体类
 * 
 * @author iswgr
 *
 */
public class User {
	private int result = 1;
	private int id;
	private String uuid;
	private String username;
	private String password;
	private int sex;
	private String cla;
	private String email;
	private int emailvalidate;
	private int vip;
	private String autograph;

	public User() {
	}

	public User(String uuid, String username, String password, int sex, String cla, String email, int emailvalidate,
			int vip, String autograph) {
		this.uuid = uuid;
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.cla = cla;
		this.email = email;
		this.emailvalidate = emailvalidate;
		this.vip = vip;
		this.autograph = autograph;
	}

	public String toString() {
		return "User [uuid=" + this.uuid + ", username=" + this.username + ", password=" + this.password + ", sex="
				+ this.sex + ", cla=" + this.cla + ", email=" + this.email + ", emailvalidate=" + this.emailvalidate
				+ ", vip=" + this.vip + "]";
	}

	public int getResult() {
		return this.result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getSex() {
		return this.sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getCla() {
		return this.cla;
	}

	public void setCla(String cla) {
		this.cla = cla;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEmailvalidate() {
		return this.emailvalidate;
	}

	public void setEmailvalidate(int emailvalidate) {
		this.emailvalidate = emailvalidate;
	}

	public int getVip() {
		return this.vip;
	}

	public void setVip(int vip) {
		this.vip = vip;
	}

	public String getAutograph() {
		return this.autograph;
	}

	public void setAutograph(String autograph) {
		this.autograph = autograph;
	}
}