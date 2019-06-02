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
<form id="tAnnouncementform" lay-filter="tAnnouncementform" class="layui-form" style="margin-top: 5px">
	<input type="hidden" id="id" name="id" class="layui-input">
	<div class="layui-form-item">
		<label class="layui-form-label">标题</label>
		<div class="layui-input-block">
			<input id="titlle" name="titlle" class="layui-input">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">内容</label>
		<div class="layui-input-block">
			<input id="content" name="content" class="layui-input">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">图片</label>
		<div class="layui-input-block">
			<div style="float: left; width: 150px;height: 150px" align="center">
				<div class="layui-inline">
	  				<img id="img" src="/1.jpg" class="layui-circle" style="width: 130px;height: 130px">
				</div>
			</div>
			<input style="display: none;" id="pictureId" name="pictureId" class="layui-input">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">状态</label>
		<div class="layui-input-block">
			<select id="state" name="state" lay-filter="state">
		        <option value="" selected="selected">选择状态</option>
		        <option value="开启">开启</option>
		        <option value="关闭">关闭</option>
			</select>
		</div>
	</div>
	</form>
	<script type="text/javascript">
	layui.use(['form','laydate'], function(){
        var laydate = layui.laydate,
        $ = layui.$;
        	form = layui.form; 
        form.render();
        layui.use(['upload','layer'],function() {
			var upload = layui.upload;
			var layer=layui.layer;
	 
			upload.render({
			    elem: '#img'
			    ,url: BASE_PATH+'/TUser/upload.do'
			    ,multiple: false
			    ,done: function(res){
			    	$('#img').attr("src",res.data.avatar);
			    }
			  });
		});
	 }); 
	</script>
</body>
              
</html>