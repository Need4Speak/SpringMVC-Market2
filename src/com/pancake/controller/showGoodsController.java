package com.pancake.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pancake.entity.GoodForm;
import com.pancake.service.impl.ShowGoodServiceImpl;

@Controller
public class showGoodsController {
	private static final Log logger = LogFactory
			.getLog(showGoodsController.class);
	
	@RequestMapping(value = "/showGoods")
	public ModelAndView inputProduct(HttpServletRequest request,HttpServletResponse response) {
		logger.info("InputProductController called");
		ModelAndView mav = new ModelAndView("showGoods"); 
		
	  	ShowGoodServiceImpl sgsi = new ShowGoodServiceImpl();
		List<GoodForm> goodForms = sgsi.showGoodWithSeller();
		
		mav.addObject("goodForms", goodForms); 
		return mav;
	}
	
	@RequestMapping(value = "/goodInfo")
	public ModelAndView goodInfo(HttpServletRequest request,HttpServletResponse response) {
		logger.info("InputProductController called");
		ModelAndView mav = new ModelAndView("goodInfo"); 
		
		int goodId = Integer.parseInt(request.getParameter("goodId"));
	  	ShowGoodServiceImpl sgsi = new ShowGoodServiceImpl();
		GoodForm goodForm = sgsi.showGoodInfo(goodId);
		
		mav.addObject("goodForm", goodForm); 
		return mav;
	}
}
