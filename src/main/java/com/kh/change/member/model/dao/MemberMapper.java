package com.kh.change.member.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.kh.change.member.model.vo.Member;
import com.kh.change.member.model.vo.MemberDto;

@Mapper
public interface MemberMapper {

	Member login(Member member);
	
	int insertMember(Member member);
	
	int updateMember(Member member);
	
	int updatePwd(MemberDto memberDto);
	
	int delete(MemberDto memberDto);
	
}
