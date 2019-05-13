<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
	<script type="text/javascript" src="<%=basePath%>/myCollect.js"></script>
	<form  id="Collectlistform" class="layui-form" style="margin-top: 5px">
		<div class="layui-input-inline">
			<input type="text" id="name" name="name" placeholder="商品名" class="layui-input" style="width:100px">
		</div>
		<div class="layui-input-inline">
			<select id="category" name="category" lay-filter="category">
		        <option value="" selected="selected">选择类别</option>
		        <option value="配件">配件</option>
		        <option value="手机">手机</option>
		        <option value="书籍">书籍</option>
		        <option value="玩具">玩具</option>
		        <option value="服饰">服饰</option>
		        <option value="家居">家居</option>
		        <option value="票卷">票卷</option>
		        <option value="其他">其他</option>
			</select>
		</div>
		<div class="layui-input-inline">
			<input type="text" id="info" name="info" placeholder="详细信息" class="layui-input" style="width:100px">
		</div>
		<div class="layui-input-inline">
			<input type="text" id="secprice" name="secprice" placeholder="价格" class="layui-input" style="width:100px">
		</div>
		<div class="layui-input-inline">
			<select id="conditions" name="conditions" lay-filter="conditions">
		        <option value="" selected="selected">选择新旧程度</option>
		        <option value="十层新">十层新(还没使用的)</option>
		        <option value="九层新">九层新(拆开却没用的)</option>
		        <option value="八层新">八层新(吃了点灰层)</option>
		        <option value="七层新">七层新(用了好几次)</option>
		        <option value="六层新">六层新(用了一阵子)</option>
		        <option value="五层新">五层新(失去青春的光泽)</option>
		        <option value="四层新">四层新(饱受岁月洗礼)</option>
		        <option value="三层新">三层新(破旧品)</option>
		        <option value="二层新">二层新(用到快烂了)</option>
		        <option value="一层新">一层新(用到要烂了)</option>
			</select>
		</div>
		<div class="layui-input-inline">
			<select id="state" name="state" lay-filter="state">
		        <option value="" selected="selected">选择状态</option>
		        <option value="已出售">已出售</option>
		        <option value="出售中">出售中</option>
		        <option value="已下架">已下架</option>
			</select>
		</div>
		
		<button id="resetbtn" type="reset" class="layui-btn layui-btn-small layui-btn-warm">清空</button>
	</form>
	<table class="layui-table" id="Collectlist" lay-filter="Collectlist"></table>
	
</body>
<script type="text/html" id="barDemo">
	<a class="layui-btn layui-btn-xs" lay-event="edit">查看</a>
	<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
</html>