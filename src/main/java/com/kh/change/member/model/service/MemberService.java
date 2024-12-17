package com.kh.change.member.model.service;

import com.kh.change.member.model.vo.Member;
import com.kh.change.member.model.vo.MemberDto;

public interface MemberService {
	
	Member login(Member member);
	
	int insertMember(Member member);
	
	int updateMember(Member member);
	
	int updatePwd(MemberDto memberDto);
	
	int delete(MemberDto memberDto);
	
	
}
