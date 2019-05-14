layui.use(['layer', 'table','element','form','laydate'], function(){
  	var layer = layui.layer, 
	table = layui.table, 
	element = layui.element, 
	laydate = layui.laydate,
	laypage=layui.laypage,
	form = layui.form,
	$ = layui.$;

  	$.ajax({
		url:BASE_PATH+'/TUser/findTUserById.do',
		type:'get',
		dataType:'json',
		error:function (res) {
			layer.alert(res.errors);
		},
		success:function (res) {
			form.val("form", {
				"id":res.data.id,
				"qq":res.data.qq,
				  "account": res.data.account,
				  "username":  res.data.username,
				  "email": res.data.userEmail,
				  "sex":res.data.sex,
				  "sex1":res.data.sex,
				  "school": res.data.school,
				  "phone":  res.data.tel,
				  "alipay": res.data.alipay,
				  "wechat":  res.data.wechat,
				  "address":  res.data.address,
				  "creattime":new Date(res.data.creatTime*1000).format("yyyy-MM-dd hh:mm:ss"),
				  "lasttime":new Date(res.data.lastTime*1000).format("yyyy-MM-dd hh:mm:ss"),
				});
			form.render(); 
			$('#img1').attr("src",res.data.avatar);
			$('#img').attr("src",res.data.avatar);
		}
	});
  	
  	$("#modify").click(function(){
		$('#form1').prop("hidden",true);
		$('#form2').prop("hidden",false);
	});
  	
  	$("#submit").click(function(){
  		$.ajax({
  			url:BASE_PATH+'/TUser/updateTUserById.do',
  			type:'get',
  			dataType:'json',
  			data:{
  				tUser_id:$('#id').val(),
  				tUser_username:$('#username').val(),
  				tUser_userEmail:$('#email').val(),
  				tUser_tel:$('#phone').val(),
  				tUser_sex:$('#sex input[name="sex1"]:checked').val(),
  				tUser_school:$('#school').val(),
  				tUser_address:$('#address').val(),
  				tUser_qq:$('#qq').val(),
  				tUser_wechat:$('#wechat').val(),
  				tUser_alipay:$('#alipay').val(),
  				tUser_avatar:$('#img1').attr("src")
  			},
  			error:function (res) {
  			},
  			success:function (res) {
  				$.ajax({
  					url:BASE_PATH+'/TUser/findTUserById.do',
  					type:'get',
  					dataType:'json',
  					error:function (res) {
  						layer.alert(res.errors);
  					},
  					success:function (res) {
  						form.val("form", {
  							"id":res.data.id,
  							"qq":res.data.qq,
  							  "account": res.data.account,
  							  "username":  res.data.username,
  							  "email": res.data.userEmail,
  							  "sex":res.data.sex,
  							  "sex1":res.data.sex,
  							  "school": res.data.school,
  							  "phone":  res.data.tel,
  							  "alipay": res.data.alipay,
  							  "wechat":  res.data.wechat,
  							  "address":  res.data.address,
  							  "creattime":new Date(res.data.creatTime*1000).format("yyyy-MM-dd hh:mm:ss"),
  							  "lasttime":new Date(res.data.lastTime*1000).format("yyyy-MM-dd hh:mm:ss"),
  							});
  						form.render(); 
  						$('#img1').attr("src",res.data.avatar);
  						$('#img').attr("src",res.data.avatar);
  					}
  				});
  				$('#form2').prop("hidden",true);
  				$('#form1').prop("hidden",false);
  			}
  		});
	});
  	
  	layui.use(['upload','layer'],function() {
		var upload = layui.upload;
		var layer=layui.layer;
 
		upload.render({
		    elem: '#img1'
		    ,url: BASE_PATH+'/TUser/upload.do'
		    ,multiple: false
		    ,done: function(res){
		    	$('#img1').attr("src",res.data.avatar);
		    }
		  });
	});
});