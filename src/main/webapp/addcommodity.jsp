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
      <td>
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
      </td>
      <td>类别</td>
      <td>
      	<select id="category" name="category" lay-filter="category">
	        <option value="" selected="selected">选择类别</option>
	        <option value="配件">配件</option>
	        <option value="手机">手机</option>
	        <option value="书籍">书籍</option>
	        <option value="玩具">玩具</option>
	        <option value="服饰">服饰</option>
	        <option value="家居">家居</option>
	        <option value="美食">美食</option>
	        <option value="票卷">票卷</option>
		</select>
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