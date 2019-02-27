<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="base.jsp"%>
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
	<form  id="dictlistform" class="layui-form" style="margin-top: 5px">
		<div class="layui-input-inline">
			<input type="text" id="name" name="name" placeholder="name" class="layui-input" style="width:100px">
		</div>
		<div class="layui-input-inline">
			<input type="text" id="category" name="category" placeholder="category" class="layui-input" style="width:100px">
		</div>
		<div class="layui-input-inline">
			<input type="text" id="info" name="info" placeholder="info" class="layui-input" style="width:100px">
		</div>
		<div class="layui-input-inline">
			<input type="text" id="pop" name="pop" placeholder="pop" class="layui-input" style="width:100px">
		</div>
		<div class="layui-input-inline">
			<input type="text" id="pictureId" name="pictureId" placeholder="pictureId" class="layui-input" style="width:100px">
		</div>
		<div class="layui-input-inline">
			<input type="text" id="price" name="price" placeholder="price" class="layui-input" style="width:100px">
		</div>
		<div class="layui-input-inline">
			<input type="text" id="secprice" name="secprice" placeholder="secprice" class="layui-input" style="width:100px">
		</div>
		<div class="layui-input-inline">
			<input type="text" id="conditions" name="conditions" placeholder="conditions" class="layui-input" style="width:100px">
		</div>
		<div class="layui-input-inline">
			<input type="text" id="messageId" name="messageId" placeholder="messageId" class="layui-input" style="width:100px">
		</div>
		<div class="layui-input-inline">
			<input type="text" id="num" name="num" placeholder="num" class="layui-input" style="width:100px">
		</div>
		<div class="layui-input-inline">
			<input type="text" id="sellerId" name="sellerId" placeholder="sellerId" class="layui-input" style="width:100px">
		</div>
		<div class="layui-input-inline">
			<input type="text" id="buyerId" name="buyerId" placeholder="buyerId" class="layui-input" style="width:100px">
		</div>
		<div class="layui-input-inline">
			<input type="text" id="creartTime" name="creartTime" placeholder="creartTime" class="layui-input" style="width:100px">
		</div>
		<div class="layui-input-inline">
			<input type="text" id="closingTime" name="closingTime" placeholder="closingTime" class="layui-input" style="width:100px">
		</div>
		<div class="layui-input-inline">
			<input type="text" id="state" name="state" placeholder="state" class="layui-input" style="width:100px">
		</div>
		
  		<input class="layui-btn layui-btn-small layui-btn-normal" id="addTCommodity" value="新增" style="width:100px" />
		<button id="resetbtn" type="reset" class="layui-btn layui-btn-small layui-btn-warm">清空</button>
	</form>
	<table class="layui-table" id="tCommoditylist" lay-filter="tCommoditylist"></table>
	<script type="text/javascript" src="<%=basePath%>/tCommodity.js"></script>
	
</body>
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
</html>