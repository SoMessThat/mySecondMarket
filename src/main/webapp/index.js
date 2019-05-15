function addcommodity(){
	layui.use('form', function(){
		var form = layui.form,
		$ = layui.$;
		parent.layer.open({
			type: 2,
			skin: 'layui-layer-rim',
			title: '发布闲置商品',
			btn: ['保存'],
			btnAlign: 'c',
			shadeClose: true,
			shade: [0.8, '#393D49'],
			maxmin: false,
			offset: 'auto',
			area: ['70%', '60%'],
			content: BASE_PATH+'/addcommodity.jsp',
			success : function(layero, index){
				layer.iframeAuto(index);
			},	
			yes: function (layero, index) {
				var body = layui.layer.getChildFrame('body', layero); 
				//获取弹出框的值
				var images=body.find("input#images").val();
				var name=body.find("input#name").val();
				var prix=body.find("input#prix").val();
				var conditions=body.find("select#conditions").val();
				var category=body.find("select#category").val();
				var secprix=body.find("input#secprix").val();
				var info=body.find("textarea#info").val();
				//判断是否为空
				if(images==""||name==""||prix==""){
					layer.alert('请输入完整信息!');
				}
				else{
					$.ajax({
						url:BASE_PATH+'/TCommodity/addTCommodity.do',
						type:'get',
						data: {
							sellerId:user.value,
							address:images,
							name:name,
							price:prix,
							info:info,
							secprice:secprix,
							conditions:conditions,
							category:category,
							creartTime:(new Date().getTime())
						},
						dataType:'json',
						error:function (res) {
							layer.alert(res.data.erro);
						},
						success : function(layero, index){
							layer.alert('添加成功!',function(){
								layer.closeAll();
							});
						},
					});
				}

			}
		});
	});  
}

function wantcommodity(){
	layui.use(['form','layer'], function(){
		var form = layui.form,
		layer = layui.layer,
		$ = layui.$;
		layer.open({
			type: 2,
			skin: 'layui-layer-rim',
			title: '新增TDemand信息',
			btn: ['保存'],
			btnAlign: 'c',
			shadeClose: true,
			shade: true,
			maxmin: false,
			area: ['70%', '80%'],
			content: BASE_PATH+'/editTDemand.jsp',
			yes: function (layero, index) {
				var body = layui.layer.getChildFrame('body', layero); //得到iframe页的body内容
				$.ajax({
					url:BASE_PATH+'/TDemand/addTDemand.do',
					type:'get',
					data: {
						tDemand_price:body.find("input#price").val(),
						tDemand_name:body.find("input#name").val(),
						tDemand_info:body.find("input#info").val(),
					},
					dataType:'json',
					error:function (res) {
						layer.alert('网络错误!');
					},
					success : function(layero, index){
						layer.alert('添加成功!',function(){
							layer.closeAll();
							table.reload('tDemandlist');
						});
					}
				});
			}
		})
	});
}
function change(e) {
	layui.use('form', function(){
		var form = layui.form,
		$ = layui.$;
		$('#tittleBar').find('.line').removeClass("line");
		$('#tittleBar').find('.active').removeClass("active");
		$(e).find('.name').addClass("active");
		$(e).append('<div data-v-03fbd53c="" class="line"></div>');
		var text = $(e).attr("str");
		if (text == "type=收购") {
			loadBuy()
		}else {
			loadInfo(text);
		}
	});
}
function loadInfo(text) {
	layui.use('flow', function(){
		var $ = layui.jquery;
		var flow = layui.flow;
		$('#demo').html("");
		flow.load({
			elem: '#demo',
			done: function(page, next){
				var lis = [];
				$.get(BASE_PATH+'/TCommodity/queryPageTCommodity.do?limit=10&page='+page+'&'+text,function(res){
					layui.each(res.data, function(index, item){
						lis.push('<a data-v-4c853d07="" href="'+BASE_PATH+'/TCommodity/info.do?id='+item.id+'" target="_blank" class="item-wrap">');
						lis.push('<div data-v-4c853d07="" class="item-img" style="background-image: url('+item.pictureId+');"></div>');
						lis.push('<div data-v-4c853d07="" class="item-info">');
						lis.push('<p data-v-4c853d07="" class="item-title">'+item.name+'</p>');
						lis.push('<div data-v-4c853d07="" class="price-line">');
						lis.push('<div data-v-4c853d07="" class="price">');
						lis.push('<p data-v-4c853d07="" class="price-unit">￥</p>');
						lis.push('<p data-v-4c853d07="" class="price-value">'+item.price+'</p>');
						lis.push('</div>');
						lis.push('<p data-v-4c853d07="" class="want-num">'+item.pop+'人想要</p>');
						lis.push('</div>');
						lis.push('</div>');
						lis.push('<div data-v-4c853d07="" class="user-line">');
						lis.push('<div data-v-4c853d07="" class="user-info">');
						lis.push('<img data-v-4c853d07="" src="http://img.alicdn.com/bao/uploaded/i1/O1CN01CNIVnZ1LriMilqWll_!!0-fleamarket.jpg" class="usericon">');
						lis.push('<p data-v-4c853d07="" class="user-name">'+item.sellerId+'</p>');
						lis.push('<img data-v-4c853d07="" src="http://gw.alicdn.com/mt/TB1HCq9GN1YBuNjy1zcXXbNcXXa-168-24.png" class="user-tag">');
						lis.push('</div>');
						lis.push('</div></a>');
					}); 
					next(lis.join(' '), page < res.count/10);    
				},"json");
			}
		});
	});
}
function loadBuy() {
	layui.use('flow', function(){
		var $ = layui.jquery;
		var flow = layui.flow;
		$('#demo').html("");
		flow.load({
			elem: '#demo',
			done: function(page, next){
				var lis = [];
				$.get(BASE_PATH+'/TDemand/queryPageTDemand.do?limit=10&page='+page,function(res){
					layui.each(res.data, function(index, item){
						lis.push('<div class="owl-item" style="width: 23%;"><div class="post-slide">');
						lis.push('<div class="post-img">');
						lis.push('<a href="#"><img style="height: 200px" src="'+BASE_PATH+'/images/WebCode.png" alt=""></a>');
						lis.push('</div>');
						lis.push('<div class="post-content">');
						lis.push('<h3 class="post-title"><a href="#">'+item.name+'</a></h3>');
						lis.push('<p class="post-description">'+item.info+'</p>');
						lis.push('<ul class="post-bar">');
						lis.push('<li><i class="fa fa-calendar"></i>'+item.price+'元</li>');
						lis.push('<li><i class="layui-icon">&#xe770;</i><a href="#">'+item.seller.username+'</a>');
						lis.push('<i class="layui-icon">&#xe60e;</i><a href="#">'+item.creartTime+'</a>');
						lis.push('<i class="layui-icon">&#xe653;</i><a href="#">'+item.state+'</a></li>');
						lis.push('</ul>');
						lis.push('<a href="#" class="read-more">read more</a>');
						lis.push('</div></div></div>');
					}); 
					next(lis.join(' '), page < res.count/10);    
				},"json");
			}
		});
	});
}
function searchByKey() {
	layui.use('form', function(){
		var form = layui.form,
		$ = layui.$;
		loadInfo("type=搜索&key="+$('#key').val());
	})
}
loadInfo("type=新鲜");

function hide(e) {
	layui.use('form', function(){
		var form = layui.form,
		$ = layui.$;
		$(e).css("display",'none')
	});
}

layui.use('layer', function(){
	var $ = layui.jquery,
	layer = layui.layer;
//	$("#phoneWeb").hover(function() {
//		openMsg();
//	}, function() {
//		layer.close(subtips);
//	});
//	function openMsg() {
//		subtips = layer.msg('<img src="'+BASE_PATH+'/images/WebCode.png" />', {offset: 'auto'});
//	} 
	
	$.ajax({
		url:BASE_PATH+'/TAnnouncement/queryPageTAnnouncement.do',
		type:'get',
		data: {
			tAnnouncement_state:"开启",
			page:1,
			limit:100
		},
		dataType:'json',
		error:function (res) {
			layer.alert('网络错误!');
		},
		success : function(layero, index){
			layui.each(layero.data, function(index, item){
				if (item.titlle=="右上角") {
					$('#rt').attr('src',item.pictureId);
				}
				else if (item.titlle=="左上角") {
					$('#lt').attr('src',item.pictureId);
				}
				else if (item.titlle=="右下角") {
					$('#rb').attr('src',item.pictureId);
				}
				else if (item.titlle=="左下角") {
					$('#lb').attr('src',item.pictureId);
				}
			}); 
		}
	});
	
	layer.open({
        type: 1
        ,title: false //不显示标题栏
        ,closeBtn: false
        ,area: '300px;'
        ,shade: 0.8
        ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
        ,btn: ['火速围观', '残忍拒绝']
        ,btnAlign: 'c'
        ,moveType: 1 //拖拽模式，0或者1
        ,content: '<div style="padding: 50px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;">你知道吗？亲！<br>layer ≠ layui<br><br>layer只是作为Layui的一个弹层模块，由于其用户基数较大，所以常常会有人以为layui是layerui<br><br>layer虽然已被 Layui 收编为内置的弹层模块，但仍然会作为一个独立组件全力维护、升级。<br><br>我们此后的征途是星辰大海 ^_^</div>'
        ,success: function(layero){
          var btn = layero.find('.layui-layer-btn');
          btn.find('.layui-layer-btn0').attr({
            href: 'http://www.layui.com/'
            ,target: '_blank'
          });
        }
      });
});