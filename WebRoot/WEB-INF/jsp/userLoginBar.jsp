<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String fileName=request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1);
fileName = "index.jsp";
System.out.println("fileName: " + fileName);
%>
