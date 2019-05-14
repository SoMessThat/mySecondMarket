<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="base.jsp"%>

	
	<script type="text/javascript" src="<%=basePath%>/myInfo.js"></script>
	
	<style>
		.layui-form-label {
			text-align:left;
		}
		label.layui-form-label {
		    font-size: 13px;
		    font-weight: 800;
		}
	</style>

<form class="layui-form" style="margin-top: 50px;margin-left: 20%" lay-filter="form">
<input type="hidden" name="id" id="id">
<div id="form1">

	<div style="float: left; width: 150px;height: 150px" align="center">
			<div class="layui-inline">
  				<img id="img" src="/1.jpg" class="layui-circle" style="width: 130px;height: 130px">
			</div>
	</div>
	<div style="float: left;">
			<div class="layui-form-item" style="left:">
				<label class="layui-form-label">账号</label>
				<div class="layui-input-block" style="width: 200px;">
					<input name="account" type="text" style="border: 0;" readonly="readonly"placeholder="请输入" autocomplete="off"
						class="layui-input" readonly="readonly">
				</div>
			</div>
			<div class="layui-form-item" style="left:">
				<label class="layui-form-label">用户名</label>
				<div class="layui-input-block" style="width: 200px;">
					<input type="text" name="username" style="border: 0;" readonly="readonly"placeholder="请输入" autocomplete="off"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">性别</label>
				<div class="layui-input-block">
					<input type="text" name=sex style="border: 0;" readonly="readonly"placeholder="请输入" autocomplete="off"
						class="layui-input">
<!-- 					<input type="radio" name="sex" style="border: 0;" readonly="readonly"value="男" title="男"> -->
<!-- 					<input type="radio" name="sex" style="border: 0;" readonly="readonly"value="女" title="女" checked> -->
				</div>
			</div>
	</div>
			<div class="layui-form-item">
				<label class="layui-form-label">邮箱</label>
				<div class="layui-input-block" style="width: 350px;">
					<input type="text" name="email" style="border: 0;" readonly="readonly"placeholder="请输入" autocomplete="off"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">电话</label>
				<div class="layui-input-block" style="width: 350px">
					<input type="text" name="phone" style="border: 0;" readonly="readonly"placeholder="请输入" autocomplete="off"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">学校</label>
				<div class="layui-input-block" style="width: 350px;">
					<input type="text" name="school" style="border: 0;" readonly="readonly"placeholder="请输入" autocomplete="off"
						class="layui-input">
<!-- 					<select hidden="true" name="school" readonly="readonly"> -->
<!-- 						<option value="福建工程学院">福建工程学院</option> -->
<!-- 						<option value="福州大学">福州大学</option> -->
<!-- 						<option value="福建医科大学">福建医科大学</option> -->
<!-- 						<option value="福建师范大学">福建师范大学</option> -->
<!-- 					</select> -->
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">地址</label>
				<div class="layui-input-block" style="width: 350px;">
					<input type="text" name="address" style="border: 0;" readonly="readonly" placeholder="请输入" autocomplete="off"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">QQ</label>
				<div class="layui-input-block" style="width: 350px;">
					<input type="text" name="qq" placeholder="请输入" autocomplete="off"
						style="border: 0;" readonly="readonly" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">支付宝</label>
				<div class="layui-input-block" style="width: 350px;">
					<input type="text" name="alipay" placeholder="请输入" autocomplete="off"
						style="border: 0;" readonly="readonly" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">微信</label>
				<div class="layui-input-block" style="width: 350px;">
					<input type="text" name="wechat" placeholder="请输入" autocomplete="off"
						style="border: 0;" readonly="readonly" class="layui-input">
				</div>
			</div>
			<br>
			<div class="layui-form-item layui-form-text" >
				<label class="layui-form-label">创建时间</label>
				<div class="layui-input-block" style="width: 350px;">
					<input name="creattime" style="border: 0;" readonly="readonly" value="2019-01-01" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item layui-form-text" >
				<label class="layui-form-label">最近登录时间</label>
				<div class="layui-input-block" style="width: 350px;">
					<input name="lasttime" style="border: 0;" readonly="readonly" value="2019-01-01" type="text" name="" placeholder="" autocomplete="off" class="layui-input">
				</div>
			</div>
			<br> <br>
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn" type="button" id="modify" style="width: 200px">修改</button>
				</div>
			</div>
</div>

<div id="form2" hidden="ture">

	<div style="float: left; width: 150px;height: 150px" align="center">
		<div class="layui-inline">
			<div class="layui-upload">
  				<img id="img1" src="/1.jpg" class="layui-circle" style="width: 130px;height: 130px">
			</div>
		</div>
	</div>
	<div style="float: left;">
			<div class="layui-form-item" style="left:">
				<label class="layui-form-label">账号</label>
				<div class="layui-input-block" style="width: 200px;">
					<input name="account" type="text" placeholder="请输入" autocomplete="off"
						style="border: 0;" readonly="readonly" class="layui-input" readonly="readonly">
				</div>
			</div>
			<div class="layui-form-item" style="left:">
				<label class="layui-form-label">用户名</label>
				<div class="layui-input-block" style="width: 200px;">
					<input type="text" name="username" placeholder="请输入" autocomplete="off" id="username"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">性别</label>
				<div class="layui-input-block" id="sex">
					<input type="radio" name="sex1" value="男" title="男">
					<input type="radio" name="sex1" value="女" title="女">
				</div>
			</div>
	</div>
			<div class="layui-form-item">
				<label class="layui-form-label">邮箱</label>
				<div class="layui-input-block" style="width: 350px;">
					<input type="text" name="email" placeholder="请输入" autocomplete="off" id="email"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">电话</label>
				<div class="layui-input-block" style="width: 350px">
					<input type="text" name="phone" placeholder="请输入" autocomplete="off" id="phone"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">学校</label>
				<div class="layui-input-block" style="width: 350px;">
					<select hidden="true" name="school" readonly="readonly" id="school">
						<option value="福建工程学院">福建工程学院</option>
						<option value="福州大学">福州大学</option>
						<option value="福建医科大学">福建医科大学</option>
						<option value="福建师范大学">福建师范大学</option>
					</select>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">地址</label>
				<div class="layui-input-block" style="width: 350px;">
					<input type="text" name="address" placeholder="请输入" autocomplete="off" id="address"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">QQ</label>
				<div class="layui-input-block" style="width: 350px;">
					<input type="text" name="qq" placeholder="请输入" autocomplete="off" id="qq"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">支付宝</label>
				<div class="layui-input-block" style="width: 350px;">
					<input type="text" name="alipay" placeholder="请输入" autocomplete="off" id="alipay"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">微信</label>
				<div class="layui-input-block" style="width: 350px;">
					<input type="text" name="wechat" placeholder="请输入" autocomplete="off" id="wechat"
						class="layui-input">
				</div>
			</div>
			<br>
			<div class="layui-form-item layui-form-text" >
				<label class="layui-form-label">创建时间</label>
				<div class="layui-input-block" style="width: 350px;">
					<input name="creattime"style="border: 0;" readonly="readonly" 
					 value="2019-01-01" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item layui-form-text" >
				<label class="layui-form-label">最近登录时间</label>
				<div class="layui-input-block" style="width: 350px;">
					<input name="lasttime" style="border: 0;" readonly="readonly"  
					value="2019-01-01" type="text" name="" placeholder="" autocomplete="off" class="layui-input">
				</div>
			</div>
			<br> <br>
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button type="button" class="layui-btn" id="submit">立即提交</button>
					<button class="layui-btn layui-btn-primary">取消</button>
				</div>
			</div>

</div>
		</form>
