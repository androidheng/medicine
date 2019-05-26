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
					
					<!-- breadcrumb-area start -->
					<div class="breadcrumb-area">
						<div class="container">
							<div class="row">
								<div class="col-md-12">
									<div class="breadcrumb-list">
										<ul>
											<li><a href="<%=basePath%>index.jsp">首页</a></li>
											<li><a href="<%=basePath%>shop.jsp">购物中心</a></li>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- breadcrumb-area end -->
					<!-- shop-area start -->
					<div class="shop-area">
						<div class="container">
							<div class="row">
							
								<!-- left-sidebar end -->
								<div class="col-md-12 col-sm-12 col-xs-12">
									<div class="shop-content">
						
										<div class="clear"></div>
										<!-- Tab panes -->
										<div class="tab-content">
											<div role="tabpanel" class="tab-pane active" id="home">
												<div class="row">
													<!-- single-product start -->
													<div class="col-md-4 col-sm-4" v-for="(item,index) in paructList" @click="goShopDetail(index)">
														<div class="single-product">
															<div class="product-img">
																<a >
																	<img :src="item.logo" alt="" />
						
																</a>
															</div>
															<div class="product-content">
																<h3><a >{{item.shopname}}</a></h3>
																<div class="price">
																	<span>￥{{item.price}}</span>
										
																</div>
															</div>
														</div>
													</div>
													<!-- single-product end -->
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
		</div>
       
		<!-- shop-area end -->
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
		<script src="<%=basePath%>js/main.js"></script>
		<script src="<%=basePath%>js/public/public.js"></script>
		<script src="https://cdn.bootcss.com/vue/2.6.10/vue.min.js"></script>
		<script>
		   let vm = new Vue({
			   el:"#wrappers",
			   data(){
				   return{
					   paructList:[]
				   }
			   },
			   mounted(){
                  //调用获取商品的方法
				  this.getShops()
			   },
			   methods:{
				   //获取商品数据
				   getShops(){
                      //发送请求获取商品数据
					  //赋值 this.paructList = 返回数据
					  let self = this
					   $.ajax({
					          url:"<%=basePath%>shop/sellerShop",
					          type:'post',//method请求方式，get或者post
					          dataType:'json',//预期服务器返回的数据类型
					          data:JSON.stringify({sellerid:2}),//表格数据序列化
					          contentType: "application/json; charset=utf-8",
					          success:function(res){//res为相应体,function为回调函数
					        	  self.paructList = res
					          },
					          error:function(){
					           
					          }
					        });
                     
				   },
				   //跳转商品详情
				   goShopDetail(index){
					   let id = this.paructList[index].id;
					   //location.href = '<%=basePath%>product-details.jsp?id='+id;
					   location.href = '<%=basePath%>shop/detail?id='+id;
				   },
				   //我的订单
				   goMyOrder(){
					   location.href = '<%=basePath%>myorder.jsp';
				   },
				   //我的购物车
			   }
		   })
		</script>
    </body>
</html>