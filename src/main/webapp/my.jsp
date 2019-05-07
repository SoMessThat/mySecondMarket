<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="./base.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="renderer" content="webkit">
  		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<link rel="stylesheet" type="text/css" href="./css/admin.css"/>
		<title>校园二手买卖系统</title>
</head>
<body>
  <div class="main-layout" id='main-layout'>
  <!--侧边栏-->
			<div class="main-layout-side">
    <div class="m-logo">
				</div>
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree"  lay-filter="menu">
        <li class="layui-nav-item">
    	    <a href="javascript:;" data-url="<%=request.getContextPath()%>/sales/managesalesReport.php" data-id='0' data-text="我的信息">我的信息</a>
        </li>
        <li class="layui-nav-item">
          <a href="javascript:;" data-url="<%=request.getContextPath()%>/tOrder.jsp" data-id='1' data-text="我上架的商品">我上架的商品</a>
        </li>
        <li class="layui-nav-item">
    	    <a href="javascript:;" data-url="<%=request.getContextPath()%>/room/roomListView.php" data-id='2' data-text="我发布的需求">我发布的需求</a>
        </li>
        <li class="layui-nav-item">
    	    <a href="javascript:;" data-url="<%=request.getContextPath()%>/tOrder.jsp" data-id='3' data-text="我的订单">我的订单</a>
        </li>
         <li class="layui-nav-item">
             <a href="javascript:;"><span class="lll">我喜欢的商品</span></a>
			    <dl class="layui-nav-child">
			      <dd><a href="javascript:;" data-url="<%=request.getContextPath()%>/user/manageUser.php" data-id='4' data-text="我的收藏">我的收藏</a></dd>
			      <dd><a href="javascript:;"  data-url="<%=request.getContextPath()%>/admin/manageAdmin.php" data-id='5' data-text="我的关注">我的关注</a></dd>
			    </dl>
        </li>
        <li class="layui-nav-item">
    	    <a href="javascript:;" data-url="<%=request.getContextPath()%>/tAnnouncement.jsp" data-id='6' data-text="公告信息">公告信息</a>
        </li>
      </ul>
    </div>
<div class="main-layout-container">
  	<!--头部-->
				<div class="main-layout-header">
					<div class="menu-btn" id="hideBtn">
						<a href="javascript:;">
							<span class="iconfont">&lt;</span>
						</a>
					</div>
					<ul class="layui-nav" lay-filter="rightNav">
					  <li class="layui-nav-item">
					    <a href="javascript:;" data-url="admin-info.html" data-id='5' data-text="个人信息">超级管理员</a>
					  </li>
					  <li class="layui-nav-item"><a href="javascript:;">退出</a></li>
					</ul>
    			 </div>
  <div class="main-layout-body">
  <div class="layui-tab  layui-tab-brief main-layout-tab" lay-filter="tab" lay-allowClose="true">
   <ul class="layui-tab-title">
    <li class="layui-this welcome">后台主页</li>
  </ul>
  <div class="layui-tab-content">
	    <div class="layui-tab-item layui-show" style="background: #f5f5f5;">
	    	<!--1-->
	    	<iframe src="<%-- <%=request.getContextPath()%>/room/roomListView.php --%>" width="100%" height="100%" name="iframe" frameborder="0" scrolling="no"></iframe>
	    	<!--1end-->
	    </div>
	  </div>
  </div>
</div>
   </div>
  <!--遮罩-->
			<div id="main-mask" class="main-mask">
				
			</div>
  </div>
<script>
//JavaScript代码区域
layui.use(['layer', 'form', 'element', 'jquery'], function() {
	var layer = layui.layer;
	var element = layui.element;
	var form = layui.form;
	var $ = layui.jquery;
	var hideBtn = $('#hideBtn');
	var mainLayout = $('#main-layout');
	var mainMask = $('.main-mask');
	//监听导航点击
	element.on('nav(menu)', function(elem) {
		var id = elem.attr('data-id');
        var url = elem.attr('data-url');
        var text = elem.attr('data-text');
		if(!url){
			return;
		}
		var isActive = $('.layui-tab .layui-tab-title').find("li[lay-id=" + id + "]");
		if(isActive.length > 0) {
			//切换到选项卡
			element.tabChange('tab', id);
		} else {
			element.tabAdd('tab', {
				title: text,
				content: '<iframe src="' + url + '" name="iframe' + id + '" class="iframe" framborder="0" data-id="' + id + '" scrolling="auto" width="100%"  height="100%"></iframe>',
				id: id
			});
			element.tabChange('tab', id);
			
		}
		mainLayout.removeClass('hide-side');
	});
	//菜单隐藏显示
	hideBtn.on('click', function() {
		if(!mainLayout.hasClass('hide-side')) {
			mainLayout.addClass('hide-side');
		} else {
			mainLayout.removeClass('hide-side');
		}
	});
	//遮罩点击隐藏
	mainMask.on('click', function() {
		mainLayout.removeClass('hide-side');
	})

});

layui.config({
	base: '../js/layui/'
}).extend({
	dialog: 'dialog',
}); 

layui.use(['form', 'jquery', 'laydate', 'layer', 'laypage', 'dialog',   'element'], function() {
	var form = layui.form,
		layer = layui.layer,
		$ = layui.jquery,
		dialog = layui.dialog;
	//获取当前iframe的name值
	var iframeObj = $(window.frameElement).attr('name');
	//全选
	form.on('checkbox(allChoose)', function(data) {
		var child = $(data.elem).parents('table').find('tbody input[type="checkbox"]');
		child.each(function(index, item) {
			item.checked = data.elem.checked;
		});
		form.render('checkbox');
	});
	//渲染表单
	form.render();	
	//顶部添加
	$('.addBtn').click(function() {
		var url=$(this).attr('data-url');
		//将iframeObj传递给父级窗口,执行操作完成刷新
		parent.page("菜单添加", url, iframeObj, w = "700px", h = "620px");
		return false;

	}).mouseenter(function() {

		dialog.tips('添加', '.addBtn');

	})
	//顶部排序
	$('.listOrderBtn').click(function() {
		var url=$(this).attr('data-url');
		dialog.confirm({
			message:'您确定要进行排序吗？',
			success:function(){
				layer.msg('确定了')
			},
			cancel:function(){
				layer.msg('取消了')
			}
		})
		return false;

	}).mouseenter(function() {

		dialog.tips('批量排序', '.listOrderBtn');

	})	
	//顶部批量删除
	$('.delBtn').click(function() {
		var url=$(this).attr('data-url');
		dialog.confirm({
			message:'您确定要删除选中项',
			success:function(){
				layer.msg('删除了')
			},
			cancel:function(){
				layer.msg('取消了')
			}
		})
		return false;

	}).mouseenter(function() {

		dialog.tips('批量删除', '.delBtn');

	})	
	//列表添加
	$('#table-list').on('click', '.add-btn', function() {
		var url=$(this).attr('data-url');
		//将iframeObj传递给父级窗口
		parent.page("菜单添加", url, iframeObj, w = "700px", h = "620px");
		return false;
	})
	//列表删除
	$('#table-list').on('click', '.del-btn', function() {
		var url=$(this).attr('data-url');
		var id = $(this).attr('data-id');
		dialog.confirm({
			message:'您确定要进行删除吗？',
			success:function(){
				layer.msg('确定了')
			},
			cancel:function(){
				layer.msg('取消了')
			}
		})
		return false;
	})
	//列表跳转
	$('#table-list,.tool-btn').on('click', '.go-btn', function() {
		var url=$(this).attr('data-url');
		var id = $(this).attr('data-id');
		window.location.href=url+"?id="+id;
		return false;
	})
	//编辑栏目
	$('#table-list').on('click', '.edit-btn', function() {
		var That = $(this);
		var id = That.attr('data-id');
		var url=That.attr('data-url');
		//将iframeObj传递给父级窗口
		parent.page("菜单编辑", url + "?id=" + id, iframeObj, w = "700px", h = "620px");
		return false;
	})
});

/**
 * 控制iframe窗口的刷新操作
 */
var iframeObjName;

//父级弹出页面
function page(title, url, obj, w, h) {
	if(title == null || title == '') {
		title = false;
	};
	if(url == null || url == '') {
		url = "404.html";
	};
	if(w == null || w == '') {
		w = '700px';
	};
	if(h == null || h == '') {
		h = '350px';
	};
	iframeObjName = obj;
	//如果手机端，全屏显示
	if(window.innerWidth <= 768) {
		var index = layer.open({
			type: 2,
			title: title,
			area: [320, h],
			fixed: false, //不固定
			content: url
		});
		layer.full(index);
	} else {
		var index = layer.open({
			type: 2,
			title: title,
			area: [w, h],
			fixed: false, //不固定
			content: url
		});
	}
}

/**
 * 刷新子页,关闭弹窗
 */
function refresh() {
	//根据传递的name值，获取子iframe窗口，执行刷新
	if(window.frames[iframeObjName]) {
		window.frames[iframeObjName].location.reload();

	} else {
		window.location.reload();
	}

	layer.closeAll();
}
</script>
</body>
</html>
