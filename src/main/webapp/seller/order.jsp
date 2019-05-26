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
                  <a>订单信息</a>
                </span>
                <h2 class="title">订单信息</h2>
            </div>
        </div>
        <div class="layui-row">
            <div class="layui-card">
                <div class="layui-card-body">
                    <div class="form-box">
                        <div class="layui-form layui-form-item" style="margin-top:10px;">
                            <div class="layui-inline">
                                <div class="layui-form-mid">订单号:</div>
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
    <script src="<%=basePath%>assets/layui.all.js"></script>
    <script type="text/html" id="barDemo">
      <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="showOrderDetail">详情</a>
     
    </script>
    <script>
  layui.use('table', function(){
     var table = layui.table,form = layui.form,$=layui.$;
       //方法级渲染
     table.render({
        elem: '#LAY_table_user'
        ,url:'<%=basePath%>order/search'  //数据请求地址
       ,cols: [[
            ,{field: 'orderno', title: '订单号', minWidth: 160,align:'center'}
            ,{field: 'ordertime', title: '下单时间', minWidth: 150,align:'center'}
            ,{field: 'orderamt', title: '订单金额', minWidth: 100,align:'center'}
            ,{field: 'receiverman', title: '收货人', width: 100,align:'center'}
            ,{field: 'reveiverphone', title: '收货电话', width: 100,align:'center'}
            ,{field: 'reveiveraddress', title: '收货地址', width: 100,align:'center'}
            ,{field: 'uid', title: '买家id', width: 100,align:'center'}
            ,{field: 'sellerid', title: '卖家id', width: 100,align:'center'}
            ,{field: 'orderstatus', title: '订单状态', width: 100,align:'center'}
            ,{fixed: 'right', title:'操作', toolbar: '#barDemo',width: 120,align:'center'}
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
             key: { key: demoReload.val() } //筛选参数
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
      
         if(obj.event === 'showOrderDetail'){
           layer.open({
              type: 1,
              skin: 'layui-layer-demo', //样式类名
              closeBtn: 1, //不显示关闭按钮
              anim: 2,
              area: ['800px', '80%'],
              shadeClose: true, //开启遮罩关闭
              content: $("#box"),
              end:function(){
                 $("#box").hide();
              },
           });
          
          //订单详情数据渲染
          table.render({
              elem: '#orderDetail'
             ,url:'<%=basePath%>order/houSearchDetail?id='+data.id  //数据请求地址
             ,cols: [[ //标题栏
            	  ,{field: 'shopname', title: '商品名称', minWidth: 160,align:'center'}
                  ,{field: 'detailcount', title: '商品数量', minWidth: 150,align:'center'}
                  ,{field: 'detailprice', title: '订单金额', minWidth: 100,align:'center'}
                  
              ]]
              
              ,page:false
             ,even: true
          });
        }
     });
     
});
</script>
</body>
</html>