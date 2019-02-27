layui.use(['layer', 'table','element','form','laydate'], function(){
	  var layer = layui.layer, 
	  	  table = layui.table, 
	  	  element = layui.element, 
	  	  laydate = layui.laydate,
	  	  laypage=layui.laypage,
	  	  form = layui.form,
	  	  $ = layui.$;

   	  table.render({
   		elem: '#tCommoditylist',
	    url: BASE_PATH+'/TCommodity/queryPageTCommodity.do',
	 //   toolbar: '#barDemo',
		limit:10,	
		limits:[5,10,15,20],
		toolbar: true,
	    page:true, //开启分页
	    height:'full',
	    response: {
	    	  statusName: 'status' //数据状态的字段名称，默认：code
	    	  ,statusCode: 200//成功的状态码，默认：0
	    	  ,msgName: 'messages' //状态信息的字段名称，默认：msg
	    	  ,countName: 'count' //数据总数的字段名称，默认：count
	    	  ,dataName: 'data' //数据列表的字段名称，默认：data
	    	},
	    cols: [[ //表头
       	  {field:'name', title: 'name', width:200, fixed: 'left' }  ,
       	  {field:'category', title: 'category', width:200, fixed: 'left' }  ,
       	  {field:'info', title: 'info', width:200, fixed: 'left' }  ,
       	  {field:'pop', title: 'pop', width:200, fixed: 'left' }  ,
       	  {field:'pictureId', title: 'pictureId', width:200, fixed: 'left' }  ,
       	  {field:'price', title: 'price', width:200, fixed: 'left' }  ,
       	  {field:'secprice', title: 'secprice', width:200, fixed: 'left' }  ,
       	  {field:'conditions', title: 'conditions', width:200, fixed: 'left' }  ,
       	  {field:'messageId', title: 'messageId', width:200, fixed: 'left' }  ,
       	  {field:'num', title: 'num', width:200, fixed: 'left' }  ,
       	  {field:'sellerId', title: 'sellerId', width:200, fixed: 'left' }  ,
       	  {field:'buyerId', title: 'buyerId', width:200, fixed: 'left' }  ,
       	  {field:'creartTime', title: 'creartTime', width:200, fixed: 'left' }  ,
       	  {field:'closingTime', title: 'closingTime', width:200, fixed: 'left' }  ,
       	  {field:'state', title: 'state', width:200, fixed: 'left' }  ,
	      {fixed: 'right', title: '操作',width: 150, align:'center', toolbar: '#barDemo'}
	    ]]
      });
   
   	  //监听行工具事件
   	  table.on('tool(tCommoditylist)', function(obj){
	   	  if(obj.event === 'del'){
	   		  layer.confirm('真的删除行么', function(index){
	   			  var id = obj.data.id;
	   			  $.ajax({
	   				  url:BASE_PATH+'/TCommodity/delTCommodity.do',
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
   							    table.reload('tCommoditylist');
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
	    	      content: BASE_PATH+'/editTCommodity.jsp',
	    	      success : function(layero, index){
	    	    	  var body = layer.getChildFrame('body', index);
    	    	      var iframeWin = window[layero.find('iframe')[0]['name']];
    	    	      var dialogform = iframeWin.layui.form;
	    	    	  var id = obj.data.id;
					//设置不可编辑
	    	    	  //body.find("input#roomcode").attr("disabled",true);
  	                  //body.find("select#roomfloor").attr("disabled",true);
	    	    	  $.ajax({
			                url:BASE_PATH+'/TCommodity/findTCommodityById.do',
			                type:'get',
			                dataType:'json',
			                async:true,  //异步加载
			                data:{
			                	'id':id
			                },
			                error:function (res) {
			                    layer.alert(res.data.erro);
			                },
			                success : function(data){
								body.find("input#id").val(data.data.id);
								body.find("input#name").val(data.data.name);
								body.find("input#category").val(data.data.category);
								body.find("input#info").val(data.data.info);
								body.find("input#pop").val(data.data.pop);
								body.find("input#pictureId").val(data.data.pictureId);
								body.find("input#price").val(data.data.price);
								body.find("input#secprice").val(data.data.secprice);
								body.find("input#conditions").val(data.data.conditions);
								body.find("input#messageId").val(data.data.messageId);
								body.find("input#num").val(data.data.num);
								body.find("input#sellerId").val(data.data.sellerId);
								body.find("input#buyerId").val(data.data.buyerId),
								body.find("input#creartTime").val(data.data.creartTime),
								body.find("input#closingTime").val(data.data.closingTime),
								body.find("input#state").val(data.data.state)
							//dialogform.render('select');
			    	                
			    	        }
			            });
	    	      },
	    	      yes: function (layero, index) {
	    	    	  var body = layui.layer.getChildFrame('body', layero); //得到iframe页的body内容
	    	    	
	    			  //判断是否为空
	    			/*if(roomCode==""||roomFloor==""||roomType==""||roomState==""||roomPrix==""){
	    				layer.alert('请输入完整信息!');
	    			}
	    			else {*/ 	
	    	    	  $.ajax({
	    	    		  url:BASE_PATH+'/TCommodity/updateTCommodityById.do',
	    	    		  type:'get',
	    	    		  data: {
							  id:body.find("input#id").val(),
							  name:body.find("input#name").val(),
							  category:body.find("input#category").val(),
							  info:body.find("input#info").val(),
							  pop:body.find("input#pop").val(),
							  pictureId:body.find("input#pictureId").val(),
							  price:body.find("input#price").val(),
							  secprice:body.find("input#secprice").val(),
							  conditions:body.find("input#conditions").val(),
							  messageId:body.find("input#messageId").val(),
							  num:body.find("input#num").val(),
							  sellerId:body.find("input#sellerId").val(),
							  buyerId:body.find("input#buyerId").val(),
							  creartTime:body.find("input#creartTime").val(),
							  closingTime:body.find("input#closingTime").val(),
							  state:body.find("input#state").val()
	    	    			},
	    	    		  error:function (res) {
	    	    			  layer.alert('网络错误!');
	    	    		  },
	    	    		  success : function(layero, index){
	    	    			  layer.alert('修改成功!',function(){
	    	    				  layer.closeAll();
	    	    				  table.reload('tCommoditylist');
	    	    			  });
	    	    		  }
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
		table.reload('tCommoditylist', {
	        page: {
	          curr: 1 //重新从第 1 页开始
	        },
	        where: {
				id: $("#id").val(),
				name: $("#name").val(),
				category: $("#category").val(),
				info: $("#info").val(),
				pop: $("#pop").val(),
				pictureId: $("#pictureId").val(),
				price: $("#price").val(),
				secprice: $("#secprice").val(),
				conditions: $("#conditions").val(),
				messageId: $("#messageId").val(),
				num: $("#num").val(),
				sellerId: $("#sellerId").val(),
				buyerId: $("#buyerId").val(),
				creartTime: $("#creartTime").val(),
				closingTime: $("#closingTime").val(),
				state: $("#state").val(),
		    }
	    });
	});
	 $("#name").bind('input propertychange', function () {
		table.reload('tCommoditylist', {
	        page: {
	          curr: 1 //重新从第 1 页开始
	        },
	        where: {
				id: $("#id").val(),
				name: $("#name").val(),
				category: $("#category").val(),
				info: $("#info").val(),
				pop: $("#pop").val(),
				pictureId: $("#pictureId").val(),
				price: $("#price").val(),
				secprice: $("#secprice").val(),
				conditions: $("#conditions").val(),
				messageId: $("#messageId").val(),
				num: $("#num").val(),
				sellerId: $("#sellerId").val(),
				buyerId: $("#buyerId").val(),
				creartTime: $("#creartTime").val(),
				closingTime: $("#closingTime").val(),
				state: $("#state").val(),
		    }
	    });
	});
	 $("#category").bind('input propertychange', function () {
		table.reload('tCommoditylist', {
	        page: {
	          curr: 1 //重新从第 1 页开始
	        },
	        where: {
				id: $("#id").val(),
				name: $("#name").val(),
				category: $("#category").val(),
				info: $("#info").val(),
				pop: $("#pop").val(),
				pictureId: $("#pictureId").val(),
				price: $("#price").val(),
				secprice: $("#secprice").val(),
				conditions: $("#conditions").val(),
				messageId: $("#messageId").val(),
				num: $("#num").val(),
				sellerId: $("#sellerId").val(),
				buyerId: $("#buyerId").val(),
				creartTime: $("#creartTime").val(),
				closingTime: $("#closingTime").val(),
				state: $("#state").val(),
		    }
	    });
	});
	 $("#info").bind('input propertychange', function () {
		table.reload('tCommoditylist', {
	        page: {
	          curr: 1 //重新从第 1 页开始
	        },
	        where: {
				id: $("#id").val(),
				name: $("#name").val(),
				category: $("#category").val(),
				info: $("#info").val(),
				pop: $("#pop").val(),
				pictureId: $("#pictureId").val(),
				price: $("#price").val(),
				secprice: $("#secprice").val(),
				conditions: $("#conditions").val(),
				messageId: $("#messageId").val(),
				num: $("#num").val(),
				sellerId: $("#sellerId").val(),
				buyerId: $("#buyerId").val(),
				creartTime: $("#creartTime").val(),
				closingTime: $("#closingTime").val(),
				state: $("#state").val(),
		    }
	    });
	});
	 $("#pop").bind('input propertychange', function () {
		table.reload('tCommoditylist', {
	        page: {
	          curr: 1 //重新从第 1 页开始
	        },
	        where: {
				id: $("#id").val(),
				name: $("#name").val(),
				category: $("#category").val(),
				info: $("#info").val(),
				pop: $("#pop").val(),
				pictureId: $("#pictureId").val(),
				price: $("#price").val(),
				secprice: $("#secprice").val(),
				conditions: $("#conditions").val(),
				messageId: $("#messageId").val(),
				num: $("#num").val(),
				sellerId: $("#sellerId").val(),
				buyerId: $("#buyerId").val(),
				creartTime: $("#creartTime").val(),
				closingTime: $("#closingTime").val(),
				state: $("#state").val(),
		    }
	    });
	});
	 $("#pictureId").bind('input propertychange', function () {
		table.reload('pictureIdlist', {
	        page: {
	          curr: 1 //重新从第 1 页开始
	        },
	        where: {
				id: $("#id").val(),
				name: $("#name").val(),
				category: $("#category").val(),
				info: $("#info").val(),
				pop: $("#pop").val(),
				pictureId: $("#pictureId").val(),
				price: $("#price").val(),
				secprice: $("#secprice").val(),
				conditions: $("#conditions").val(),
				messageId: $("#messageId").val(),
				num: $("#num").val(),
				sellerId: $("#sellerId").val(),
				buyerId: $("#buyerId").val(),
				creartTime: $("#creartTime").val(),
				closingTime: $("#closingTime").val(),
				state: $("#state").val(),
		    }
	    });
	});
	 $("#price").bind('input propertychange', function () {
		table.reload('tCommoditylist', {
	        page: {
	          curr: 1 //重新从第 1 页开始
	        },
	        where: {
				id: $("#id").val(),
				name: $("#name").val(),
				category: $("#category").val(),
				info: $("#info").val(),
				pop: $("#pop").val(),
				pictureId: $("#pictureId").val(),
				price: $("#price").val(),
				secprice: $("#secprice").val(),
				conditions: $("#conditions").val(),
				messageId: $("#messageId").val(),
				num: $("#num").val(),
				sellerId: $("#sellerId").val(),
				buyerId: $("#buyerId").val(),
				creartTime: $("#creartTime").val(),
				closingTime: $("#closingTime").val(),
				state: $("#state").val(),
		    }
	    });
	});
	 $("#secprice").bind('input propertychange', function () {
		table.reload('tCommoditylist', {
	        page: {
	          curr: 1 //重新从第 1 页开始
	        },
	        where: {
				id: $("#id").val(),
				name: $("#name").val(),
				category: $("#category").val(),
				info: $("#info").val(),
				pop: $("#pop").val(),
				pictureId: $("#pictureId").val(),
				price: $("#price").val(),
				secprice: $("#secprice").val(),
				conditions: $("#conditions").val(),
				messageId: $("#messageId").val(),
				num: $("#num").val(),
				sellerId: $("#sellerId").val(),
				buyerId: $("#buyerId").val(),
				creartTime: $("#creartTime").val(),
				closingTime: $("#closingTime").val(),
				state: $("#state").val(),
		    }
	    });
	});
	 $("#conditions").bind('input propertychange', function () {
		table.reload('tCommoditylist', {
	        page: {
	          curr: 1 //重新从第 1 页开始
	        },
	        where: {
				id: $("#id").val(),
				name: $("#name").val(),
				category: $("#category").val(),
				info: $("#info").val(),
				pop: $("#pop").val(),
				pictureId: $("#pictureId").val(),
				price: $("#price").val(),
				secprice: $("#secprice").val(),
				conditions: $("#conditions").val(),
				messageId: $("#messageId").val(),
				num: $("#num").val(),
				sellerId: $("#sellerId").val(),
				buyerId: $("#buyerId").val(),
				creartTime: $("#creartTime").val(),
				closingTime: $("#closingTime").val(),
				state: $("#state").val(),
		    }
	    });
	});
	 $("#messageId").bind('input propertychange', function () {
		table.reload('tCommoditylist', {
	        page: {
	          curr: 1 //重新从第 1 页开始
	        },
	        where: {
				id: $("#id").val(),
				name: $("#name").val(),
				category: $("#category").val(),
				info: $("#info").val(),
				pop: $("#pop").val(),
				pictureId: $("#pictureId").val(),
				price: $("#price").val(),
				secprice: $("#secprice").val(),
				conditions: $("#conditions").val(),
				messageId: $("#messageId").val(),
				num: $("#num").val(),
				sellerId: $("#sellerId").val(),
				buyerId: $("#buyerId").val(),
				creartTime: $("#creartTime").val(),
				closingTime: $("#closingTime").val(),
				state: $("#state").val(),
		    }
	    });
	});
	 $("#num").bind('input propertychange', function () {
		table.reload('tCommoditylist', {
	        page: {
	          curr: 1 //重新从第 1 页开始
	        },
	        where: {
				id: $("#id").val(),
				name: $("#name").val(),
				category: $("#category").val(),
				info: $("#info").val(),
				pop: $("#pop").val(),
				pictureId: $("#pictureId").val(),
				price: $("#price").val(),
				secprice: $("#secprice").val(),
				conditions: $("#conditions").val(),
				messageId: $("#messageId").val(),
				num: $("#num").val(),
				sellerId: $("#sellerId").val(),
				buyerId: $("#buyerId").val(),
				creartTime: $("#creartTime").val(),
				closingTime: $("#closingTime").val(),
				state: $("#state").val(),
		    }
	    });
	});
	 $("#sellerId").bind('input propertychange', function () {
		table.reload('tCommoditylist', {
	        page: {
	          curr: 1 //重新从第 1 页开始
	        },
	        where: {
				id: $("#id").val(),
				name: $("#name").val(),
				category: $("#category").val(),
				info: $("#info").val(),
				pop: $("#pop").val(),
				pictureId: $("#pictureId").val(),
				price: $("#price").val(),
				secprice: $("#secprice").val(),
				conditions: $("#conditions").val(),
				messageId: $("#messageId").val(),
				num: $("#num").val(),
				sellerId: $("#sellerId").val(),
				buyerId: $("#buyerId").val(),
				creartTime: $("#creartTime").val(),
				closingTime: $("#closingTime").val(),
				state: $("#state").val(),
		    }
	    });
	});
	 $("#buyerId").bind('input propertychange', function () {
		table.reload('tCommoditylist', {
	        page: {
	          curr: 1 //重新从第 1 页开始
	        },
	        where: {
				id: $("#id").val(),
				name: $("#name").val(),
				category: $("#category").val(),
				info: $("#info").val(),
				pop: $("#pop").val(),
				pictureId: $("#pictureId").val(),
				price: $("#price").val(),
				secprice: $("#secprice").val(),
				conditions: $("#conditions").val(),
				messageId: $("#messageId").val(),
				num: $("#num").val(),
				sellerId: $("#sellerId").val(),
				buyerId: $("#buyerId").val(),
				creartTime: $("#creartTime").val(),
				closingTime: $("#closingTime").val(),
				state: $("#state").val(),
		    }
	    });
	});
	 $("#creartTime").bind('input propertychange', function () {
		table.reload('tCommoditylist', {
	        page: {
	          curr: 1 //重新从第 1 页开始
	        },
	        where: {
				id: $("#id").val(),
				name: $("#name").val(),
				category: $("#category").val(),
				info: $("#info").val(),
				pop: $("#pop").val(),
				pictureId: $("#pictureId").val(),
				price: $("#price").val(),
				secprice: $("#secprice").val(),
				conditions: $("#conditions").val(),
				messageId: $("#messageId").val(),
				num: $("#num").val(),
				sellerId: $("#sellerId").val(),
				buyerId: $("#buyerId").val(),
				creartTime: $("#creartTime").val(),
				closingTime: $("#closingTime").val(),
				state: $("#state").val(),
		    }
	    });
	});
	 $("#closingTime").bind('input propertychange', function () {
		table.reload('tCommoditylist', {
	        page: {
	          curr: 1 //重新从第 1 页开始
	        },
	        where: {
				id: $("#id").val(),
				name: $("#name").val(),
				category: $("#category").val(),
				info: $("#info").val(),
				pop: $("#pop").val(),
				pictureId: $("#pictureId").val(),
				price: $("#price").val(),
				secprice: $("#secprice").val(),
				conditions: $("#conditions").val(),
				messageId: $("#messageId").val(),
				num: $("#num").val(),
				sellerId: $("#sellerId").val(),
				buyerId: $("#buyerId").val(),
				creartTime: $("#creartTime").val(),
				closingTime: $("#closingTime").val(),
				state: $("#state").val(),
		    }
	    });
	});
	 $("#state").bind('input propertychange', function () {
		table.reload('tCommoditylist', {
	        page: {
	          curr: 1 //重新从第 1 页开始
	        },
	        where: {
				id: $("#id").val(),
				name: $("#name").val(),
				category: $("#category").val(),
				info: $("#info").val(),
				pop: $("#pop").val(),
				pictureId: $("#pictureId").val(),
				price: $("#price").val(),
				secprice: $("#secprice").val(),
				conditions: $("#conditions").val(),
				messageId: $("#messageId").val(),
				num: $("#num").val(),
				sellerId: $("#sellerId").val(),
				buyerId: $("#buyerId").val(),
				creartTime: $("#creartTime").val(),
				closingTime: $("#closingTime").val(),
				state: $("#state").val(),
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
    	table.reload('tCommoditylist', {
    		page: {
  		          curr: 1 //重新从第 1 页开始
  		    },
    		where: {
				id: '',
				name: '',
				category: '',
				info: '',
				pop: '',
				pictureId: '',
				price: '',
				secprice: '',
				conditions: '',
				messageId: '',
				num: '',
				sellerId: '',
				buyerId: '',
				creartTime: '',
				closingTime: '',
				state: '',
  		    }
    	});
	});
    
    
      //新增按钮
	$(document).on('click','#addTCommodity',function(){
		layer.open({
			type: 2,
			skin: 'layui-layer-rim',
			title: '新增TCommodity信息',
			btn: ['保存'],
			btnAlign: 'c',
			shadeClose: true,
			shade: true,
			maxmin: false,
			area: ['70%', '80%'],
			content: BASE_PATH+'/editTCommodity.jsp',
			yes: function (layero, index) {
				var body = layui.layer.getChildFrame('body', layero); //得到iframe页的body内容
				
				//判断是否为空
				/*if(roomCode==""||roomFloor==""||roomType==""||roomState==""||roomPrix==""){
				layer.alert('请输入完整信息!');
				}
			else if(roomcodeExist==""){*/
				$.ajax({
					url:BASE_PATH+'/TCommodity/addTCommodity.do',
					type:'get',
					data: {
						id:body.find("input#id").val(),
						name:body.find("input#name").val(),
						category:body.find("input#category").val(),
						info:body.find("input#info").val(),
						pop:body.find("input#pop").val(),
						pictureId:body.find("input#pictureId").val(),
						price:body.find("input#price").val(),
						secprice:body.find("input#secprice").val(),
						conditions:body.find("input#conditions").val(),
						messageId:body.find("input#messageId").val(),
						num:body.find("input#num").val(),
						sellerId:body.find("input#sellerId").val(),
						buyerId:body.find("input#buyerId").val(),
						creartTime:body.find("input#creartTime").val(),
						closingTime:body.find("input#closingTime").val(),
						state:body.find("input#state").val(),
					},
					dataType:'json',
					error:function (res) {
						layer.alert('网络错误!');
					},
					success : function(layero, index){
						layer.alert('添加成功!',function(){
						layer.closeAll();
						table.reload('#tCommoditylist');
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