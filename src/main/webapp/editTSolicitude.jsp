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
	
<form id="tSolicitudeform" lay-filter="tSolicitudeform" class="layui-form" style="margin-top: 5px">
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
		<td>userId</td>
		<td>
			<input id="userId" name="userId" class="layui-input" style="width:150px">
		</td>
    </tr>
    <tr>
		<td>commodityId</td>
		<td>
			<input id="commodityId" name="commodityId" class="layui-input" style="width:150px">
		</td>
    </tr>
    <tr>
		<td>category</td>
		<td>
			<input id="category" name="category" class="layui-input" style="width:150px">
		</td>
    </tr>
    <tr>
		<td>type</td>
		<td>
			<input id="type" name="type" class="layui-input" style="width:150px">
		</td>
    </tr>
  </tbody>
</table>
	</form>

</body>
              
</html>