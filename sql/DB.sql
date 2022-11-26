#db 생성
DROP DATABASE IF EXISTS SB_AM;
CREATE DATABASE SB_AM;
USE SB_AM;

DROP TABLE article;
# 게시글 테이블 생성
CREATE TABLE article(
    id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    regDate DATETIME NOT NULL,
    updateDate DATETIME NOT NULL,
    title CHAR(100) NOT NULL,
    `body` TEXT NOT NULL
);

# 게시글 테스트데이터 생성
INSERT INTO article 
SET regDate = NOW(),
updateDate = NOW(),
title = '제목1',
`body` = '제목1';

INSERT INTO article 
SET regDate = NOW(),
updateDate = NOW(),
title = '제목2',
`body` = '제목2';

INSERT INTO article 
SET regDate = NOW(),
updateDate = NOW(),
title = '제목3',
`body` = '제목3';

SELECT * FROM article;

SELECT LAST_INSERT_ID();



DROP TABLE `member`;
# 회원 테이블 생성
CREATE TABLE `member`(
    id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    regDate DATETIME NOT NULL,
    updateDate DATETIME NOT NULL,
    loginId CHAR(20) NOT NULL,
    loginPw CHAR(60) NOT NULL,
    `authLevel` SMALLINT(2) UNSIGNED DEFAULT 3 COMMENT '권한 레벨(3=일반,7=관리자)',
    `name` CHAR(20) NOT NULL,
    nickname CHAR(20) NOT NULL,
    cellphoneNum CHAR(20) NOT NULL,
    email CHAR(50) NOT NULL,
    delStatus TINYINT(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '탈퇴여부 (0=가입중 1=탈퇴)',
    delDate DATETIME COMMENT '탈퇴날짜'
);

# 관리자 테스트데이터 생성
	INSERT INTO `member` 
	SET regDate = NOW(),
	updateDate = NOW(),
    loginId = 'admin',
    loginPw = 'admin',
    `authLevel` = 7,
    `name` = '관리자',
    nickname = '관리자',
    cellphoneNum = '01011112222',
    email = 'lee_hajin@naver.com';
    
  # 일반유저 테스트데이터 생성
	INSERT INTO `member` 
	SET regDate = NOW(),
	updateDate = NOW(),
    loginId = 'test1',
    loginPw = 'test1',
    `name` = '사용자1',
    nickname = '사용자1',
    cellphoneNum = '01099999999',
    email = 'user1@gmail.com';

	INSERT INTO `member` 
	SET regDate = NOW(),
	updateDate = NOW(),
    loginId = 'test2',
    loginPw = 'test2',
    `name` = '사용자2',
    nickname = '사용자2',
    cellphoneNum = '01088889999',
    email = 'user2@gmail.com';
    
SELECT * FROM `member`;

#게시물 테이블에 회원번호 칼럼 추가
ALTER TABLE article ADD COLUMN memberId INT(10) UNSIGNED NOT NULL AFTER `updateDate`;

UPDATE article
SET memberId = 2
WHERE memberId = 0;

SELECT * FROM article;

SELECT LAST_INSERT_ID();