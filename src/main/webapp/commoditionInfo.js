layui.use(['jquery','layer'], function(){
	var $ = jQuery = layui.$,
	 	layer = layui.layer;
//初始化评论列表
		 $.ajax({
			url:BASE_PATH+'/TCommodity/queryMessage.do?commodityId='+$('#commodity').val(),
			type:'get',
			dataType:'json',
			error:function (res) {
				layer.alert(res.data.erro);
			},
			success : function(data){
				for(var i=0;i<data.data.length;i++){
					message(data.data[i]);
				}
		 		$("#mydiv").append(str);
			}
		});
 //展示与隐藏回复框
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
	str ='';
	window.message = function(data){
		str=str+'		<div class="cont-head-gw">'+
				'			<div class="head-img-gw"> 	'+
				'				<a node-type="photo" href="javascript:;" title="'+data.passersby.username+'">'+
				' 					<div class="img-corner"> </div>'+
				'					<img src="'+data.passersby.avatar+'" width="42" height="42" alt="">'+
				'	 			</a>'+
				'			</div>'+
				'		</div> '+
				'		<div class="cont-msg-gw"> '+
				'			<div class="msg-wrap-gw">'+
				'				<div class="wrap-user-gw global-clear-spacing">'+
				'  					<span class="user-time-gw">'+timestampToTime(data.time)+'</span> '+
				'					<span class="module-cy-score user-grade-gw"></span>'+
				' 					<span node-type="nickname" class="user-name-gw">'+
				'						<a href="javascript:void(0)">'+data.passersby.username+'</a>'+
				'					</span>'+
				'     				<span class="user-address-gw">[<i>我家在北京</i>网友]</span>'+
				'    			</div>'+
				'  				<div class="wrap-issue-gw">'+
				'      				<p class="issue-wrap-gw"><span class="wrap-word-gw">'+data.content+'</span></p>'+
				'      				<div class="cy-see-more"> <span></span><i></i> </div>'+
				'  				</div> '+
				' 				<div node-type="btns-bar" class="clear-g wrap-action-gw">'+
				'					<div node-type="action-click-gw" class="action-click-gw global-clear-spacing">'+
				'						<i class="gap-gw"></i>'+
				'						<span node-type="report" class="click-report-gw">'+
				'    						<a href="javascript:void(0)"><i class="icon-gw icon-flag"></i></a>'+
				'						</span>'+
				'						<i class="gap-gw"></i>'+
				'						<span node-type="reply" class="click-reply-gw">'+
				'							<a id="'+data.id+'" href="javascript:void(0)" onclick="openGW(this)">回复</a>'+
				'						</span>'+
				' 						<i class="gap-gw"></i>'+
				' 						<span node-type="support" class="click-ding-gw">'+
				'     						<a href="javascript:;"><i class="icon-gw icon-ding-bg"></i><em class="icon-name-bg">0</em></a>'+
				'  						</span>'+
				'						<i class="gap-gw"></i>'+
				'						<span node-type="oppose" class="click-cai-gw">'+
				'							<a href="javascript:;"><i class="icon-gw icon-cai-bg"></i><em class="icon-name-bg">0</em></a>'+
				'						</span>'+
				'					</div>'+
				'				</div> '+
				'				<div id="box_'+data.id+'" class="module-cmt-box" style="display: none;"> '+
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
				'                    				<textarea id="context'+data.id+'" node-type="textarea" name="" class="textarea-fw textarea-bf"></textarea> '+
				'                				</div> '+
				'           				</div> '+
				'       				</div> '+
				'        				<div class="clear-g wrap-action-w"> '+
				'            				<div class="clear-g action-issue-w"> '+
				'                				<div class="issue-btn-w"> '+
				'                    				<a href="javascript:void(0)"> '+
				'                        				<button id="'+data.id+'" node-type="issue" class="btn-fw" onclick="huifu(this)"></button> '+
				'                    				</a> '+
				'                				</div> '+
				'            				</div> '+
				'						</div>'+
				'        			</div> '+
				'    			</div> ';
		for (var int = 0; int < data.answer.length; int++) {
			str=str+'<div node-type="cmt-list" id="cy-cmt-list">'+
			'<div node-type="cmt-item" data-id="1574501057" data-user-id="10065897456987" data-platform-id="4" class="clear-g block-cont-gw">';
			message(data.answer[int]);
			str=str+'               </div>'+
					'			</div>  ';
		}
		str=str+'       </div>'+
				'	</div>  ';
	}
//回复	
	window.huifu = function(e){
		$.ajax({
			url:BASE_PATH+'/TMessage/addTMessage.do',
			type:'post',
			dataType:'json',
			data:{
				tMessage_passersbyId:$("#tMessage_passersbyId").val(),
				tMessage_commodityId:$("#commodity").val(),
				tMessage_content:$("#context"+e.id).val(),
				tMessage_passersbyName:$("#tMessage_passersbyName").val(),
				tMessage_answerId:e.id
			},
			error:function (res) {
				alert('网络连接错误，请重新再试！');
			},
			success:function (res) {
				$("#context"+e.id).val('');
			}
		});
	}
//评论
	$("#comment").on("click",function(){
		$.ajax({
			url:BASE_PATH+'/TMessage/addTMessage.do',
			type:'post',
			dataType:'json',
			data:{
				tMessage_passersbyId:$("#tMessage_passersbyId").val(),
				tMessage_commodityId:$("#commodity").val(),
				tMessage_content:$("#context").val(),
				tMessage_passersbyName:$("#tMessage_passersbyName").val()
			},
			error:function (res) {
			},
			success:function (res) {
				$("#context").val('');
			}
		});
	});
//点击修改图片
	var ione=$(".one"),ithe=$(".the"),itwo=$(".two img"),tthe=$(".the img");
	window.changeImages = function(e){
		$('#img001').attr("src",$(e).attr('src'));
	}
	
//付款
	window.pay = function(){
		$.ajax({
			url:BASE_PATH+'/TCommodity/pay.do',
			type:'post',
			dataType:'json',
			data:{
				rechargeMon:"221",
			},
			error:function (res) {
				layer.alert(res.errors);
			},
			success:function (res) {
				layer.alert(res);
			}
		});
	}
});
