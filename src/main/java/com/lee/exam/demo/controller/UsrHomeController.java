package com.lee.exam.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UsrHomeController {
	private int count;
	
	public UsrHomeController() {
		count = 0;	//생성자에서 초기화
	}
	//http://localhost:8081/usr/home/main
	//application.yml .server.port 변경
	
	@RequestMapping("/usr/home/getCount")
	@ResponseBody
	public int getCount() {
		return count;
	}
	
//	http://localhost:8081/usr/home/doSetCount?count=10
	@RequestMapping("/usr/home/doSetCount")
	@ResponseBody
	public String doSetCount(int count) {
		this.count = count;
		return "count 의 값이 " + this.count + "로 초기화됨";
		}
}
