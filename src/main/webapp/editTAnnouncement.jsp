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
	
	<script type="text/javascript" src="<%=basePath%>/editTAnnouncement.js"></script>
	
<form id="tAnnouncementform" lay-filter="tAnnouncementform" class="layui-form" style="margin-top: 5px">
<input type="hidden" id="id" name="id" class="layui-input" style="width:150px">
<table class="layui-table">
  <colgroup>
    <col width="50">
    <col width="100">
  </colgroup>
  <tbody>
    <tr>
		<td>titlle</td>
		<td>
			<input id="titlle" name="titlle" class="layui-input" style="width:150px">
		</td>
    </tr>
    <tr>
		<td>content</td>
		<td>
			<input id="content" name="content" class="layui-input" style="width:150px">
		</td>
    </tr>
    <tr>
		<td>pictureId</td>
		<td>
			<input id="pictureId" name="pictureId" class="layui-input" style="width:150px">
		</td>
    </tr>
    <tr>
		<td>creatTime</td>
		<td>
			<input id="creatTime" name="creatTime" class="layui-input" style="width:150px">
		</td>
    </tr>
    <tr>
		<td>state</td>
		<td>
			<input id="state" name="state" class="layui-input" style="width:150px">
		</td>
    </tr>
  </tbody>
</table>
	</form>

</body>
              
</html>