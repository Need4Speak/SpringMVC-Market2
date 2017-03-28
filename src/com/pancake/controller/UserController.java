package com.pancake.controller;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pancake.entity.Good;
import com.pancake.entity.User;
import com.pancake.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	private static final Log logger = LogFactory.getLog(GoodController.class);
	
	@RequestMapping(value = "/userInfoController")
	public ModelAndView userInfo(Model model, HttpSession session) {
		String userName = (String) session.getAttribute("userName");
		User aUser = userService.getByName(userName);
		ModelAndView mav = new ModelAndView("userInfo");
		mav.addObject("user", aUser);
		return mav;
	}
}
