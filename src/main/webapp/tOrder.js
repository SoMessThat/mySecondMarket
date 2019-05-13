layui.use(['layer', 'table','form','laydate'], function(){
	var layer = layui.layer, 
	table = layui.table, 
	laydate = layui.laydate,
	laypage=layui.laypage,
	form = layui.form,
	$ = layui.$;

	laydate.render({
		  elem: '#payTime',
		  done: function(value, date, endDate){
			  table.reload('tOrderlist', {
					page: {
						curr: 1 //重新从第 1 页开始
					},
					where: {
						commodityName: $("#commodityName").val(),
						tOrder_price: $("#price").val(),
						sellerName: $("#sellerName").val(),
						tOrder_payTime: value,
						tOrder_state: $("#state").val(),
						tOrder_isSign: $("#isSign").val()
					}
				});
		  }
	  });
	
	table.render({
		elem: '#tOrderlist',
		url: BASE_PATH+'/TOrder/queryPageTOrder.do',
		limit:5,	
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
		         {field:"commodityName", title: '商品名', fixed: 'left',
		        	 	templet: function(res){return res.commodity.name}},
		         {field:"pictureId", title: '图片',style:'height:100px', fixed: 'left',
		        	 	templet: function(res){return '<div><img src="'+res.pictureId+'"</div>' }},
		         {field:"price", title: '价格', fixed: 'left' }  ,
		         {field:'seller.username', title: '卖家昵称', fixed: 'left',
		        	 	templet: function(res){return res.seller.username}},
		         {field:"payTime", title: '付款时间', fixed: 'left',templet: function(res){
			    	  var a = new Date(res.payTime*1000).format("yyyy-MM-dd hh:mm:ss");
			    	  return a;
			      }},
		         {field:"state", title: '状态', fixed: 'left' }  ,
		         {field:"address", title: '地址', fixed: 'left' }  ,
		         {field:"isSign", title: '是否签收', fixed: 'left' }  ,
		         {field:"logisticsCode", title: '物流', fixed: 'left' }  ,
		         {fixed: 'right', title: '操作',width:150, align:'center', toolbar: '#barDemo'}
		         ]]
	});

	//监听行工具事件
	table.on('tool(tOrderlist)', function(obj){
		if(obj.event === 'del'){
			layer.confirm('真的删除行么', function(index){
				var id = obj.data.id;
				$.ajax({
					url:BASE_PATH+'/TOrder/delTOrder.do',
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
							table.reload('tOrderlist');
						});
						obj.del();
					}
				});
			});
		} else if(obj.event === 'edit'){
			window.open(BASE_PATH+"/TCommodity/info.do?id="+obj.data.commodityId,"_blank");
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

	$("#commodityName").bind('input propertychange', function () {
		table.reload('tOrderlist', {
			page: {
				curr: 1 //重新从第 1 页开始
			},
			where: {
				commodityName: $("#commodityName").val(),
				tOrder_price: $("#price").val(),
				sellerName: $("#sellerName").val(),
				tOrder_payTime: $("#payTime").val(),
				tOrder_state: $("#state").val(),
				tOrder_isSign: $("#isSign").val()
			}
		});
	});
	$("#price").bind('input propertychange', function () {
		table.reload('tOrderlist', {
			page: {
				curr: 1 //重新从第 1 页开始
			},
			where: {
				commodityName: $("#commodityName").val(),
				tOrder_price: $("#price").val(),
				sellerName: $("#sellerName").val(),
				tOrder_payTime: $("#payTime").val(),
				tOrder_state: $("#state").val(),
				tOrder_isSign: $("#isSign").val()
			}
		});
	});
	$("#sellerName").bind('input propertychange', function () {
		table.reload('tOrderlist', {
			page: {
				curr: 1 //重新从第 1 页开始
			},
			where: {
				commodityName: $("#commodityName").val(),
				tOrder_price: $("#price").val(),
				sellerName: $("#sellerName").val(),
				tOrder_payTime: $("#payTime").val(),
				tOrder_state: $("#state").val(),
				tOrder_isSign: $("#isSign").val()
			}
		});
	});
	form.on('select(state)', function(data){
		table.reload('tOrderlist', {
			page: {
				curr: 1 //重新从第 1 页开始
			},
			where: {
				commodityName: $("#commodityName").val(),
				tOrder_price: $("#price").val(),
				sellerName: $("#sellerName").val(),
				tOrder_payTime: $("#payTime").val(),
				tOrder_state: $("#state").val(),
				tOrder_isSign: $("#isSign").val()
			}
		});
	});
	form.on('select(isSign)', function(data){
		table.reload('tOrderlist', {
			page: {
				curr: 1 //重新从第 1 页开始
			},
			where: {
				commodityName: $("#commodityName").val(),
				tOrder_price: $("#price").val(),
				sellerName: $("#sellerName").val(),
				tOrder_payTime: $("#payTime").val(),
				tOrder_state: $("#state").val(),
				tOrder_isSign: $("#isSign").val()
			}
		});
	});

	//清空
	$("#resetbtn").on('click',function(){
		table.reload('tOrderlist', {
			page: {
				curr: 1 //重新从第 1 页开始
			},
			where: {
				commodityName: '',
				tOrder_price: '',
				sellerName: '',
				tOrder_payTime: '',
				tOrder_state: '',
				tOrder_isSign: '',
			}
		});
	});


});