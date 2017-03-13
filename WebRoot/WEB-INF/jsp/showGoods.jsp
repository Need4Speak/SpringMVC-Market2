<%@page import="com.pancake.service.impl.ShowGoodServiceImpl"%>
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ page language="java" import="com.pancake.entity.*, com.pancake.dao.*, java.util.Iterator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		body{ text-align:center} 
		/* css 注释：这样设置了对象divcss5宽度为300px样式 */ 
		.divcssTop{
					width:250px;
					height:80px;
					margin: 0 auto;
  					padding: 0;
  					background: #FF4040;}
		.divcssMiddle{
					width:250px;
					height:40px;
					margin: 0 auto;
  					padding: 0;
  					background: #FF6A6A;}
		.divcssBottom{
					width:250px;
					margin: 0 auto;
  					padding: 0;
  					background: #FAEBD7;}
	</style>
  </head>
  
  <body>
    <div  class="divcssTop">二手交易网站</div>
    
    <div  class="divcssMiddle">
        <table width="250px" height="40px" border="1" cellspacing="0" cellpadding="0">
        	<tr>
			    <td >最新</td>
			    <td><%@ include file="userLoginBar.jsp"%></td>
		  	</tr>
        </table>
    </div>
    
    <div  class="divcssBottom">
    <c:forEach items="${goodForms}" var="goodForm">
    	<c:if test="${goodForm.status == 1}"> 
	    	<a href="goodInfoController?goodId=${goodForm.goodId}">  
			<table width="250px" height="150px" border="1" cellspacing="0" cellpadding="0">
			  <tr height="20px">
			    <td >卖家昵称:${goodForm.userName}</td>
			    <td>价格:${goodForm.price}</td>
			  </tr>
			  <tr>
			    <td width="125px"><img src="images/${goodForm.pictures[0]}" border="0" width="120px" height="90px" /></td>
			    <td><img src="images/${goodForm.pictures[1]}" border="0" width="120px" height="90px" /></td>
			  </tr>
			  <tr height="50px">
			    <td>商品名:${goodForm.goodName}</td>
			    <td>分类:${goodForm.classificationNameString}</td>
			  </tr>
			</table>
			</a>
		</c:if>
	</c:forEach> 
    </div>
    
  </body>
</html>
