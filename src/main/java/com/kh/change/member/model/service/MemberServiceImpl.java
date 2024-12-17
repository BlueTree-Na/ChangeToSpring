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
		return mapper.login(member);
	}
	
	@Override
	public int insertMember(Member member) {
		return mapper.insertMember(member);
	}
	
	@Override
	public int updateMember(Member member) {
		return mapper.updateMember(member);
	}

	@Override
	public int updatePwd(MemberDto memberDto) {
		return mapper.updatePwd(memberDto);
	}

	@Override
	public int delete(MemberDto memberDto) {
		return mapper.delete(memberDto);
	}
	
	
	
	
}
