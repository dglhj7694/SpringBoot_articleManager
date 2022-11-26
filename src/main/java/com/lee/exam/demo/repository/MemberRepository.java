package com.lee.exam.demo.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberRepository {

	@Insert("""
			INSERT INTO `member`
			SET regDate = now()
			, updateDate = now()
			, loginId = #{loginId}
			, loginPw = #{loginId}
			, `name` = #{name}
			, nickname = #{nickname}
			, cellphoneNum = #{cellphoneNum}
			, email = #{email}
				""")
	void join(String loginId, String loginPw, String name, String nickname, String cellphoneNum, String email);

}
