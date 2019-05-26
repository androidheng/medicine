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
		<div id=wrappers>

				<%@ include file="commonheader.jsp" %>
					<!-- header end -->
			
					<!-- slider-area start -->
					<div class="slider-area">
						<div class="slider-active">
							<div class="single-slider slide-height d-flex align-items-center" data-background="<%=basePath%>img/slider/slide3.jpg">
								<div class="container">
									<div class="row">
										<div class="col-lg-7">
											<div class="slide-content slide-white">
												<h1 data-animation="fadeInUp" data-delay=".5s">给您最好的购物体验</h1>
												
												<a class="btn btn-white" href="shop.jsp" data-animation="fadeInUp" data-delay="1.5s">立即购买</a>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="single-slider slide-height d-flex align-items-center" data-background="<%=basePath%>img/slider/slide2.jpg">
								<div class="container">
									<div class="row">
										<div class="col-lg-8 col-lg-offset-2">
											<div class="slide-content slide-white text-center">
												<h1 data-animation="fadeInUp" data-delay=".5s">给您最好的购物体验</h1>
												<a class="btn btn-white" href="shop.html" data-animation="fadeInUp" data-delay="1.5s">立即购买</a>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="single-slider slide-height d-flex align-items-center" data-background="<%=basePath%>img/slider/slide1.jpg">
								<div class="container">
									<div class="row">
										<div class="col-lg-7">
											<div class="slide-content slide-white">
												<h1 data-animation="fadeInUp" data-delay=".5s">给您最好的购物体验</h1>
												<a class="btn btn-white" href="shop.html" data-animation="fadeInUp" data-delay="1.5s">立即购买</a>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- slider-area end -->
					
				
					<!-- category-area start -->
					<div class="category-area pad-60">
						<div class="container">
							<div class="row">
								<div class="col-md-12">
									<div class="section-title text-center">
										<h2>热门商品</h2>
										<img src="<%=basePath%>img/section-title.png" alt="" />
									</div>
								</div>
							</div>
							<div class="row">
								
									<div class="col-md-12" v-for="(item,index) in hotPructList" @click="goShopDetail(index)">
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
       
		<!-- category-area end -->
	<!-- all js here -->
		<!-- jquery latest version -->
        <script src="<%=basePath%>js/vendor/jquery-1.12.0.min.js"></script>
		<!-- bootstrap js -->
        <script src="<%=basePath%>js/bootstrap.min.js"></script>
		<!-- owl.carousel js -->
       
		<!-- meanmenu js -->
        <script src="<%=basePath%>js/jquery.meanmenu.js"></script>
		<!-- jquery-ui js -->
        <script src="<%=basePath%>js/jquery-ui.min.js"></script>
		<!-- wow js -->
        <script src="<%=basePath%>js/wow.min.js"></script>
		<!-- plugins js -->
        <script src="<%=basePath%>js/plugins.js"></script>
		<!-- main js -->
		
		<script src="https://cdn.bootcss.com/vue/2.6.10/vue.min.js"></script>
		<script>
		   let vm = new Vue({
			   el:'#wrappers',
			   data(){
				   return {
                      hotPructList:[]
				   }
			   },
			   mounted(){
				  this.getHotProduct()
			   },	
			   methods:{
                   //获取人民推荐商品
				   getHotProduct(){
                	   let self = this
					 //发送请求
					 //以下写在请求成功回调函数里面
					   $.ajax({
				          url:"<%=basePath%>shop/hotShop",
				          type:'post',//method请求方式，get或者post
				          dataType:'json',//预期服务器返回的数据类型
				          contentType: "application/json; charset=utf-8",
				          success:function(res){//res为相应体,function为回调函数
				        	  self.hotPructList = res
				        	 /* self.$nextTick(function () {
				        		  
			                     })
				        	  console.log(res);*/
				          },
				          error:function(){
				           
				          }
				        });
					
				   },
				   goShopDetail(idx){
					   let id = this.hotPructList[idx].id;
					   console.log(id)
					   location.href = '<%=basePath%>shop/detail?id='+id
				   }
			   }
		   })
		</script>
		 <script src="<%=basePath%>js/owl.carousel.min.js"></script>
		 <script src="<%=basePath%>js/main.js"></script>
    </body>
</html>