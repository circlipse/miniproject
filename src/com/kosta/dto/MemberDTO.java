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
	public MemberDTO(int memberno, String id, String pwd, String name, String email, String joindate) {
		super();
		this.memberno = memberno;
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.joindate = joindate;
	}
	public MemberDTO() {
		super();
	}
	
	
}
//(memberno number(5) constraint member_mno_pk primary key
//		 ,id varchar2(100)
//		  ,pwd varchar2(1000)
//		  ,name varchar2(20)
//		  ,email varchar2(1000)
//		  ,joindate date default sysdate);
//		  