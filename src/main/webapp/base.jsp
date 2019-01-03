<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
	Long nettime=null;
%>



<script src="<%=basePath%>/js/layui/layui.js" type="text/javascript"
	charset="utf-8"></script>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/js/layui/css/layui.css" />
<script> 
	layui.use(['jquery'], function(){
		var $ = jQuery = layui.$;
	});
	
	//获取当前网络时间
	function webTime(){
		var xhr = null;
		if(window.XMLHttpRequest){
			xhr = new window.XMLHttpRequest();
		}else{ // ie
			xhr = new ActiveObject("Microsoft")
		}
		// 通过get的方式请求当前文件
		xhr.open("get","/SecondMarket/base.jsp");
		xhr.send(null);
		// 监听请求状态变化
		return xhr.onreadystatechange = function(){
			var time = null,
			curDate = null;
			if(xhr.readyState===2){
				nettime=null;
				// 获取响应头里的时间戳
				time = xhr.getResponseHeader("Date");
				console.log(xhr.getAllResponseHeaders());
				curDate = new Date(time);
				nettime=(curDate.getFullYear()+"-"+(curDate.getMonth()+1)+"-"+curDate.getDate()+" "+curDate.getHours()+":"+curDate.getMinutes()+":"+curDate.getSeconds());	
				return nettime;
			}
			
		}
	}
	
	//时间戳->时间
	function timestampToTime(timestamp) {
 	        var date = new Date(timestamp * 1000);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
 	        var Y = date.getFullYear() + '-';
 	        var M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
 	        var D = date.getDate() + ' ';
 	        var h = date.getHours() + ':';
 	        var m = date.getMinutes() + ':';
 	        var s = date.getSeconds();
 	        return Y+M+D+h+m+s;
 	    }
	
	  Date.prototype.format = function(format)
	  {
	  	 var o = {
	  	 "M+" : this.getMonth()+1, //month
	  	 "d+" : this.getDate(),    //day
	  	 "h+" : this.getHours(),   //hour
	  	 "m+" : this.getMinutes(), //minute
	  	 "s+" : this.getSeconds(), 
	  	 "q+" : Math.floor((this.getMonth()+3)/3),  //quarter
	  	 "S" : this.getMilliseconds() //millisecond
	  	 }
	  	 if(/(y+)/.test(format)) format=format.replace(RegExp.$1,
	  	 (this.getFullYear()+"").substr(4 - RegExp.$1.length));
	  	 for(var k in o)if(new RegExp("("+ k +")").test(format))
	  	 format = format.replace(RegExp.$1,
	  	 RegExp.$1.length==1 ? o[k] :
	  	 ("00"+ o[k]).substr((""+ o[k]).length));
	  	 return format;
	  }
	  

	//时间->时间戳
	  function timetrans(date){
	      var date = new Date(date*1000);//如果date为13位不需要乘1000
	      var Y = date.getFullYear() + '-';
	      var M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
	      var D = (date.getDate() < 10 ? '0' + (date.getDate()) : date.getDate()) + ' ';
	      var h = (date.getHours() < 10 ? '0' + date.getHours() : date.getHours()) + ':';
	      var m = (date.getMinutes() <10 ? '0' + date.getMinutes() : date.getMinutes()) + ':';
	      var s = (date.getSeconds() <10 ? '0' + date.getSeconds() : date.getSeconds());
	      return Y+M
	  }
	
	//---下拉框数据适配
	//---参数
	//------type:字典类型
	//------name:控件名字
	//------form:form
	//------$:$
	//---列如
	//------adapt("roomFloor","#roomfloor",form,$);
	var adapt = function(type,name,form,$){
		$.ajax({
			url: BASE_PATH+'/dict/querySelect.php',
			type: "GET",
			data:{
				dictType:type
			},
			dataType: "json",
			success: function(data){
				for(var i=0;i<data.data.length;i++){
					$(name).append("<option value=\""+data.data[i].dictCode+"\">"+data.data[i].dictValue+"</option>"); 
				}
				form.render();
			}
		});
	}
	
	//---验证手机号的格式是否正确
	//---参数
	//------name:控件名字
	//------form:form
	//------$:$
	function check_tel(name,form,$){
		//获得电话
		  var tel=$.trim($(name).val());
		//判断手机号的格式
		if(!/^1[3458]\d{9}$/.test(tel)){
		    alert('手机号码格式不正确');
		    return false;
		}
		else
		{
			return true;
		}
		
    }
	
	//---验证身份证号的格式是否正确
	//---参数
	//------name:控件名字
	//------form:form
	//------$:$
	function check_idno(name,form,$){
		//获得身份证号
		  var idno=$.trim($(name).val());
		//判断身份证号的格式
		if(!/^\d{6}(18|19|20)?\d{2}(0[1-9]|1[012])(0[1-9]|[12]\d|3[01])\d{3}(\d|X)$/i.test(idno)){
		    alert('身份证号格式不正确');
		    return false;
		}
		else
		{
			return true;
		}
		
    }
</script>

<script>
var BASE_PATH = '<%=basePath%>';
nettime=webTime();
</script>

