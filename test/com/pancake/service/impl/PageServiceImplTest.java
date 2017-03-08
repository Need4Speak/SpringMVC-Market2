/**   
* @Title: PageServiceImplTest.java 
* @Package com.pancake.service.impl 
* @Description: TODO 
* @author zhangchao zcsd2668@163.com   
* @date 2017年3月8日 下午3:24:56 
* @version V1.0   
*/
package com.pancake.service.impl;

import org.junit.Test;

import com.pancake.entity.Page;

/**
 * @author m
 *
 */
public class PageServiceImplTest {

	@Test
	public void testQueryForPage() {
		PageServiceImpl psi = new PageServiceImpl();
		System.out.println("start debug.");
		Page page = psi.queryForPage(1, 3);
		System.out.println(page.getPageSize());
		System.out.println(page.getPageNo());
		System.out.println(page.getTotalRecords());
//		List aList = (List) page.getList();
//		for (OrderTable iterable_element : aList) {
//			
//		}
		System.out.println();
	}

}
