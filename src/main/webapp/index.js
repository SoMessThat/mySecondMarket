function addcommodity(){
	layui.use('form', function(){
		var form = layui.form,
		$ = layui.$;
		layer.open({
			type: 2,
			skin: 'layui-layer-rim',
			title: '编辑字典信息',
			btn: ['保存'],
			btnAlign: 'c',
			shadeClose: true,
			shade: false,
			maxmin: false,
			area: ['70%', '80%'],
			content: BASE_PATH+'/TCommodity/addcommodityDialog.do',
			success : function(layero, index){
//				var body = layer.getChildFrame('body', index);
//				var iframeWin = window[layero.find('iframe')[0]['name']];
//				var dialogform = iframeWin.layui.form;
//				var dictId = obj.data.dictId;

//				body.find("input#dictCode").attr("disabled",true);//账号不可编辑
//				$.ajax({
//				url:BASE_PATH+'/dict/findDictById.php',
//				type:'get',
//				dataType:'json',
//				async:true,  //异步加载
//				data:{
//				'dictId':dictId
//				},
//				error:function (res) {
//				layer.alert(res.data.erro);
//				},
//				success : function(data){
//				body.find("input#dictId").val(data.data.dictId);
//				body.find("input#dictValue").val(data.data.dictValue);
//				body.find("input#dictCode").val(data.data.dictCode);
//				body.find("input#dictType").val(data.data.dictType);
//				body.find("textarea#remark").val(data.data.remark); 
//				dialogform.render();
//				},
//				});
			},
			yes: function (layero, index) {
				var body = layui.layer.getChildFrame('body', layero); 
				//获取弹出框的值
				var images=body.find("input#images").val();
				var name=body.find("input#name").val();
				var prix=body.find("input#prix").val();
				var info=body.find("textarea#info").val();
				//判断是否为空
				if(images==""||name==""||prix==""){
					layer.alert('请输入完整信息!');
				}
				else{
					alert(images+"|"+name+"|"+prix+"|"+info)
					$.ajax({
						url:BASE_PATH+'/TCommodity/addTCommodity.do',
						type:'get',
						data: {
							pictureId:images,
							name:name,
							secprice:prix,
							info:info
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