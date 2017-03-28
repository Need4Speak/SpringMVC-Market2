<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Book List</title>
<style type="text/css">@import url("<c:url value="/css/main.css"/>");</style>
</head>
<body>

<div id="global">
<h1>已买</h1>
<a href="showGoodsController">返回首页</a><br/>
<c:forEach items="${orderList}" var="order">
<table>
    <tr>
    	<td><img src="images/${order.userByBuyerId.userName}/goodPics/${order.good.pictures}" border="0" width="120px" height="90px" /></td>
        <td>${order.good.name}</td>
        <td>${order.good.price + order.good.freight}</td>
        
        <c:choose>
		    <c:when test="${order.status == 0}">
		       	<td>订单已取消</td>
		    </c:when>
		    <c:when test="${order.status == 1}">
		       	<td>去支付</td>
		       	<td><a href="orderCancelController/${order.orderId}">取消</a></td>
		    </c:when>
		    <c:when test="${order.status == 2}">
		       	<td>已支付</td>
		    </c:when>
		</c:choose>
		
    </tr>
</table>
<hr style="height:1px;border:none;border-top:1px dashed #0066CC;" />
</c:forEach>
</div>
</body>
</html>
