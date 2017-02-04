<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ page language="java" import="com.pancake.entity.*,com.pancake.dao.*, java.util.Iterator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
<title>商品详情</title>
<style type="text/css">@import url(css/main.css);</style>
</head>
<body>
<div id="global">
<form>
	<%@ include file="userLoginBar.jsp"%>
    <fieldset>
        <legend>商品详情</legend>
        <table width="250px">
		  <tr>
		    <td width="159px">商品名称: ${goodForm.goodName}</td>
		    <td width="91px">价格: ${goodForm.price}</td>
		  </tr>
		  <c:forEach items="${goodForm.pictures}" var="picture">
			  <tr>
				<td colspan="2"><img src="images/${picture}" border="0" width="120px" height="90px" /></td>
			  </tr>
		  </c:forEach>
		  <tr>
		  	<td colspan="2">商品详情</td>
		  </tr>
		  <tr>
		    <td width="125px"><a href="showGoodsController">返回</a></td>
		    
		   	<c:choose>
			    <c:when test="${userName != null}">
			    	<td width="125px"><a href="tryPlaceOrderController?goodId=${goodForm.goodId}">购买</a></td>
			    </c:when>
			    <c:otherwise>
			    	<td width="125px"><a href="loginBarController">登录后购买</a></td>
    			</c:otherwise>
			</c:choose>

		  </tr>
		</table>
    </fieldset>
</form>
</div>
</body>
</html>