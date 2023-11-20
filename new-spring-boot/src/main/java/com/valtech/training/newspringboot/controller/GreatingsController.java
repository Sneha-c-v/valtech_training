package com.valtech.training.newspringboot.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.server.ServerHttpAsyncRequestControl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GreatingsController {
	//@RequestMapping(method = RequestMethod.GET, path = "/hello")
	@GetMapping("/hello")
	//@ResponseBody
	public String hello(@RequestParam("name") String name,Model model) {
		//return "Hello Spring MVC";
		//String name=request.getParameter("name");
		System.out.println("Name =" +name);
		model.addAttribute("name",name);
		return "hello";
	}
}