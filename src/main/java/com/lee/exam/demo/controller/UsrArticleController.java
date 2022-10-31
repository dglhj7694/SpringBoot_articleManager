package com.lee.exam.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lee.exam.demo.service.ArticleService;
import com.lee.exam.demo.vo.Article;


@Controller
public class UsrArticleController {

	// 인스턴스 변수
	@Autowired
	private ArticleService articleService;

	// 액션메서드

	/**
	 * @Author : hjlee
	 * @Date : 2022. 10. 31.
	 * @Method : doAdd
	 * @param title
	 * @param body
	 * @return Article
	 */
	@RequestMapping("/usr/article/doAdd")
	@ResponseBody
	public Article doAdd(String title, String body) {
		Article article = articleService.writeArticle(title, body);

		return article;
	}

	
	/**
	 * @Author : hjlee
	 * @Date : 2022. 10. 31.
	 * @Method : getArticles
	 * @return List<Article>
	 */
	@RequestMapping("/usr/article/getArticles")
	@ResponseBody
	public List<Article> getArticles() {
		return articleService.articles();	
	}

	/**
	 * @Author : hjlee
	 * @Date : 2022. 10. 31.
	 * @Method : doDelete
	 * @param id
	 * @return String
	 */
	@RequestMapping("/usr/article/doDelete")
	@ResponseBody
	public String doDelete(int id) {
		Article article = articleService.getArticle(id);

		if (article == null) {
			return id + "번 게시물은 존재하지 않습니다";
		}

		articleService.deleteArticle(id);

		return id + "번 게시물을 삭제했습니다";
	}

	/**
	 * @Author : hjlee
	 * @Date : 2022. 10. 31.
	 * @Method : doModify
	 * @param id
	 * @param title
	 * @param body
	 * @return Object
	 */
	@RequestMapping("/usr/article/doModify")
	@ResponseBody
	public Object doModify(int id, String title, String body) {
		Article article = articleService.getArticle(id);

		if (article == null) {
			return id + "번 게시물은 존재하지 않습니다";
		}

		articleService.modifyArticle(id, title, body);

		return article;
	}

	/**
	 * @Author : hjlee
	 * @Date : 2022. 10. 31.
	 * @Method : getArticleAction
	 * @param id
	 * @return Object
	 */
	@RequestMapping("/usr/article/getArticle")
	@ResponseBody
	public Object getArticleAction(int id) {
		Article article = articleService.getArticle(id);

		if (article == null) {
			return id + "번 게시물은 존재하지 않습니다";
		}

		return article;
	}

}