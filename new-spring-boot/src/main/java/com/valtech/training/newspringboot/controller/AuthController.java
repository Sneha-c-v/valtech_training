package com.valtech.training.newspringboot.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.valtech.training.newspringboot.model.ChangePasswordModel;
import com.valtech.training.newspringboot.model.RegisterUserModel;
import com.valtech.training.newspringboot.service.AuthService;

@Controller
public class AuthController {
	
	@Autowired
	private AuthService authService;
	 @PostMapping("/changePassword")
	 public String handleChangePassword(@AuthenticationPrincipal UserDetails userDetails,@ModelAttribute ChangePasswordModel pwdModel,Model model) {
		 pwdModel.setUsername(userDetails.getUsername());
		 if(Objects.equals(pwdModel.getNewPassword(), pwdModel.getConfirmPassword())) {
			if(authService.changePassword(pwdModel)) {
				model.addAttribute("message","Password changed Successfully");
			}else {
				model.addAttribute("message","pld password doesnot matched");
				return "changePassword";
			}
			 
		 }else {
			 model.addAttribute("massage","password and confirm password doesnoy match");
			 return "changePassword";
		 }
		 return "redirect:logout";
	 }
	
	@GetMapping("/changePassword")
	public String changePassword() {
		return "changePassword";
	}
		
	
	 @GetMapping("/register")
	 public String registerForm() {
		 return "register";
	 }
	 
	 @PostMapping("/register")
	 public String handleRegistration(@ModelAttribute RegisterUserModel regUserModel,Model model) {
		 if(Objects.equals(regUserModel.getPassword(),regUserModel.getConfirmPassword())) {
			 authService.createUser(regUserModel);
			 model.addAttribute("message","Password and Confirm password are same ");
			 
		 }
		 else {
			 model.addAttribute("message","Password and Confirm Password Doesnot match");
			return "register";
		 }
		 return "login";
	 }
	 
	@GetMapping("/anon")
	@ResponseBody
	public String anonPage() {
		return "Anonymous Page";
		
	}
	 @GetMapping("/login")
	 
	 public  String login() {
		 return "login";
	 }
	
	@GetMapping("/user")
	@ResponseBody
	public String userPage() {
		return "User Page";
		
	}
	
	@GetMapping("/admin")
	@ResponseBody
	public String adminPage() {
		return "Admin Page";
		
	}

}
