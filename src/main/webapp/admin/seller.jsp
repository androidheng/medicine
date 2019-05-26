<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ include file="../common.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="<%=basePath%>assets/css/layui.css">
    <link rel="stylesheet" href="<%=basePath%>assets/css/view.css"/>
    <link rel="icon" href="/favicon.ico">
    <title>管理后台</title>
</head>
<body class="layui-view-body">
     <div class="layui-content" id="box" style="display:none">
        <div class="layui-row">
         <div class="layui-card">
           <table class="layui-hide" id="orderDetail" lay-filter="user"></table> 
       </div>
     </div>
     </div>
    <div class="layui-content">
        <div class="layui-page-header">
            <div class="pagewrap">
                <span class="layui-breadcrumb">
                  <a>首页</a>
                  <a>商家信息</a>
                </span>
                <h2 class="title">商家信息</h2>
            </div>
        </div>
        <div class="layui-row">
            <div class="layui-card">
                <div class="layui-card-body">
                    <div class="form-box">
                        <div class="layui-form layui-form-item" style="margin-top:10px;">
                            <div class="layui-inline">
                                <div class="layui-form-mid">商家名称:</div>
                                <div class="layui-inline">
                                    <input class="layui-input" name="key" id="demoReload" autocomplete="off">
                                </div>
                                <button class="layui-btn search"  data-type="reload">查询</button>
                                <button class="layui-btn layui-btn-primary">重置</button>
                            </div>
                        </div>
                        <table class="layui-hide" id="LAY_table_user" lay-filter="user"></table> 
                    </div>
                </div>
            </div>
        </div>
    </div>
   </div>
    <script src="https://heerey525.github.io/layui-v2.4.3/layui-v2.4.5/layui.js"></script>
    <script type="text/html" id="barDemo">
      <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="applyNo">审核不通过</a>
      <a class="layui-btn layui-btn-info layui-btn-xs" lay-event="applyYes">审核通过</a>
    </script>
    <script>
  layui.use('table', function(){
     var table = layui.table,form = layui.form,$=layui.$;
       //方法级渲染
     table.render({
        elem: '#LAY_table_user'
        ,url:'<%=basePath%>seller/searchno'  //数据请求地址
       ,cols: [[
            ,{field: 'username', title: '用户名',align:'center'}
            ,{field: 'shopname', title: '商家名称',align:'center'}
            ,{field: 'shopaddress', title: '商家地址',align:'center'}
            ,{fixed: 'right', title:'操作', toolbar: '#barDemo',align:'center'}
        ]]
        ,id: 'testReload'
        ,page: true
        ,height: 315
        ,skin: 'line' //表格风格
        ,even: true
        ,limits: [5, 7, 10]
        ,limit: 5 //每页默认显示的数量
      });
     var active = {
       reload: function(){
        var demoReload = $('#demoReload');
        //执行重载
        table.reload('testReload', {
          page: {
            curr: 1 //重新从第 1 页开始
          }
         ,where: {
             key: { shopname: demoReload.val() } //筛选参数
          }
        });
      }
    };
  
     $('.search').on('click', function(){
       var type = $(this).data('type');
         active[type] ? active[type].call(this) : '';
     });
      //监听工具条
     table.on('tool(user)', function(obj){
        var data = obj.data;
        console.log(data)
        if(obj.event === 'applyYes'){
        	   $.ajax({
        	          url:"<%=basePath%>seller/audit",
        	          type:'post',//method请求方式，get或者post
        	          dataType:'json',//预期服务器返回的数据类型
        	          data:JSON.stringify({id:data.id}),//表格数据序列化
        	          contentType: "application/json; charset=utf-8",
        	          success:function(res){//res为相应体,function为回调函数
        	            if(res.success){
        	              layer.alert(res.message,{icon:1});
        	              //location.href="<%=basePath%>seller/index.jsp";
        	              //$("#res").click();//调用重置按钮将表单数据清空
        	              
        	            }else{
        	              layer.alert(res.message,{icon: 5});
        	            }
        	          },
        	          error:function(){
        	            layer.alert('操作失败！！！',{icon:5});
        	          }
        	        });
        }
        else{
        	  $.ajax({
    	          url:"<%=basePath%>seller/noaudit",
    	          type:'post',//method请求方式，get或者post
    	          dataType:'json',//预期服务器返回的数据类型
    	          data:JSON.stringify({id:data.id}),//表格数据序列化
    	          contentType: "application/json; charset=utf-8",
    	          success:function(res){//res为相应体,function为回调函数
    	            if(res.success){
    	              layer.alert(res.message,{icon:1});
    	              //location.href="<%=basePath%>seller/index.jsp";
    	              //$("#res").click();//调用重置按钮将表单数据清空
    	              
    	            }else{
    	              layer.alert(res.message,{icon: 5});
    	            }
    	          },
    	          error:function(){
    	            layer.alert('操作失败！！！',{icon:5});
    	          }
    	        });
          
         
        }
     });
     
});
</script>
</body>
</html>