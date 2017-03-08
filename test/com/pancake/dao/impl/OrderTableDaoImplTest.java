package com.pancake.dao.impl;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.pancake.entity.Good;
import com.pancake.entity.OrderTable;
import com.pancake.entity.User;

public class OrderTableDaoImplTest {

	private UserDaoImpl udi = new UserDaoImpl();
	private OrderTableDaoImpl otdi = new OrderTableDaoImpl();
	private GoodDaoImpl gdi = new GoodDaoImpl();
	@Test
	public void testFindByGood() {
		Good good = gdi.findById(1);
		List<OrderTable> list = otdi.findByGood(good);
		for (OrderTable orderTable : list) {
			System.out.println(orderTable.getOrderId());
		}
	}

	@Test
	public void testFindByBuyer() {
		User user = udi.findById(2);
		List<OrderTable> list = otdi.findByBuyer(user);
		for (OrderTable orderTable : list) {
			System.out.println(orderTable.getOrderId());
		}
	}

	@Test
	public void testFindBySeller() {
		User user = udi.findById(2);
		List<OrderTable> list = otdi.findBySeller(user);
		for (OrderTable orderTable : list) {
			System.out.println(orderTable.getOrderId());
		}
		
	}
	
	@Test
	public void testQueryForPage() {
		int offset = 0;
		int length = 3;
		List<OrderTable> list = otdi.queryPageList(offset, length);
		for (OrderTable orderTable : list) {
			System.out.println("sys: " + orderTable.getOrderId());
		}
	} 

}
