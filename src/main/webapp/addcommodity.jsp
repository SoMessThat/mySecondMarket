<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="base.jsp"%>

	
	<script type="text/javascript" src="<%=basePath%>/addcommodity.js"></script>
	
	
<form id="form" lay-filter="form" class="layui-form" style="margin-top: 5px">
<input type="hidden" id="images" name="images" class="layui-input">
<table class="layui-table">
  <tbody>
    <tr>
      <td>添加图片</td>
      <td colspan="3">
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
      <td colspan="3">
      	<input type="text" id="name" name="name" placeholder="" class="layui-input" >	
      </td>
    </tr>
    <tr>
      <td>新旧程度</td>
      <td colspan="3">
      	<input type="text" id="conditions" name="conditions" placeholder="" class="layui-input" >	
      </td>
    </tr>
     <tr>
      <td>价格</td>
      <td>
   	  <input type="text" id="prix" name="prix" placeholder="" class="layui-input" >
      </td>
      <td>原价</td>
      <td>
   	  <input type="text" id="secprix" name="secprix" placeholder="" class="layui-input" >
      </td>
    </tr>
     <tr>
      <td>描述</td>
      <td colspan="3">
 	    <textarea id="info" name="info" placeholder="请输入内容" class="layui-textarea"></textarea>
      </td>
    </tr>
  </tbody>
</table>
	</form>