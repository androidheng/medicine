	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%
	HttpSession se=request.getSession();
%>
	<header>
						<div class="header-top-area">
							<div class="container">
								<div class="row">
									<div class="col-md-6 col-sm-6">
										<div class="top-info">
											<p>联系我们 : (+86) 6 888 888</p>
										</div>
									</div>
									<div class="col-md-6 col-sm-6">
										<div class="top-nav">
											
										 <div class="account">
										 	<%
													if(se.getAttribute("user")==null){%>
													<span>|</span>
												
									            	<a class="login" href="<%=basePath%>login.jsp">登录</a>
												<span>|</span>
												<a class="register" href="<%=basePath%>login.jsp">注册</a>
													<% 
													}
												%>
												
												<%
													if(se.getAttribute("user")!=null){%>
													
													<a class="register" @click="loginOut" >退出登录</a>
													<span>|</span>
									            	<a @click="goMyOrder" class="register">我的订单</a>
													<% 
													}
												%>
												
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- header-bottom-area start -->
						<div id="sticker" class="header-bottom-area">
							<div class="container">
								<div class="inner-container">
									<div class="row">
										<div class="col-md-2 col-sm-4 col-xs-6">
											<div class="logo">
												<a href="<%=basePath%>index.jsp"><img src="img/logo.png" alt="" /></a>
											</div>
										</div>
										<div class="col-md-8 hidden-xs hidden-sm">
											
										</div>
										<div class="col-md-2 col-sm-8 col-xs-6 header-right">
											<div class="my-cart">
												<div class="total-cart">
													<a @click="myCar">
														<img src="img/cart/cart.png" alt="" />
														<span>3</span>
													</a>
												</div>
											
											</div>
			
									
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- header-bottom-area end -->
						
					</header>
					
						<script>
					    function myCar(){
					    	<%
							if(se.getAttribute("user")!=null){%>
							location.href = '<%=basePath%>cart.jsp';
							<% 
							}else{
						%>
							alert("请先登录");
							location.href = '<%=basePath%>login.jsp';
							<%}%>
					    }
					    function goMyOrder(){
					    	alert("");
					    	<%
							if(se.getAttribute("user")!=null){%>
							location.href = '<%=basePath%>myorder.jsp';
							<% 
							}else{
						%>
							alert("请先登录");
							location.href = '<%=basePath%>login.jsp';
							<%}%>
					    }
					    function loginOut(){
					    	$.ajax({
								 url:'<%=basePath%>user/loginOut',
								 type:'post',//method请求方式，get或者post
								 dataType:'json',//预期服务器返回的数据类型
								 data:JSON.stringify(parames),//表格数据序列化
								 contentType: "application/json; charset=utf-8",
								 success:function(res){//res为相应体,function为回调函数
									    if(res.success){
									    	alert(res.message);
									    	location.href = '<%=basePath%>login.jsp';
									    }
								},
								error:function(){
									           
								}
							});
					    }
				
			 </script>