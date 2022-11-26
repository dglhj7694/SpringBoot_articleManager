package com.lee.exam.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.lee.exam.demo.vo.Article;

/* ::인터페이스
 * 추상 클래스에서는 구현이 불가능
 *  mybatis 추가 (의존 추가)
 *  */
@Mapper
public interface ArticleRepository {
	//@Insert("INSERT INTO article SET regDate = now(), updateDate = now(), title = #{title} , body = #{body}")
	public void writeArticle(int memberId, String title, String body);

	//@Select("SELECT * FROM article where id = #{id}")
	public Article getArticle(@Param("id") int id);

	//@Select("SELECT * FROM article order by id desc")
	public List<Article> getArticles();

	//@Delete("DELETE FROM article WHERE id = #{id}")
	public void deleteArticle(int id);

	//@Update("UPDATE article SET title = #{title}, body = #{body}, updateDate = NOW() WHERE id = #{id}")
	public void modifyArticle(int id, String title, String body);

	//@Select("SELECT LAST_INSERT_ID()")
	public int getLastInsertId();

}