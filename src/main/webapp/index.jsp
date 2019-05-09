<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="base.jsp"%>
<html>
<head>
<meta property="wb:webmaster" content="bd14bd59a79e2a4d" />
<meta name="360-site-verification"
	content="0d4ec208337c4c03706dbb76fccd784e" />
<meta name="sogou_site_verification" content="dMhEpiNZxp" />
<meta name="baidu-site-verification" content="CrHL5lkDw2" />
<title>闲钱网</title>
<meta name="spm-id" content="2007.1000261" />
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/css/index.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/css/index2.css" />
<!--  <script type="text/javascript"
	src="//g.alicdn.com/mtb/??lib-windvane/2.1.1/windvane.js,lib-env/1.5.15/env.js,app-idle-lib/0.0.46/download.js,app-idle-lib/0.0.46/callapp.js"></script> -->
<script charset="utf-8"
	src="//g.alicdn.com/idleFish-F2e/idle-pc/1.0.7/home/index-min.js"></script>

<link rel="stylesheet" href="<%=basePath%>/css/index3.css">
<link rel="stylesheet" href="<%=basePath%>/css/index-card.css">

</head>

<body data-spm="1000261">
	<input type="hidden" name="user" id="user" value="${sessionScope.user.id}">
	<script type="text/javascript" src="<%=basePath%>/index.js"></script>
	<script id="tb-beacon-aplus"
		src="//g.alicdn.com/alilog/mlog/aplus_v2.js"
		exparams="category=&amp;userid=&amp;aplus&amp;yunid=&amp;f99ee776ee40e&amp;trid=&amp;asid=AQAAAABWeSRcyDX1DgAAAADzYEOWYn1/BQ=="></script>
	<script>
		with (document)
			with (body)
				with (insertBefore(createElement("script"), firstChild))
					setAttribute(
							"exparams",
							"category=&userid=&aplus&yunid=&f99ee776ee40e&trid=&asid=AQAAAABWeSRcyDX1DgAAAADzYEOWYn1/BQ==",
							id = "tb-beacon-aplus",
							src = (location > "https" ? "//g" : "//g")
									+ ".alicdn.com/alilog/mlog/aplus_v2.js")
	</script>


	<div class="site-nav site-nav-status-logout" id="J_SiteNav"
		data-component-config="{ &quot;cart&quot;: &quot;0.0.6&quot;,&quot;message&quot;: &quot;3.4.6&quot;,&quot;umpp&quot;: &quot;1.5.4&quot;,&quot;mini-login&quot;: &quot;6.3.8&quot;,&quot;tb-ie-updater&quot;: &quot;0.0.4&quot;,&quot;tbar&quot;: &quot;2.1.0&quot;,&quot;tb-footer&quot;: &quot;1.1.7&quot;,&quot;sidebar&quot;: &quot;1.0.10&quot; }"
		data-tbar="{ &quot;show&quot;:true, &quot;miniCart&quot;: &quot;2.12.2&quot;,&quot;paramsBlackList&quot;: &quot;_wt,seeyouagain1722&quot;,&quot;my_activity&quot;: &quot;https://market.m.taobao.com/apps/abs/5/38/my12?psId=58386&amp;pcPsId=58388&quot;, &quot;venueUrl&quot;: &quot;https://1212.taobao.com?wh_weex=true&amp;data_prefetch=true&amp;wx_navbar_transparent=true&quot;, &quot;helpUrl&quot;: &quot;https://consumerservice.taobao.com/online-help&quot;, &quot;validTime&quot;:{&quot;startTime&quot;: 1512057599, &quot;endTime&quot;: 1513094400}, &quot;style&quot;: {&quot;name&quot;: &quot;171212&quot;, &quot;path&quot;: &quot;kg/sidebar-style-171212/0.0.5/&quot; }, &quot;page&quot;:[],&quot;blackList&quot;:[],&quot;navDataId&quot;:{&quot;tceSid&quot;:1182567,&quot;tceVid&quot;:0},&quot;pluginVersion&quot;:{ &quot;cart&quot;:&quot;0.2.0&quot;,&quot;history&quot;:&quot;0.2.0&quot;,&quot;redpaper&quot;:&quot;0.0.8&quot;,&quot;gotop&quot;:&quot;0.2.5&quot;,&quot;help&quot;:&quot;0.2.1&quot;,&quot;ww&quot;:&quot;0.0.3&quot;,&quot;pagenav&quot;:&quot;0.0.27&quot;,&quot;myasset&quot;:&quot;0.0.9&quot;,&quot;my1212&quot;:&quot;0.0.1&quot;,&quot;my1111&quot;:&quot;0.2.2&quot;}}">
		<div class="site-nav-bd" id="J_SiteNavBd">

			<ul class="site-nav-bd-l" id="J_SiteNavBdL" data-spm-ab="1">

				<li class="site-nav-menu site-nav-login" id="J_SiteNavLogin"
					data-name="login" data-spm="754894437"><div
						class="site-nav-menu-hd">
						<div class="site-nav-sign">
							<a href="#" target="_top" class="h"><!-- 亲，请登录 -->欢迎您，${sessionScope.user.username}</a> <a href="#"
								target="_top"><!-- 免费注册 -->退出</a>
						</div>
						<div class="site-nav-user">
							<a href="#" target="_top" class="site-nav-login-info-nick ">undefined</a>
							<span class="site-nav-arrow"><span class="site-nav-icon"></span></span>
						</div>
					</div>
					<div class="site-nav-menu-bd" id="J_SiteNavLoginPanel"></div></li>




				<li id="J_Tmsg"
					class="site-nav-tmsg tmsg site-nav-multi-menu J_MultiMenu"
					data-name="tmsg" data-spm="1997563201">
					<div class="J_Menu site-nav-menu">
						<div class="site-nav-menu-hd J_Tmsg_Basic tmsg_basic">
							<span class="J_Tmsg_Logo tmsg_logo_area" style="zoom: 1;">
								<span class="J_Tmsg_Logo_Loading tmsg_logo_loading"></span> <span
								class="J_Tmsg_Logo_Icon tmsg_logo_icon site-nav-icon"
								style="display: none"></span> <span
								class="J_Tmsg_Logo_Text tmsg_logo_text">消息</span> <span
								class="J_Tmsg_Logo_Unread tmsg_logo_unread"></span>
							</span> <span class="site-nav-arrow"><span class="site-nav-icon"></span></span>

						</div>

						<div class="site-nav-menu-bd">
							<div class="J_Tmsg_Panel_Apps tmsg_panel_apps"></div>
						</div>
					</div>
					<div class="J_Tmsg_Panels tmsg_panels">
						<div class="J_Tmsg_Panel_Detail tmsg_panel_detail"></div>
						<div class="J_Tmsg_Panel_history tmsg_panel_history"></div>
						<div class="J_Tmsg_Panel_Strong tmsg_panel_strong"></div>
						<div class="J_Tmsg_Panel_Setting tmsg_panel_setting"></div>
					</div>
				</li>




				<li class="site-nav-menu site-nav-mobile" id="J_SiteNavMobile"
					data-name="mobile" data-spm="1997563273">
					<div class="site-nav-menu-hd">
						<a href="#" target="_top"> <span>手机逛闲钱网</span>
						</a>

					</div>

				</li>




				<li
					class="site-nav-menu site-nav-weekend site-nav-multi-menu J_MultiMenu"
					id="J_SiteNavWeekend" data-name="weekend" data-spm="201711111212">
				</li>



			</ul>

			<ul class="site-nav-bd-r" id="J_SiteNavBdR" data-spm-ab="2">




				<li
					class="site-nav-menu site-nav-mytaobao site-nav-multi-menu J_MultiMenu"
					id="J_SiteNavMytaobao" data-name="mytaobao" data-spm="1997525045">
					<div class="site-nav-menu-hd">
						<a href="<%=basePath%>/my.jsp" target="_top"> <span>我的闲钱网</span>
						</a> <span class="site-nav-arrow"><span class="site-nav-icon"></span></span>

					</div>

					<div class="site-nav-menu-bd site-nav-menu-list">
						<div class="site-nav-menu-bd-panel menu-bd-panel">

							<a href="#" target="_top">已买到的宝贝</a> <a href="#" target="_top">我的足迹</a>

						</div>
					</div>

				</li>




				<li
					class="site-nav-menu site-nav-cart site-nav-menu-empty site-nav-multi-menu J_MultiMenu menu-empty J_SiteNavDisableMenu mini-cart menu"
					id="J_MiniCart" data-name="cart" data-spm="1997525049">
					<div class="site-nav-menu-hd">
						<a href="#" target="_top" id="mc-menu-hd"> <span
							class="site-nav-icon site-nav-icon-highlight"></span> <span>购物车</span>
							<strong class="h" id="J_MiniCartNum"></strong>
						</a> <span class="site-nav-arrow"><span class="site-nav-icon"></span></span>

					</div>
					<div class="site-nav-menu-bd">
						<div class="site-nav-menu-bd-panel menu-bd-panel"></div>
					</div>
				</li>




				<li
					class="site-nav-menu site-nav-favor site-nav-multi-menu J_MultiMenu"
					id="J_SiteNavFavor" data-name="favor" data-spm="1997525053">
					<div class="site-nav-menu-hd">
						<a href="#" target="_top"> <span class="site-nav-icon"></span>
							<span>收藏夹</span>
						</a> <span class="site-nav-arrow"><span class="site-nav-icon"></span></span>

					</div>

					<div class="site-nav-menu-bd site-nav-menu-list">
						<div class="site-nav-menu-bd-panel menu-bd-panel">

							<a href="#" target="_top">收藏的宝贝</a> <a href="#" target="_top">收藏的店铺</a>

						</div>
					</div>

				</li>




				<li class="site-nav-menu site-nav-catalog" id="J_SiteNavCatalog"
					data-name="catalog" data-spm="1997563209">
					<div class="site-nav-menu-hd">
						<a href="#" target="_top"> <span>商品分类</span>
						</a>

					</div>

				</li>


				<li class="site-nav-pipe">|</li>



				<li
					class="site-nav-menu site-nav-seller site-nav-multi-menu J_MultiMenu"
					id="J_SiteNavSeller" data-name="seller" data-spm="1997525073">
					<div class="site-nav-menu-hd">
						<a href="#" target="_top"> <span>卖家中心</span>
						</a> <span class="site-nav-arrow"><span class="site-nav-icon"></span></span>

					</div>

					<div class="site-nav-menu-bd site-nav-menu-list">
						<div class="site-nav-menu-bd-panel menu-bd-panel">

							<a href="#" target="_top">免费开店</a> <a href="#" target="_top">已卖出的宝贝</a>
							<a href="#" target="_top">出售中的宝贝</a> <a href="#" target="_top">卖家服务市场</a>

							<a href="#" target="_top">卖家培训中心</a> <a href="#" target="_top">体检中心</a>
							<a href="#" target="_top">问商友</a>

						</div>
					</div>

				</li>




				<li
					class="site-nav-menu site-nav-service site-nav-multi-menu J_MultiMenu"
					id="J_SiteNavService" data-name="service" data-spm="754895749">
					<div class="site-nav-menu-hd">
						<a href="#" target="_top"> <span>联系客服</span>
						</a> <span class="site-nav-arrow"><span class="site-nav-icon"></span></span>

					</div>

					<div class="site-nav-menu-bd site-nav-menu-list">
						<div class="site-nav-menu-bd-panel menu-bd-panel">

							<a href="#" target="_top">消费者客服</a> <a href="#" target="_top">卖家客服</a>

						</div>
					</div>

				</li>




				<li
					class="site-nav-menu site-nav-sitemap site-nav-multi-menu J_MultiMenu"
					id="J_SiteNavSitemap" data-name="sitemap" data-spm="1997525077">
					<div class="site-nav-menu-hd">
						<a href="#" target="_top"> <span
							class="site-nav-icon site-nav-icon-highlight"></span> <span>网站导航</span>
						</a> <span class="site-nav-arrow"><span class="site-nav-icon"></span></span>

					</div>

				</li>
			</ul>

		</div>
	</div>

	<div class="main">
		<div data-v-3fb25ee8="" class="banner-wrap">
			<div data-v-3fb25ee8="" class="main-wrap">
				<div data-v-5aeb7472="" data-v-3fb25ee8="" class="navbar-wrap">
					<img src="<%=basePath%>/images/SecondMarketLogo.png"
						class="logo">
					<div data-v-5aeb7472="" class="tab-wrap">
						<div data-v-5aeb7472="" class="tab">
							<p data-v-5aeb7472="" class="tab-name">首页</p>
							<div data-v-5aeb7472="" class="tab-line"></div>
						</div>
						<div data-v-5aeb7472="" class="tab xz">
							<div data-v-5aeb7472=""
								style="display: flex; flex-direction: row; align-items: center;">
								<span data-v-5aeb7472="" class="tab-name"> 我的闲置 </span> <img
									data-v-5aeb7472=""
									src="//img.alicdn.com/tfs/TB1bI4vnOLaK1RjSZFxXXamPFXa-24-24.png"
									class="icon-more">
							</div>
							<div data-v-5aeb7472="" class="sublist">
								<div data-v-5aeb7472="" class="sub">
									<p data-v-5aeb7472="" class="name">出售中</p>
									<p data-v-5aeb7472="" id="saleing1" class="num">0</p>
								</div>
								<div data-v-5aeb7472="" class="sub">
									<p data-v-5aeb7472="" class="name">已卖出</p>
									<p data-v-5aeb7472="" id="saled1" class="num">0</p>
								</div>
								<div data-v-5aeb7472="" class="sub">
									<p data-v-5aeb7472="" class="name">我的关注</p>
									<p data-v-5aeb7472="" id="attention1" class="num">0</p>
								</div>
								<div data-v-5aeb7472="" class="sub">
									<p data-v-5aeb7472="" class="name">我的收藏</p>
									<p data-v-5aeb7472="" id="collect1" class="num">0</p>
								</div>
							</div>
						</div>
					</div>
				</div>
				<%-- <div data-v-60ebec27="" data-v-3fb25ee8="" class="usercard-wrap">
					<div data-v-60ebec27="" class="unlogin">
						<img data-v-60ebec27="" src="${user.avatar}" class="icon">
						<a data-v-60ebec27="" href="#" class="tip">${user.username}</a>
						<a data-v-60ebec27="" href="#" class="btn">退出</a>
					</div>
				</div> --%>
				<div data-v-60ebec27="" data-v-3fb25ee8="" class="usercard-wrap">
					<div data-v-60ebec27="" class="logined">
						<div data-v-60ebec27="" class="user-info">
							<div data-v-60ebec27="" class="head">
								<img data-v-60ebec27="" src="${sessionScope.user.avatar}" class="head-img">
							</div>
							<div data-v-60ebec27="" class="user-des">
								<p data-v-60ebec27="" class="nick">${sessionScope.user.username}</p>
								<p data-v-60ebec27="" class="sum">虽然没挣到钱，但在闲钱网开心就好</p>
							</div>
						</div>
						<div data-v-60ebec27="" class="my-list">
							<div data-v-60ebec27="" class="my-item">
								<img data-v-60ebec27=""
									src="//img.alicdn.com/tfs/TB1W0t9nVzqK1RjSZSgXXcpAVXa-52-52.png"
									class="item-icon">
								<p data-v-60ebec27="" class="item-name">出售中</p>
								<p data-v-60ebec27="" id="saleing" class="item-num">0</p>
							</div>
							<div data-v-60ebec27="" class="my-item">
								<img data-v-60ebec27=""
									src="//img.alicdn.com/tfs/TB1xwqvn4jaK1RjSZKzXXXVwXXa-52-52.png"
									class="item-icon">
								<p data-v-60ebec27="" class="item-name">已卖出</p>
								<p data-v-60ebec27="" id="saled" class="item-num">0</p>
							</div>
							<div data-v-60ebec27="" class="my-item">
								<img data-v-60ebec27=""
									src="//img.alicdn.com/tfs/TB1k8c.nSzqK1RjSZFjXXblCFXa-52-52.png"
									class="item-icon">
								<p data-v-60ebec27="" class="item-name">我的关注</p>
								<p data-v-60ebec27="" id="attention" class="item-num">0</p>
							</div>
							<div data-v-60ebec27="" class="my-item">
								<img data-v-60ebec27=""
									src="//img.alicdn.com/tfs/TB1wahwn4naK1RjSZFtXXbC2VXa-52-52.png"
									class="item-icon">
								<p data-v-60ebec27="" class="item-name">我的收藏</p>
								<p data-v-60ebec27="" id="collect" class="item-num">0</p>
							</div>
						</div>
					</div>
				</div>
				<script type="text/javascript">
			 	  layui.use('jquery', function(){
			 		  var $ = layui.jquery;
			 		 $.ajax({
							url:BASE_PATH+'/TCommodity/countCommodity.do',
							type:'post',
							data: {
								sellerId:$('#user').val(),
							},
							dataType:'json',
							error:function (res) {
								layer.alert(res.data.erro);
							},
							success : function(layero, index){
								$("#saleing").text(layero.data.saleing);
								$("#saled").text(layero.data.saled);
								$("#attention").text(layero.data.attention);
								$("#collect").text(layero.data.collect);
								$("#saleing1").text(layero.data.saleing);
								$("#saled1").text(layero.data.saled);
								$("#attention1").text(layero.data.attention);
								$("#collect1").text(layero.data.collect);
							},
						});
			 		});
	 	    </script>
			</div>
		</div>
		<div data-v-0bf36d39="" class="slodbar-wrap">
			<div data-v-0bf36d39="" class="slodbar-item" onclick="wantcommodity()">
				<img data-v-0bf36d39=""
					src="//img.alicdn.com/tfs/TB1SkxunMDqK1RjSZSyXXaxEVXa-112-112.png"
					class="icon">
				<div data-v-0bf36d39="" class="desc">
					<p data-v-0bf36d39="" class="name">发布需求</p>
					<p data-v-0bf36d39="" class="cont">你的需要就是我的需求，我的百倍用心，愿你十分满意</p>
					<p data-v-0bf36d39="" class="cont" style="color: red;">不怕找不到，就怕想不到。不卖也要嫁给我！</p>
				</div>
			</div>
			<div data-v-0bf36d39="" class="line"></div>
			<div data-v-0bf36d39="" class="slodbar-item" onclick="addcommodity()">
				<img data-v-0bf36d39=""
					src="//img.alicdn.com/tfs/TB1g54xnMHqK1RjSZFPXXcwapXa-112-112.png"
					class="icon">
				<div data-v-0bf36d39="" class="desc">
					<p data-v-0bf36d39="" class="name">发布闲置</p>
					<p data-v-0bf36d39="" class="cont">更换新主人，寻找新归宿</p>
					<p data-v-0bf36d39="" class="cont" style="color: red;">你不想要的，或许真是我所需，不买也要来娶我！</p>
				</div>
			</div>
		</div>
		<div data-v-03fbd53c="" id="tittleBar" class="tabbar-wrap">
			<div data-v-03fbd53c="" class="item" onclick="change(this)" str="type=新鲜">
				<p data-v-03fbd53c="" class="name active">新鲜</p>
				<div data-v-03fbd53c="" class="line"></div>
			</div>
			<div data-v-03fbd53c="" class="item" onclick="change(this)" str="type=人气">
				<p data-v-03fbd53c="" class="name">人气</p>
				<!---->
			</div>
			<div data-v-03fbd53c="" class="item" onclick="change(this)" str="category=配件">
				<p data-v-03fbd53c="" class="name">配件</p>
				<!---->
			</div>
			<div data-v-03fbd53c="" class="item" onclick="change(this)" str="category=手机">
				<p data-v-03fbd53c="" class="name">手机</p>
				<!---->
			</div>
			<div data-v-03fbd53c="" class="item" onclick="change(this)" str="category=书籍">
				<p data-v-03fbd53c="" class="name">书籍</p>
				<!---->
			</div>
			<div data-v-03fbd53c="" class="item" onclick="change(this)" str="type=关注">
				<p data-v-03fbd53c="" class="name">关注</p>
				<!---->
			</div>
			<div data-v-03fbd53c="" class="item" onclick="change(this)" str="type=收购">
				<p data-v-03fbd53c="" class="name">收购</p>
				<!---->	
			</div>
			<div style="margin-right: 20px">
				<div class="layui-input-block" style="float: left; position: relative;">
				    <label class="layui-form-label">关键字：</label>
				  	<input style="width: auto;" type="text" id="key" name="key" lay-verify="required" placeholder="请输入关键字" autocomplete="off" class="layui-input">
				</div>
				<button class="layui-btn" lay-submit="" id="searchBtn" data-type="getInfo" style="float: left; font-weight: 500;
					background-color: #ffd84d;font-size: 16px;font-family: PingFangSC-Semibold;" onclick="searchByKey()">搜索</button>
			</div>
		</div>
		<div class="item-list">
			<div class="item-list-wrap" id="demo"></div>
			<script type="text/javascript">
	 	    </script>
		</div>


		<!--  分页条  -->
		<!-- 		<div class="pagination">
			<div class="el-pagination is-background">
				<button type="button" disabled="disabled" class="btn-prev">
					<i class="el-icon el-icon-arrow-left"></i>
				</button>
				<ul class="el-pager">
					<li class="number active">1</li>
					
					<li class="number">2</li>
					<li class="number">3</li>
					<li class="number">4</li>
					<li class="number">5</li>
					<li class="number">6</li>
					<li class="el-icon more btn-quicknext el-icon-more"></li>
					<li class="number">100</li>
				</ul>
				<button type="button" class="btn-next">
					<i class="el-icon el-icon-arrow-right"></i>
				</button>
			</div>
		</div> -->
		<div data-v-e288e42c="">
			<div data-v-e288e42c="" class="bottom-wrap">
				<div data-v-e288e42c="" class="bottom-main">
					<img data-v-e288e42c="" src="<%=basePath%>/images/logo2.png"
						class="bottom-logo"> <img data-v-e288e42c=""
						src="<%=basePath%>/images/logo3.png" class="bottom-desc">
					<div data-v-e288e42c="" class="bottom-download">
						<div data-v-e288e42c="" class="download-w"
							style="margin-right: 5px;">
							<a data-v-e288e42c="" href="#" target="_blank"
								style="display: block;"><img data-v-e288e42c=""
								src="//img.alicdn.com/tps/i4/TB1VO4WHVXXXXcKXFXXfBBiHXXX-200-62.png"
								class="bottom-download-ios" style="margin-bottom: 5px;"></a> <img
								data-v-e288e42c=""
								src="//img.alicdn.com/tps/i2/TB1aOKTHVXXXXXdXpXXfBBiHXXX-200-62.png"
								class="bottom-download-and">
						</div>
						<div data-v-e288e42c="" class="bottom-download-code">
							<img data-v-e288e42c="" src="<%=basePath%>/images/2wm.png"
								class="bottom-download-code1">
						</div>
					</div>
				</div>
			</div>
			<div data-v-e288e42c="" class="rz-wrap">
				<div data-v-e288e42c="" class="rz-main">
					<img data-v-e288e42c=""
						src="//img.alicdn.com/tfs/TB1COuknQvoK1RjSZPfXXXPKFXa-264-60.png">
					<img data-v-e288e42c=""
						src="//img.alicdn.com/tfs/TB1Zj1enMDqK1RjSZSyXXaxEVXa-294-60.png">
					<img data-v-e288e42c=""
						src="//img.alicdn.com/tfs/TB1j3V.nSrqK1RjSZK9XXXyypXa-272-60.png">
					<a data-v-e288e42c="" href="#" target="_blank"><img
						data-v-e288e42c=""
						src="//img.alicdn.com/tfs/TB1H49mnNTpK1RjSZFMXXbG_VXa-356-60.png"
						style="cursor: pointer;"></a>
				</div>
			</div>
		</div>
		<div data-v-9a34bc10="" class="pop-wrap">
			<!---->
			<img data-v-9a34bc10="" src="<%=basePath%>/images/shabi.jpg"
				class="pop-icon">
			<div data-v-9a34bc10="" class="line"></div>
			<!---->
		</div>
		<div data-v-839d5c44="" class="el-dialog__wrapper"
			style="display: none;">
			<div role="dialog" aria-modal="true"
				aria-label="电脑端该功能已打烊，请下载闲鱼App进行操作。"
				class="el-dialog el-dialog--center"
				style="margin-top: 15vh; width: 650px;">
				<div class="el-dialog__header">
					<span class="el-dialog__title">电脑端该功能已打烊，请下载闲鱼App进行操作。</span>
					<button type="button" aria-label="Close"
						class="el-dialog__headerbtn">
						<i class="el-dialog__close el-icon el-icon-close"></i>
					</button>
				</div>
				<!---->
				<!---->
			</div>
		</div>
	</div>
	<!-- ushu abtest -->
	<script type="text/javascript" src="//assets.alicdn.com/s/fdc/xwj.js"></script>
	<script type="text/javascript">
	    		    			window._ap_xwj && _ap_xwj.monitor("130917-225");
	    				</script>

	<script type="text/javascript"
		src="//assets.alicdn.com/s/tb-tracer-min.js"></script>
	<img
		src="//img.alicdn.com/tps/i4/T1pkSfXexkXXXXXXXX-1-1.gif?tracer=20120918-90-771">
	<!-- <script src='//w.cnzz.com/c.php?id=30057895' ></script> -->


	<div id="J_SiteFooter" style="min-height: 150px"></div>
	<iframe
		src="//g.alicdn.com/alilog/oneplus/blk.html#coid=nZKfFDVYQlkCAdpVJYHcZ2qU&amp;noid="
		id="_oid_ifr_" style="width: 0px; height: 0px; display: none;"></iframe>
</body>
</html>
