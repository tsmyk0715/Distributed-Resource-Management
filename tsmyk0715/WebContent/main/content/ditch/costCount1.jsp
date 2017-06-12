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
    $('#orders').datagrid('selectRow',index);// 关键在这里  
    var row = $('#orders').datagrid('getSelected');  
    if (row){ 
    	if($('#'+index).text()=='已审核'){
    		return false;
    	}
    	alert("审核成功！");
        $('#'+index).text("已审核");
        $('#'+index).css("cursor","default");
        $('#'+index).css("color","#5F9EA0");
        $('#'+index).css("text-decoration","none");
    }  
} 
function formatOper1(val,row,index){  
    return '<input type="text" class="inputText" value="0" id='+index+'></input>&nbsp;点';  
} 
function formatOper2(val,row,index){  
    return '<em id='+index+'>0</em>';  
} 
function formatOper3(val,row,index){  
	var row = $('#orders').datagrid('getSelected');  
	if(row){
		//alert(row.truePay);
    	return '<em id='+index+'>row.truePay</em>';  
	}
} 
function formatOper4(val,row,index){  
    return '<button id='+index+'></input>';  
} 
</script>



<style type="text/css">

	.inputText{
		width:25px;
	}
</style>

</head>
<body style="padding: 0; margin:0">
	<!-- 显示数据的表格 start -->
	<table id="costCount" title="分销费用计算" class="easyui-datagrid" 
		style="width:1129px;height:522px;"
        url="../../../tsmyk0715/processCostCount?userid=${user.id }" 
        rownumbers="true" fitColumns="true" singleSelect="false" 
        data-options="autoRowHeight:false,rowStyler:function(){return 'height: 34px';}"
        striped="true"
        pagination="true"
        pageSize=10   
        method="post"
        toolbar="#searchDialog"
        iconCls="icon-search">
	    <thead>
	        <tr align="center">
	        	<th field="ck"  checkbox="true"></th>
	        	<th field="id" hidden="true">ID</th>
	            <th field="number" width="50">订单编号</th>
	            <th field="customername" width="50">客户名称</th>
	            <th field="name" width="50">商品名称</th>
	            <th field="size" width="50">商品型号</th>
	            <th field="price" width="100">商品价格</th>
	            <th field="goodsNum" width="50">商品数量</th>
	            <th field="truePay" width="100">应付账款</th>
	             <th data-options="field:'fandian',width:80,align:'center',formatter:formatOper1">返点</th>  
	             <th data-options="field:'shijifandian',width:80,align:'center',formatter:formatOper2">实际返点金额</th>  
	             <th data-options="field:'truePayMoney',width:80,align:'center',formatter:formatOper3">实际付款</th>  
	             <th data-options="field:'count',width:80,align:'center',formatter:formatOper4">计算</th>  
	        </tr>
	    </thead>
    </table>
    <!-- 显示数据的表格 end -->
</body>
</html>