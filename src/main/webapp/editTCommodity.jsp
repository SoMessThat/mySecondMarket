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
	
	<script type="text/javascript" src="<%=basePath%>/editTCommodity.js"></script>
	
<form id="tCommodityform" lay-filter="tCommodityform" class="layui-form" style="margin-top: 5px">
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
		<td>name</td>
		<td>
			<input id="name" name="name" class="layui-input" style="width:150px">
		</td>
    </tr>
    <tr>
		<td>category</td>
		<td>
			<input id="category" name="category" class="layui-input" style="width:150px">
		</td>
    </tr>
    <tr>
		<td>info</td>
		<td>
			<input id="info" name="info" class="layui-input" style="width:150px">
		</td>
    </tr>
    <tr>
		<td>pop</td>
		<td>
			<input id="pop" name="pop" class="layui-input" style="width:150px">
		</td>
    </tr>
    <tr>
		<td>pictureId</td>
		<td>
			<input id="pictureId" name="pictureId" class="layui-input" style="width:150px">
		</td>
    </tr>
    <tr>
		<td>price</td>
		<td>
			<input id="price" name="price" class="layui-input" style="width:150px">
		</td>
    </tr>
    <tr>
		<td>secprice</td>
		<td>
			<input id="secprice" name="secprice" class="layui-input" style="width:150px">
		</td>
    </tr>
    <tr>
		<td>conditions</td>
		<td>
			<input id="conditions" name="conditions" class="layui-input" style="width:150px">
		</td>
    </tr>
    <tr>
		<td>messageId</td>
		<td>
			<input id="messageId" name="messageId" class="layui-input" style="width:150px">
		</td>
    </tr>
    <tr>
		<td>num</td>
		<td>
			<input id="num" name="num" class="layui-input" style="width:150px">
		</td>
    </tr>
    <tr>
		<td>sellerId</td>
		<td>
			<input id="sellerId" name="sellerId" class="layui-input" style="width:150px">
		</td>
    </tr>
    <tr>
		<td>buyerId</td>
		<td>
			<input id="buyerId" name="buyerId" class="layui-input" style="width:150px">
		</td>
    </tr>
    <tr>
		<td>creartTime</td>
		<td>
			<input id="creartTime" name="creartTime" class="layui-input" style="width:150px">
		</td>
    </tr>
    <tr>
		<td>closingTime</td>
		<td>
			<input id="closingTime" name="closingTime" class="layui-input" style="width:150px">
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