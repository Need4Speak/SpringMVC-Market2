package com.pancake.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pancake.entity.GoodForm;
import com.pancake.entity.OrderTable;
import com.pancake.service.impl.ShowGoodServiceImpl;
import com.pancake.service.impl.ShowOrderServiceImpl;

@Controller
public class OrderController {
	private static final Log logger = LogFactory
			.getLog(ShowGoodsController.class);
	
	@RequestMapping(value = "/tryPlaceOrderController")
	public ModelAndView tryPlaceOrder(HttpServletRequest request,HttpServletResponse response) {
		logger.info("placeOrderController called");
		ModelAndView mav = new ModelAndView("tryPlaceOrder"); 
		
		int goodId = Integer.parseInt(request.getParameter("goodId"));
	  	ShowGoodServiceImpl sgsi = new ShowGoodServiceImpl();
		GoodForm goodForm = sgsi.showGoodInfo(goodId);
		
		mav.addObject("goodForm", goodForm); 
		return mav;
	}
	
	@RequestMapping(value = "/placeOrderController")
	public ModelAndView placeOrder(HttpServletRequest request,HttpServletResponse response) {
		logger.info("placeOrderController called");
		ModelAndView mav = new ModelAndView("showOrder"); 
		
		int goodId = Integer.parseInt(request.getParameter("goodId"));
	  	ShowGoodServiceImpl sgsi = new ShowGoodServiceImpl();
		GoodForm goodForm = sgsi.showGoodInfo(goodId);
		
		String address = request.getParameter("address").trim();
		String description = request.getParameter("description").trim();
		String buyerName = (String) request.getSession().getAttribute("userName");
		
		ShowOrderServiceImpl sosi = new ShowOrderServiceImpl();
		OrderTable orderForm = sosi.createOrder(buyerName, goodId, address, description);
		
		mav.addObject("goodForm", goodForm);
		mav.addObject("orderForm", orderForm); 
		return mav;
	}
}
