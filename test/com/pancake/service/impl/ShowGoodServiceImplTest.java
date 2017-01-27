package com.pancake.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.pancake.entity.GoodForm;

public class ShowGoodServiceImplTest {

	@Test
	public void testShowGoodService() {
		ShowGoodServiceImpl sgsi = new ShowGoodServiceImpl();
		List<GoodForm> goodForms = sgsi.showGoodService();
		for (GoodForm aGoodForm : goodForms) {
			System.out.println(aGoodForm);
		}
		// fail("Not yet implemented");
	}

}
