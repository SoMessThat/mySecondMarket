layui.use(['layer', 'table','element','form','laydate'], function(){
  	var layer = layui.layer, 
	table = layui.table, 
	element = layui.element, 
	laydate = layui.laydate,
	laypage=layui.laypage,
	form = layui.form,
	$ = layui.$;

	table.render({
		elem: '#Attentionlist',
		url: BASE_PATH+'/TSolicitude/queryPageAttention.do',
	//   toolbar: '#barDemo',
		limit:10,	
		limits:[5,10,15,20],
		toolbar: true,
		page:true, //开启分页
		height:'full-150',
		response: {
			statusName: 'status',
			statusCode: 200,
			msgName: 'messages',
			countName: 'count',
			dataName: 'data'
		},
		cols: [[ //表头
			{field:"userId", title:'卖家名', fixed: 'left' }  ,
			{field:"commodityId", title:'商品名', fixed: 'left' }  ,
			{field:"category", title:'类别', fixed: 'left' }  ,
			{field:"type", title:'', fixed: 'left' }  ,
			{fixed: 'right', title: '操作', width:150, align:'center', toolbar: '#barDemo'}
		]]
	});

	//监听行工具事件
	table.on('tool(Attentionlist)', function(obj){
		if(obj.event === 'del'){
			layer.confirm('真的删除行么', function(index){
				var id = obj.data.id;
				$.ajax({
					url:BASE_PATH+'/TSolicitude/delTSolicitude.do',
					type:'get',
					dataType:'text',
					data:{
						id:id,
					},
					error:function (res) {
						layer.alert(res.errors);
					},
					success:function (res) {
						layer.alert('保存成功!',function(){
							layer.closeAll();
							table.reload('Attentionlist');
						});
						obj.del();
					}
				});
			});
		} else if(obj.event === 'edit'){
			layer.open({
				type: 2,
				skin: 'layui-layer-rim',
				title: '编辑房间信息',
				btn: ['保存'],
				btnAlign: 'c',
				shadeClose: true,
				shade: true,
				maxmin: false,
				area: ['70%', '80%'],
				content: BASE_PATH+'/editTSolicitude.jsp',
				success : function(layero, index){
					var body = layer.getChildFrame('body', index);
					var iframeWin = window[layero.find('iframe')[0]['name']];
					var dialogform = iframeWin.layui.form;
					var id = obj.data.id;
					//设置不可编辑
					//body.find("input#roomcode").attr("disabled",true);
					//body.find("select#roomfloor").attr("disabled",true);
					$.ajax({
						url:BASE_PATH+'/TSolicitude/findTSolicitudeById.do',
						type:'get',
						dataType:'json',
						async:true,  //异步加载
						data:{
							'id':id
						},
						error:function (res) {
							layer.alert(res.data.erro);
						},
						success:function(data){
								body.find("input#id").val(data.data.id);
								body.find("input#userId").val(data.data.userId);
								body.find("input#commodityId").val(data.data.commodityId);
								body.find("input#category").val(data.data.category);
								body.find("input#type").val(data.data.type);
							//dialogform.render('select');	
						},
					});
				},
				yes: function (layero, index) {
					var body = layui.layer.getChildFrame('body', layero); //得到iframe页的body内容
					//获取值弹出框值
						<!--  ul  li -->
					var id=body.find("input#id").val();
					var userId=body.find("input#userId").val();
					var commodityId=body.find("input#commodityId").val();
					var category=body.find("input#category").val();
					var type=body.find("input#type").val();
					//判断是否为空
					/*if(roomCode==""||roomFloor==""||roomType==""||roomState==""||roomPrix==""){
						layer.alert('请输入完整信息!');
					}
					else {*/ 	
					$.ajax({
						url:BASE_PATH+'/TSolicitude/updateTSolicitudeById.do',
						type:'get',
						dataType:'json',
						data: {
							id:body.find("input#id").val(),
							userId:body.find("input#userId").val(),
							commodityId:body.find("input#commodityId").val(),
							category:body.find("input#category").val(),
							type:body.find("input#type").val(),
						},
						error:function (res) {
							layer.alert('网络错误!');
						},
						success : function(layero, index){
							layer.alert('修改成功!',function(){
								layer.closeAll();
								table.reload('Attentionlist');
							});
						},
					});
				//}
				}
			});
		}
	});
});
  
  //查询条件监听
layui.use(['form','table','layedit', 'laydate'], function(){
	var form = layui.form,
	table = layui.table,
	layer = layui.layer,
	layedit = layui.layedit,
	laydate = layui.laydate,
	$ = layui.$;
      
	 $("#id").bind('input propertychange', function () {
		table.reload('Attentionlist', {
	        page: {
	        	curr: 1 //重新从第 1 页开始
	        },
	        where: {
					tSolicitude_id:$("#id").val(),
					tSolicitude_userId:$("#userId").val(),
					tSolicitude_commodityId:$("#commodityId").val(),
					tSolicitude_category:$("#category").val(),
					tSolicitude_type:$("#type").val(),
		    }
	    });
	});
	 $("#userId").bind('input propertychange', function () {
		table.reload('Attentionlist', {
	        page: {
	        	curr: 1 //重新从第 1 页开始
	        },
	        where: {
					tSolicitude_id:$("#id").val(),
					tSolicitude_userId:$("#userId").val(),
					tSolicitude_commodityId:$("#commodityId").val(),
					tSolicitude_category:$("#category").val(),
					tSolicitude_type:$("#type").val(),
		    }
	    });
	});
	 $("#commodityId").bind('input propertychange', function () {
		table.reload('Attentionlist', {
	        page: {
	        	curr: 1 //重新从第 1 页开始
	        },
	        where: {
					tSolicitude_id:$("#id").val(),
					tSolicitude_userId:$("#userId").val(),
					tSolicitude_commodityId:$("#commodityId").val(),
					tSolicitude_category:$("#category").val(),
					tSolicitude_type:$("#type").val(),
		    }
	    });
	});
	 $("#category").bind('input propertychange', function () {
		table.reload('Attentionlist', {
	        page: {
	        	curr: 1 //重新从第 1 页开始
	        },
	        where: {
					tSolicitude_id:$("#id").val(),
					tSolicitude_userId:$("#userId").val(),
					tSolicitude_commodityId:$("#commodityId").val(),
					tSolicitude_category:$("#category").val(),
					tSolicitude_type:$("#type").val(),
		    }
	    });
	});
	 $("#type").bind('input propertychange', function () {
		table.reload('Attentionlist', {
	        page: {
	        	curr: 1 //重新从第 1 页开始
	        },
	        where: {
					tSolicitude_id:$("#id").val(),
					tSolicitude_userId:$("#userId").val(),
					tSolicitude_commodityId:$("#commodityId").val(),
					tSolicitude_category:$("#category").val(),
					tSolicitude_type:$("#type").val(),
		    }
	    });
	});
     /*下拉框
      form.on('select(roomfloor)', function(data){
   		table.reload('roomlist', {
		        page: {
		          curr: 1 //重新从第 1 页开始
		        },
		        where: {
		        	roomcode:$('#roomcode').val(),
  	            	roomfloor:$('#roomfloor').val(),
  	            	roomtype:$('#roomtype').val(),
  	            	roomstate:$('#roomstate').val(),
	            	roomprix:$('#roomprix').val()
		        }
	      });
  	    });
	  */
      
    //清空
     $("#resetbtn").on('click',function(){
    	table.reload('Attentionlist', {
    		page: {
  		        curr: 1 //重新从第 1 页开始
  		    },
    		where: {
					tSolicitude_id: '',
					tSolicitude_userId: '',
					tSolicitude_commodityId: '',
					tSolicitude_category: '',
					tSolicitude_type: '',
  		    }
    	});
	});
    
});