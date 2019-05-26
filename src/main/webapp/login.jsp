<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="common.jsp" %>
<!DOCTYPE html >
<html>
 <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Login || Richman</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico">
        <!-- Place favicon.ico in the root directory -->


		<!-- all css here -->
		<!-- bootstrap v3.3.6 css -->
        <link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css">
		<!-- animate css -->
        <link rel="stylesheet" href="<%=basePath%>css/animate.css">
		<!-- jquery-ui.min css -->
        <link rel="stylesheet" href="<%=basePath%>css/jquery-ui.min.css">
		<!-- meanmenu css -->
        <link rel="stylesheet" href="<%=basePath%>css/meanmenu.min.css">
		<!-- owl.carousel css -->
        <link rel="stylesheet" href="<%=basePath%>css/owl.carousel.css">
		<!-- font-awesome css -->
        <link rel="stylesheet" href="<%=basePath%>css/font-awesome.min.css">
		<!-- style css -->
		<link rel="stylesheet" href="<%=basePath%>css/style.css">
		<!-- responsive css -->
        <link rel="stylesheet" href="<%=basePath%>css/responsive.css">
		<!-- modernizr js -->
		<script src="<%=basePath%>js/public/public.js"></script>
        <script src="<%=basePath%>js/vendor/modernizr-2.8.3.min.js"></script>
    </head>
    <body>
        <div id="wrappers">
				 <%@ include file="commonheader.jsp" %>
					<!-- header end -->
					
				
					<!-- login-area start -->
					<div class="login-area">
						<div class="container">
							<div class="row">
								<div class="col-md-6">
									<div class="login-content">
										<h2 class="login-title">登录</h2>
										<p>欢迎您的到来</p>
										
										<form action="#">
											<label>用户名</label>
											<input type="text" v-model="userName"/>
											<label>密码</label>
											<input type="password" v-model="password"/>
											<input @click="loginOrregiser(0)" class="login-sub" type="button" value="登录" />
										</form>
									</div>
								</div>
								<div class="col-md-6">
									<div class="login-content login-margin">
										<h2 class="login-title">创建一个新账号</h2>
										<p>创建账号.</p>
										<form action="#">
											<label>用户名</label>
											<input type="text" v-model="registerName" />
											<label>密码</label>
											<input type="password" v-model="registerWord"/>
											<input class="login-sub" @click="loginOrregiser(1)" type="button" value="注册" />
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
		</div>
        
	
		<!-- jquery latest version -->
        <script src="<%=basePath%>js/vendor/jquery-1.12.0.min.js"></script>
		<!-- bootstrap js -->
        <script src="<%=basePath%>js/bootstrap.min.js"></script>
		<!-- owl.carousel js -->
        <script src="<%=basePath%>js/owl.carousel.min.js"></script>
		<!-- meanmenu js -->
        <script src="<%=basePath%>js/jquery.meanmenu.js"></script>
		<!-- jquery-ui js -->
        <script src="<%=basePath%>js/jquery-ui.min.js"></script>
		<!-- wow js -->
        <script src="<%=basePath%>js/wow.min.js"></script>
		<!-- plugins js -->
        <script src="<%=basePath%>js/plugins.js"></script>
		<!-- main js -->
		<script src="<%=basePath%>js/main.js"></script>
		<script src="https://cdn.bootcss.com/vue/2.6.10/vue.min.js"></script>
		<script>
		       let vm = new Vue({
					el:"#wrappers",
					data(){
						return{
							userName:'',
							password:'',
							registerName:'',
							registerWord:''
						}
					},
					mounted(){
					  
					},
					methods:{
						//登录或注册
						loginOrregiser(type){
						    let url = type==0?'<%=basePath%>user/login':'<%=basePath%>user/register'
							let self = this
							let parames = {
							     username :type==0?this.userName:this.registerName,
							     password :type==0?this.password:this.registerWord,
							}
							$.ajax({
								 url:url,
								 type:'post',//method请求方式，get或者post
								 dataType:'json',//预期服务器返回的数据类型
								 data:JSON.stringify(parames),//表格数据序列化
								 contentType: "application/json; charset=utf-8",
								 success:function(res){//res为相应体,function为回调函数
									  if(res.success){
										  alert(res.message);
									    	location.href = '<%=basePath%>index.jsp';
									  }    	
								},
								error:function(){
									           
								}
							});
						}
					      
					  }
				})
			 </script>
    </body>
</html>