package com.kh.change.member.model.service;

import org.springframework.stereotype.Service;

import com.kh.change.member.model.dao.MemberMapper;
import com.kh.change.member.model.vo.Member;
import com.kh.change.member.model.vo.MemberDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

	private final MemberMapper mapper;

	@Override
	public Member login(Member member) {
		return null;
	}
	
	@Override
	public int insertMember(Member member) {
		return 0;
	}
	
	@Override
	public int updateMember(Member member) {
		return 0;
	}

	@Override
	public int updatePwd(MemberDto memberDto) {
		return 0;
	}

	@Override
	public int delete(MemberDto memberDto) {
		return 0;
	}
	
	
	
	
}
