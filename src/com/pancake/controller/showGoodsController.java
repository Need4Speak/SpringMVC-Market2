package com.pancake.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pancake.entity.GoodForm;
import com.pancake.service.impl.ShowGoodServiceImpl;

@Controller
public class showGoodsController {
	private static final Log logger = LogFactory
			.getLog(showGoodsController.class);
	
	@RequestMapping(value = "/showGoods")
//	public String inputProduct(Model model) {
//		logger.info("InputProductController called");
//	  	ShowGoodServiceImpl sgsi = new ShowGoodServiceImpl();
//		List<GoodForm> goodForms = sgsi.showGoodService();
//		model.addAttribute(goodForms);
//		return "showGoods";
//	}
	public ModelAndView inputProduct(HttpServletRequest request,HttpServletResponse response) {
		logger.info("InputProductController called");
		ModelAndView mav = new ModelAndView("showGoods"); 
		
	  	ShowGoodServiceImpl sgsi = new ShowGoodServiceImpl();
		List<GoodForm> goodForms = sgsi.showGoodService();
		
		mav.addObject("goodForms", goodForms); 
		return mav;
	}
}
