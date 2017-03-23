package com.pancake.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.service.jdbc.connections.internal.UserSuppliedConnectionProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.pancake.entity.Good;
import com.pancake.entity.GoodWithImage;
import com.pancake.entity.Image;
import com.pancake.entity.User;
import com.pancake.service.ClassificationService;
import com.pancake.service.GoodService;
import com.pancake.service.UserService;
import com.pancake.service.impl.ClassificationServiceImpl;
import com.pancake.util.FilePath;
import com.pancake.util.GetTime;
import com.pancake.util.PicFormatProcess;

@Controller
public class GoodController {

	@Autowired
	private GoodService goodService;
	@Autowired
	private UserService userService;
	@Autowired
	private ClassificationService classificationService;

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

	@RequestMapping(value = "/good_delete/{id}")
	public String deleteGood(Model model, @PathVariable int id) {
		Good good = goodService.get(id);
		// 0: can't buy. Don't delete the good info.
		good.setStatus(0);
		goodService.update(good);
		model.addAttribute("good", good);
		return "redirect:/good_list";
	}

	@RequestMapping(value = "/good_save")
	public String saveGood(@ModelAttribute GoodWithImage good, HttpSession session, HttpServletRequest request) {
		logger.info("save Good called");
		// Get user object by "userName" attr which is stored in session.
		// Then add in to object good.
		good.setUser(userService.getByName((String) session.getAttribute("userName")));
		good.setClassification(classificationService
				.getClassificationById(Integer.parseInt(request.getParameter("classification_id"))));
		// 1 means the good can be selled, by default status=1.
		good.setStatus(1);

		// 存储图片到image下
		List<String> piclList = storeImage(good, session, request);
		String picString = PicFormatProcess.ListToStr(piclList);
		logger.info("good name: " + good.getName());
		Timestamp addTime = new Timestamp(System.currentTimeMillis());
		Timestamp delTime = null;
		Good goodInDB = new Good(good.getClassification(), good.getUser(), good.getName(), good.getPrice(), picString,
				good.getFreight(), good.getDescription(), good.getStatus(), addTime, delTime, good.getOrderTables());
		goodService.save(goodInDB);
		return "redirect:/good_list";
	}

	public List<String> storeImage(GoodWithImage good, HttpSession session, HttpServletRequest servletRequest) {
		List<MultipartFile> files = good.getPictures();

		List<String> fileNames = new ArrayList<String>();

		if (null != files && files.size() > 0) {
			for (MultipartFile multipartFile : files) {

				String fileName = multipartFile.getOriginalFilename();
				fileName = GetTime.getTimeForPic() + "." + fileName.split("[.]")[fileName.split("[.]").length - 1];
				fileNames.add(fileName);
				String imagesDir = servletRequest.getServletContext().getRealPath("/images");
				String userName = ((String) session.getAttribute("userName")).trim();
				String picStoreDir = servletRequest.getServletContext()
						.getRealPath("/images/" + userName + "/goodPics");
				FilePath.isExistDir(picStoreDir);

				logger.info("images path: " + servletRequest.getServletContext().getRealPath("/images"));
				File imageFile = new File(picStoreDir, fileName);
				try {
					multipartFile.transferTo(imageFile);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return fileNames;
	}

	@RequestMapping(value = "/good_update")
	public String updateGood(@ModelAttribute Good good, HttpSession session, HttpServletRequest request) {
		// Don't no how to bound field "User user", use session temporary。
		good.setUser(userService.getByName((String) session.getAttribute("userName")));
		good.setClassification(goodService.get(good.getGoodId()).getClassification());
		good.setAddTime(goodService.get(good.getGoodId()).getAddTime());
		good.setDelTime(goodService.get(good.getGoodId()).getDelTime());
		goodService.update(good);
		return "redirect:/good_list";
	}

	@RequestMapping(value = "/good_list")
	public String listGoods(Model model, HttpSession session) {
		logger.info("good_list");
		List<Good> goods = goodService
				.getAllGoodsByUser(userService.getByName((String) session.getAttribute("userName")));
		model.addAttribute("goods", goods);
		return "GoodList";
	}
}