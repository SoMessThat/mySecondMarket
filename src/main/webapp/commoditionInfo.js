layui.use(['jquery'], function(){
	var $ = jQuery = layui.$;

	window.openGW = function(id){
		if($(id).text()=="回复"){
			$(id).text("取消回复");
			document.getElementById("box_"+id.id).style.display='block';
		}

		else
		{
			$(id).text("回复");
			document.getElementById("box_"+id.id).style.display='none';
		}

	}
	function createId() {
		    	return (Math.random()*10000000).toString(16).substr(0,4)+'-'+(new Date()).getTime()+'-'+Math.random().toString().substr(2,5);
		    }
	window.message = function(data){
		var id=createId();
		$("#mydiv").append(
				'		<div class="cont-head-gw">'+
				'			<div class="head-img-gw"> 	'+
				'				<a node-type="photo" href="javascript:;" title="'+data.ownerName+'">'+
				' 					<div class="img-corner"> </div>'+
				'					<img src="http://sucimg.itc.cn/avatarimg/10065897456987_1534862560258_c55" width="42" height="42" alt="">'+
				'	 			</a>'+
				'			</div>'+
				'		</div> '
		);
		$("#mydiv").append(
				'		<div class="cont-msg-gw"> '+
				'			<div class="msg-wrap-gw">'+
				'				<div class="wrap-user-gw global-clear-spacing">'+
				'  					<span class="user-time-gw">'+data.time+'</span> '+
				'					<span class="module-cy-score user-grade-gw"></span>'+
				' 					<span node-type="nickname" class="user-name-gw">'+
				'						<a href="javascript:void(0)">'+data.ownerName+'</a>'+
				'					</span>'+
				'     				<span class="user-address-gw">[<i>我家在北京</i>网友]</span>'+
				'    			</div>'+
				'  				<div class="wrap-issue-gw">'+
				'      				<p class="issue-wrap-gw"><span class="wrap-word-gw">'+data.content+'</span></p>'+
				'      				<div class="cy-see-more"> <span></span><i></i> </div>'+
				'  				</div> '
		);
		$("#mydiv").append(
				' 				<div node-type="btns-bar" class="clear-g wrap-action-gw">'+
				'					<div node-type="action-click-gw" class="action-click-gw global-clear-spacing">'+
				'						<i class="gap-gw"></i>'+
				'						<span node-type="report" class="click-report-gw">'+
				'    						<a href="javascript:void(0)"><i class="icon-gw icon-flag"></i></a>'+
				'						</span>'+
				'						<i class="gap-gw"></i>'+
				'						<span node-type="reply" class="click-reply-gw">'+
				'							<a id="'+id+'" href="javascript:void(0)" onclick="openGW(this)">回复</a>'+
				'						</span>'+
				' 						<i class="gap-gw"></i>'+
				' 						<span node-type="support" class="click-ding-gw">'+
				'     						<a href="javascript:;"><i class="icon-gw icon-ding-bg"></i><em class="icon-name-bg">123</em></a>'+
				'  						</span>'+
				'						<i class="gap-gw"></i>'+
				'						<span node-type="oppose" class="click-cai-gw">'+
				'							<a href="javascript:;"><i class="icon-gw icon-cai-bg"></i><em class="icon-name-bg">321</em></a>'+
				'						</span>'+
				'					</div>'+
		'				</div> ');

		$("#mydiv").append(
				'				<div id="box_'+id+'" class="module-cmt-box" style="display: none;"> '+
				'     				<div class="post-wrap-w"> '+
				'        				<div class="post-wrap-border-l"></div> '+
				'        				<div class="post-wrap-border-r"></div> '+
				'        				<div node-type="post-wrap-main" class="post-wrap-main post-wrap-main-focus"> '+
				'            				<div class="post-wrap-border-t"> '+
				'                				<div node-type="post-wrap-border-t-l" class="post-wrap-border-t-l"></div> '+
				'                				<div node-type="post-wrap-border-t-r" class="post-wrap-border-t-r"></div> '+
				'           				</div> '+
				'            				<div class="wrap-area-w"> '+
				'               				<div class="area-textarea-w area-textarea-e"> '+
				'                    				<textarea node-type="textarea" name="" class="textarea-fw textarea-bf"></textarea> '+
				'                				</div> '+
				'           				</div> '+
				'       				</div> '+
				'        				<div class="clear-g wrap-action-w"> '+
				'            				<div class="clear-g action-issue-w"> '+
				'                				<div class="issue-btn-w"> '+
				'                    				<a href="javascript:void(0)"> '+
				'                        				<button node-type="issue" class="btn-fw"></button> '+
				'                    				</a> '+
				'                				</div> '+
				'            					<div class="issue-icon-w" node-type="share-icons"> </div> '+
				'            				</div> '+
				'            				<div class="cbox-prompt-w" node-type="error-tips"> '+
				'                				<span node-type="prompt-empty" class="prompt-empty-w">评论内容为空！</span> '+
				'            				</div> '+
				'        				</div> '+
				'    				</div> '+
				'				</div>   ');

		$("#mydiv").append(
				'               </div>'+
				'			</div>  ');
	}
	var ione=$(".one"),ithe=$(".the"),itwo=$(".two img"),tthe=$(".the img");
	var arr=["../images/bg2.jpg","../images/logo.png","../images/shehui.jpg"];
	var oarr=["img/111.jpg","img/222.jpg","img/333.jpg"];
	itwo.each(
			function(i){
				$(this).click(function(){$
					(".one img").attr("src",arr[i])
					tthe.attr("src",oarr[i])
					itwo.removeClass("active")
					$(this).addClass("active")})
					ione.mousemove(function(a){
						var evt=a||window.event
						ithe.css('display','block')
						var ot=evt.clientY-($(".one").offset().top-$(document).scrollTop())-87;
						var ol=evt.clientX-($(".one").offset().left-$(document).scrollLeft())-87;
						if(ol<=0){ol=0;}
						if(ot<=0){ot=0;}
						if(ol>=175){ol=175}
						if(ot>=175){ot=175}
						$("span").css({'left':ol,'top':ot})
						var ott=ot/350*800
						var oll=ol/350*800
						tthe.css({'left':-oll,'top':-ott})})
						ione.mouseout(function(){
							ithe.css('display','none')
						})
			})
			$.ajax({
				url:BASE_PATH+'/TCommodity/findTCommodityById.do',
				type:'get',
				dataType:'text',
				data:{
					id:$('#commodity').val(),
				},
				error:function (res) {
					layer.alert(res.errors);
				},
				success:function (res) {
					console.log(res.data);
				}
			});
});