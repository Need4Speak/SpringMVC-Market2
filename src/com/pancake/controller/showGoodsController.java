package com.pancake.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class showGoodsController {
	private static final Log logger = LogFactory
			.getLog(showGoodsController.class);
	
	@RequestMapping(value = "/showGoods")
	public String inputProduct() {
		logger.info("InputProductController called");
		return "showGoods";
	}
}
