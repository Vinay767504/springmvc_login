package com.skss.web.springmvc_login.controller;

import java.util.ArrayList;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skss.web.springmvc_login.dao.imp1.UserDaoImp1;
import com.skss.web.springmvc_login.model.UserModel;

@Controller
public class UserController {

	@Autowired
	UserDaoImp1 dao;
	
	@RequestMapping("users")
	public ModelAndView getAllUsers() {
		ArrayList<UserModel> users=dao.getAllUsers();
		ModelAndView mv=new ModelAndView();
		
		mv.addObject("allusers",users);
		mv.setViewName("displayusers.jsp");
		return mv;
	}

	@RequestMapping("editUser")
	public ModelAndView editUser(@RequestParam int id) {
		
		UserModel existing=dao.getUser(id);
		ModelAndView mv=new ModelAndView();
		mv.addObject("olduser",existing);
		mv.setViewName("edit.jsp");
		return mv; 
	}
	@RequestMapping("updateUser")
	public ModelAndView updateUser(@ModelAttribute UserModel userModel) {
		
		String message=dao.updateUser(userModel);
		ModelAndView mv=new ModelAndView();
		mv.addObject("result",message);
		mv.setViewName("message.jsp"); 
		return mv;
	}

	@RequestMapping("deleteUser")
	public ModelAndView deleteUsers(@RequestParam int id) {

		String message=dao.deleteUser(id);
		ModelAndView mv=new ModelAndView();
		mv.addObject("result",message);
		mv.setViewName("message.jsp");

		return mv;

	}
	@RequestMapping("displayUsers")
	public ModelAndView displayUsers() {

		ArrayList<UserModel> users=dao.getAllUsers();
		ModelAndView mv=new ModelAndView();
		mv.addObject("allusers",users);
		mv.setViewName("displayusers.jsp");

		return mv;

	}
	@RequestMapping("saveUser")
	public ModelAndView saveUser(@ModelAttribute UserModel user) {

		String message=dao.saveUser(user);
		ModelAndView mv=new ModelAndView();
		mv.addObject("result",message);
		mv.setViewName("message.jsp");
		return mv;

	}
	@RequestMapping("createUser")
	public ModelAndView createUser() {

		ModelAndView mv=new ModelAndView();
		mv.addObject("user",new UserModel());
		mv.setViewName("createuser.jsp");
		return mv;

	}  
}