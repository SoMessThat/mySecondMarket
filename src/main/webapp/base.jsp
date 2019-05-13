<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
	String path2 = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort();
%>



<script src="<%=basePath%>/js/layui/layui.js" type="text/javascript"
	charset="utf-8"></script>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/js/layui/css/layui.css" />
<script> 
	layui.use(['jquery'], function(){
		var $ = jQuery = layui.$;
	});
	
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
    
	function createId() {
    	return (Math.random()*10000000).toString(16).substr(0,4)+'-'+(new Date()).getTime()+'-'+Math.random().toString().substr(2,5);
    }
</script>

<script>
var BASE_PATH = '<%=basePath%>';
</script>

