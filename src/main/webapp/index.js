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
							creartTime:(new Date(nettime).getTime())/1000
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
		loadInfo(text);
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
function searchByKey() {
	layui.use('form', function(){
		var form = layui.form,
		$ = layui.$;
		loadInfo("type=搜索&key="+$('#key').val());
	})
}
loadInfo("type=新鲜");

layui.use('layer', function(){
	var $ = layui.jquery,
	layer = layui.layer;
	$("#phoneWeb").hover(function() {
		openMsg();
	}, function() {
		layer.close(subtips);
	});
	function openMsg() {
		subtips = layer.msg('<img src="'+BASE_PATH+'/images/WebCode.png" />', {offset: 'auto'});;
	} 
});