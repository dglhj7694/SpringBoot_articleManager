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
	
	@RequestMapping("/usr/home/main")
	@ResponseBody
	public String showMain() {
		return "안녕하세요";
	}
	@RequestMapping("/usr/home/main2")
	@ResponseBody
	public String showMain2() {
		return "반갑습니다";
	}
	@RequestMapping("/usr/home/main3")
	@ResponseBody
	public String showMain3() {
		return "잘가요";
	}
	
	@RequestMapping("/usr/home/main4")
	@ResponseBody
	public int showMain4() {
//		count++; //1부터 나오지 (전위 후위 연산자)
		return count++; //0부터 나오고 1씩 증가
	}
	
	@RequestMapping("/usr/home/main5")
	@ResponseBody
	public String showMain5() {
		count = 0;
		return "count를 다시 0으로 초기화 함"; 
	}
}
