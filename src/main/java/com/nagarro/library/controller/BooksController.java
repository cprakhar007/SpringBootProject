package com.nagarro.library.controller;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.library.bookservice.BooksServices;
import com.nagarro.library.entity.BooksDetails;


@Controller
public class BooksController {
	
	@Autowired
   BooksServices bs;
	
	@RequestMapping("/getbooks")
	public ModelAndView getAllBooks(){
		
		
		ModelAndView mv = new ModelAndView();
		
		
		mv.addObject("list",bs.getAllbooks());
		mv.setViewName("Books.jsp");
		
		
		return mv;
	}
	
	
	@RequestMapping("/addbook")
	public ModelAndView CreatePge() {
		
		ModelAndView mv= new ModelAndView();
		
		
		mv.addObject("list", bs.getAllbooks());
		mv.setViewName("addbook.jsp");
		
		return mv;
	}
	
	@RequestMapping("/addnewbook")
	public void createBook(@ModelAttribute("BooksDetails") BooksDetails bd, HttpServletResponse response,HttpServletRequest request) throws IOException {
		
		
	  if(bs.isBookexist(bd,bs.getAllbooks()))
	  {
		  HttpSession session= request.getSession();
		  
			session.setAttribute("message", "Entered Book Code already exits");
		  response.sendRedirect("/library/addbook");
			
	  }
	  else
	  {
		bs.createBook(bd);
			
	    response.sendRedirect("/library/getbooks");
	  }
		
	}
	
	
	@RequestMapping("/deletebook")
	public void deleteBook(@RequestParam("bcode") int bcode,HttpServletResponse response) throws IOException {
		
		bs.deleteBook(bcode);
		
		response.sendRedirect("/library/getbooks");
	}
	
	
	
	
	
	
	@RequestMapping("/updatebook")
	public ModelAndView updatePage(@ModelAttribute("BooksDetails")BooksDetails bd) {
		
		ModelAndView mv= new ModelAndView();
		
		mv.addObject("list", bs.getAllbooks());
		mv.addObject("book", bd);
		
		mv.setViewName("updatebook.jsp");
		
		return mv;
	}
	
	
	
	@RequestMapping("/updatenewbook")
	public void updateBook(@ModelAttribute("BooksDetails") BooksDetails bd, HttpServletResponse response) throws IOException {
		
		bs.updateBook(bd);
			
	    response.sendRedirect("/library/getbooks");
		
	}
	 
	
	@RequestMapping("/logout")
	public void logoutLibrary(HttpServletResponse response,HttpServletRequest request) throws IOException {
		 
		
        HttpSession sess= request.getSession();
		
		sess.removeAttribute("username");
		sess.removeAttribute("message");
		
		response.sendRedirect("login.jsp");
		
	}
	

}
