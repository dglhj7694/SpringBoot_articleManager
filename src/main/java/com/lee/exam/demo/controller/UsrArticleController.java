package com.lee.exam.demo.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lee.exam.demo.vo.Article;

@Controller
public class UsrArticleController {
	private int lastArticleId;
	private List<Article> articles;

	// 생성자
	public UsrArticleController() {
		lastArticleId = 0;
		articles = new ArrayList<>();

		// test data
		makeTestData();
	}

	// 서비스 메서드
	// get article
	private Article getArticle(int id) {
		for (Article article : articles) {
			if (article.getId() == id) {
				return article;
			}
		}
		return null;
	}

	// 삭제
	private void deleteArticle(int id) {
		Article article = getArticle(id);
		articles.remove(article);
	}

	private Article writeArticle(String title, String body) {
		int id = lastArticleId + 1;
		Article article = new Article(id, title, body);
		articles.add(article);
		lastArticleId = id;
		return article;
	}

	// make test data
	private void makeTestData() {
		for (int i = 0; i < 10; i++) {
			String title = "제목" + i;
			String body = "내용" + i;

			writeArticle(title, body);
		}
	}

	// action method

	// 게시물 작성
	@RequestMapping("/usr/article/doAdd")
	@ResponseBody
	public Article doAdd(String title, String body) {
		Article article = writeArticle(title, body);
		return article;
	}

	// 게시물 삭제
	@RequestMapping("/usr/article/doDelete")
	@ResponseBody
	public String doDelete(int id) {
		Article article = getArticle(id);
		if (article == null) {
			return id + "번 게시물은 없던데?";
		}
		deleteArticle(id);
		return id + "번 게시물을 삭제했습니다.";
	}

	// 게시물 리스트 조회
	@RequestMapping("/usr/article/getArticles")
	@ResponseBody
	public List<Article> getArticles() {

		return articles;
	}

}
