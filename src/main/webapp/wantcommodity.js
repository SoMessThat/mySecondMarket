/*var success=0;
var fail=0;
var imgurls="";
layui.use('form', function(){
	var form = layui.form,
	$ = layui.$;
	var imgsName="";
	layui.use(['upload','layer'],function() {
		var upload = layui.upload;
		var layer=layui.layer;
 
		upload.render({
		    elem: '#test2'
		    ,url: BASE_PATH+'/TCommodity/upload.do'
		    ,multiple: true
		    ,before: function(obj){
		      //预读本地文件示例，不支持ie8
		      obj.preview(function(index, file, result){
		        $('#demo2').append('<img src="'+ result +'" alt="'+ file.name +'" class="layui-upload-img">');
		      });
		    }
		    ,done: function(res){
		    	$('#images').val($('#images').val()+res.data.name+';');
		    }
		  });
	});
});
*/