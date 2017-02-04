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
<h1>订单列表</h1>
<a href="showGoodsController">返回首页</a><br/>
<c:forEach items="${orderList}" var="order">
<table>
	<tr>
	${order.good.pictures}
	</tr>
    <tr>
        <td>${order.good.name}</td>
        <td>${order.good.price + order.good.freight}</td>
        <td>
        <c:choose>
		    <c:when test="${order.status == 0}">
		       	订单已取
		    </c:when>
		    <c:when test="${order.status == 1}">
		       	去支付
		    </c:when>
		    <c:when test="${order.status == 2}">
		       	已支付
		    </c:when>
		</c:choose>
		</td>
    </tr>
</table>
<hr style="height:1px;border:none;border-top:1px dashed #0066CC;" />
</c:forEach>
</div>
</body>
</html>
