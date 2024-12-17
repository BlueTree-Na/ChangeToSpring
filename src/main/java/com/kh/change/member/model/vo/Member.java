package com.kh.change.member.model.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class Member {
	
	private String userId;   
	private String userPwd;
	private String userName;
	private String email;
	private String gender;
//	private int age; 
	private String age;
	private String phone;
	private String address;
	private Date enrollDate;
	private Date modifyDate;
	private String status;
	
}

//vo => DAO(sql) mapper => controller => service(비즈니스 로직)
