<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../../../tsmyk0715/common/js/jquery.min.js"></script>
<style type="text/css">
	em{color: red;margin-left: 6px;}
</style>
<script type="text/javascript">
	//是否为空
	function isEmpty(s){
		return s===null || s===undefined || s=='';
	}
	//是否存在中文
	function isExistChinese(str) {
	    if(!str || str == ""){
	    	return false;
	    }
	    for(var i = 0; i < str.length; i++){
	    	if(str.charCodeAt(i) > 255){
	    		return true;
	    	}
	    }
	    return false;
	}
	//检测字符串是否是整数
	function isNumber(str){
		if (typeof(str) === "number") {
			return true;
		}
		var reg = /^([1-9]+[0-9]*)$/g;
		reg.lastIndex = 0;
		return reg.test(str);
	}
	function checkNull(){
		var number = $("#number").val().trim();
		var name = $("#name").val().trim();
		var productPlace = $("#productPlace").val().trim();
		var size = $("#size").val().trim();
		var price = $("#price").val().trim();
		var goodsNum = $("#goodsNum").val().trim();
		var goodsPackage = $("#goodsPackage").val().trim();
		var productCode = $("#productCode").val().trim();
		var promitCode = $("#promitCode").val().trim();
		if(isEmpty(number)){
			$("#tipMsg").text("请输入商品编号！");
			return false;
		}
		if(!isEmpty(number) && isExistChinese(number)){
			$("#tipMsg").text("商品编号不能含有中文！");
			return false;
		}
		if(isEmpty(name)){
			$("#tipMsg").text("请输入商品名称！");
			return false;
		}
		if(isEmpty(productPlace)){
			$("#tipMsg").text("请输入产地！");
			return false;
		}
		if(isEmpty(size)){
			$("#tipMsg").text("请输入规格！");
			return false;
		}
		if(isEmpty(goodsPackage)){
			$("#tipMsg").text("请输入包装！");
			return false;
		}
		if(isEmpty(productCode)){
			$("#tipMsg").text("请输入生产批号！");
			return false;
		}
		if(isEmpty(promitCode)){
			$("#tipMsg").text("请输入批准文号！");
			return false;
		}
		if(isEmpty(price)){
			$("#tipMsg").text("请输入价格！");
			return false;
		}
		if(!isEmpty(price) && isNaN(price)){
			$("#tipMsg").text("价格为数字！");
			return false;
		}
		if(isEmpty(goodsNum)){
			$("#tipMsg").text("请输入商品数量！");
			return false;
		}
		if(!isEmpty(goodsNum) && !isNumber(goodsNum)){
			$("#tipMsg").text("商品数量为整数！");
			return false;
		}
	}
</script>
</head>
<body>
<form action="addGoodsAction" method="post">
	<h3 style="margin-left: 30px;">添加商品信息</h3>
	<table id="addGoods" style="width:750px;height:400px;margin-left: 70px;">
	    <tbody>
	    	<tr>
	    		<td><input type="hidden" name="userId" value="${user.id }"></td>
	    	</tr>
	    	<tr>
	    		<td align="center">商品编号</td>
	    		<td><input type="text" name="number" id="number"><em>*</em></td>

	    		<td align="center">商品名称</td>
	    		<td><input type="text" name="name" id="name"><em>*</em></td>
	    	</tr>
	    
	    	<tr>
	    		<td align="center">产地</td>
	    		<td><input type="text" name="productPlace" id="productPlace"><em>*</em></td>

	    		<td align="center">规格</td>
	    		<td><input type="text" name="size" id="size"><em>*</em></td>
	    	</tr>
	    
	    	<tr>
	    		<td align="center">包装</td>
	    		<td><input type="text" name="goodsPackage" id="goodsPackage"><em>*</em></td>

	    		<td align="center">生产批号</td>
	    		<td><input type="text" name="productCode" id="productCode"><em>*</em></td>
	    	</tr>
	    
	    	<tr>
	    		<td align="center">批准文号</td>
	    		<td><input type="text" name="promitCode" id="promitCode"><em>*</em></td>

	    		<td align="center">价格</td>
	    		<td><input type="text" name="price" id="price"><em>*</em></td>
	    	</tr>
	    
	    	<tr>
	    		<td align="center">商品数量</td>
	    		<td><input type="text" name="goodsNum" id="goodsNum"><em>*</em></td>

	    		<td align="center">状态</td>
	    		<td><input type="text" name="available"></td>
	    	</tr>
	    	
	    	<tr>
	    		<td align="center">备注</td>
	    		<td colspan="3">
	    			<textarea rows="7" cols="60" name="description"></textarea>
	    		</td>
	    	</tr>
	    </tbody>
    </table>
    <br>
	<input type="submit" value="添加" onclick="return checkNull();" style="margin-left:100px;">
	<font id="tipMsg" color="red" style="margin-left: 100px;"></font>
</form>
</body>
</html>