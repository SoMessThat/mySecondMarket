layui.use(['layer', 'table','element','form','laydate'], function(){
	  var layer = layui.layer, 
	  	  table = layui.table, 
	  	  element = layui.element, 
	  	  laydate = layui.laydate,
	  	  laypage=layui.laypage,
	  	  form = layui.form,
	  	  $ = layui.$;

   	  table.render({
   		elem: '#tAnnouncementlist',
	    url: BASE_PATH+'/TAnnouncement/queryPageTAnnouncement.do',
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
       	  {field:"id", title: 'id', width:100, fixed: 'left' }  ,
       	  {field:"titlle", title: 'titlle', width:100, fixed: 'left' }  ,
       	  {field:"content", title: 'content', width:100, fixed: 'left' }  ,
       	  {field:"pictureId", title: 'pictureId', width:100, fixed: 'left' }  ,
       	  {field:"creatTime", title: 'creatTime', width:100, fixed: 'left' }  ,
       	  {field:"state", title: 'state', width:100, fixed: 'left' }  ,
	      {fixed: 'right', title: '操作',width: 150, align:'center', toolbar: '#barDemo'}
	    ]]
      });
   
   	  //监听行工具事件
   	  table.on('tool(tAnnouncementlist)', function(obj){
	   	  if(obj.event === 'del'){
	   		  layer.confirm('真的删除行么', function(index){
	   			  var id = obj.data.id;
	   			  $.ajax({
	   				  url:BASE_PATH+'/TAnnouncement/delTAnnouncement.do',
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
   							    table.reload('tAnnouncementlist');
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
	    	      content: /*BASE_PATH+*/'./editTAnnouncement.jsp',
	    	      success : function(layero, index){
	    	    	  var body = layer.getChildFrame('body', index);
    	    	      var iframeWin = window[layero.find('iframe')[0]['name']];
    	    	      var dialogform = iframeWin.layui.form;
	    	    	  var id = obj.data.id;
					//设置不可编辑
	    	    	  //body.find("input#roomcode").attr("disabled",true);
  	                  //body.find("select#roomfloor").attr("disabled",true);
	    	    	  $.ajax({
			                url:BASE_PATH+'/TAnnouncement/findTAnnouncementById.do',
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
								body.find("input#titlle").val(data.data.titlle);
								body.find("input#content").val(data.data.content);
								body.find("input#pictureId").val(data.data.pictureId);
								body.find("input#creatTime").val(data.data.creatTime);
								body.find("input#state").val(data.data.state);
							//dialogform.render('select');
			    	                
			    	        }
			            });
	    	      },
	    	      yes: function (layero, index) {
	    	    	  var body = layui.layer.getChildFrame('body', layero); //得到iframe页的body内容
	    	    	//获取值弹出框值
					<!--  ul  li -->
				      var id=body.find("input#id").val();
				      var titlle=body.find("input#titlle").val();
				      var content=body.find("input#content").val();
				      var pictureId=body.find("input#pictureId").val();
				      var creatTime=body.find("input#creatTime").val();
				      var state=body.find("input#state").val();
	    			  //判断是否为空
	    			/*if(roomCode==""||roomFloor==""||roomType==""||roomState==""||roomPrix==""){
	    				layer.alert('请输入完整信息!');
	    			}
	    			else {*/ 	
	    	    	  $.ajax({
	    	    		  url:BASE_PATH+'/TAnnouncement/updateTAnnouncementById.do',
	    	    		  type:'get',
	    	    		  data: {
	    	    			  tAnnouncement_id:body.find("input#id").val(),
	    	    			  tAnnouncement_titlle:body.find("input#titlle").val(),
	    	    			  tAnnouncement_content:body.find("input#content").val(),
	    	    			  tAnnouncement_pictureId:body.find("input#pictureId").val(),
	    	    			  tAnnouncement_creatTime:body.find("input#creatTime").val(),
	    	    			  tAnnouncement_state:body.find("input#state").val()
	    	    			},
	    	    		  dataType:'json',
	    	    		  error:function (res) {
	    	    			  layer.alert('网络错误!');
	    	    		  },
	    	    		  success : function(layero, index){
	    	    			  layer.alert('修改成功!',function(){
	    	    				  layer.closeAll();
	    	    				  table.reload('tAnnouncementlist');
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
		table.reload('tAnnouncementlist', {
	        page: {
	          curr: 1 //重新从第 1 页开始
	        },
	        where: {
	        	tAnnouncement_id: $("#id").val(),
	        	tAnnouncement_titlle: $("#titlle").val(),
	        	tAnnouncement_content: $("#content").val(),
	        	tAnnouncement_pictureId: $("#pictureId").val(),
	        	tAnnouncement_creatTime: $("#creatTime").val(),
	        	tAnnouncement_state: $("#state").val()
		    }
	    });
	});
	 $("#titlle").bind('input propertychange', function () {
		table.reload('tAnnouncementlist', {
	        page: {
	          curr: 1 //重新从第 1 页开始
	        },
	        where: {
	        	tAnnouncement_id: $("#id").val(),
	        	tAnnouncement_titlle: $("#titlle").val(),
	        	tAnnouncement_content: $("#content").val(),
	        	tAnnouncement_pictureId: $("#pictureId").val(),
	        	tAnnouncement_creatTime: $("#creatTime").val(),
	        	tAnnouncement_state: $("#state").val()
		    }
	    });
	});
	 $("#content").bind('input propertychange', function () {
		table.reload('tAnnouncementlist', {
	        page: {
	          curr: 1 //重新从第 1 页开始
	        },
	        where: {
	        	tAnnouncement_id: $("#id").val(),
	        	tAnnouncement_titlle: $("#titlle").val(),
	        	tAnnouncement_content: $("#content").val(),
	        	tAnnouncement_pictureId: $("#pictureId").val(),
	        	tAnnouncement_creatTime: $("#creatTime").val(),
	        	tAnnouncement_state: $("#state").val()
		    }
	    });
	});
	 $("#pictureId").bind('input propertychange', function () {
		table.reload('tAnnouncementlist', {
	        page: {
	          curr: 1 //重新从第 1 页开始
	        },
	        where: {
	        	tAnnouncement_id: $("#id").val(),
	        	tAnnouncement_titlle: $("#titlle").val(),
	        	tAnnouncement_content: $("#content").val(),
	        	tAnnouncement_pictureId: $("#pictureId").val(),
	        	tAnnouncement_creatTime: $("#creatTime").val(),
	        	tAnnouncement_state: $("#state").val()
		    }
	    });
	});
	 $("#creatTime").bind('input propertychange', function () {
		table.reload('tAnnouncementlist', {
	        page: {
	          curr: 1 //重新从第 1 页开始
	        },
	        where: {
	        	tAnnouncement_id: $("#id").val(),
	        	tAnnouncement_titlle: $("#titlle").val(),
	        	tAnnouncement_content: $("#content").val(),
	        	tAnnouncement_pictureId: $("#pictureId").val(),
	        	tAnnouncement_creatTime: $("#creatTime").val(),
	        	tAnnouncement_state: $("#state").val()
		    }
	    });
	});
	 $("#state").bind('input propertychange', function () {
		table.reload('tAnnouncementlist', {
	        page: {
	          curr: 1 //重新从第 1 页开始
	        },
	        where: {
	        	tAnnouncement_id: $("#id").val(),
	        	tAnnouncement_titlle: $("#titlle").val(),
	        	tAnnouncement_content: $("#content").val(),
	        	tAnnouncement_pictureId: $("#pictureId").val(),
	        	tAnnouncement_creatTime: $("#creatTime").val(),
	        	tAnnouncement_state: $("#state").val()
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
    	table.reload('tAnnouncementlist', {
    		page: {
  		          curr: 1 //重新从第 1 页开始
  		    },
    		where: {
    			tAnnouncement_id: '',
    			tAnnouncement_titlle: '',
    			tAnnouncement_content: '',
    			tAnnouncement_pictureId: '',
    			tAnnouncement_creatTime: '',
    			tAnnouncement_state: '',
  		    }
    	});
	});
    
    
      //新增按钮
	$(document).on('click','#addTAnnouncement',function(){
		layer.open({
			type: 2,
			skin: 'layui-layer-rim',
			title: '新增TAnnouncement信息',
			btn: ['保存'],
			btnAlign: 'c',
			shadeClose: true,
			shade: true,
			maxmin: false,
			area: ['70%', '80%'],
			content: /*BASE_PATH+*/'./editTAnnouncement.jsp',
			yes: function (layero, index) {
				var body = layui.layer.getChildFrame('body', layero); //得到iframe页的body内容
				//判断是否为空
				/*if(roomCode==""||roomFloor==""||roomType==""||roomState==""||roomPrix==""){
				layer.alert('请输入完整信息!');
				}
			else if(roomcodeExist==""){*/
				$.ajax({
					url:BASE_PATH+'/TAnnouncement/addTAnnouncement.do',
					type:'get',
					data: {
						tAnnouncement_id:body.find("input#id").val(),
						tAnnouncement_titlle:body.find("input#titlle").val(),
						tAnnouncement_content:body.find("input#content").val(),
						tAnnouncement_pictureId:body.find("input#pictureId").val(),
						tAnnouncement_creatTime:body.find("input#creatTime").val(),
						tAnnouncement_state:body.find("input#state").val()
					},
					dataType:'json',
					error:function (res) {
						layer.alert('网络错误!');
					},
					success : function(layero, index){
						layer.alert('添加成功!',function(){
						layer.closeAll();
						table.reload('tAnnouncementlist');
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