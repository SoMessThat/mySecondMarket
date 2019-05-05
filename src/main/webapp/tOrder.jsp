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
	</head>
	<body>  
	<form  id="tOrderlistform" class="layui-form" style="margin-top: 5px">
		<div class="layui-input-inline">
			<input type="text" id="id" name="id" placeholder="id" class="layui-input" style="width:100px">
        <ul class="" ><li>id</li></ul>
		</div>
		<div class="layui-input-inline">
			<input type="text" id="commodityId" name="commodityId" placeholder="commodityId" class="layui-input" style="width:100px">
        <ul class="" ><li>commodityId</li></ul>
		</div>
		<div class="layui-input-inline">
			<input type="text" id="pictureId" name="pictureId" placeholder="pictureId" class="layui-input" style="width:100px">
        <ul class="" ><li>pictureId</li></ul>
		</div>
		<div class="layui-input-inline">
			<input type="text" id="price" name="price" placeholder="price" class="layui-input" style="width:100px">
        <ul class="" ><li>price</li></ul>
		</div>
		<div class="layui-input-inline">
			<input type="text" id="num" name="num" placeholder="num" class="layui-input" style="width:100px">
        <ul class="" ><li>num</li></ul>
		</div>
		<div class="layui-input-inline">
			<input type="text" id="sellerId" name="sellerId" placeholder="sellerId" class="layui-input" style="width:100px">
        <ul class="" ><li>sellerId</li></ul>
		</div>
		<div class="layui-input-inline">
			<input type="text" id="buyerId" name="buyerId" placeholder="buyerId" class="layui-input" style="width:100px">
        <ul class="" ><li>buyerId</li></ul>
		</div>
		<div class="layui-input-inline">
			<input type="text" id="creartTime" name="creartTime" placeholder="creartTime" class="layui-input" style="width:100px">
        <ul class="" ><li>creartTime</li></ul>
		</div>
		<div class="layui-input-inline">
			<input type="text" id="payTime" name="payTime" placeholder="payTime" class="layui-input" style="width:100px">
        <ul class="" ><li>payTime</li></ul>
		</div>
		<div class="layui-input-inline">
			<input type="text" id="state" name="state" placeholder="state" class="layui-input" style="width:100px">
        <ul class="" ><li>state</li></ul>
		</div>
		<div class="layui-input-inline">
			<input type="text" id="address" name="address" placeholder="address" class="layui-input" style="width:100px">
        <ul class="" ><li>address</li></ul>
		</div>
		<div class="layui-input-inline">
			<input type="text" id="isSign" name="isSign" placeholder="isSign" class="layui-input" style="width:100px">
        <ul class="" ><li>isSign</li></ul>
		</div>
		<div class="layui-input-inline">
			<input type="text" id="isPay" name="isPay" placeholder="isPay" class="layui-input" style="width:100px">
        <ul class="" ><li>isPay</li></ul>
		</div>
		<div class="layui-input-inline">
			<input type="text" id="logisticsCode" name="logisticsCode" placeholder="logisticsCode" class="layui-input" style="width:100px">
        <ul class="" ><li>logisticsCode</li></ul>
		</div>
		
  		<input class="layui-btn layui-btn-small layui-btn-normal" id="addTOrder" value="新增" style="width:100px" />
		<button id="resetbtn" type="reset" class="layui-btn layui-btn-small layui-btn-warm">清空</button>
	</form>
	<table class="layui-table" id="tOrderlist" lay-filter="tOrderlist"></table>
	
	<script type="text/javascript" src="<%=basePath%>/tOrder.js"></script>
</body>
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
</html>