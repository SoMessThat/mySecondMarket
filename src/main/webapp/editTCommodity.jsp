<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/base.jsp"%>
<html>
	<head>
</head>

	<body>  
		<meta charset="UTF-8">
		<style type="text/css">
		.layui-table-cell {
			overflow: visible !important;
		}
		
		.layui-table-box {
			overflow: visible;
		}
		
		.layui-table-body {
			overflow: visible;
		}
		
		td .layui-form-select {
			margin-top: -10px;
			margin-left: -15px;
			margin-right: -15px;
		}
		</style>
	
<form id="tCommodityform" lay-filter="tCommodityform" class="layui-form" style="margin-top: 5px">
<input type="hidden" id="id" name="id" class="layui-input">
    <div class="layui-form-item">
		<label class="layui-form-label">名称</label>
		<div class="layui-input-block">
			<input id="name" name="name" class="layui-input">
		</div>
    </div>
    <div class="layui-form-item">
		<label class="layui-form-label">类别</label>
		<div class="layui-input-block">
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
	</div>
    <div class="layui-form-item">
		<label class="layui-form-label">详情</label>
		<div class="layui-input-block">
			<input id="info" name="info" class="layui-input">
		</div>
    </div>
    <div class="layui-form-item">
		<label class="layui-form-label">原价</label>
		<div class="layui-input-block">
			<input id="price" name="price" class="layui-input">
		</div>
    </div>
    <div class="layui-form-item">
		<label class="layui-form-label">现价</label>
		<div class="layui-input-block">
			<input id="secprice" name="secprice" class="layui-input">
		</div>
    </div>
    <div class="layui-form-item">
		<label class="layui-form-label">新旧程度</label>
		<div class="layui-input-block">
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
    </div>
    <div class="layui-form-item">
		<label class="layui-form-label">状态</label>
		<div class="layui-input-block">
			<select id="state" name="state" lay-filter="state">
		        <option value="" selected="selected">选择状态</option>
		        <option value="已出售">已出售</option>
		        <option value="出售中">出售中</option>
		        <option value="已下架">已下架</option>
			</select>
		</div>
    </div>
</form>
	<script type="text/javascript">
	layui.use(['form','laydate'], function(){
        var laydate = layui.laydate,
        	form = layui.form; 
        form.render();
	 }); 
	</script>
</body>
              
</html>