layui.use(['layer', 'table','form','laydate'], function(){
	var layer = layui.layer, 
	table = layui.table, 
	laydate = layui.laydate,
	laypage=layui.laypage,
	form = layui.form,
	$ = layui.$;

	table.render({
		elem: '#tOrderlist',
		url: BASE_PATH+'/TOrder/queryPageTOrder.do',
		limit:10,	
		limits:[5,10,15,20],
		toolbar: true,
		page:true, //开启分页
		height:'450px',
		response: {
			statusName: 'status',
			statusCode: 200,
			msgName: 'messages',
			countName: 'count',
			dataName: 'data'
		},
		cols: [[ //表头
		         {field:"commodityId", title: '', width:50, fixed: 'left' }  ,
		         {field:"pictureId", title: '', width:50, fixed: 'left' }  ,
		         {field:"price", title: '价格', width:50, fixed: 'left' }  ,
		         {field:"sellerId", title: '', width:50, fixed: 'left' }  ,
		         {field:"buyerId", title: '', width:50, fixed: 'left' }  ,
		         {field:"creartTime", title: '创建时间', width:50, fixed: 'left' }  ,
		         {field:"payTime", title: '付款时间', width:50, fixed: 'left' }  ,
		         {field:"state", title: '状态', width:50, fixed: 'left' }  ,
		         {field:"address", title: '地址', width:50, fixed: 'left' }  ,
		         {field:"isSign", title: '', width:50, fixed: 'left' }  ,
		         {field:"isPay", title: '', width:50, fixed: 'left' }  ,
		         {field:"logisticsCode", title: '', width:50, fixed: 'left' }  ,
		         {fixed: 'right', title: '操作',width: 50, align:'center', toolbar: '#barDemo'}
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
				content: BASE_PATH+'/editTOrder.jsp',
				success : function(layero, index){
					var body = layer.getChildFrame('body', index);
					var iframeWin = window[layero.find('iframe')[0]['name']];
					var dialogform = iframeWin.layui.form;
					var id = obj.data.id;
					//设置不可编辑
					//body.find("input#roomcode").attr("disabled",true);
					//body.find("select#roomfloor").attr("disabled",true);
					$.ajax({
						url:BASE_PATH+'/TOrder/findTOrderById.do',
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
							body.find("input#id").val(data.data.id),
							body.find("input#commodityId").val(data.data.commodityId),
							body.find("input#pictureId").val(data.data.pictureId),
							body.find("input#price").val(data.data.price),
							body.find("input#num").val(data.data.num),
							body.find("input#sellerId").val(data.data.sellerId),
							body.find("input#buyerId").val(data.data.buyerId),
							body.find("input#creartTime").val(data.data.creartTime),
							body.find("input#payTime").val(data.data.payTime),
							body.find("input#state").val(data.data.state),
							body.find("input#address").val(data.data.address),
							body.find("input#isSign").val(data.data.isSign),
							body.find("input#isPay").val(data.data.isPay),
							body.find("input#logisticsCode").val(data.data.logisticsCode);
							//dialogform.render('select');
						}
					});
				},
				yes: function (layero, index) {
					var body = layui.layer.getChildFrame('body', layero); //得到iframe页的body内容
					$.ajax({
						url:BASE_PATH+'/TOrder/updateTOrderById.do',
						type:'get',
						data: {
							id:body.find("input#id").val(),
							commodityId:body.find("input#commodityId").val(),
							pictureId:body.find("input#pictureId").val(),
							price:body.find("input#price").val(),
							num:body.find("input#num").val(),
							sellerId:body.find("input#sellerId").val(),
							buyerId:body.find("input#buyerId").val(),
							creartTime:body.find("input#creartTime").val(),
							payTime:body.find("input#payTime").val(),
							state:body.find("input#state").val(),
							address:body.find("input#address").val(),
							isSign:body.find("input#isSign").val(),
							isPay:body.find("input#isPay").val(),
							logisticsCode:body.find("input#logisticsCode").val(),
						},
						error:function (res) {
							layer.alert('网络错误!');
						},
						success : function(layero, index){
							layer.alert('修改成功!',function(){
								layer.closeAll();
								table.reload('tOrderlist');
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

	$("#id").bind('input propertychange', function () {
		table.reload('tOrderlist', {
			page: {
				curr: 1 //重新从第 1 页开始
			},
			where: {
				tOrder_id: $("#id").val(),
				tOrder_commodityId: $("#commodityId").val(),
				tOrder_pictureId: $("#pictureId").val(),
				tOrder_price: $("#price").val(),
				tOrder_num: $("#num").val(),
				tOrder_sellerId: $("#sellerId").val(),
				tOrder_buyerId: $("#buyerId").val(),
				tOrder_creartTime: $("#creartTime").val(),
				tOrder_payTime: $("#payTime").val(),
				tOrder_state: $("#state").val(),
				tOrder_address: $("#address").val(),
				tOrder_isSign: $("#isSign").val(),
				tOrder_isPay: $("#isPay").val(),
				tOrder_logisticsCode: $("#logisticsCode").val(),
			}
		});
	});
	$("#commodityId").bind('input propertychange', function () {
		table.reload('tOrderlist', {
			page: {
				curr: 1 //重新从第 1 页开始
			},
			where:{
				tOrder_id: $("#id").val(),
				tOrder_commodityId: $("#commodityId").val(),
				tOrder_pictureId: $("#pictureId").val(),
				tOrder_price: $("#price").val(),
				tOrder_num: $("#num").val(),
				tOrder_sellerId: $("#sellerId").val(),
				tOrder_buyerId: $("#buyerId").val(),
				tOrder_creartTime: $("#creartTime").val(),
				tOrder_payTime: $("#payTime").val(),
				tOrder_state: $("#state").val(),
				tOrder_address: $("#address").val(),
				tOrder_isSign: $("#isSign").val(),
				tOrder_isPay: $("#isPay").val(),
				tOrder_logisticsCode: $("#logisticsCode").val(),
			}
		});
	});
	$("#pictureId").bind('input propertychange', function () {
		table.reload('tOrderlist', {
			page: {
				curr: 1 //重新从第 1 页开始
			},
			where:{
				tOrder_id: $("#id").val(),
				tOrder_commodityId: $("#commodityId").val(),
				tOrder_pictureId: $("#pictureId").val(),
				tOrder_price: $("#price").val(),
				tOrder_num: $("#num").val(),
				tOrder_sellerId: $("#sellerId").val(),
				tOrder_buyerId: $("#buyerId").val(),
				tOrder_creartTime: $("#creartTime").val(),
				tOrder_payTime: $("#payTime").val(),
				tOrder_state: $("#state").val(),
				tOrder_address: $("#address").val(),
				tOrder_isSign: $("#isSign").val(),
				tOrder_isPay: $("#isPay").val(),
				tOrder_logisticsCode: $("#logisticsCode").val(),
			}
		});
	});
	$("#price").bind('input propertychange', function () {
		table.reload('tOrderlist', {
			page: {
				curr: 1 //重新从第 1 页开始
			},
			where: {
				tOrder_id: $("#id").val(),
				tOrder_commodityId: $("#commodityId").val(),
				tOrder_pictureId: $("#pictureId").val(),
				tOrder_price: $("#price").val(),
				tOrder_num: $("#num").val(),
				tOrder_sellerId: $("#sellerId").val(),
				tOrder_buyerId: $("#buyerId").val(),
				tOrder_creartTime: $("#creartTime").val(),
				tOrder_payTime: $("#payTime").val(),
				tOrder_state: $("#state").val(),
				tOrder_address: $("#address").val(),
				tOrder_isSign: $("#isSign").val(),
				tOrder_isPay: $("#isPay").val(),
				tOrder_logisticsCode: $("#logisticsCode").val(),
			}
		});
	});
	$("#num").bind('input propertychange', function () {
		table.reload('tOrderlist', {
			page: {
				curr: 1 //重新从第 1 页开始
			},
			where: {
				tOrder_id: $("#id").val(),
				tOrder_commodityId: $("#commodityId").val(),
				tOrder_pictureId: $("#pictureId").val(),
				tOrder_price: $("#price").val(),
				tOrder_num: $("#num").val(),
				tOrder_sellerId: $("#sellerId").val(),
				tOrder_buyerId: $("#buyerId").val(),
				tOrder_creartTime: $("#creartTime").val(),
				tOrder_payTime: $("#payTime").val(),
				tOrder_state: $("#state").val(),
				tOrder_address: $("#address").val(),
				tOrder_isSign: $("#isSign").val(),
				tOrder_isPay: $("#isPay").val(),
				tOrder_logisticsCode: $("#logisticsCode").val(),
			}
		});
	});
	$("#sellerId").bind('input propertychange', function () {
		table.reload('tOrderlist', {
			page: {
				curr: 1 //重新从第 1 页开始
			},
			where: {
				tOrder_id: $("#id").val(),
				tOrder_commodityId: $("#commodityId").val(),
				tOrder_pictureId: $("#pictureId").val(),
				tOrder_price: $("#price").val(),
				tOrder_num: $("#num").val(),
				tOrder_sellerId: $("#sellerId").val(),
				tOrder_buyerId: $("#buyerId").val(),
				tOrder_creartTime: $("#creartTime").val(),
				tOrder_payTime: $("#payTime").val(),
				tOrder_state: $("#state").val(),
				tOrder_address: $("#address").val(),
				tOrder_isSign: $("#isSign").val(),
				tOrder_isPay: $("#isPay").val(),
				tOrder_logisticsCode: $("#logisticsCode").val(),
			}
		});
	});
	$("#buyerId").bind('input propertychange', function () {
		table.reload('tOrderlist', {
			page: {
				curr: 1 //重新从第 1 页开始
			},
			where: {
				tOrder_id: $("#id").val(),
				tOrder_commodityId: $("#commodityId").val(),
				tOrder_pictureId: $("#pictureId").val(),
				tOrder_price: $("#price").val(),
				tOrder_num: $("#num").val(),
				tOrder_sellerId: $("#sellerId").val(),
				tOrder_buyerId: $("#buyerId").val(),
				tOrder_creartTime: $("#creartTime").val(),
				tOrder_payTime: $("#payTime").val(),
				tOrder_state: $("#state").val(),
				tOrder_address: $("#address").val(),
				tOrder_isSign: $("#isSign").val(),
				tOrder_isPay: $("#isPay").val(),
				tOrder_logisticsCode: $("#logisticsCode").val(),
			}
		});
	});
	$("#creartTime").bind('input propertychange', function () {
		table.reload('tOrderlist', {
			page: {
				curr: 1 //重新从第 1 页开始
			},
			where: {
				tOrder_id: $("#id").val(),
				tOrder_commodityId: $("#commodityId").val(),
				tOrder_pictureId: $("#pictureId").val(),
				tOrder_price: $("#price").val(),
				tOrder_num: $("#num").val(),
				tOrder_sellerId: $("#sellerId").val(),
				tOrder_buyerId: $("#buyerId").val(),
				tOrder_creartTime: $("#creartTime").val(),
				tOrder_payTime: $("#payTime").val(),
				tOrder_state: $("#state").val(),
				tOrder_address: $("#address").val(),
				tOrder_isSign: $("#isSign").val(),
				tOrder_isPay: $("#isPay").val(),
				tOrder_logisticsCode: $("#logisticsCode").val(),
			}
		});
	});
	$("#payTime").bind('input propertychange', function () {
		table.reload('tOrderlist', {
			page: {
				curr: 1 //重新从第 1 页开始
			},
			where: {
				tOrder_id: $("#id").val(),
				tOrder_commodityId: $("#commodityId").val(),
				tOrder_pictureId: $("#pictureId").val(),
				tOrder_price: $("#price").val(),
				tOrder_num: $("#num").val(),
				tOrder_sellerId: $("#sellerId").val(),
				tOrder_buyerId: $("#buyerId").val(),
				tOrder_creartTime: $("#creartTime").val(),
				tOrder_payTime: $("#payTime").val(),
				tOrder_state: $("#state").val(),
				tOrder_address: $("#address").val(),
				tOrder_isSign: $("#isSign").val(),
				tOrder_isPay: $("#isPay").val(),
				tOrder_logisticsCode: $("#logisticsCode").val(),
			}
		});
	});
	$("#state").bind('input propertychange', function () {
		table.reload('tOrderlist', {
			page: {
				curr: 1 //重新从第 1 页开始
			},
			where: {
				tOrder_id: $("#id").val(),
				tOrder_commodityId: $("#commodityId").val(),
				tOrder_pictureId: $("#pictureId").val(),
				tOrder_price: $("#price").val(),
				tOrder_num: $("#num").val(),
				tOrder_sellerId: $("#sellerId").val(),
				tOrder_buyerId: $("#buyerId").val(),
				tOrder_creartTime: $("#creartTime").val(),
				tOrder_payTime: $("#payTime").val(),
				tOrder_state: $("#state").val(),
				tOrder_address: $("#address").val(),
				tOrder_isSign: $("#isSign").val(),
				tOrder_isPay: $("#isPay").val(),
				tOrder_logisticsCode: $("#logisticsCode").val(),
			}
		});
	});
	$("#address").bind('input propertychange', function () {
		table.reload('tOrderlist', {
			page: {
				curr: 1 //重新从第 1 页开始
			},
			where: {
				tOrder_id: $("#id").val(),
				tOrder_commodityId: $("#commodityId").val(),
				tOrder_pictureId: $("#pictureId").val(),
				tOrder_price: $("#price").val(),
				tOrder_num: $("#num").val(),
				tOrder_sellerId: $("#sellerId").val(),
				tOrder_buyerId: $("#buyerId").val(),
				tOrder_creartTime: $("#creartTime").val(),
				tOrder_payTime: $("#payTime").val(),
				tOrder_state: $("#state").val(),
				tOrder_address: $("#address").val(),
				tOrder_isSign: $("#isSign").val(),
				tOrder_isPay: $("#isPay").val(),
				tOrder_logisticsCode: $("#logisticsCode").val(),
			}
		});
	});
	$("#isSign").bind('input propertychange', function () {
		table.reload('tOrderlist', {
			page: {
				curr: 1 //重新从第 1 页开始
			},
			where: {
				tOrder_id: $("#id").val(),
				tOrder_commodityId: $("#commodityId").val(),
				tOrder_pictureId: $("#pictureId").val(),
				tOrder_price: $("#price").val(),
				tOrder_num: $("#num").val(),
				tOrder_sellerId: $("#sellerId").val(),
				tOrder_buyerId: $("#buyerId").val(),
				tOrder_creartTime: $("#creartTime").val(),
				tOrder_payTime: $("#payTime").val(),
				tOrder_state: $("#state").val(),
				tOrder_address: $("#address").val(),
				tOrder_isSign: $("#isSign").val(),
				tOrder_isPay: $("#isPay").val(),
				tOrder_logisticsCode: $("#logisticsCode").val(),
			}
		});
	});
	$("#isPay").bind('input propertychange', function () {
		table.reload('tOrderlist', {
			page: {
				curr: 1 //重新从第 1 页开始
			},
			where: {
				tOrder_id: $("#id").val(),
				tOrder_commodityId: $("#commodityId").val(),
				tOrder_pictureId: $("#pictureId").val(),
				tOrder_price: $("#price").val(),
				tOrder_num: $("#num").val(),
				tOrder_sellerId: $("#sellerId").val(),
				tOrder_buyerId: $("#buyerId").val(),
				tOrder_creartTime: $("#creartTime").val(),
				tOrder_payTime: $("#payTime").val(),
				tOrder_state: $("#state").val(),
				tOrder_address: $("#address").val(),
				tOrder_isSign: $("#isSign").val(),
				tOrder_isPay: $("#isPay").val(),
				tOrder_logisticsCode: $("#logisticsCode").val(),
			}
		});
	});
	$("#logisticsCode").bind('input propertychange', function () {
		table.reload('tOrderlist', {
			page: {
				curr: 1 //重新从第 1 页开始
			},
			where: {
				tOrder_id: $("#id").val(),
				tOrder_commodityId: $("#commodityId").val(),
				tOrder_pictureId: $("#pictureId").val(),
				tOrder_price: $("#price").val(),
				tOrder_num: $("#num").val(),
				tOrder_sellerId: $("#sellerId").val(),
				tOrder_buyerId: $("#buyerId").val(),
				tOrder_creartTime: $("#creartTime").val(),
				tOrder_payTime: $("#payTime").val(),
				tOrder_state: $("#state").val(),
				tOrder_address: $("#address").val(),
				tOrder_isSign: $("#isSign").val(),
				tOrder_isPay: $("#isPay").val(),
				tOrder_logisticsCode: $("#logisticsCode").val(),
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
		table.reload('tOrderlist', {
			page: {
				curr: 1 //重新从第 1 页开始
			},
			where: {
				tOrder_id: '',
				tOrder_commodityId: '',
				tOrder_pictureId: '',
				tOrder_price: '',
				tOrder_num: '',
				tOrder_sellerId: '',
				tOrder_buyerId: '',
				tOrder_creartTime: '',
				tOrder_payTime: '',
				tOrder_state: '',
				tOrder_address: '',
				tOrder_isSign: '',
				tOrder_isPay: '',
				tOrder_logisticsCode: '',
			}
		});
	});


	//新增按钮
	$(document).on('click','#addTOrder',function(){
		layer.open({
			type: 2,
			skin: 'layui-layer-rim',
			title: '新增TOrder信息',
			btn: ['保存'],
			btnAlign: 'c',
			shadeClose: true,
			shade: true,
			maxmin: false,
			area: ['70%', '80%'],
			content: BASE_PATH+'/editTOrder.jsp',
			yes: function (layero, index) {
				var body = layui.layer.getChildFrame('body', layero); //得到iframe页的body内容

				//判断是否为空
				/*if(roomCode==""||roomFloor==""||roomType==""||roomState==""||roomPrix==""){
				layer.alert('请输入完整信息!');
				}
			else if(roomcodeExist==""){*/
				$.ajax({
					url:BASE_PATH+'/TOrder/addTOrder.do',
					type:'get',
					data: {
						tOrder_id:body.find("input#id").val(),
						tOrder_commodityId:body.find("input#commodityId").val(),
						tOrder_pictureId:body.find("input#pictureId").val(),
						tOrder_price:body.find("input#price").val(),
						tOrder_num:body.find("input#num").val(),
						tOrder_sellerId:body.find("input#sellerId").val(),
						tOrder_buyerId:body.find("input#buyerId").val(),
						tOrder_creartTime:body.find("input#creartTime").val(),
						tOrder_payTime:body.find("input#payTime").val(),
						tOrder_state:body.find("input#state").val(),
						tOrder_address:body.find("input#address").val(),
						tOrder_isSign:body.find("input#isSign").val(),
						tOrder_isPay:body.find("input#isPay").val(),
						tOrder_logisticsCode:body.find("input#logisticsCode").val(),
					},
					dataType:'json',
					error:function (res) {
						layer.alert('网络错误!');
					},
					success : function(layero, index){
						layer.alert('添加成功!',function(){
							layer.closeAll();
							table.reload('tOrderlist');
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