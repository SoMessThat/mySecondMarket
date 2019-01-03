<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="base.jsp"%>
<html class="ks-webkit537 ks-webkit ks-chrome63 ks-chrome">
<head>
<meta name="data-spm" content="a2107">
<title>淘宝网 - 淘！我喜欢</title>
<meta charset="gbk">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link type="text/css" href="//g.alicdn.com/sd/ncpc/nc.css?t=2018122813"
	rel="stylesheet" disabled="">
<link rel="stylesheet"
	href="https://g.alicdn.com/vip/login/0.5.65/css/page.css?t=20151220">
<!-- 登录窗口  -->
<link rel="stylesheet" href="<%=basePath%>/css/login1.css">

<link rel="stylesheet" href="<%=basePath%>/css/login2.css">
<link href="<%=basePath%>/favicon.ico" rel="shortcut icon">
<script src="https://g.alicdn.com/kissy/k/1.4.4/seed-min.js"></script>
<script src="//g.alicdn.com/secdev/sufei_data/3.6.8/index.js"
	id="aplus-sufei"></script>
<script src="//g.alicdn.com/secdev/nsv/1.0.47/ns_a_51_2_fa.js"></script>
</head>
<body class="chl-reg" data-spm="1">

	<div id="page" class="">
		<div id="header" class="clearfix" data-spm="1000340">

			<div class="logo">
				<h1>
					<a href="//www.taobao.com" title="淘宝网"><i
						class="iconfont tb-logo-cn"></i><i class="iconfont tb-logo-url"></i></a>
				</h1>

				<!-- 提醒框 -->
				<!-- 	<div class="login-msg error"
					style="text-align: center; width: 880px; margin: 0 auto;"
					data-spm-anchor-id="a2107.1.1000340.i0.6df011d9E4LeUD">
					<p class="error" style="float: none; width: auto;">
						为确保您账户的安全及正常使用，依《网络安全法》相关要求，6月1日起会员账户需绑定手机。如您还未绑定，请尽快完成，感谢您的理解及支持！
					</p>
				</div> -->

				<!-- 
				<a href="https://survey.taobao.com/survey/Q095thIx2" class="link">
					<i class="iconfont"></i> "登录页面"改进建议
				</a> -->
			</div>

		</div>
		<div id="content">

			<div class="login-newbg"
				style="background-image: url(<%=basePath%>/images/bg2.jpg);">
				<input type="hidden" id="J_adUrl" name="adUrl" value=""> <input
					type="hidden" id="J_adImage" name="adImage" value=""> <input
					type="hidden" id="J_adText" name="adText" value=""> <input
					type="hidden" id="J_viewFd4PC" name="viewFd4PC" value=""> <input
					type="hidden" id="J_viewFd4Mobile" name="viewFd4Mobile" value="">
			</div>
			<div class="login-adlink">
				<a href="https://www.taobao.com/m" target="_blank"
					onclick="javascript:goldlog.record('/member.11.1','','','H46777383')"></a>
			</div>


			<div class="content-layout">
				<div class="login-box-warp">

					<div class="login-box no-longlogin module-quick" id="J_LoginBox">
						<script type="text/javascript">
						(function(x) {
							x && (x.className += " loading")
						})(document.getElementById("J_LoginBox"))
					</script>
						<!--login box begin-->

						<div class="hd">

							<div class="login-switch" onselectstart="return false;">
								<i class="iconfont quick" id="J_Static2Quick"
									onclick="javascript:goldlog.record('/member.13.1','','','H46777383')"
									data-spm-anchor-id="a2107.1.0.i1.6df011d9E4LeUD"></i> <i
									class="iconfont static" id="J_Quick2Static"
									data-spm-anchor-id="a2107.1.0.i0.6df011d9E4LeUD"></i>
							</div>
							<div class="login-tip">
								<div class="poptip">
									<div class="poptip-arrow">
										<em></em> <span></span>
									</div>
									<div class="poptip-content">
										<i class="iconfont"></i>扫码登录更安全
									</div>
								</div>
							</div>

						</div>
						<div class="bd">
							<!--登录的错误信息结束-->
							<div id="J_QuickLogin" class="ww-login hidden"
								style="display: none;">
								<form action="" class="ww-form">
									<div class="login-title">选择其中一个已登录的账户</div>

									<div class="ww-userlist"></div>
									<div class="trigger"></div>
									<div class="submit">
										<button type="submit" class="J_Submit" id="J_SubmitQuick">登
											录</button>
									</div>
									<div class="other-login">
										<a href="" class="light-link" id="J_Sso2Static">使用其他账户登录</a>
									</div>
								</form>
							</div>
							<div id="J_MiserLogin" class="ww-login hidden">
								<form action="" class="ww-form">
									<input type="hidden" id="x_token" value="">
									<div class="login-title">选择其中一个已登录的账户</div>

									<div class="ww-userlist"></div>
									<div class="trigger"></div>
									<div class="submit">
										<p>
											<input type="checkbox" id="J_Mdelete"> 不再记住密码
										</p>
										<button type="submit" tabindex="5" id="J_SubmitMiser">登
											录</button>
									</div>
									<div class="other-login">
										<a href="" title="使用其他账户登录" class="light-link"
											id="J_Miser2Static">使用其他账户登录</a>
									</div>
								</form>
							</div>

							<!--标准登录框-->
							<div class="static-form " id="J_StaticForm">
								<div class="login-title">密码登录</div>

								<form action="<%=basePath%>/login/index.do" method="post"
									id="J_Form">
									<div id="J_Message" style="display: none;"
										class="login-msg error">
										<i class="iconfont"></i>

										<p class="error"></p>

									</div>
									<!-- 手机号登录 -->



									<div class="field username-field">
										<label for="TPL_username_1"> <i class="iconfont"
											title="会员名"></i>
										</label> <span class="ph-label">会员名/邮箱/手机号</span> <input type="text"
											name="TPL_username" id="TPL_username_1"
											class="login-text J_UserName" value="" maxlength="32"
											tabindex="1" aria-label="会员名/邮箱/手机号">
									</div>

									<div class="field pwd-field">
										<label id="password-label" for="TPL_password_1"><i
											class="icon iconfont" title="登录密码"></i></label> <span
											id="J_StandardPwd"> <input type="password"
											name="TPL_password" id="TPL_password_1" class="login-text"
											maxlength="40" tabindex="2" autocomplete="off"
											aria-label="登录密码">
										</span>
									</div>

									<!-- use new slide checkcode -->
									<div id="nocaptcha" class="nc-container tb-login"
										data-nc-idx="1">
										<div id="nc_1_wrapper" class="nc_wrapper">
											<div id="nc_1_n1t" class="nc_scale">
												<div id="nc_1__bg" class="nc_bg"></div>
												<span id="nc_1_n1z" class="nc_iconfont btn_slide"></span>
												<div id="nc_1__scale_text" class="scale_text slidetounlock">
													<span class="nc-lang-cnt" data-nc-lang="_startTEXT">请按住滑块，拖动到最右边</span>
												</div>
												<div id="nc_1_clickCaptcha" class="clickCaptcha">
													<div class="clickCaptcha_text">
														<b id="nc_1__captcha_text" class="nc_captch_text"></b> <i
															id="nc_1__btn_2" class="nc_iconfont nc_btn_2 btn_refresh"></i>
													</div>
													<div class="clickCaptcha_img"></div>
													<div class="clickCaptcha_btn"></div>
												</div>
												<div id="nc_1_imgCaptcha" class="imgCaptcha">
													<div class="imgCaptcha_text">
														<input id="nc_1_captcha_input" maxlength="6" type="text"
															style="ime-mode: disabled">
													</div>
													<div class="imgCaptcha_img" id="nc_1__imgCaptcha_img"></div>
													<i id="nc_1__btn_1"
														class="nc_iconfont nc_btn_1 btn_refresh"
														onclick="document.getElementById('nc_1__imgCaptcha_img').children[0].click()"></i>
													<div class="imgCaptcha_btn">
														<div id="nc_1__captcha_img_text"
															class="nc_captcha_img_text"></div>
														<div id="nc_1_scale_submit" class="nc_scale_submit"></div>
													</div>
												</div>
												<div id="nc_1_cc" class="nc-cc"></div>
												<i id="nc_1__voicebtn" tabindex="0" role="button"
													class="nc_voicebtn nc_iconfont" style="display: none"></i>
												<b id="nc_1__helpbtn" class="nc_helpbtn"><span
													class="nc-lang-cnt" data-nc-lang="_learning">了解新功能</span></b>
											</div>
											<div id="nc_1__voice" class="nc_voice"></div>
										</div>
									</div>



									<div class="submit">

										<!-- <input id="J_NcoSig" name="ncoSig" type="hidden"> <input
											id="J_NcoSessionid" name="ncoSessionid" type="hidden">
										<input id="J_NcoToken" type="hidden" name="ncoToken"
											value="3da4bec56ce3f215703fee2d9eec88a766028a89"> <input
											id="J_NcoShow" type="hidden" name="slideCodeShow"
											value="false"> <input type="hidden" name="useMobile"
											value="false"> <input type="hidden" id="J_lang"
											name="lang" value="zh_CN"> <input type="hidden"
											name="loginsite" value="0" id="J_loginsite"> <input
											type="hidden" name="newlogin" value=""> <input
											type="hidden" id="J_TPL_redirect_url" name="TPL_redirect_url"
											value="https://2.taobao.com/"> <input type="hidden"
											id="J_From" name="from" value="tbTop"> <input
											type="hidden" name="fc" value="default"> <input
											type="hidden" id="J_CssStyle" name="style" value="default">
										<input type="hidden" id="J_CssStyle2" name="css_style"
											value=""> <input type="hidden" name="keyLogin"
											value="false"> <input type="hidden" name="qrLogin"
											value="true"> <input type="hidden" name="newMini"
											value="false"> <input type="hidden" name="newMini2"
											value="false"> <input type="hidden" name="tid">
										<input type="hidden" name="loginType" value="3"> <input
											type="hidden" name="minititle" value=""> <input
											type="hidden" name="minipara" value=""> <input
											type="hidden" name="pstrong" value=""> <input
											type="hidden" id="J_sign" name="sign" value=""> <input
											type="hidden" id="J_need_sign" name="need_sign" value="">

										<input type="hidden" id="J_isIgnore" name="isIgnore" value="">
										<input type="hidden" id="J_full_redirect" name="full_redirect"
											value="">
										子账号跳转方式
										<input type="hidden" name="sub_jump" value=""> <input
											type="hidden" name="popid" value=""> <input
											type="hidden" name="callback" value=""> <input
											type="hidden" id="J_guf" name="guf" value=""> <input
											type="hidden" id="J_not_duplite_str" name="not_duplite_str"
											value=""> <input type="hidden" name="need_user_id"
											value=""> <input type="hidden" name="poy"> <input
											type="hidden" id="gvfdc" name="gvfdcname" value="10">
										<input type="hidden" name="gvfdcre"
											value="68747470733A2F2F322E74616F62616F2E636F6D2F"> <input
											type="hidden" id="J_from_encoding" name="from_encoding"
											value=""> <input type="hidden" id="J_sub" name="sub"
											value=""> <input type="hidden" name="TPL_password_2"
											id="TPL_password_2"> <input type="hidden" id="J_PBK"
											value="9a39c3fefeadf3d194850ef3a1d707dfa7bec0609a60bfcc7fe4ce2c615908b9599c8911e800aff684f804413324dc6d9f982f437e95ad60327d221a00a2575324263477e4f6a15e3b56a315e0434266e092b2dd5a496d109cb15875256c73a2f0237c5332de28388693c643c8764f137e28e8220437f05b7659f58c4df94685">
										<input type="hidden" name="loginASR" value="1"> <input
											type="hidden" name="loginASRSuc" value="0"> <input
											type="hidden" id="J_allp" name="allp" value=""> <input
											type="hidden" name="oslanguage" value="zh-CN"> <input
											type="hidden" name="sr" value="1920*1080"> <input
											type="hidden" name="osVer"> <input type="hidden"
											name="naviVer" value="chrome|63.0323926"> <input
											type="hidden" name="osACN" value="Mozilla"> <input
											type="hidden" name="osAV"
											value="5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.26 Safari/537.36 Core/1.63.6788.400 QQBrowser/10.3.2816.400">
										<input type="hidden" name="osPF" value="Win32"> <input
											type="hidden" name="miserHardInfo" id="M_hard_info">
										<input type="hidden" id="J_Appkey" name="appkey"
											value="00000000"> <input type="hidden"
											name="nickLoginLink" value=""> <input type="hidden"
											name="mobileLoginLink"
											value="https://login.taobao.com/member/login.jhtml?spm=2007.1000261.0.0.135334f1u6muCb&amp;f=top&amp;redirectURL=https://2.taobao.com/&amp;useMobile=true">
										<input type="hidden" name="showAssistantLink" value="">


										<input id="J_UnitClose " value="true" type="hidden"> -->
										<button type="submit" class="J_Submit" tabindex="3"
											id="J_SubmitStatic" data-ing="正在登录...">登 录</button>
									</div>

									<ul class="entries">
										<li id="J_OtherLogin" class="other-login"><a
											href="http://weibo.com/login.php?entry=taobao&amp;goto=https%3A%2F%2Flogin.taobao.com%2Faso%2Ftvs%3Fdomain%3Dweibo%26sid%3De0c45514e4ff880d2b1594d2b3c794d6%26target%3D68747470733A2F2F322E74616F62616F2E636F6D2F&amp;goto2=https%3A%2F%2F2.taobao.com%2F"
											tabindex="4" class="weibo-login"><i class="iconfont"></i>微博登录</a>

											<a
											href="https://auth.alipay.com/login/index.htm?loginScene=7&amp;goto=https%3A%2F%2Fauth.alipay.com%2Flogin%2Ftaobao_trust_login.htm%3Ftarget%3Dhttps%253A%252F%252Flogin.taobao.com%252Fmember%252Falipay_sign_dispatcher.jhtml%253Ftg%253Dhttps%25253A%25252F%25252F2.taobao.com%25252F&amp;params=VFBMX3JlZGlyZWN0X3VybD1odHRwcyUzQSUyRiUyRjIudGFvYmFvLmNvbSUyRg%3D%3D"
											tabindex="5" class="alipay-login"><i class="iconfont"></i>支付宝登录</a>


										</li>
									</ul>


									<div class="login-links">



										<a
											href="https://passport.taobao.com/ac/password_find.htm?from_site=0&amp;login_id=&amp;lang=zh_CN&amp;app_name=&amp;tracelog=signin_main_pass"
											tabindex="6" class="forget-pwd" target="_blank"> 忘记密码</a> <a
											href="https://passport.taobao.com/ac/nick_find.htm?from_site=0&amp;lang=zh_CN&amp;app_name=tbTop"
											target="_blank">忘记会员名</a> <a
											href="http://reg.taobao.com/member/newbie.htm?from=login"
											class="register" target="_blank" tabindex="7">免费注册</a>

									</div>
									<!-- <input type="hidden" name="um_token"
										value="HV02PAAZ0baf530bda5525815c25b7c604091828999999"> -->
								</form>
							</div>





							<!--快速登录开始-->
							<div class="quick-form">
								<!--扫码登录开始-->
								<div class="qrcode-login" id="J_QRCodeLogin" style="">
									<div class="login-tip" style="display: none;">
										<div class="poptip">
											<div class="poptip-arrow">
												<em></em> <span></span>
											</div>
											<div class="poptip-content">
												<i class="iconfont"></i>密码登录在这里
											</div>
										</div>
									</div>
									<div class="login-title">手机扫码，安全登录</div>

									<div class="qrcode-mod">
										<div class="qrcode-main">
											<div class="qrcode-img" id="J_QRCodeImg"
												style="opacity: 1; left: 80px;">
												<!-- <img
													src="//img.alicdn.com/tfscom/TB1NGPSyOLaK1RjSZFxwu1mPFXa.png"> -->
												<div id="qrcodeCanvas"></div>
												<script type='text/javascript'
													src='http://cdn.staticfile.org/jquery/2.1.1/jquery.min.js'></script>
												<script type="text/javascript"
													src="http://cdn.staticfile.org/jquery.qrcode/1.0/jquery.qrcode.min.js"></script>
												<script>
													jQuery('#qrcodeCanvas').qrcode({
													    width   : 140,
													    height  : 140,
													    text    : "http://129.204.72.147:8080/SecondMarket/"
													}); 
													</script>
											</div>
											<div class="qrcode-help"></div>
											<div class="msg-err">
												<h6>二维码已失效</h6>
												<a href="javascript:;" class="refresh J_QRCodeRefresh">请点击刷新</a>
											</div>
										</div>
										<div class="qrcode-desc" data-spm="25847036">
											<i class="iconfont"></i>

											<p>
												<font class="ft-gray">打开 </font> <a
													href="https://www.taobao.com/m" target="_blank"
													class="light-link">手机淘宝<br></a> <font class="ft-gray">扫一扫登录</font>
											</p>

										</div>

									</div>
									<div class="qrcode-msg">
										<div class="msg-ok">
											<div class="msg-icon">
												<i class="iconfont icon-ok"></i> <i
													class="iconfont icon-phone"></i>
											</div>
											<h6>扫描成功！</h6>
											<p>请在手机上确认登录</p>
											<div class="link">
												<a href="#" class="light-link J_QRCodeRefresh">返回二维码登录</a>
											</div>
										</div>
									</div>
									<div class="login-links">
										<a href="" class="forget-pwd J_Quick2Static" target="_blank">密码登录</a>
										<a href="http://reg.taobao.com/member/newbie.htm?from=login"
											class="register" target="_blank">免费注册</a>
									</div>
								</div>
								<!--扫码登录结束-->
								<!--一键登录开始-->

								<!--一键登录结束-->
							</div>
							<!--快速登录结束-->
						</div>
					</div>
					<!--标准登录框结束-->
				</div>
			</div>
		</div>
		<!--登录脚本-->

		<script>
    window.loginConfig = {
        //验证码
        codeURL: "",
        codeHandle: "#J_StandardCode",
        codeImg: "#J_StandardCode_m",
        enableQRCode: true,   // 是否允许二维码登录 
        shownQRCode: true, // 是否自动显示二维码登录
        getQRCodeURL: "https://qrlogin.taobao.com/qrcodelogin/generateQRCode4Login.do",
        checkQRCodeURL: "https://qrlogin.taobao.com/qrcodelogin/qrcodeLoginCheck.do",
        intervalQRCode: 2000,
        enableLoginByKey:false,
        startLoginByKeyURL:"https://qrlogin.taobao.com/qrcodelogin/startLoginByKey.do",
        checkLoginByKeyURL:"https://qrlogin.taobao.com/qrcodelogin/loginByKey.do",
        enableMiserLogin:false,
        audioCodeURL: "",
        checkUserNameURL:"/member/request_nick_check.do?_input_charset=utf-8",	
        disableQuickLogin:false,		
        defaultView: "static"
    };
</script>

		<!--login box end-->
	</div>
	<!-- .login-box END -->


	<div class="footer" data-spm="1997523009">

		<div class="footer-hd">
			<p>
				<a href="#">广告位招租</a> <b>|</b> <a href="#">广告位一</a> <b>|</b> <a
					href="#">广告位二</a> <b>|</b> <a href="#">广告位三</a> <b>|</b> <a
					href="#">广告位四</a> <b>|</b> <a href="#">广告位五</a> <b>|</b> <a
					href="#">广告位六</a> <b>|</b> <a href="#">广告位七</a> <b>|</b> <a
					href="#">广告位八</a> <b>|</b> <a href="#">广告位九</a> <b>|</b> <a
					href="#">广告位十</a> <b>|</b> <a href="#">广告位十一</a> <b>|</b> <a
					href="#">广告位十二</a>
			</p>
		</div>
		<div class="footer-bd">
			<p data-spm-anchor-id="a2107.1.1997523009.i0.6df011d9E4LeUD">
				<a href="#">关于我们</a> <a href="#">合作伙伴</a> <a href="#">营销中心</a> <a
					href="#" title="lianzheng@taobao.com" target="_self">廉正举报</a> <a
					href="#">联系客服</a> <a href="#">开放平台</a> <a href="#">诚征英才</a> <a
					href="#">联系我们</a> <a href="#">网站地图</a> <a href="#">法律声明</a> <a
					href="#">隐私权政策</a> <em>© 2018 陈杰文 版权所有</em>
			</p>
			<p>
				<span>福建工程学院 - 国脉信息学院</span> <b>|</b> <span>计算机与信息科学系 - 软件工程</span>
				<b>|</b> <span>软件1503班 - 3158907305 - 陈杰文</span>
			</p>
		</div>

	</div>










	<script type="text/javascript">
TRLang = {
        ERROR_NICK_BLANK : '请填写账户名',
        ERROR_PASSWORD_BLANK :  '请输入密码',
        ERROR_NICK_PASSWORD_BLANK : '请输入账户名和密码',
        ERROR_CHECKCODE_BLANK : '请输入验证码',
        TIPS_REMEMBER_PASSWORD : '记住密码',
        TIPS_NOT_REMEMBER_PSW_ON_PUBLIC : '不要在公共计算机记住密码，防止账户被盗'
    };
</script>



	<!-- 	<script>
  var UA_Opt = {};
  UA_Opt.ExTarget = ['TPL_password_1','TPL_password_2','J_Pwd1','J_PwdV'];
  UA_Opt.FormId = "J_Form";
  
  function initNC() {
		var nc = new noCaptcha();
			var opt = {
				renderTo : "nocaptcha",
				appkey : "CF_APP_TBLogin_PC",
				token : "3da4bec56ce3f215703fee2d9eec88a766028a89",
				elementID : [ "TPL_username_1" ],
				trans : {"behaviorTraceId": "null"},
				is_Opt : 1,
				language : "zh_CN",
				isEnabled : true,
				
				customWidth: 'J_StaticForm',
				customFloatHeight: 420,
				
				times : 3,
				callback: function (data) {
					var S = KISSY;
					S.one("#J_NcoSig").val( data.sig);
					S.one("#J_NcoSessionid").val(data.csessionid);
				},
				error: function (s) {
					window.console && console.log("error");
					window.console && console.log(s);
				},
				is_tbLogin : true
			};
			nc.init(opt);		
	}

	initNC();
</script> -->

	<div id="_umfp"
		style="display: inline; width: 1px; height: 1px; overflow: hidden">
	</div>

	<!--  二维码登录加载  -->
	<script
		src="https://g.alicdn.com/vip/login/0.5.65/js/login/nlogin.js?t=20151220"></script>
	<!-- 
	<iframe
		src="//g.alicdn.com/alilog/oneplus/blk.html#coid=nZKfFDVYQlkCAdpVJYHcZ2qU&amp;noid="
		id="_oid_ifr_" style="width: 0px; height: 0px; display: none;"></iframe> -->
</body>
</html>