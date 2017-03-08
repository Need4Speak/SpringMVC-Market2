/**   
* @Title: PageServiceImpl.java 
* @Package com.pancake.service.impl 
* @Description: TODO 
* @author zhangchao zcsd2668@163.com   
* @date 2017年3月8日 上午10:30:10 
* @version V1.0   
*/
package com.pancake.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pancake.dao.impl.OrderTableDaoImpl;
import com.pancake.entity.OrderTable;
import com.pancake.entity.Page;
import com.pancake.service.PageService;
@Service
public class PageServiceImpl implements PageService {
	
	private OrderTableDaoImpl otdi = new OrderTableDaoImpl();

	/* 
	 * @see com.pancake.service.PageService#queryForPage(int, int)
	 * 分页查询 
	 * @param currentPage 当前页号：现在显示的页数
     * @param pageSize 每页显示的记录条数
     * @return 封闭了分页信息(包括记录集list)的Bean
	 */
	@Override
	public Page<OrderTable> queryForPage(int currentPage, int pageSize) {
		Page<OrderTable> page = new Page<OrderTable>();        
		//当前页开始记录
		int offset = page.countOffset(currentPage,pageSize); 
		//分页查询结果集
	    List<OrderTable> list = otdi.queryPageList(offset, pageSize); 
		//总记录数
		int allRow = otdi.findAll().size();

	    page.setPageNo(currentPage);
	    page.setPageSize(pageSize);
	    page.setTotalRecords(allRow);
	    page.setList(list);
	    
	    return page;
		}

}
