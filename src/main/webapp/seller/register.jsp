<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../common.jsp" %>
<!DOCTYPE html >
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="<%=basePath%>assets/css/layui.css">
    <link rel="stylesheet" href="<%=basePath%>assets/css/login.css">
    <link rel="icon" href="/favicon.ico">
    <title>管理后台</title>
<title>Insert title here</title>
</head>
<body class="login-wrap">
	 
    <div class="login-container">
    	
        <form class="login-form layui-form"  action="" >
            <h3 style="width:100%;text-align:center">商家注册申请</h3>
            <div class="layui-form-item">
                <div class="input-group">
                    <input type="text" id="username" name="username" lay-verify="username" class="input-field">
                    <label for="username" class="input-label">
                        <span class="label-title">用户名</span>
                    </label>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="input-group">
                    <input type="text" id="shopname" name="shopname" lay-verify="shopname" class="input-field">
                    <label for="username" class="input-label">
                        <span class="label-title">店铺名称</span>
                    </label>
                </div>
            </div>
               <div class="layui-form-item">
                <div class="input-group">
                    <input type="text" id="shopaddress" name="shopaddress" lay-verify="shopaddress" class="input-field">
                    <label for="username" class="input-label">
                        <span class="label-title">店铺地址</span>
                    </label>
                </div>
            </div>
            <div class="input-group">
                <input type="password" name="password"  id="password" lay-verify="password" class="input-field">
                <label for="password" class="input-label">
                    <span class="label-title">密码</span>
                </label>
            </div>
            <button type="button" class="login-button" lay-submit="" lay-filter="login">确定申请<i class="ai ai-enter"></i></button>
        </form>
    </div>
</body>
<script src="<%=basePath%>assets/layui.js"></script>
<script src="<%=basePath%>js/login.js"></script>
<script>
    layui.use(['form'], function(){
      var form = layui.form
      ,layer = layui.layer
      //自定义验证规则
      form.verify({
        username: function(value){
          if(value.length < 5){
            return '用户名至少得5个字符啊';
          }
        }
        ,password: [
          /^[\S]{6,12}$/
          ,'密码必须6到12位，且不能出现空格'
        ]
      });
      //监听提交
      form.on('submit(login)', function(data){
        console.log(data)
       // location.href = 'index.html'
        var param=data.field;
       /*  layer.alert(JSON.stringify(data.field), {
          title: '最终的提交信息'
        }) */
         $.ajax({
          url:"<%=basePath%>seller/add",
          type:'post',//method请求方式，get或者post
          dataType:'json',//预期服务器返回的数据类型
          data:JSON.stringify(param),//表格数据序列化
          contentType: "application/json; charset=utf-8",
          success:function(res){//res为相应体,function为回调函数
            if(res.success){
              layer.alert(res.message,{icon:1});
            }else{
              layer.alert(res.message,{icon: 5});
            }
          },
          error:function(){
            layer.alert('操作失败！！！',{icon:5});
          }
        });
      //  return true;
      });
     });
    </script>
</html>