package com.pancake.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.service.jdbc.connections.internal.UserSuppliedConnectionProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.pancake.entity.Good;
import com.pancake.entity.User;
import com.pancake.service.GoodService;
import com.pancake.service.UserService;

@Controller
public class GoodController {

	@Autowired
	private GoodService goodService;
	@Autowired
	private UserService userService;

	private static final Log logger = LogFactory.getLog(GoodController.class);

	@RequestMapping(value = "/good_input")
	public String inputGood(Model model) {
		model.addAttribute("good", new Good());
		return "GoodAddForm";
	}

	@RequestMapping(value = "/good_edit/{id}")
	public String editGood(Model model, @PathVariable int id) {
		Good good = goodService.get(id);
		model.addAttribute("good", good);
		return "GoodEditForm";
	}

	@RequestMapping(value = "/good_save")
	public String saveGood(@ModelAttribute Good good, HttpSession session) {
		logger.info("save Good called");
		// Get user object by "userName" attr which is stored in session.
		// Then add in to object good.
		good.setUser(userService.getByName((String) session
				.getAttribute("userName")));
		// 1 means the good can be selled, by default status=1.
		good.setStatus(1);
		goodService.save(good);
		return "redirect:/good_list";
	}

	@RequestMapping(value = "/good_update")
	public String updateGood(@ModelAttribute Good good, HttpSession session) {
		// Don't no how to bound field "User user", use session temporary。
		good.setUser(userService.getByName((String) session
				.getAttribute("userName")));
		goodService.update(good);
		return "redirect:/good_list";
	}

	@RequestMapping(value = "/good_list")
	public String listGoods(Model model, HttpSession session) {
		logger.info("good_list");
		List<Good> goods = goodService.getAllGoodsByUser(userService
				.getByName((String) session.getAttribute("userName")));
		model.addAttribute("goods", goods);
		return "GoodList";
	}
}