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
	<script type="text/javascript" src="<%=basePath%>/tDemand.js"></script>
	<form  id="tDemandlistform" class="layui-form" style="margin-top: 5px">
		<div class="layui-input-inline">
			<input type="text" id="price" name="price" placeholder="价格" class="layui-input" style="width:100px">
		</div>
		<div class="layui-input-inline">
			<input type="text" id="name" name="name" placeholder="标题" class="layui-input" style="width:100px">
		</div>
		<div class="layui-input-inline">
			<input type="text" id="info" name="info" placeholder="内容" class="layui-input" style="width:100px">
		</div>
		<div class="layui-input-inline">
			<input type="text" id="creartTime" name="creartTime" placeholder="发布时间" class="layui-input" style="width:100px">
		</div>
		<div class="layui-input-inline">
			<select id="state" name="state" lay-filter="state">
		        <option value="" selected="selected">选择状态</option>
		        <option value="等待中">等待中</option>
		        <option value="已下架">已下架</option>
			</select>
		</div>
		
  		<input class="layui-btn layui-btn-small layui-btn-normal" id="addTDemand" value="新增" style="width:100px" />
		<button id="resetbtn" type="reset" class="layui-btn layui-btn-small layui-btn-warm">清空</button>
	</form>
	<table class="layui-table" id="tDemandlist" lay-filter="tDemandlist"></table>
	
</body>
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
</html>