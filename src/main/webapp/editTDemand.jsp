<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/base.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="renderer" content="webkit">
  		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title></title>
	</head>

	<body>  
	
	<script type="text/javascript" src="<%=basePath%>/editTDemand.js"></script>
	
<form id="tDemandform" lay-filter="tDemandform" class="layui-form" style="margin-top: 5px">
<input type="hidden" id="id" name="id" class="layui-input" style="width:150px">
<table class="layui-table">
  <colgroup>
    <col width="50">
    <col width="100">
    <col width="50">
    <col width="100">
  </colgroup>
  <tbody>
    <tr>
		<td>价格</td>
		<td>
			<input id="price" name="price" class="layui-input" style="width:150px">
		</td>
    </tr>
    <tr>
		<td>名称</td>
		<td>
			<input id="name" name="name" class="layui-input" style="width:150px">
		</td>
    </tr>
    <tr>
		<td>描述</td>
		<td>
			<input id="info" name="info" class="layui-input" style="width:150px">
		</td>
    </tr>
  </tbody>
</table>
	</form>

</body>