<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ page language="java" import="com.pancake.entity.*,com.pancake.dao.*, java.util.Iterator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="utf-8">
      <title>商品详情</title>
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <!-- 引入 Bootstrap -->
      <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
      <style type="text/css">
      	body{
            font-family: Arial;
            padding: 20px;
         }
         img{
            width: 100%;
            height: auto;
            margin-bottom: 20px;
         }
         img.head{
            width: 23%;
            height: 23%;
            float:left;
            border-radius: 20%;
         }
         .name{
            text-align: left;
            font-size: 12px;
            display: inline;
            margin-top: 20px;
         }
         .price{
            font-size: 16px;
            color: red;
            font-style: bold;
            text-align: right;
            }
         .detail{
            font-size: 15px;
         }
      </style>
   </head>
   <body>
     <div class="container">
   <div class="row clearfix">
      <div class="col-md-2 column">
         <img class="head" src="images/${goodForm.userName}/head/${userPhoto}" alt="我是头像">
      </div>
      <div class="col-md-2 column">
         <p class="name">卖家：${goodForm.userName}</p>
      </div>
      <div class="col-md-6 column">
      </div>
      <div class="col-md-2 column">
         <p class="price">价格：￥${goodForm.price}</p>
      </div>
      <div class="col-md-2 column">
         <p class="price">运费：￥${goodForm.freight}</p>
      </div>
   </div>
    <div class="row clearfix">
      <div class="col-md-12 column">
         <p class="detail">商品名： ${goodForm.goodName}</p>
         <p class="detail">详情：</p>
         <p class="detail">${goodForm.description}</p>
      </div>
   </div>
   <div class="row clearfix">
		<div class="col-md-12 column">
	      	<c:forEach items="${goodForm.pictures}" var="picture">
				<img class="productphoto" src="images/${goodForm.userName}/goodPics/${picture}" alt="我是产品图片">
			</c:forEach>
        </div>
   </div>
      <div class="row clearfix">
		<div class="col-md-12 column">
			<c:choose>
			    <c:when test="${userName != null}">
			    	<form action="tryPlaceOrderController?goodId=${goodForm.goodId}" method="post">
			    		<input type="submit" class="btn btn-default btn-block active btn-danger" value="购买">
			    	</form>
			    </c:when>
			    <c:otherwise>
			    	<form action="loginBarController" method="post">
				    	<input type="submit" class="btn btn-default btn-block active btn-danger" value="登录后购买">
			    	</form>
    			</c:otherwise>
			</c:choose>
			</form>
        </div>
   </div>
</div>
   </body>
</html>