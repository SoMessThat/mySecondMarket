
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
	<script type="text/javascript" src="<%=basePath%>/tAnnouncement.js"></script>
	<form  id="dictlistform" class="layui-form" style="margin-top: 5px">
		<div class="layui-input-inline">
			<input type="text" id="id" name="id" placeholder="id" class="layui-input" style="width:100px">
		</div>
		<div class="layui-input-inline">
			<input type="text" id="titlle" name="titlle" placeholder="titlle" class="layui-input" style="width:100px">
		</div>
		<div class="layui-input-inline">
			<input type="text" id="content" name="content" placeholder="content" class="layui-input" style="width:100px">
		</div>
		<div class="layui-input-inline">
			<input type="text" id="pictureId" name="pictureId" placeholder="pictureId" class="layui-input" style="width:100px">
		</div>
		<div class="layui-input-inline">
			<input type="text" id="creatTime" name="creatTime" placeholder="creatTime" class="layui-input" style="width:100px">
		</div>
		<div class="layui-input-inline">
			<input type="text" id="state" name="state" placeholder="state" class="layui-input" style="width:100px">
		</div>
		
  		<input class="layui-btn layui-btn-small layui-btn-normal" id="addTAnnouncement" value="新增" style="width:100px" />
		<button id="resetbtn" type="reset" class="layui-btn layui-btn-small layui-btn-warm">清空</button>
	</form>
	<table class="layui-table" id="tAnnouncementlist" lay-filter="tAnnouncementlist"></table>
	
</body>
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
</html>