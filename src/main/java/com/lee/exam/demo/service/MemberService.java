package com.lee.exam.demo.service;

import org.springframework.stereotype.Service;

import com.lee.exam.demo.repository.MemberRepository;
import com.lee.exam.demo.vo.Member;

@Service
public class MemberService {
	private MemberRepository memberRepository;

	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	public int join(String loginId, String loginPw, String name, String nickname, String cellphoneNum, String email) {
		// 아이디 중복체크
		Member existsMember = getMemberByLoginId(loginId);
		if (existsMember != null) {
			return -1;
		}

		// 이름 이메일 중복체크
		existsMember = getMemberByEmail(email);
		if (existsMember != null) {
			return -2;
		}

		memberRepository.join(loginId, loginPw, name, nickname, cellphoneNum, email);
		return memberRepository.getLastInsertId();
	}

	private Member getMemberByEmail(String email) {
		return memberRepository.getMemberByEmail(email);
	}

	private Member getMemberByLoginId(String loginId) {
		return memberRepository.getMemberByLoginId(loginId);
	}

	public Member getMemberById(int id) {
		return memberRepository.getmemberById(id);
	}

}
