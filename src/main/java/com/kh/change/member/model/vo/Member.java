package com.kh.change.member.model.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class Member {
	
	private int userNo;
	private String userId;
	private String userPwd;
	private String userName;
	private String email;
	private String interest;
	private Date enrollDate;
	private Date modifyDate;
	private String status;
	
}

//vo => DAO(sql) mapper => controller => service(비즈니스 로직)
