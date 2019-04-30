<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/base.jsp"%>
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
	
	<script type="text/javascript" src="<\%=basePath%>/editTOrder.js"></script>
	
<form id="tOrderform" lay-filter="tOrderform" class="layui-form" style="margin-top: 5px">
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
		<td>id</td>
		<td>
			<input id="id" name="id" class="layui-input" style="width:150px">
		</td>
    </tr>
    <tr>
		<td>commodityId</td>
		<td>
			<input id="commodityId" name="commodityId" class="layui-input" style="width:150px">
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
		<td>payTime</td>
		<td>
			<input id="payTime" name="payTime" class="layui-input" style="width:150px">
		</td>
    </tr>
    <tr>
		<td>state</td>
		<td>
			<input id="state" name="state" class="layui-input" style="width:150px">
		</td>
    </tr>
    <tr>
		<td>address</td>
		<td>
			<input id="address" name="address" class="layui-input" style="width:150px">
		</td>
    </tr>
    <tr>
		<td>isSign</td>
		<td>
			<input id="isSign" name="isSign" class="layui-input" style="width:150px">
		</td>
    </tr>
    <tr>
		<td>isPay</td>
		<td>
			<input id="isPay" name="isPay" class="layui-input" style="width:150px">
		</td>
    </tr>
    <tr>
		<td>logisticsCode</td>
		<td>
			<input id="logisticsCode" name="logisticsCode" class="layui-input" style="width:150px">
		</td>
    </tr>
  </tbody>
</table>
	</form>

</body>
              
</html>