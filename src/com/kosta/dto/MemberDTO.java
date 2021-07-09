package com.kosta.dto;

public class MemberDTO {
	private int memberno ;
	private String id ;
	private String pwd ;
	private String name ;
	private String email ;
	private String joindate ;
	public int getMemberno() {
		return memberno;
	}
	public void setMemberno(int memberno) {
		this.memberno = memberno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "MemberDTO [memberno=" + memberno + ", id=" + id + ", pwd=" + pwd + ", name=" + name + ", email=" + email
				+ ", joindate=" + joindate + "]";
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getJoindate() {
		return joindate;
	}
	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}
	public MemberDTO() {
		super();
	}
	
	
}
