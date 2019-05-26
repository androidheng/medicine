<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common.jsp" %>
<!DOCTYPE html>
<html>
<head>
      <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Home One || Richman</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="shortcut icon" type="<%=basePath%>image/x-icon" href="img/favicon.ico">
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
		<!-- slick slider css -->
		<link rel="stylesheet" href="<%=basePath%>css/slick.css">
		<!-- font-awesome css -->
        <link rel="stylesheet" href="<%=basePath%>css/font-awesome.min.css">
		<!-- style css -->
		<link rel="stylesheet" href="<%=basePath%>css/style.css">
		<!-- responsive css -->
        <link rel="stylesheet" href="<%=basePath%>css/responsive.css">
		<!-- modernizr js -->
        <script src="<%=basePath%>js/vendor/modernizr-2.8.3.min.js"></script>
</head>
 <body>
        <!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->

        <!-- Add your site or application content here -->

		<!-- header start -->
		<div id="wrappers">
            	<%@ include file="commonheader.jsp" %>
				<!-- header end -->
				<!-- page-title-area start -->
				<div class="page-title-area">
					<div class="container">
						<div class="row">
							<div class="col-md-12">
								<div class="title-heading text-center">
									<h1>我的结算页面</h1>
									<p>我们是一个自称时尚的特色品牌</p>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- page-title-area end -->
				<!-- breadcrumb-area start -->
				<div class="breadcrumb-area">
					<div class="container">
						<div class="row">
							<div class="col-md-12">
								<div class="breadcrumb-list">
									<ul>
										<li><a href="<%=basePath %>index.jsp">首页</a></li>
										<li><a href="<%=basePath %>shop.jsp">商品</a></li>
										<li><a href="<%=basePath %>cart.jsp">购物车</a></li>
										<li><span>结算</span></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- breadcrumb-area end -->
			
				<!-- checkout-area start -->
				<div class="checkout-area">
					<div class="container">
						<div class="row">
							<form action="#">
								<div class="col-lg-12 col-md-12">
									<div class="checkbox-form">
										<h3>请填写地址</h3>
										<div class="row">
										
											<div class="col-md-12">
												<div class="checkout-form-list">
													<label>姓名 <span class="required">*</span></label>
													<input type="text" placeholder="" v-model="receiverman"/>
												</div>
											</div>
											<div class="col-md-12">
												<div class="checkout-form-list">
														<label>联系电话 <span class="required">*</span></label>
														<input type="text" placeholder="Postcode / Zip" v-model="reveiverphone"/>
												</div>
											</div>
											
											<div class="col-md-12">
												<div class="checkout-form-list">
													<label>详细地址<span class="required">*</span></label>
													<input type="text" placeholder=""  v-model="reveiveraddress"  />
												</div>
											</div>
										</div>
									</div>
									<div class="wc-proceed-to-checkout" @click='creatOrder'>
										<a  style="float: right;">创建订单</a>
									</div>
								</div>
								
							</form>
						</div>
					</div>
				</div>
				<!-- checkout-area end -->
		</div>
	

		

		<!-- all js here -->
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
		<script src="<%=basePath%>js/public/public.js"></script>
		<!-- main js -->
		<script src="<%=basePath%>js/main.js"></script>
		<script src="<%=basePath%>js/public/public.js"></script>
		<script src="https://cdn.bootcss.com/vue/2.6.10/vue.min.js"></script>
		<script>
				let vm = new Vue({
					el:"#wrappers",
					data(){
						return{
							receiverman:'',
							reveiveraddress:'',
							reveiverphone:''
						}
					},
					mounted(){
						
					},
					methods:{
						
						//创建订单
						creatOrder(){
							if(!this.receiverman||!this.reveiveraddress||!this.reveiverphone) return alert('请完善信息！')
							let parames = {
									receiverman:this.receiverman,
									reveiveraddress:this.reveiveraddress,
									reveiverphone:this.reveiverphone
							}
							console.log(parames)
							 $.ajax({
						          url:"<%=basePath%>order/add",
						          type:'post',//method请求方式，get或者post
						          dataType:'json',//预期服务器返回的数据类型
						          contentType: "application/json; charset=utf-8",
						          data:JSON.stringify(parames),
						          success:function(res){//res为相应体,function为回调函数
						            if(res.success){
						            	alert(res.message);
						            }else{
						              alert(res.message);
						            }
						          },
						          error:function(){
						           alert('操作失败！！！');
						          }
						        });
						},
						//我的订单
				     	goMyOrder(){
							location.href = this.isLogin?'myOrder.html':'login.html'
						}
					}
				})
			 </script>
    </body>
</html>