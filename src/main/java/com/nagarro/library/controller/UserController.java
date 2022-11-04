package com.nagarro.library.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nagarro.library.bookservice.UserService;
import com.nagarro.library.entity.User;

@Controller
public class UserController {
	
	@Autowired
	UserService us ;
	
	@RequestMapping("/checkuser")
	public void userLogin(@ModelAttribute("User") User uc,HttpServletResponse response,HttpServletRequest request) throws IOException {
		
		if(us.checkUser(uc,uc.getUsername()))
		{
			HttpSession session= request.getSession();
			session.setAttribute("username", uc.getUsername());
			response.sendRedirect("/library/getbooks");
		}
		else
		{   
			HttpSession session= request.getSession();
			session.setAttribute("message", "invalid username/password");
			response.sendRedirect("login.jsp");
		}
	}

}
