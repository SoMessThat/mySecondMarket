<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="base.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="renderer" content="webkit">
  		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>淘宝网 - 淘！我喜欢</title>
	</head>

	<body>  
	
	<script type="text/javascript" src="<%=basePath%>/addcommodity.js"></script>
	
	
<form id="form" lay-filter="form" class="layui-form" style="margin-top: 5px">
<input type="hidden" id="images" name="images" class="layui-input">
<table class="layui-table">
  <colgroup>
    <col width="50">
    <col width="100">
    <col width="50">
    <col width="100">
  </colgroup>
  <tbody>
    <tr>
      <td>添加图片</td>
      <td>
      	<div class="layui-form-item">
	        <div class="layui-upload">
			  <button type="button" class="layui-btn" id="test2">多图片上传</button> 
			  <blockquote class="layui-elem-quote layui-quote-nm" style="margin-top: 10px;">
			    预览图：
			    <div class="layui-upload-list" id="demo2"></div>
			 </blockquote>
			</div>
	    </div>
	  </td>
    </tr>
    <tr>
      <td>名称</td>
      <td>
      	<input type="text" id="name" name="name" placeholder="" class="layui-input" >	
      </td>
    </tr>
     <tr>
      <td>价格</td>
      <td>
   	  <input type="text" id="prix" name="prix" placeholder="" class="layui-input" >
      </td>
    </tr>
     <tr>
      <td>描述</td>
      <td>
 	    <textarea id="info" name="info" placeholder="请输入内容" class="layui-textarea"></textarea>
      </td>
    </tr>
  </tbody>
</table>
	</form>

</body>
              
</html>