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
           <form class="layui-form layui-card-body" action="" id="addOrEdit" lay-filter="example">
              <div class="layui-form-item">
                  <label class="layui-form-label">商品id</label>
                  <div class="layui-input-block">
                    <input type="text" name="id" disabled  autocomplete="off" class="layui-input">
                  </div>
                </div>
             <div class="layui-form-item">
               <label class="layui-form-label">商品名称</label>
               <div class="layui-input-block">
                 <input type="text" name="shopname" required  lay-verify="required" placeholder="请输入商品名称" autocomplete="off" class="layui-input">
               </div>
             </div>
             <div class="layui-form-item">
               <label class="layui-form-label">价格</label>
               <div class="layui-input-block">
                 <input type="text" name="price" required  lay-verify="required|number" placeholder="请输入价格" autocomplete="off" class="layui-input">
               </div>
             </div>
             <div class="layui-form-item">
               <label class="layui-form-label">库存</label>
               <div class="layui-input-block">
                 <input type="text" name="store" required  lay-verify="required|number" placeholder="请输入库存" autocomplete="off" class="layui-input">
               </div>
             </div>
             <div class="layui-form-item">
                <div class="layui-upload">
                    <button type="button" class="layui-btn" id="test2">多图片上传</button> 
                    <blockquote class="layui-elem-quote layui-quote-nm" style="margin-top: 10px;">
                      预览图：
                      <div class="layui-upload-list" id="demo2"></div>
                   </blockquote>
                </div>
             </div>
             <div class="layui-form-item">
               <label class="layui-form-label">单位</label>
               <div class="layui-input-block">
                 <input type="text" name="unit" required  lay-verify="required" placeholder="请输入单位" autocomplete="off" class="layui-input">
               </div>
             </div>
             <div class="layui-form-item">
               <label class="layui-form-label">卖家</label>
               <div class="layui-input-block">
                 <input type="text" name="sellerid" required  lay-verify="required" placeholder="请输入卖家" autocomplete="off" class="layui-input">
               </div>
             </div>
             <div class="layui-form-item">
               <label class="layui-form-label">类型</label>
               <div class="layui-input-block">
                 <select name="typeid" id="typeid" lay-filter="projectfilter">
                 </select>
               </div>
             </div>
             <div class="layui-form-item">
               <label class="layui-form-label">商品描述</label>
               <div class="layui-input-block">
                   <textarea id="edit" name="description" style="display: none;" placeholder="请输入商品描述"></textarea>
               </div>
             </div>
             <div class="layui-form-item">
               <label class="layui-form-label">商品状态</label>
               <div class="layui-input-block">
                 <input type="checkbox" checked="" name="shopstatus" lay-skin="switch" lay-text="上架|下架">
               </div>
             </div>
            <div class="layui-form-item">
               <div class="layui-input-block">
                 <button class="layui-btn layui-btn-blue" lay-submit lay-filter="formDemo">立即提交</button>
                 <button type="reset" class="layui-btn layui-btn-primary">重置</button>
               </div>
             </div>
           </form>  
       </div>
     </div>
     </div>
    <div class="layui-content">
        <div class="layui-page-header">
            <div class="pagewrap">
                <span class="layui-breadcrumb">
                  <a>首页</a>
                  <a>商品信息</a>
                </span>
                <h2 class="title">商品信息</h2>
            </div>
        </div>
        <div class="layui-row">
            <div class="layui-card">
                <div class="layui-card-body">
                    <div class="form-box">
                        <button class="layui-btn layui-btn-blue add" id="add"><i class="layui-icon">&#xe654;</i>新增</button>
                        <div class="layui-form layui-form-item" style="margin-top:10px;">
                            <div class="layui-inline">
                                <div class="layui-form-mid">商品名称:</div>
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
      <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
      <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    </script>
    <script type="text/html" id="switchTpl">
      <!-- 这里的 checked 的状态只是演示 -->
      <input type="checkbox" name="sex" value="{{d.id}}" lay-skin="switch" lay-text="上架|下架" lay-filter="sexDemo" {{ d.id == 10001 ? 'checked' : '' }}>
    </script>
    <script>
  layui.use('table', function(){
    
     var table = layui.table,form = layui.form,$=layui.$;
     let logo = ''
       //方法级渲染
     table.render({
        elem: '#LAY_table_user'
       ,url:'<%=basePath%>shop/search'  //数据请求地址
       ,cols: [[
             {field: 'id', title: 'ID', width: 80, sort: true}
            ,{field: 'shopname', title: '商品名称', minWidth: 160}
            ,{field: 'price', title: '商品价格', minWidth: 100}
            ,{field: 'store', title: '商品库存', minWidth: 100}
            ,{field: 'unit', title: '商品单位', width: 100}
            ,{field: 'typeid', title: '商品类型', width: 100}
            ,{field: 'sellerid', title: '卖家', width: 100}
            ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:120}
            ,{fixed: 'right', title:'上架/下架', width:100, templet: '#switchTpl', unresize: true}
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
        if(obj.event === 'showDetail'){
           layer.msg('ID：'+ data.id + ' 的查看操作');
        } else if(obj.event === 'del'){
        layer.confirm('真的删除行么', function(index){
           
           
           $.ajax({
               url:"<%=basePath%>shop/delete?id="+data.id,
               type:'post',//method请求方式，get或者post
               dataType:'json',//预期服务器返回的数据类型
               contentType: "application/json; charset=utf-8",
               success:function(res){//res为相应体,function为回调函数
                 if(res.success){
                   layer.alert(res.message,{icon:1});
                   obj.del();
                  // location.href="<%=basePath%>seller/index.jsp";
                   layer.close(1)  //关闭弹窗
                   //$("#res").click();//调用重置按钮将表单数据清空
                 }else{
                   layer.alert(res.message,{icon: 5});
                 }
               },
               error:function(){
                 layer.alert('操作失败！！！',{icon:5});
               }
             });
           layer.close(index);
          });
        } else if(obj.event === 'edit'){
            layui.use('layedit', function(){
              var layedit = layui.layedit;
              layedit.build('edit'); //建立编辑器
            });
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
           //获取商品类型接口
           $.ajax({
        	   url:"<%=basePath%>type/findAll",
               dataType: 'json',
               type: 'get',
               success: function (data) {
                $("#typeid").empty();
                $("#typeid").append(new Option("请选择", ""));
				    		$.each(data, function(index, item) {
						      	$('#typeid').append(new Option(item.typename, item.id));
					    	});
                 form.render("select");
                }
             })
           //表单初始赋值
           console.log(data)
           form.val('example', data)
          
        }
      });
       //提交
     form.on('submit(formDemo)', function(data){
          // layer.msg(JSON.stringify(data.field));
          delete data.field.file;
          data.field.logo = logo;
          console.log(data)
        
           var param=data.field;
           /*  layer.alert(JSON.stringify(data.field), {
              title: '最终的提交信息'
            }) */
             $.ajax({
              url:"<%=basePath%>shop/addOrUpdate",
              type:'post',//method请求方式，get或者post
              dataType:'json',//预期服务器返回的数据类型
              data:JSON.stringify(param),//表格数据序列化
              contentType: "application/json; charset=utf-8",
              success:function(res){//res为相应体,function为回调函数
                if(res.success){
                  layer.alert(res.message,{icon:1});
                 // location.href="<%=basePath%>seller/index.jsp";
                  layer.close(1)  //关闭弹窗
                  //$("#res").click();//调用重置按钮将表单数据清空
                }else{
                  layer.alert(res.message,{icon: 5});
                }
              },
              error:function(){
                layer.alert('操作失败！！！',{icon:5});
              }
            });
           return false;
       });
       //增加
     $(document).on('click','#add',function(){
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
           $('#addOrEdit')[0].reset();
           //获取商品类型接口
           $.ajax({
        	   url:"<%=basePath%>type/findAll",
               dataType: 'json',
               type: 'get',
               success: function (data) {
                $("#typeid").empty();
                $("#typeid").append(new Option("请选择", ""));
				    		$.each(data, function(index, item) {
						      	$('#typeid').append(new Option(item.typename, item.id));
					    	});
                 form.render("select");
                }
             })
           //表单初始赋值
           console.log(data)
           form.val('example', data)
       });
     //监听上架下架
     form.on('switch(sexDemo)', function(obj){
          // layer.tips(this.value + ' ' + this.name + '：'+ obj.elem.checked, obj.othis);
           var shopstatus='on';
           //alert(obj.elem.value);
           console.log(obj);
           if(obj.elem.checked){
        	   shopstatus='on';
           }else{
        	   shopstatus='off';
           }
           $.ajax({
               url:'<%=basePath%>shop/updatestatus?id='+obj.elem.value+'&shopstatus='+shopstatus,
               type:'post',//method请求方式，get或者post
               dataType:'json',//预期服务器返回的数据类型
               contentType: "application/json; charset=utf-8",
               success:function(res){//res为相应体,function为回调函数
                 if(res.success){
                   layer.alert(res.message,{icon:1});
                   obj.del();
                   layer.close(1)  //关闭弹窗
                   //$("#res").click();//调用重置按钮将表单数据清空
                 }else{
                   layer.alert(res.message,{icon: 5});
                 }
               },
               error:function(){
                 layer.alert('操作失败！！！',{icon:5});
               }
             });
       });
      //多图片上传
     layui.use('upload',function(){
         let upload = layui.upload;
         upload.render({
            elem: '#test2'
           ,url: '<%=basePath%>shop/upload'
           ,multiple: true
           ,before: function(obj){
           //预读本地文件示例，不支持ie8
            obj.preview(function(index, file, result){
              $('#demo2').append('<img src="'+ result +'" alt="'+ file.name +'" class="layui-upload-img">')
            });
          }
           ,done: function(res){
          //上传完毕
               logo = res.message
        	   
           }
        });
      })
     
});
   </script>
</body>
</html>