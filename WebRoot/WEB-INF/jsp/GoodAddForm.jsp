<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Add Book Form</title>
<style type="text/css">@import url("<c:url value="/css/main.css"/>");</style>
</head>
<body>

<div id="global">
<form:form commandName="good" action="good_save" method="post">
    <fieldset>
        <legend>发布商品</legend>
        <p>
            <label for="name">商品名: </label>
            <form:input id="name" path="name"/>
        </p>
        <p>
            <label for="price">价格： </label>
            <form:input id="price" path="price"/>
        </p>
        <p>
            <label for="pictures">图片: </label>
            <form:input id="pictures" path="pictures"/>
        </p>
       	<p>
            <label for="freight">运费: </label>
            <form:input id="freight" path="freight"/>
        </p>
        <p>
            <label for="description">详细介绍: </label>
            <form:input id="description" path="description"/>
        </p>
        <p>
            <label for="description">分类: </label>
            <label><input name="classification_id" type="radio" value="2" />电子产品 </label> 
			<label><input name="classification_id" type="radio" value="3" />服装 </label> 
			<label><input name="classification_id" type="radio" value="4" />化妆品 </label> 
			<label><input name="classification_id" type="radio" value="5" />食品 </label> 
			<label><input name="classification_id" type="radio" value="6" />图书 </label> 
			<label><input name="classification_id" type="radio" value="1" />其它 </label>
        </p>
        
        <p id="buttons">
            <input id="reset" type="reset" tabindex="4">
            <input id="submit" type="submit" tabindex="5" 
                value="发布商品">
        </p>
    </fieldset>
</form:form>
</div>
</body>
</html>
