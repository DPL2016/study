package com.kaishengit.pojo;

import java.io.Serializable;
import java.util.Date;

public class Card implements Serializable {
	private static final long serialVersionUID = -4731903758993945925L;
	private Integer id;
	private String code;
	private String name;
	private String tel;
	private Date btime;
	public Date getBtime() {
		return btime;
	}
	public void setBtime(Date btime) {
		this.btime = btime;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
}
