<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common.jsp" %>
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
         <div id="wrappers">
            <%@ include file="../commonheader.jsp" %>
			
			</header>
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
									<li><a href="<%=basePath %>index.jsp">首页</a></li>
									<li><a href="<%=basePath %>shop.jsp">商品</a></li>
									<li><span>商品详情</span></li>
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
						<div class="col-md-9">
							<div class="row">
								<div class="col-md-5 col-sm-5 col-xs-12">
									<div class="single-pro-tab-content">
										<!-- Tab panes -->
										<div class="tab-content">
											<div role="tabpanel" class="tab-pane active" id="home"><a href="#"><img class="zoom" src="${shop.logo}" data-zoom-image="img/product/15.jpg" alt="" /></a></div>
											</div>
										
									</div>
								</div>
								<div class="col-md-7 col-sm-7 col-xs-12 shop-list shop-details">
									<div class="product-content">
										<h3><a href="product-details.html">${shop.shopname}</a></h3>
										<div class="price">
											<span>￥${shop.price}</span>
										</div>
										<p>库存：${shop.store}</p>
														
										<!--  <div class="pro-size">
											<label>尺寸 <span>*</span></label>
											<select>
												<option value="1">Default</option>
												<option value="1">small</option>
												<option value="1">Medium</option>
												<option value="1">Large</option>
												<option value="1">extra large</option>
											</select>
										</div>
										<div class="pro-size">
											<label>颜色 <span>*</span></label>
											<select>
												<option value="1">Black</option>
												<option value="1">White</option>
												<option value="1">Red</option>
												<option value="1">Yellow</option>
												<option value="1">Pink</option>
											</select>
										</div>-->
										<div class="product-action">
											<div class="cart-plus">
												<form action="#">
													<input type="number" min=1 :max="${shop.store }" v-model="shopcount" />
												</form>
											</div>
											
											<div class="button-cart">
												<button @click="addCar"><i class="fa fa-shopping-cart"></i> 添加到购物车</button>
											</div>
										</div>
									
									</div>
								</div>
							</div>
							<div class="row">
							
								<div class="col-md-12 col-sm-12">
									<div class="product-tabs">
											<div>
											  <!-- Nav tabs -->
											  <ul class="pro-details-tab" role="tablist">
												<li role="presentation" class="active"><a href="#tab-desc" aria-controls="tab-desc" role="tab" data-toggle="tab">商品描述</a></li>
											</ul>
											<div>
											
											</div>
											  <!-- Tab panes -->
											  <div class="tab-content">
												<div role="tabpanel" class="tab-pane active" id="tab-desc">
													<div class="product-tab-desc">
														${shop.description}
													</div>
												</div>
											  </div>
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
		<!-- elevateZoom js -->
        <script src="<%=basePath%>js/jquery.elevateZoom-3.0.8.min.js"></script>
		<!-- wow js -->
        <script src="<%=basePath%>js/wow.min.js"></script>
		<script>
			$(".zoom").elevateZoom();
		</script>
		<!-- plugins js -->
        <script src="<%=basePath%>js/plugins.js"></script>
		<!-- main js -->
		<script src="<%=basePath%>js/main.js"></script>
		<script src="https://cdn.bootcss.com/vue/2.6.10/vue.min.js"></script>
		<script src="<%=basePath%>js/public/public.js"></script>
		<script>
		//alert(${shop.id})
				let vm = new Vue({
					el:"#wrappers",
					data(){
						return{
							productInfo:{

							}, //商品信息
							//购买数量
							shopcount:1
						}
					},
					mounted(){
					  
					},
					methods:{
					
						//加入购物车
						addCar(index){
							let self = this
							let parames = {
								shopcount:self.shopcount,
								shopid:${shop.id}
							}
							console.log(parames)
							  $.ajax({
						          url:"<%=basePath%>cart/add",
						          type:'post',//method请求方式，get或者post
						          dataType:'json',//预期服务器返回的数据类型
						          data:JSON.stringify(parames),//表格数据序列化
						          contentType: "application/json; charset=utf-8",
						          success:function(res){//res为相应体,function为回调函数
						            if(res.success){
						              alert(res.message);
						              //$("#res").click();//调用重置按钮将表单数据清空
						            }else{
						              alert(res.message);
						            }
						          },
						          error:function(){
						            alert('操作失败！！！');
						          }
						        });
							
						}
					}
				})
			 </script>
    </body>
</html>