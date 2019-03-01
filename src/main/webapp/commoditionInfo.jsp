<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="base.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description"
	content="${commodity.name}" />
<meta name="keywords" content="${commodity.name}" />
<meta name="spm-id" content="2007.1000338" />
<title>&#36842;&#22885;&#21475;&#32418; - 闲鱼.淘宝二手</title>
<script>window.g_config={appId:1007,toolbar:false};</script>


<!-- start idle vmcommon assets 4.0-->
<link rel="shortcut icon" type="image/x-icon"
	href="//www.taobao.com/favicon.ico" />
<link rel="search" type="application/opensearchdescription+xml"
	href="//assets.alicdn.com/plugins/opensearch/provider.xml" title="淘宝购物" />
<!-- S GLOBAL CSS -->
<link rel="stylesheet"
	href="//g.alicdn.com/tb/global/3.5.34/global-min.css">
<!-- S GLOBAL CSS -->
<link rel="stylesheet"
	href="//g.alicdn.com/mtb/app-idle-pc/1.7.10/??common/base-min.css,widget/header5/index-min.css,widget/footer5/index-min.css,pages/detail/page/detail-min.css">
<!-- S GLOBAL JS -->
<script
	src="//g.alicdn.com/??kissy/k/1.3.0/kissy-min.js,tb/global/3.5.34/global-min.js"></script>
<!-- E GLOBAL JS -->
<script
	src="//g.alicdn.com/mtb/app-idle-pc/1.7.10/common/??package-config-min.js,global-min.js"></script>

<!-- end idle vmcommon assets 4.0-->
</head>
<body>
	<script>
with(document)with(body)with(insertBefore(createElement("script"),firstChild))setAttribute("exparams","category=&userid=&aplus&yunid=&3933e334e1ab3&trid=&asid=AQAAAABhwm9ca2kDDwAAAABuqIJANz8hsw==",id="tb-beacon-aplus",src=(location>"https"?"//g":"//g")+".alicdn.com/alilog/mlog/aplus_v2.js")
</script>

	<script>(function(){var a=document.body;window.screen.width>1024?a.className="w1190":a.className="w990"})();</script>
<input type="hidden" name="commotity" id="commotity" value="${commotity.id}">
	<!-- S GLOBAL HTML -->
	<div id="J_SiteNav" class="site-nav">
		<div id="J_SiteNavBd" class="site-nav-bd">
			<ul id="J_SiteNavBdL" class="site-nav-bd-l"></ul>
			<ul id="J_SiteNavBdR" class="site-nav-bd-r"></ul>
		</div>
	</div>
	<!-- E GLOBAL HTML -->

	<script>
TB.Global.init();
ABC.config({
    pageName: 'detail',
    pub: '1.7.10',
    path: '//g.alicdn.com/mtb/app-idle-pc/',
    charset: 'utf-8'
});
SecondHand.current = 'detail';
</script>

	<div class="idle-header-wrap">
		<div class="idle-header" id="J_IdleHeader">
			<h1 class="idle-logo">
				<a href="http://2.taobao.com" target="_top"><img
					src="//img.alicdn.com/tps/i3/TB1ys1sHVXXXXcrXVXXL_ZfHFXX-208-46.png"
					alt="闲鱼" width="208" height="46" /></a>
			</h1>

			<div class="idle-nav">
				<div class="idle-menu">
					<ul>
						<li class="m-home"><a href="//2.taobao.com/">首页</a></li>
						<li class="m-app"><a href="//2.taobao.com/app/index">手机二手</a></li>
						<li><a href="//www.taobao.com/markets/paimai/usedcar">二手车估价</a></li>
						<li class="m-auction"><a href="//2.taobao.com/auction/list">降降降</a></li>
					</ul>
				</div>

				<div class="idle-manage">
					<span class="idle-manage-sp">|</span>
					<ul>
						<li><a class="pub-overlay-btn">发布闲置</a></li>
						<li id="J_IdleLi" class="my-idle-li"><a class="my-idle-link"
							id="J_IdleLink" href="//trade.2.taobao.com">我的闲置<i
								class="iconfont icon-down">&#xe601;</i><i
								class="iconfont icon-up">&#xe600;</i></a></li>
					</ul>
				</div>
			</div>

			<!--<div class="idle-search">-->
			<!--  <form method="get" action="//s.2.taobao.com/list/list.htm" name="search" target="_top">-->
			<!--    <input class="input-search" id="J_HeaderSearchQuery" name="q" type="text" value="" placeholder="搜闲鱼" />-->
			<!--    <input type="hidden" name="search_type" value="item" autocomplete="off" />-->
			<!--    <input type="hidden" name="app" value="shopsearch" autocomplete="off" />-->
			<!--    <button class="btn-search" type="submit"><i class="iconfont">&#xe602;</i><span class="search-img"></span></button>-->
			<!--  </form>-->
			<!--</div>-->
		</div>
	</div>

	<script>
KISSY.use('widget/header5/index');
</script>


	<div id="content">
		<div id="page">
			<div id="idle-detail" data-token="3933e334e1ab3">
				<div class="top-nav clearfix">
					<div class="others-wrap">
						<ul class="others clearfix">

							<li id="J_Browse"
								data-url="//count.taobao.com/counter3?keys=ICVT_7_584816873266&amp;inc=ICVT_7_584816873266&amp;sign=582049afbe625afef194cf6ddb987ca9932e1"
								data-key="ICVT_7_584816873266">
								<h5>宝贝浏览次数</h5> <span>${commodity.pop}</span>
							</li>
							<li><h5>最近编辑</h5>
								<span><script> document.write( timestampToTime(${commodity.creartTime}));</script></span></li>
							<li class="tn-item-from"><a target="_blank"
								href="//www.taobao.com/market/2/new-fish.php"><h5>来自</h5>
									<p class="tn-item-icon"></p></a></li>
						</ul>
					</div>
					<div class="seller-info " id="J_SellerInfo"
						data-url="//2.taobao.com/itemref/trade_ratting.htm?uid=IvH8yMkPePmN4PF9zOmlIPH*eXmleMm*HvHgSvFguvmxT">
						<div class="simple" data-spm="2007.1000338.1">
							<div class="avatar">
								<img src="//wwc.alicdn.com/avatar/getAvatar.do?userNick=可爱天使任&width=30&height=30&type=sns">
							</div>
							<div class="wangwang">
								<a href="//2.taobao.com/credit/credit.htm?userIdCode=IvH8yMkPePmN4PF9zOmlIPH*eXmleMm*HvHgSvFguvmxT"
									class="hCard fn" target="_blank">${user.username}</a>
							</div>
							<div class="user-icons">
								<span title="已通过实名认证" class="user-verify"></span> <span
									title="vip1" class="vip-level  vip-level1" rel="nofollow"></span>
							</div>
							<b class="arrow-wrap"><i class="arrow"></i></b>
						</div>
						<div class="details">
				            <div class="basic-info">
				                <p>北京 女</p>
				                <p>注册时间：2009-07-12</p>
				            </div>
				            <div class="seller-rate">
				                <h4>转卖<strong> 6 </strong>笔，<strong> 0 </strong>人评价</h4>
				                <ul class="parameter">
				                    <li><span>靠谱度：</span><strong class="high">-</strong> 分<span class="high">&nbsp;&nbsp;</span></li>
				                    <li><span>性价比：</span><strong class="high">-</strong> 分<span class="high">&nbsp;&nbsp;</span></li>
				                </ul>
				            </div>
						</div>
					</div>
					<div>
						<a
							href="//110.alibaba.com/report/commodity_route.htm?901001=584816873266&from_source=tb"
							data-id="584816873266" target="_blank" class="inform">举报该宝贝</a>
					</div>
				</div>
				<div class="layout grid-s730m0">
					<div class="col-main">
						<div class="main-wrap">
							<div class="property" id="J_Property">
								<h1 class="title">${commodity.name}</h1>
								<ul class="price-info">
									<li class="price-block"><span class="para">转&nbsp;&nbsp;卖&nbsp;&nbsp;价：</span>
										<span class="price big"><b>&yen;</b><em>${commodity.secprice}</em></span> <span
										class="bargain-tip"> <i class="i-tip"></i>该商品拒绝讲价！
									</span></li>
									<li class="price-block"><span class="para">原&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;价：</span>
										<b>¥</b>
                						<span>${commodity.price}</span>
               						</li>
								</ul>
								<ul class="idle-info" data-spm="2007.1000338.3">
									<li><span class="para">成 色：</span> <em>${commodity.conditions}</em></li>
									<li><span class="para">所&nbsp;&nbsp;在&nbsp;&nbsp;地：</span>
										<em>${commodity.conditions}</em></li>
									<li class="contact"><span class="para">联系方式：</span>
										<div style="display: none">
											<span class="J_WangWang" data-nick="可爱天使任" data-icon="large"></span>
										</div></li>
									<li class="trade-terms" id="J_TradeWrap"><span
										class="para">交易方式：</span> <a href="#"><span data-term="0"
											class="J_Term term">在线交易</em></em></span><i></i></a>
									<li id="J_Freight" class="freight"><a id="J_Region"
										class="region" href="#" data-default=""> 至 <em
											id="J_RegionName"></em><i></i>
									</a> <span id="J_Carriage" class="fee">运费：<em class="rmb">&yen;</em><span id="J_Fee">免运费</span></span></li>
									</li>
								</ul>
								<div class="buy-now" data-spm="2007.1000338.4">
									<a id="J_BuyNow"
										data-url="//buy.2.taobao.com/buy/buy.htm?from=itemDetail&amp;x_id=&amp;id=584816873266&amp;item_id=584816873266"
										class="btn" href="#">立刻购买</a>
								</div>
								<form id="J_FrmBid"
									action="//buy.2.taobao.com/buy/buy_now.jhtml" method="post">
									<input type="hidden" id="J_ItemNumId" name="item_num_id"
										value="584816873266" /> <input type="hidden"
										id="J_TradeTermInput" name="idle_trade_style" /> <input
										type="hidden" name="item_id_num" value="584816873266" /> <input
										type="hidden" name="item_id" value="584816873266" /> <input
										type="hidden" name="auction_id" value="584816873266" /> <input
										type="hidden" name="auction_type" value="b" /> <input
										type="hidden" name="title" value="${commodity.name}" /> <input
										type="hidden" name="seller_id"
										value="IvH8yMkPePmN4PF9zOmlIPH*eXmleMm*HvHgSvFguvmxT" /> <input
										type="hidden" name="allow_quantity" value="1" /> <input
										type="hidden" name="seller_nickname" value="" /> <input
										type="hidden" name="from" value="idleDetail" /> <input
										type="hidden" name="current_price" value="219.00" /> <input
										type="hidden" name="buy_now" value="" /> <input type="hidden"
										name="photo_url" value="" /> <input type="hidden"
										name="quantity" value="1" /> <input type='hidden'
										name='_tb_token_' value='3933e334e1ab3'>
								</form>

								<div id="J_BargainContent" class="hidden">
									<div class="hd">议价</div>
									<div class="bd">
										<p class="tip">议价有效期为24小时，如果卖家同意您的出价，系统将自动创建订单并短信通知您。</p>
										<div class="control-group">
											<label for="price" class="control-label">诚心以：</label>
											<div class="controls">
												<input id="price" type="text" name="price" class="input">
												元（不含运费）的价格入手该宝贝
											</div>
										</div>
										<div class="control-group">
											<label for="phone" class="control-label">手机号：</label>
											<div class="controls">
												<input id="phone" type="text" name="phone" class="input">
												<span>请留下手机号，方便订单生成后及时通知您</span>
											</div>
										</div>
										<div class="control-group">
											<label for="message" class="control-label">诚心以：</label>
											<div class="controls">
												<textarea name="" id="message"></textarea>
											</div>
										</div>
									</div>
								</div>
								<div class="guarantee_new">
									<div class="dbjy">
										<span class="tit"></span> <strong class="desc">由支付宝先行保管,验货OK再付款到卖家账户。</strong>
									</div>
									<div class="smrz">
										<span class="tit"></span> <strong class="desc">经支付宝核实会员身份和银行账户信息,真实可靠。</strong>
									</div>
								</div>
							</div>
							<div id="J_OtherIdles" data-spm="2007.1000338.6"
								class="idle-box other-idles"
								data-url="//2.taobao.com/itemref/more_onsale.htm?userNick=%BF%C9%B0%AE%CC%EC%CA%B9%C8%CE&id=584816873266">
								<h4>
									卖家的其它闲置<span class="total"></span>
								</h4>
								<a href="//s.2.taobao.com/list/list.htm?usernick=可爱天使任"
									target="_blank" class="more">更多</a>
								<div class="entity loading"></div>
							</div>
						</div>
					</div>
					<div class="col-sub">



<div id="J_Slider" class="slider" data-spm="2007.1000338.7" data-spm-max-idx="6">
		<ul class="album" style="position: absolute; width: 999999px; left: -0px;">

        			<li class="item sh-pic ks-switchable-panel-internal72" style="display: block; float: left;">

    					 <a href="javascript:void(0);" data-spm-anchor-id="2007.1000338.7.1">

							<img class="big-img" src="http://img.alicdn.com/bao/uploaded/i1/587220610/O1CN011GNQ2pZdMgOkrKy_!!587220610.jpg" lazyload-img="">

															<div class="mau-guide" style="display: none;">
									<img class="guide-img" src="//gw.alicdn.com/mt/TB1WAqBPFXXXXbUXXXXXXXXXXXX-480-340.png" style="visibility: visible;">
									<img class="close-img" src="//gw.alicdn.com/tps/TB1d6OhMVXXXXbSXXXXXXXXXXXX-32-32.png" data-spm-anchor-id="2007.1000338.7.i0.403057cctP7obe">
								<div id="qrcode" title="https://market.m.taobao.com/app/idleFish-F2e/widle-taobao-rax/page-detail?no_silent_callapp=1&amp;wh_weex=true&amp;wx_navbar_transparent=true&amp;id=587231586968" style="position: absolute; top: 176px; left: 180px; z-index: 999999; width: 110px; height: 110px; visibility: visible;"><canvas width="110" height="110" style="display: none;"></canvas><img alt="Scan me!" style="display: block;" src="data:image/png;base64,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"></div></div>
							
						 </a>

						 
                	</li>

        			
        			<li class="item sh-pic ks-switchable-panel-internal72" style="display: block; float: left;">

    					 <a href="javascript:void(0);" data-spm-anchor-id="2007.1000338.7.2">

							<img class="big-img" src="http://img.alicdn.com/bao/uploaded/i1/TB2lXJHu4SYBuNjSsphXXbGvVXa_!!0-mytaobao.jpg" lazyload-img="">

							
						 </a>

						 
                	</li>

        			
        			<li class="item sh-pic ks-switchable-panel-internal72" style="display: block; float: left;">

    					 <a href="javascript:void(0);" data-spm-anchor-id="2007.1000338.7.3">

							<img class="big-img" src="http://img.alicdn.com/bao/uploaded/i3/TB2k6prAr9YBuNjy0FgXXcxcXXa_!!0-mytaobao.jpg" lazyload-img="">

							
						 </a>

						 
                	</li>

    			
    		
           
        </ul>

		
		<div id="J_Thumbs" class="thumbs-wrapper">

			<div class="thumb-list">

                <ul class="thumbs clearfix">

					
            		
            			
                			
                			<li class="sh-pic ks-switchable-trigger-internal71">

            					 <a href="javascript:void(0);" data-spm-anchor-id="2007.1000338.7.4">

        							<img class="small-img" src="http://img.alicdn.com/bao/uploaded/i1/587220610/O1CN011GNQ2pZdMgOkrKy_!!587220610.jpg">

        						 </a>

                        	</li>

            			
            		
            			
                			
                			<li class="sh-pic  ks-switchable-trigger-internal71 selected">

            					 <a href="javascript:void(0);" data-spm-anchor-id="2007.1000338.7.5">

        							<img class="small-img" src="http://img.alicdn.com/bao/uploaded/i1/TB2lXJHu4SYBuNjSsphXXbGvVXa_!!0-mytaobao.jpg">

        						 </a>

                        	</li>

                			
                			<li class="sh-pic  ks-switchable-trigger-internal71">

            					 <a href="javascript:void(0);" data-spm-anchor-id="2007.1000338.7.6">

        							<img class="small-img" src="http://img.alicdn.com/bao/uploaded/i3/TB2k6prAr9YBuNjy0FgXXcxcXXa_!!0-mytaobao.jpg">

        						 </a>

                        	</li>

            			
            		
                </ul>

			</div>

		</div>

	
</div>
























						<div id="J_IdleDesc" class="idle-desc">

							<div id="J_ItemTab">

								<div class="list-tabs" data-spm="2007.1000338.8">

									<ul>

										<li class="J_TabTrigger tabnavfirst actived"><a
											href="#desc-intro">宝贝介绍</a></li>



										<!--li class="J_TabTrigger" id="J_MSCount" data-key="101_584816873266" data-url="//comment.jianghu.taobao.com/json/commentCount.htm?keys=101_584816873266">

					<a href="#message" id="messages" name="messages">留言（<span>0</span>）</a>

				</li-->

										<li class="J_TabTrigger"><a href="#message" id="messages"
											name="messages">留言</a></li>

										<li class="J_TabTrigger"><a href="#guarantee">安全保障</a></li>

									</ul>

								</div>

							</div>

							<div class="security-tip">

								如遇到以下情况可能是诈骗行为：<span class="h">1.宝贝价格异常低；</span><span class="h">2.卖家要求QQ沟通；</span><span
									class="h">3.卖家要求直接汇款。</span> <a
									href="//bangpai.taobao.com/group/thread/92194-270443602.htm?tracelog=jiankong-idledetail"
									target="_blank">寻求防骗经验</a>。

							</div>



							<div id="desc-intro" class="J_Panel desc-mod desc-intro">

								<h2>
									<b>宝贝介绍</b>
								</h2>



								<div class="intro-para clearfix">



									<ul>




									</ul>

									<ul>




									</ul>

								</div>


								<div
									data-url="//osdsc.alicdn.com/i7/580/810/584816873266/TB10Yivyq6qK1RjSZFm8qt0PFla.desc%7Cvar%5Edesc%3Bsign%5E64b70be0bb315b0d3486dcdd6d310cc7%3Blang%5Egbk%3Bt%5E1546004490"
									class="describe" id="J_DescContent">${commodity.info}</div>




								<div class="xy-guide">

									<div class="xy-left">

										<div class="xy-intro"></div>

										<div class="xy-guide-btn J_xianyu">下载闲鱼客户端</div>

									</div>

									<div class="xy-right"></div>

								</div>



							</div>



							<div id="message" class="J_Panel desc-mod message"
								data-spm="2007.1000338.11">

								<h2>
									<b>留言</b>
								</h2>

								<div id="J_Message" data-targetkey="584816873266"
									data-recuserid="IvH8yMkPePmN4PF9zOmlIPH*eXmleMm*HvHgSvFguvmxT"
									data-title="${commodity.name}"></div>

								<input id="J_Token" type='hidden' name='_tb_token_'
									value='3933e334e1ab3'>

							</div>

							<div id="guarantee" class="J_Panel desc-mod guarantee">
								<h2>
									<b>安全保障</b>
								</h2>
								<h3 class="title">二手交易消费者安全保障服务</h3>
								<ul>
									<li class="first"><b class="icon"></b>
										<div class="intro">
											<h4>卖家实名认证</h4>
											<p>
												淘宝二手卖家必备网络身份证；<br>经支付宝核实会员身份信息和银行账户信息。
											</p>
										</div> <b class="arrow"></b>
										<div class="addon">真实.可靠.网络身份证</div></li>
									<li class="second"><b class="icon"></b>
										<div class="intro">
											<h4>专业团队支撑</h4>
											<p>发现可疑卖家或商品，发起举报，由安全部门专员介入处理交易出现纠纷，双方协商不成，由专业的客服小二介入仲裁。</p>
										</div> <b class="arrow"></b>
										<div class="addon">专业.精英.全方位支持</div></li>
									<li class="third"><b class="icon"></b>
										<div class="intro">
											<h4>支付宝担保交易</h4>
											<p>支付款项由支付宝先行保管，验货OK后，再确认付款到卖家账户，买家发起交易，杜绝钓鱼网站。</p>
										</div> <b class="arrow"></b>
										<div class="addon">收货.验货.满意再付款</div></li>

								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>
	<div id="J_SideBar" class="sidebar" style="left:90%;">
		<div id="J_GoTop" class="scroll-top" style="visibility: visible;">
			<a href="javascript:void(0);"><span>返回顶部</span></a>
		</div>
		<a id="J_Advice" class="advice-sidebar"
			href="//ur.taobao.com/survey/view.htm?id=891" target="_blank">建议反馈</a>
	</div>
	<script type="text/javascript">
			KISSY.config({combine:true});
   	 		KISSY.use('page/detail');
		</script>
	<script src='//w.cnzz.com/c.php?id=30058279' language='JavaScript'></script>
	<!--
<div class="sh-footer" data-spm="2007.1000261.99">

    <div class="logo-wrapper">
        <div class="logo">淘宝二手</div>
    </div>
    <div class="qualifications">
        <div class="icon auth">卖家实名认证</div>
        <div class="icon alipay">支付宝担保交易</div>
        <div class="icon group">专业团队支撑</div>
        <div class="icon weibo">官方微博</div>
        <a href="//trade.2.taobao.com/recycle/index.htm" target="_blank"><div class="icon recyclers">回收商入驻</div></a>
    </div>

</div>
-->
	<script type="text/javascript">var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");document.write(unescape("%3Cspan id='cnzz_stat_icon_1252911424'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "w.cnzz.com/q_stat.php%3Fid%3D1252911424' type='text/javascript'%3E%3C/script%3E"));</script>

	<!--token-->
	<input id="J_tb_Token" type='hidden' name='_tb_token_'
		value='3933e334e1ab3'>

	<div class="idle-footer" id="J_IdleFooter">
		<div class="idle-footer-info">
			<div class="idle-footer-download">
				<span class="idle-footer-slogan"><img
					src="//img.alicdn.com/tps/i3/TB1naO0IFXXXXXsXFXXIU.iNXXX-332-76.png"
					alt="闲置能换钱" width="299"></span> <a
					href="https://itunes.apple.com/cn/app/tao-bao-tiao-zao-jie-qing/id510909506"
					target="_blank" class="idle-download-ios"><img
					src="//img.alicdn.com/tps/i4/TB1VO4WHVXXXXcKXFXXfBBiHXXX-200-62.png"
					alt="闲鱼ios客户端下载" width="200" height="62"></a> <a href="#nogo"
					target="_self" class="idle-download-android"><img
					src="//img.alicdn.com/tps/i2/TB1aOKTHVXXXXXdXpXXfBBiHXXX-200-62.png"
					alt="闲鱼android客户端下载" width="200" height="62"></a> <span
					class="idle-qrcode"><img
					src="//img.alicdn.com/tps/i1/TB1nbl3HVXXXXaKXFXX07tlTXXX-200-200.png"
					alt="闲鱼" width="130" height="130"></span>
			</div>
			<div class="idle-footer-links">
				<div class="idle-footer-links-box">
					<a href="#nogo" target="_self" class="idle-footer-link-auth">卖家实名认证</a>
					<a href="#nogo" target="_self" class="idle-footer-link-alipay">支付宝担保交易</a>
					<a href="#nogo" target="_self" class="idle-footer-link-team">专业团队支撑</a>
					<a href="http://weibo.com/taoershou" class="idle-footer-link-weibo">官方微博</a>
				</div>
			</div>
		</div>
	</div>
	<div class="footer-idle-new footer-with-logo" id="J_SiteFooter"
		data-spm="1997523009" data-spm-max-idx="44">
		<div class="footer-hd">
			<p>
				<span> <a
					href="http://www.alibabagroup.com/cn/global/home?spm=a21bo.50862.1997523009.1.0kiejZ"
					data-spm-anchor-id="a21bo.50862.1997523009.1"> 阿里巴巴集团 </a>
				</span> <b> | </b> <span> <a
					href="//www.taobao.com?spm=a21bo.50862.1997523009.2.0kiejZ"
					data-spm-anchor-id="a21bo.50862.1997523009.2"> 淘宝网 </a>
				</span> <b> | </b> <span> <a
					href="//www.tmall.com?spm=a21bo.50862.1997523009.3.0kiejZ"
					data-spm-anchor-id="a21bo.50862.1997523009.3"> 天猫 </a>
				</span> <b> | </b> <span> <a
					href="//ju.taobao.com?spm=a21bo.50862.1997523009.4.0kiejZ"
					data-spm-anchor-id="a21bo.50862.1997523009.4"> 聚划算 </a>
				</span> <b> | </b> <span> <a
					href="http://www.aliexpress.com?spm=a21bo.50862.1997523009.5.0kiejZ"
					data-spm-anchor-id="a21bo.50862.1997523009.5"> 全球速卖通 </a>
				</span> <b> | </b> <span> <a
					href="http://www.alibaba.com/?spm=a21bo.50862.1997523009.6.0kiejZ"
					data-spm-anchor-id="a21bo.50862.1997523009.6"> 阿里巴巴国际交易市场 </a>
				</span> <b> | </b> <span> <a
					href="http://www.1688.com?spm=a21bo.50862.1997523009.7.0kiejZ"
					data-spm-anchor-id="a21bo.50862.1997523009.7"> 1688 </a>
				</span> <b> | </b> <span> <a
					href="http://www.alimama.com?spm=a21bo.50862.1997523009.8.0kiejZ"
					data-spm-anchor-id="a21bo.50862.1997523009.8"> 阿里妈妈 </a>
				</span> <b> | </b> <span> <a
					href="//www.alitrip.com?spm=a21bo.50862.1997523009.9.0kiejZ"
					data-spm-anchor-id="a21bo.50862.1997523009.9"> 阿里旅行 · 去啊 </a>
				</span> <b> | </b> <span> <a
					href="http://www.aliyun.com?spm=a21bo.50862.1997523009.10.0kiejZ"
					data-spm-anchor-id="a21bo.50862.1997523009.10"> 阿里云计算 </a>
				</span> <b> | </b> <span> <a
					href="http://www.yunos.com?spm=a21bo.50862.1997523009.11.0kiejZ"
					data-spm-anchor-id="a21bo.50862.1997523009.11"> YunOS </a>
				</span> <b> | </b> <span> <a
					href="http://www.aliqin.cn/?spm=a21bo.50862.1997523009.12.0kiejZ"
					data-spm-anchor-id="a21bo.50862.1997523009.12"> 阿里通信 </a>
				</span> <b> | </b> <span> <a
					href="http://www.etao.com/?spm=a21bo.50862.1997523009.13.0kiejZ"
					data-spm-anchor-id="a21bo.50862.1997523009.13"> 一淘 </a>
				</span> <b> | </b> <span> <a
					href="http://www.net.cn?spm=a21bo.50862.1997523009.14.0kiejZ"
					data-spm-anchor-id="a21bo.50862.1997523009.14"> 万网 </a>
				</span> <b> | </b> <span> <a
					href="http://www.autonavi.com/?spm=a21bo.50862.1997523009.15.0kiejZ"
					data-spm-anchor-id="a21bo.50862.1997523009.15"> 高德 </a>
				</span> <b> | </b> <span> <a
					href="http://www.uc.cn/?spm=a21bo.50862.1997523009.16.0kiejZ"
					data-spm-anchor-id="a21bo.50862.1997523009.16"> UC </a>
				</span> <b> | </b> <span> <a
					href="http://www.umeng.com/?spm=a21bo.50862.1997523009.17.0kiejZ"
					data-spm-anchor-id="a21bo.50862.1997523009.17"> 友盟 </a>
				</span> <br> <span> <a
					href="http://www.xiami.com?spm=a21bo.50862.1997523009.18.0kiejZ"
					data-spm-anchor-id="a21bo.50862.1997523009.18"> 虾米 </a>
				</span> <b> | </b> <span> <a
					href="http://www.ttpod.com/?spm=a21bo.50862.1997523009.19.0kiejZ"
					data-spm-anchor-id="a21bo.50862.1997523009.19"> 天天动听 </a>
				</span> <b> | </b> <span> <a
					href="http://www.laiwang.com/?spm=a21bo.50862.1997523009.20.0kiejZ"
					data-spm-anchor-id="a21bo.50862.1997523009.20"> 来往 </a>
				</span> <b> | </b> <span> <a
					href="http://www.dingtalk.com/?spm=a21bo.50862.1997523009.21.0kiejZ&lwfrom=20150130160830727"
					data-spm-anchor-id="a21bo.50862.1997523009.21"> 钉钉 </a>
				</span> <b> | </b> <span> <a href="https://www.alipay.com"
					data-spm-anchor-id="a21bo.50862.1997523009.22"> 支付宝 </a>
				</span> <b> | </b> <span> <a href="http://www.aligames.com/"
					data-spm-anchor-id="a21bo.50862.1997523009.22"> 阿里游戏 </a>
				</span>
			</p>
		</div>
		<div class="footer-bd">
			<p>
				<span> <a
					href="//www.taobao.com/about?spm=a21bo.50862.1997523009.23.0kiejZ"
					data-spm-anchor-id="a21bo.50862.1997523009.23"> 关于淘宝 </a>
				</span> <span> <a
					href="//www.taobao.com/about/partners.php?spm=a21bo.50862.1997523009.24.0kiejZ"
					data-spm-anchor-id="a21bo.50862.1997523009.24"> 合作伙伴 </a>
				</span> <span> <a
					href="//pro.taobao.com?spm=a21bo.50862.1997523009.25.0kiejZ"
					data-spm-anchor-id="a21bo.50862.1997523009.25"> 营销中心 </a>
				</span> <span> <a
					href="http://jubao.alibaba.com?spm=a21bo.50862.1997523009.26.0kiejZ"
					data-spm-anchor-id="a21bo.50862.1997523009.26"> 廉正举报 </a>
				</span> <span> <a
					href="//service.taobao.com/support/main/service_route.htm?spm=a21bo.50862.1997523009.27.0kiejZ"
					data-spm-anchor-id="a21bo.50862.1997523009.27"> 联系客服 </a>
				</span> <span> <a
					href="//open.taobao.com?spm=a21bo.50862.1997523009.28.0kiejZ"
					data-spm-anchor-id="a21bo.50862.1997523009.28"> 开放平台 </a>
				</span> <span> <a
					href="//www.taobao.com/about/join.php?spm=a21bo.50862.1997523009.29.0kiejZ"
					data-spm-anchor-id="a21bo.50862.1997523009.29"> 诚征英才 </a>
				</span> <span> <a
					href="//www.taobao.com/about/contact.php?spm=a21bo.50862.1997523009.30.0kiejZ"
					data-spm-anchor-id="a21bo.50862.1997523009.30"> 联系我们 </a>
				</span> <span> <a
					href="//www.taobao.com/sitemap.php?spm=a21bo.50862.1997523009.31.0kiejZ"
					data-spm-anchor-id="a21bo.50862.1997523009.31"> 网站地图 </a>
				</span> <span> <a
					href="//terms.alicdn.com/legal-agreement/terms/suit_bu1_taobao/suit_bu1_taobao201703241622_61002.html"
					data-spm-anchor-id="a21bo.50862.1997523009.32"> 法律声明及隐私权政策 </a>
				</span> <span> <a
					href="http://ipp.alibabagroup.com/?spm=a21bo.50862.1997523009.33.0kiejZ"
					data-spm-anchor-id="a21bo.50862.1997523009.33"> 知识产权 </a>
				</span> <b> | </b> <em> 2003-2016 Taobao.com 版权所有 </em>
			</p>
			<p>
				<span> 网络文化经营许可证： <a
					href="//img.alicdn.com/tps/i2/TB1YFcPLpXXXXaiXFXXcaDpFFXX-803-473.png"
					data-spm-anchor-id="a21bo.50862.1997523009.34">
						浙网文[2013]0268-027号 </a>
				</span> <b> | </b> <span> 增值电信业务经营许可证： <a
					href="http://zcainfo.miitbeian.gov.cn/state/outPortal/loginPortal.action?spm=a21bo.50862.1997523009.35.0kiejZ&file=loginPortal.action"
					data-spm-anchor-id="a21bo.50862.1997523009.35"> 浙B2-20080224 </a>
				</span> <b> | </b> <span> 信息网络传播视听节目许可证：1109364号 </span> <b> | </b> <span>
					互联网违法和不良信息举报电话:0571-81683755 blxx@list.alibaba-inc.com </span>
			</p>
		</div>
		<div class="footer-ft">
			<span> <a target="_blank"
				href="http://www.pingpinganan.gov.cn/?spm=a21bo.50862.1997523009.36.0kiejZ"
				class="mod"
				style="background-position: 0px 0px; width: 36px; background-image: url(//img.alicdn.com/tps/i1/T1FeW3XXNfXXXXXXXX-36-36.gif);"
				data-spm-anchor-id="a21bo.50862.1997523009.36"> </a>
			</span> <span> <a target="_blank"
				href="http://idinfo.zjaic.gov.cn/bscx.do?spm=a21bo.50862.1997523009.37.0kiejZ&method=hddoc&id=33018400000067"
				class="mod" style="background-position: 0px 0px; width: 30px;"
				data-spm-anchor-id="a21bo.50862.1997523009.37"> </a>
			</span> <span> <a target="_blank"
				href="http://idinfo.zjaic.gov.cn/bscx.do?spm=a21bo.50862.1997523009.38.0kiejZ&method=hddoc&id=33018400000067"
				class="mod" style="background-position: -40px 0px; width: 33px;"
				data-spm-anchor-id="a21bo.50862.1997523009.38"> </a>
			</span> <span> <a target="_blank"
				href="http://www.theclimategroup.org.cn/about/friend?spm=a21bo.50862.1997523009.39.0kiejZ"
				class="mod" style="background-position: -80px 0px; width: 50px;"
				data-spm-anchor-id="a21bo.50862.1997523009.39"> </a>
			</span> <span> <a target="_blank"
				href="https://ss.knet.cn/verifyseal.dll?spm=a21bo.50862.1997523009.40.0kiejZ&sn=2010062300100001357&pa=20100701"
				class="mod" style="background-position: -140px 0px; width: 83px;"
				data-spm-anchor-id="a21bo.50862.1997523009.40"> </a>
			</span> <span> <a target="_blank"
				href="http://www.ppaaol.com/verifySite.do?spm=a21bo.50862.1997523009.41.0kiejZ&id=1051"
				class="mod" style="background-position: -240px 0px; width: 94px;"
				data-spm-anchor-id="a21bo.50862.1997523009.41"> </a>
			</span> <span> <a target="_blank"
				href="http://www.12377.cn/?spm=a21bo.50862.1997523009.42.0kiejZ"
				class="mod" style="background-position: -431px 0px; width: 214px;"
				data-spm-anchor-id="a21bo.50862.1997523009.42"> </a>
			</span> <span> <a target="_blank"
				href="http://www.12377.cn/node_548446.htm?spm=a21bo.50862.1997523009.43.0kiejZ"
				class="mod" style="background-position: -650px 0px; width: 105px;"
				data-spm-anchor-id="a21bo.50862.1997523009.43"> </a>
			</span> <span> <a target="_blank"
				href="//img.alicdn.com/tps/i2/TB1YFcPLpXXXXaiXFXXcaDpFFXX-803-473.png"
				class="mod" style="background-position: -345px 0px; width: 82px;"
				data-spm-anchor-id="a21bo.50862.1997523009.44"> </a>
			</span>
		</div>
	</div>
	<script>
  KISSY.use('widget/footer5/index');
</script>

	<div align="center" id="server-num">idle011010225133.center.na61</div>

	<div id="J_Feedback4bug" data-version-id="20038"></div>




</body>
</html>