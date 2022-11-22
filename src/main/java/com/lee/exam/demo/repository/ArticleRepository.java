package com.lee.exam.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.lee.exam.demo.vo.Article;

/* ::인터페이스
 * 추상 클래스에서는 구현이 불가능
 *  mybatis 추가 (의존 추가)
 *  */
@Mapper
public interface ArticleRepository {
	// insert into article set regDate = now(), updateDate = now() title = ? , 'body' = ?,
	@Insert("INSERT INTO article SET regDate = now(), updateDate = now(), title = #{title} , body = #{body}")
	public void writeArticle(String title, String body);

	// select * from article where id = ?;
	@Select("SELECT * FROM article where id = #{id}")
	public Article getArticle(@Param("id") int id);

	// select * from article order by id desc;
	@Select("SELECT * FROM article order by id desc")
	public List<Article> getArticles();

	// delete from article where id = ?;
	@Delete("DELETE FROM article WHERE id = #{id}")
	public void deleteArticle(int id);

	// update article set title = ? , 'body' = ?, updateDate = now() where id = ?;
	@Update("UPDATE article SET title = #{title}, body = #{body}, updateDate = NOW() WHERE id = #{id}")
	public void modifyArticle(int id, String title, String body);

	@Select("SELECT LAST_INSERT_ID()")
	public int getLastInsertId();

}