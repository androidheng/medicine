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
			
			<!-- page-title-area end -->
			<!-- breadcrumb-area start -->
			<div class="breadcrumb-area">
				<div class="container">
					<div class="row">
						<div class="col-md-12">
							<div class="breadcrumb-list">
								<ul>
									<li><a href="<%=basePath%>index.jsp">首页</a></li>
									<li><a href="<%=basePath%>shop.jsp">商品列表</a></li>
									<li><span>我的订单</span></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- breadcrumb-area end -->
			<!-- cart-main-area start -->
			<div class="cart-main-area">
				<div class="container">
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<form action="#">
								<div class="table-content table-responsive">
									<table>
										<thead>
											<tr>
												<th class="product-thumbnail">订单编号</th>
												<th class="product-name">下单时间</th>
												<th class="product-price">订单总金额</th>
												<th class="product-price">订单状态</th>
												<th class="product-quantity">收货人</th>
												<th class="product-subtotal">收货电话</th>
												<th class="product-subtotal">收货地址</th>
												<th class="product-subtotal">详情</th>
											</tr>
										</thead>
										<tbody>
											<tr v-for="(item,index) in paructList">
												
												<td class="product-name">{{item.orderno}}</td>
												<td class="product-name">{{item.ordertime}}</td>
												<td class="product-price"><span class="amount">￥{{item.orderamt}}</span></td>
												<td class="product-quantity">{{item.status}}</td>
												<td class="product-quantity">{{item.receiverman}}</td>
												
												
												<td class="product-quantity">{{item.reveiverphone}}</td>
												<td class="product-subtotal">￥{{item.reveiveraddress}}</td>
												<td class="product-remove" @click="showDetail(index)"><a style="color:blue;cursor:pointer;" >查看详情</a></td>
											</tr>
										</tbody>
									</table>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
			<!-- cart-main-area end -->
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
		<!-- main js -->
		<script src="<%=basePath%>js/public/public.js"></script>
		<script src="<%=basePath%>js/main.js"></script>
		<script src="https://cdn.bootcss.com/vue/2.6.10/vue.min.js"></script>
		<script>
			let vm = new Vue({
				el:"#wrappers",
				data(){
					return{
						paructList:[
							
						],
					}
				},
				mounted(){
				    //调用获取购物车数据的方法
				    this.getOrder();
				},
				methods:{
					//获取购物车数据
					getOrder(){
					   //发送请求获取购物车数据
					   //赋值 this.paructList = 返回数据
					   //this.getAllCash()
					     let self = this
						 $.ajax({
					          url:"<%=basePath%>order/myorder",
					          type:'post',//method请求方式，get或者post
					          dataType:'json',//预期服务器返回的数据类型
					          contentType: "application/json; charset=utf-8",
					         
					          success:function(res){//res为相应体,function为回调函数
					             self.paructList = res.data
					          },
					          error:function(){
					           alert('获取失败！！！');
					          }
					        });
					  
					},
					//查看详情
					showDetail(index){
						let id = this.paructList[index].id
						let orderstatus = this.paructList[index].orderstatus
						
						location.href = '<%=basePath%>orderdetail.jsp?id='+id+'&orderstatus='+orderstatus;
					},
					//我的订单
					goMyOrder(){
							
					}
					
				
				}
			})
		 </script>
    </body>
</html>
