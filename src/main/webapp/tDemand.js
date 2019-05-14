layui.use(['layer', 'table','element','form','laydate'], function(){
  	var layer = layui.layer, 
	table = layui.table, 
	element = layui.element, 
	laydate = layui.laydate,
	laypage=layui.laypage,
	form = layui.form,
	$ = layui.$;

	laydate.render({
		  elem: '#creartTime',
		  done: function(value, date, endDate){
			  table.reload('tDemandlist', {
			        page: {
			        	curr: 1 //重新从第 1 页开始
			        },
			        where: {
							tDemand_id:$("#id").val(),
							tDemand_sellerId:$("#sellerId").val(),
							tDemand_price:$("#price").val(),
							tDemand_name:$("#name").val(),
							tDemand_info:$("#info").val(),
							tDemand_buyerId:$("#buyerId").val(),
							tDemand_creartTime:$("#creartTime").val(),
							tDemand_messageId:$("#messageId").val(),
							tDemand_state:$("#state").val()
				    }
			    });
		  }
	  });
	
	table.render({
		elem: '#tDemandlist',
		url: BASE_PATH+'/TDemand/queryMyPageTDemand.do',
		limit:10,	
		limits:[5,10,15,20],
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
		{field:"price", title: '价格', width:200, fixed: 'left' }  ,
		{field:"name", title: '名称', width:200, fixed: 'left' }  ,
		{field:"info", title: '信息', width:200, fixed: 'left' }  ,
		{field:"creartTime", title: '创建时间', width:200, fixed: 'left' }  ,
		{field:"state", title: '状态', width:200, fixed: 'left' }  ,
		{fixed: 'right', title: '操作',width: 150, align:'center', toolbar: '#barDemo'}
		]]
	});

	//监听行工具事件
	table.on('tool(tDemandlist)', function(obj){
		if(obj.event === 'del'){
			layer.confirm('真的删除行么', function(index){
				var id = obj.data.id;
				$.ajax({
					url:BASE_PATH+'/TDemand/delTDemand.do',
					type:'get',
					dataType:'json',
					data:{
						id:id,
					},
					error:function (res) {
						layer.alert(res.errors);
					},
					success:function (res) {
						layer.alert('保存成功!',function(){
							layer.closeAll();
							table.reload('tDemandlist');
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
				content: BASE_PATH+'/editTDemand.jsp',
				success : function(layero, index){
					var body = layer.getChildFrame('body', index);
					var iframeWin = window[layero.find('iframe')[0]['name']];
					var dialogform = iframeWin.layui.form;
					var id = obj.data.id;
					//设置不可编辑
					//body.find("input#roomcode").attr("disabled",true);
					//body.find("select#roomfloor").attr("disabled",true);
					$.ajax({
						url:BASE_PATH+'/TDemand/findTDemandById.do',
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
								body.find("input#price").val(data.data.price);
								body.find("input#name").val(data.data.name);
								body.find("input#info").val(data.data.info);
//								dialogform.render('select');	
						}
					});
				},
				yes: function (layero, index) {
					var body = layui.layer.getChildFrame('body', layero); //得到iframe页的body内容
					//获取值弹出框值
						<!--  ul  li -->
					var id=body.find("input#id").val();
					var price=body.find("input#price").val();
					var name=body.find("input#name").val();
					var info=body.find("input#info").val();
					var state=body.find("input#state").val();
					//判断是否为空
					/*if(roomCode==""||roomFloor==""||roomType==""||roomState==""||roomPrix==""){
						layer.alert('请输入完整信息!');
					}
					else {*/ 	
					$.ajax({
						url:BASE_PATH+'/TDemand/updateTDemandById.do',
						type:'get',
						dataType:'json',
						data: {
							tDemand_id:body.find("input#id").val(),
							tDemand_price:body.find("input#price").val(),
							tDemand_name:body.find("input#name").val(),
							tDemand_info:body.find("input#info").val(),
							tDemand_state:body.find("input#state").val()
						},
						error:function (res) {
							layer.alert('网络错误!');
						},
						success : function(layero, index){
							layer.alert('修改成功!',function(){
								layer.closeAll();
								table.reload('tDemandlist');
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
      
	 $("#price").bind('input propertychange', function () {
		table.reload('tDemandlist', {
	        page: {
	        	curr: 1 //重新从第 1 页开始
	        },
	        where: {
					tDemand_price:$("#price").val(),
					tDemand_name:$("#name").val(),
					tDemand_info:$("#info").val(),
					tDemand_creartTime:$("#creartTime").val(),
					tDemand_state:$("#state").val()
		    }
	    });
	});
	 $("#name").bind('input propertychange', function () {
		table.reload('tDemandlist', {
	        page: {
	        	curr: 1 //重新从第 1 页开始
	        },
	        where: {
					tDemand_price:$("#price").val(),
					tDemand_name:$("#name").val(),
					tDemand_info:$("#info").val(),
					tDemand_creartTime:$("#creartTime").val(),
					tDemand_state:$("#state").val()
		    }
	    });
	});
	 $("#info").bind('input propertychange', function () {
		table.reload('tDemandlist', {
	        page: {
	        	curr: 1 //重新从第 1 页开始
	        },
	        where: {
					tDemand_price:$("#price").val(),
					tDemand_name:$("#name").val(),
					tDemand_info:$("#info").val(),
					tDemand_creartTime:$("#creartTime").val(),
					tDemand_state:$("#state").val()
		    }
	    });
	});
	 form.on('select(state)', function(data){
		table.reload('tDemandlist', {
	        page: {
	        	curr: 1 //重新从第 1 页开始
	        },
	        where: {
					tDemand_price:$("#price").val(),
					tDemand_name:$("#name").val(),
					tDemand_info:$("#info").val(),
					tDemand_creartTime:$("#creartTime").val(),
					tDemand_state:$("#state").val()
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
    	table.reload('tDemandlist', {
    		page: {
  		        curr: 1 //重新从第 1 页开始
  		    },
    		where: {
					tDemand_price: '',
					tDemand_name: '',
					tDemand_info: '',
					tDemand_creartTime: '',
					tDemand_state: ''
  		    }
    	});
	});
    
    
      //新增按钮
	$(document).on('click','#addTDemand',function(){
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
				//判断是否为空
				/*if(roomCode==""||roomFloor==""||roomType==""||roomState==""||roomPrix==""){
				layer.alert('请输入完整信息!');
				}
				else if(roomcodeExist==""){*/
				$.ajax({
					url:BASE_PATH+'/TDemand/addTDemand.do',
					type:'get',
					data: {
						tDemand_id:body.find("input#id").val(),
						tDemand_sellerId:body.find("input#sellerId").val(),
						tDemand_price:body.find("input#price").val(),
						tDemand_name:body.find("input#name").val(),
						tDemand_info:body.find("input#info").val(),
						tDemand_buyerId:body.find("input#buyerId").val(),
						tDemand_creartTime:body.find("input#creartTime").val(),
						tDemand_messageId:body.find("input#messageId").val(),
						tDemand_state:body.find("input#state").val()
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
			//}
			/*else{
			layer.alert('房间已存在!');
			}
			*/
			}
		});
	});
});