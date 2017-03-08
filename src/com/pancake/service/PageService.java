package com.pancake.service;

import com.pancake.entity.OrderTable;
import com.pancake.entity.Page;

public interface PageService {
	public Page<OrderTable> queryForPage(int currentPage,int pageSize);
}
