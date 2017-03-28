package com.pancake.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pancake.entity.Good;
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
		int classification_id;
		if (request.getParameter("classification_id") != null && !request.getParameter("classification_id").equals("")) {
			classification_id = Integer.parseInt(request.getParameter("classification_id"));
			logger.info("request.getParameter(classification_id) != null");
		}
		else {
			logger.info("request.getParameter(classification_id) = null");
			classification_id = -1;
		}
		// -1 means find all goods.
//		classification_id = 2;
		List<GoodForm> goodForms = sgsi.showGoodWithSeller(classification_id);

		mav.addObject("goodForms", goodForms);
		return mav;
	}

	@RequestMapping(value = "/goodInfoController")
	public ModelAndView goodInfo(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("InputProductController called");
		ModelAndView mav = null;

		int goodId = Integer.parseInt(request.getParameter("goodId"));
		GoodForm goodForm = sgsi.showGoodInfo(goodId);
		
		if (null != goodForm) {
			mav = new ModelAndView("goodInfo");
			mav.addObject("goodForm", goodForm);
		}
		else {
			mav = new ModelAndView("goodNotReady");
		}
		return mav;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/showAll.do")
    public ModelAndView findAllOrder(HttpServletRequest request,
            HttpServletResponse response) {
		logger.info("FindAllOrder called");
		ModelAndView mav = new ModelAndView("order_list_test");
        try {
            String pageNo = request.getParameter("pageNo");
            logger.info("pageNo: " + pageNo);
            if (pageNo == null) {
                pageNo = "1";
            }
            Page page = psi.queryForOrderPage(Integer.valueOf(pageNo), 3);
            mav.addObject(page);
            request.setAttribute("page", page);
            List<OrderTable> order = page.getList();
            mav.addObject(order);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }
	
	@RequestMapping(value = "/showAll")
    public ModelAndView findAllGood(HttpServletRequest request,
            HttpServletResponse response) {
		logger.info("FindAllGood called");
		ModelAndView mav = new ModelAndView("good_list_test");
        try {
            String pageNo = request.getParameter("pageNo");
            logger.info("pageNo: " + pageNo);
            if (pageNo == null) {
                pageNo = "1";
            }
            Page page = psi.queryForGoodPage(Integer.valueOf(pageNo), 3);
            mav.addObject(page);
            List<GoodForm> goodForms = sgsi.showGoodWithPage((ArrayList<Good>) page.getList());
            request.setAttribute("goodForms", goodForms);
            mav.addObject(goodForms);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }
}
