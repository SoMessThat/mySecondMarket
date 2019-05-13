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
		limit:5,	
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
       	  {field:'name', title: 'name', fixed: 'left' }  ,
       	  {field:'category', title: 'category', fixed: 'left' }  ,
       	  {field:'info', title: 'info', fixed: 'left' }  ,
       	  {field:'pop', title: 'pop', fixed: 'left' }  ,
       	  {field:"pictureId", title: '图片',style:'height:100px', fixed: 'left',
      	 	templet: function(res){return '<div><img src="'+res.pictureId+'"</div>' }},
       	  {field:'secprice', title: 'secprice', fixed: 'left' }  ,
       	  {field:'conditions', title: 'conditions', fixed: 'left' }  ,
       	  {field:'state', title: 'state', fixed: 'left' }  ,
       	  {fixed: 'right', title: '操作', align:'center', toolbar: '#barDemo'}
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
	    	      title: '编辑商品信息',
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
								body.find("select#category").val(data.data.category);
								body.find("input#info").val(data.data.info);
								body.find("input#price").val(data.data.price);
								body.find("input#secprice").val(data.data.secprice);
								body.find("select#conditions").val(data.data.conditions);
								body.find("select#state").val(data.data.state)
								dialogform.render('select');
			    	                
			    	        }
			            });
	    	      },
	    	      yes: function (layero, index) {
	    	    	  var body = layui.layer.getChildFrame('body', layero); //得到iframe页的body内容
	    	    	
	    	    	  $.ajax({
	    	    		  url:BASE_PATH+'/TCommodity/updateTCommodityById.do',
	    	    		  type:'get',
	    	    		  data: {
							  id:body.find("input#id").val(),
							  name:body.find("input#name").val(),
							  category:body.find("input#category").val(),
							  info:body.find("input#info").val(),
							  price:body.find("input#price").val(),
							  secprice:body.find("input#secprice").val(),
							  conditions:body.find("input#conditions").val(),
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
      
	 $("#name").bind('input propertychange', function () {
		table.reload('tCommoditylist', {
	        page: {
	          curr: 1 //重新从第 1 页开始
	        },
	        where: {
	        	tCommodity_name: $("#name").val(),
	        	tCommodity_category: $("#category").val(),
				tCommodity_info: $("#info").val(),
				tCommodity_secprice: $("#secprice").val(),
				tCommodity_conditions: $("#conditions").val(),
				tCommodity_state: $("#state").val()
		    }
	    });
	});
	 form.on('select(category)', function(data){
		table.reload('tCommoditylist', {
	        page: {
	          curr: 1 //重新从第 1 页开始
	        },
	        where: {
	        	tCommodity_name: $("#name").val(),
	        	tCommodity_category: $("#category").val(),
				tCommodity_info: $("#info").val(),
				tCommodity_secprice: $("#secprice").val(),
				tCommodity_conditions: $("#conditions").val(),
				tCommodity_state: $("#state").val()
		    }
	    });
	});
	 $("#info").bind('input propertychange', function () {
		table.reload('tCommoditylist', {
	        page: {
	          curr: 1 //重新从第 1 页开始
	        },
	        where: {
	        	tCommodity_name: $("#name").val(),
	        	tCommodity_category: $("#category").val(),
				tCommodity_info: $("#info").val(),
				tCommodity_secprice: $("#secprice").val(),
				tCommodity_conditions: $("#conditions").val(),
				tCommodity_state: $("#state").val()
		    }
	    });
	});
	 $("#secprice").bind('input propertychange', function () {
		table.reload('tCommoditylist', {
	        page: {
	          curr: 1 //重新从第 1 页开始
	        },
	        where: {
	        	tCommodity_name: $("#name").val(),
	        	tCommodity_category: $("#category").val(),
				tCommodity_info: $("#info").val(),
				tCommodity_secprice: $("#secprice").val(),
				tCommodity_conditions: $("#conditions").val(),
				tCommodity_state: $("#state").val()
		    }
	    });
	});
	 form.on('select(conditions)', function(data){
		table.reload('tCommoditylist', {
	        page: {
	          curr: 1 //重新从第 1 页开始
	        },
	        where: {
	        	tCommodity_name: $("#name").val(),
	        	tCommodity_category: $("#category").val(),
				tCommodity_info: $("#info").val(),
				tCommodity_secprice: $("#secprice").val(),
				tCommodity_conditions: $("#conditions").val(),
				tCommodity_state: $("#state").val()
		    }
	    });
	});
		form.on('select(state)', function(data){
		table.reload('tCommoditylist', {
	        page: {
	          curr: 1 //重新从第 1 页开始
	        },
	        where: {
	        	tCommodity_name: $("#name").val(),
	        	tCommodity_category: $("#category").val(),
				tCommodity_info: $("#info").val(),
				tCommodity_secprice: $("#secprice").val(),
				tCommodity_conditions: $("#conditions").val(),
				tCommodity_state: $("#state").val()
		    }
	    });
	});
      
    //清空
     $("#resetbtn").on('click',function(){
    	table.reload('tCommoditylist', {
    		page: {
  		          curr: 1 //重新从第 1 页开始
  		    },
    		where: {
    			tCommodity_name: '',
				tCommodity_category: '',
				tCommodity_info: '',
				tCommodity_secprice: '',
				tCommodity_conditions: '',
				tCommodity_state: '',
  		    }
    	});
	});
    
    
      //新增按钮
	$(document).on('click','#addTCommodity',function(){
		layer.open({
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
							sellerId:$("#userId").val(),
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
});