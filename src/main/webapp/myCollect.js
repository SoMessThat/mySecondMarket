layui.use(['layer', 'table','element','form','laydate'], function(){
  	var layer = layui.layer, 
	table = layui.table, 
	element = layui.element, 
	laydate = layui.laydate,
	laypage=layui.laypage,
	form = layui.form,
	$ = layui.$;

	table.render({
		elem: '#Collectlist',
		url: BASE_PATH+'/TSolicitude/queryPageCollect.do',
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
	table.on('tool(Collectlist)', function(obj){
		if(obj.event === 'del'){
			layer.confirm('真的删除行么', function(index){
				var id = obj.data.comId;
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
							table.reload('Collectlist');
						});
						obj.del();
					}
				});
			});
		}else if(obj.event === 'edit'){
			window.open(BASE_PATH+"/TCommodity/info.do?id="+obj.data.id,"_blank");
		}
	});
});
  
  //查询条件监听
layui.use(['form','table'], function(){
	var form = layui.form,
	table = layui.table,
	$ = layui.$;
      
	 $("#name").bind('input propertychange', function () {
			table.reload('Collectlist', {
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
			table.reload('Collectlist', {
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
			table.reload('Collectlist', {
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
			table.reload('Collectlist', {
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
			table.reload('Collectlist', {
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
			table.reload('Collectlist', {
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
    	table.reload('Collectlist', {
    		page: {
  		        curr: 1 
  		    },
    		where: {
					tSolicitude_commodityId: '',
					tSolicitude_category: '',
					tSolicitude_type: '',
  		    }
    	});
	});
    
});