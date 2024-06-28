package com.app.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class FirstController {
  
	@GetMapping("/test1")
	public ModelAndView test1() {
		System.out.println("in First Controller test 1"); 
		return new ModelAndView("/welcome1", "modelView",LocalDateTime.now());
		
	}
	
	@GetMapping("/")
	public String index() {
		System.out.println("in First Controller request for index"); 
		return "/index";
		
	}
	@GetMapping("/test2")
	public String test1(Model modelMap) {
		System.out.println("in First Controller in test 2 modelMap is "+modelMap);
		
		modelMap.addAttribute("modelView1", LocalDateTime.now());
		modelMap.addAttribute("modelView2", List.of(1,12,3,2,4,5,6,7,8,5,3));
		System.out.println("in First Controller in test 2 modelMap is "+modelMap);
		return "/welcome2";
		
	}
}
