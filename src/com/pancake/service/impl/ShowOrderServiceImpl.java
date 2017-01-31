package com.pancake.service.impl;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.pancake.dao.impl.GoodDaoImpl;
import com.pancake.dao.impl.OrderTableDaoImpl;
import com.pancake.dao.impl.UserDaoImpl;
import com.pancake.entity.Good;
import com.pancake.entity.OrderTable;
import com.pancake.entity.User;
import com.pancake.service.ShowOrderService;
@Service
public class ShowOrderServiceImpl implements ShowOrderService {

	private OrderTableDaoImpl otdi = new OrderTableDaoImpl();
	private GoodDaoImpl gdi = new GoodDaoImpl();
	private UserDaoImpl udi = new UserDaoImpl();

	public OrderTable getOrderById(java.lang.Integer orderId) {
		OrderTable order = otdi.findById(orderId);
		return order;
	}

	public OrderTable createOrder(String buyerName, int goodId, String address,
			String description) {
		Good aGood = gdi.findById(goodId);
		User aBuyer = udi.findByUserName(buyerName);
		int buyerId = aBuyer.getUserId();
		int sellerId = aGood.getUser().getUserId();
//		Date creationTime = new Date();
//		Date cancelTime = null;
		Timestamp creationTime = new Timestamp(System.currentTimeMillis());
		Timestamp cancelTime = null;
		int status = 1; // 1 means waiting for purchase.
		String deliveryAddress = address;
		double freight = aGood.getFreight();
		OrderTable aOrder = new OrderTable(goodId, buyerId, sellerId,
				creationTime, cancelTime, status, deliveryAddress, freight,
				description);
		otdi.save(aOrder);
		return aOrder;
	}
}
