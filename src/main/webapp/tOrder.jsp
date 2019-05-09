<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="../../base.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="renderer" content="webkit">
  		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title></title>
		<style type="text/css">
		.layui-table img {
		    height: 50px;
		    max-width: 100px;
		    padding: -10px;
		    margin: 0px;
		}
		.layui-table-cell {
			text-align: center;
			height: auto !important;
			max-height:50px;
			height:50px;
			white-space: normal;
		}
		</style>
	</head>
	<body>  
	<form  id="tOrderlistform" class="layui-form" style="margin-top: 5px">
		<div class="layui-input-inline">
			<input type="text" id="commodityName" name="commodityName" placeholder="商品名" class="layui-input" style="width:100px">
		</div>
		<div class="layui-input-inline">
			<input type="text" id="price" name="price" placeholder="价格" class="layui-input" style="width:100px">
		</div>
		<div class="layui-input-inline">
			<input type="text" id="sellerName" name="sellerName" placeholder="卖家名" class="layui-input" style="width:100px">
		</div>
		<div class="layui-input-inline">
			<input type="text" id="payTime" name="payTime" placeholder="付款时间" class="layui-input" style="width:100px">
		</div>
		<div class="layui-input-inline" style="width:100px">
			<select id="state" name="state" lay-filter="state">
		        <option value="" selected="selected">选择状态</option>
		        <option value="正常">正常</option>
		        <option value="异常">异常</option>
			</select>
		</div>
		<div class="layui-input-inline" style="width:100px">
			<select id="isSign" name="isSign" lay-filter="state">
		        <option value="" selected="selected">是否签收</option>
		        <option value="已签收">已签收</option>
		        <option value="未签收">未签收</option>
			</select>
		</div>
		
		<button id="resetbtn" type="reset" class="layui-btn layui-btn-small layui-btn-warm">清空</button>
	</form>
	<table class="layui-table" id="tOrderlist" lay-filter="tOrderlist"></table>
	
	<script type="text/javascript" src="<%=basePath%>/tOrder.js"></script>
</body>
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="edit">查看</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
</html>