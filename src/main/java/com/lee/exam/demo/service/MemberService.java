package com.lee.exam.demo.service;

import org.springframework.stereotype.Service;

import com.lee.exam.demo.repository.MemberRepository;
import com.lee.exam.demo.util.Ut;
import com.lee.exam.demo.vo.Member;
import com.lee.exam.demo.vo.ResultData;

@Service
public class MemberService {
	private MemberRepository memberRepository;

	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	public ResultData<Integer> join(String loginId, String loginPw, String name, String nickname, String cellphoneNum, String email) {
		// 아이디 중복체크
		Member existsMember = getMemberByLoginId(loginId);
		if (existsMember != null) {
			return ResultData.from("F-7", Ut.f("이미 사용중인 아이디(%s) 입니다.", loginId));
		}

		// 이름 이메일 중복체크
		existsMember = getMemberByEmail(email);
		if (existsMember != null) {
			return ResultData.from("F-8", Ut.f("이미 사용중인 이메일(%s) 입니다.", email));
		}

		memberRepository.join(loginId, loginPw, name, nickname, cellphoneNum, email);
		int id = memberRepository.getLastInsertId();
		return ResultData.from("S-1", "회원가입 완료", id);
	}

	private Member getMemberByEmail(String email) {
		return memberRepository.getMemberByEmail(email);
	}

	public Member getMemberByLoginId(String loginId) {
		return memberRepository.getMemberByLoginId(loginId);
	}

	public Member getMemberById(int id) {
		return memberRepository.getmemberById(id);
	}

}
