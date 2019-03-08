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
			content: /*BASE_PATH+*/'../addcommodity.jsp',
			success : function(layero, index){
				layer.iframeAuto(index);
			},	
			yes: function (layero, index) {
				var body = layui.layer.getChildFrame('body', layero); 
				//获取弹出框的值
				var images=body.find("input#images").val();
				var name=body.find("input#name").val();
				var prix=body.find("input#prix").val();
				var conditions=body.find("input#conditions").val();
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
	layui.use('form', function(){
		var form = layui.form,
		$ = layui.$;
		layer.open({
			type: 2,
			skin: 'layui-layer-rim',
			title: '我需要这样的商品',
			btn: ['保存'],
			btnAlign: 'c',
			shadeClose: true,
			shade: [0.8, '#393D49'],
			maxmin: false,
			offset: 'auto',
			content: /*BASE_PATH+*/'../wantcommodity.jsp',
			success : function(layero, index){
				layer.iframeAuto(index);
			},
			yes: function (layero, index) {
				var body = layui.layer.getChildFrame('body', layero); 
				//获取弹出框的值
				var name=body.find("input#name").val();
				var prix=body.find("input#prix").val();
				var info=body.find("textarea#info").val();
				//判断是否为空
				if(info==""||name==""||prix==""){
					layer.alert('请输入完整信息!');
				}
				else{
					alert(name+"|"+prix+"|"+info)
//					$.ajax({
//						url:BASE_PATH+'/TCommodity/111.do',
//						type:'get',
//						data: {
//							name:name,
//							price:prix,
//							info:info,
//							creartTime:new Date(nettime).getTime()
//						},
//						dataType:'json',
//						error:function (res) {
//							layer.alert(res.data.erro);
//						},
//						success : function(layero, index){
//							layer.alert('添加成功!',function(){
//								layer.closeAll();
//							});
//						},
//					});
				}

			}
		});
	});  
}