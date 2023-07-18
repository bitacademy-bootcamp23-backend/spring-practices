package com.bitacademy.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *	@RequestMapping
 *	클래스 + 메서드(핸들러) 매핑
 *	강추!
 * 
 */

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join() {
		return "/WEB-INF/views/join.jsp";
	}

	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(UserVo userVo) {
		System.out.println(userVo);
		return "redirect:/";
	}
	
	@ResponseBody
	@RequestMapping("/list")
	public String list() {
		return "UserController.list()";
	}
	
	@ResponseBody
	@RequestMapping("/logout")
	public String logout() {
		return "UserController.logout()";
	}
}
