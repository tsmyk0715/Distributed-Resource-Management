<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="../../../tsmyk0715/common/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../../../tsmyk0715/common/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../../../tsmyk0715/common/themes/icon.css">
<link rel="stylesheet" type="text/css" href="../../../tsmyk0715/common/themes/demo.css">
<script type="text/javascript" src="../../../tsmyk0715/common/js/jquery.min.js"></script>
<script type="text/javascript" src="../../../tsmyk0715/common/js/jquery.easyui.min.js"></script>

<script type="text/javascript">

function change(index){  
    $('#costCount').datagrid('selectRow',index);// 关键在这里  
    var row = $('#costCount').datagrid('getSelected');  
    if (row){ 
    	if($('#'+index).text()=='同意申请，已收款'){
    		return false;
    	}
    	var flag = confirm("请确认实际收款是否一致，否则请点击任务栏修改按钮进行修改！");
    	if(flag == true){
	        $('#'+index).text("同意申请，已收款");
	        $('#'+index).css("cursor","default");
	        $('#'+index).css("color","#5F9EA0");
	        $('#'+index).css("text-decoration","none");
    	}
    }  
} 
function formatOper(val,row,index){  
    return '<a href="#" class="verify" id='+index+' onclick="change('+index+')">客户付款申请</a>';  
} 
</script>

<style type="text/css">
	.inputText{
		width:25px;
	}
	.verify{
		text-decoration:none;
		color: blue;
	}
</style>

</head>
<body style="padding: 0; margin:0">

	<!-- 顶部操作按钮 start -->
	<div style="padding:1px;width:70%;">
		<a id="edit" href="#" class="easyui-linkbutton" iconCls="icon-edit">实际收款有误,点击修改</a>
	</div>

	<!-- 显示数据的表格 start -->
	<table id="costCount" title="付款结算管理" class="easyui-datagrid" 
		style="width:1146px;height:546px;"
        url="../../../tsmyk0715/processCostVerify?userid=${user.id }" 
        rownumbers="true" fitColumns="true" singleSelect="true" 
        data-options="autoRowHeight:false,rowStyler:function(){return 'height: 40px';}"
        striped="true"
        pagination="true"
        pageSize=10   
        method="post"
        toolbar="#searchDialog"
        iconCls="icon-search"
        sortName="id"
        loadMsg="正在加载数据...">
	    <thead>
	        <tr align="center">
	        	<th field="ck"  checkbox="true"></th>
	        	<th field="id" hidden="true">ID</th>
	            <th field="number" width="50">订单编号</th>
	            <th field="customername" width="50">客户名称</th>
	            <th field="name" width="50">商品名称</th>
	            <th field="size" width="120">商品型号</th>
	            <th field="price" width="60">商品价格</th>
	            <th field="goodsNum" width="50">商品数量</th>
	            <th field="truePay" width="100">应付账款</th>
	            <th field="fandian" width="50">返点</th>
	            <th field="fandianjine" width="80">返点金额</th>
	            <th field="shijifukuan" width="80">实际应付款</th>
	            <th field="shijishouokuan" width="80">实际收款</th>
	            <th data-options="field:'verify',width:80,align:'center',formatter:formatOper">客户付款申请</th>  
	        </tr>
	    </thead>
    </table>
    <!-- 显示数据的表格 end -->
</body>
</html>