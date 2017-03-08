package com.pancake.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pancake.entity.GoodForm;
import com.pancake.entity.OrderTable;
import com.pancake.entity.Page;
import com.pancake.service.impl.PageServiceImpl;
import com.pancake.service.impl.ShowGoodServiceImpl;

@Controller
public class ShowGoodsController {
	private static final Log logger = LogFactory
			.getLog(ShowGoodsController.class);
	@Autowired
	private ShowGoodServiceImpl sgsi;
	@Autowired
	private PageServiceImpl psi;

	@RequestMapping(value = "/showGoodsController")
	public ModelAndView inputProduct(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("InputProductController called");
		ModelAndView mav = new ModelAndView("showGoods");

		List<GoodForm> goodForms = sgsi.showGoodWithSeller();

		mav.addObject("goodForms", goodForms);
		return mav;
	}

	@RequestMapping(value = "/goodInfoController")
	public ModelAndView goodInfo(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("InputProductController called");
		ModelAndView mav = new ModelAndView("goodInfo");

		int goodId = Integer.parseInt(request.getParameter("goodId"));
		GoodForm goodForm = sgsi.showGoodInfo(goodId);

		mav.addObject("goodForm", goodForm);
		return mav;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/showAll.do")
    public ModelAndView findAllCourse(HttpServletRequest request,
            HttpServletResponse response) {
		logger.info("InputProductController called");
		ModelAndView mav = new ModelAndView("order_list_test");
        try {
            String pageNo = request.getParameter("pageNo");
            logger.info("pageNo: " + pageNo);
            if (pageNo == null) {
                pageNo = "1";
            }
            Page page = psi.queryForPage(Integer.valueOf(pageNo), 3);
            mav.addObject(page);
            request.setAttribute("page", page);
            List<OrderTable> order = page.getList();
            mav.addObject(order);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }
}
