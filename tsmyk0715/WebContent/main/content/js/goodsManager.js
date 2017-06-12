$(function(){
	
	//添加“查询”按钮事件监听
	$("#search").click(searchBtnAction);
	//添加“清空条件”按钮事件监听
	$("#clear").click(clearBtnAction);
	//添加“修改”的事件监听
	$("#edit").click(eaitBtnAction);
	//添加"提交修改"的事件监听
	$("#okBtn").click(submitBtnAction);
	//添加“删除”的事件监听
	$("#delete").click(deleteBtnAction);
	
	//是否为String
	function isString(s){
		return typeof s==="string";
	}
	//是否为空
	function isEmpty(s){
		return s===null || s===undefined || s=='' || (isString(s) && s=='');
	}
	
	/**
	 * 查询提交按钮的监听函数
	 * @returns
	 */
	function searchBtnAction(){
		var $number = $("#search_number").val().trim();
		var $goodsNme = $("#search_name").val().trim();
		var $place = $("#search_place").val().trim();
		$('#goodsManager').datagrid('load',{
			number:$number,
			name:$goodsNme,
			place:$place,
		});
	}
	
	/**
	 * “清空按钮”的监听函数
	 */
	function clearBtnAction(){
		$("#search_number").val("");
		$("#search_name").val("");
		$("#search_place").val("");
	}
	
	/**
	 * 修改按钮的监听函数
	 * @returns
	 */
	function eaitBtnAction(){
		var goods = $("#goodsManager").datagrid("getSelections");
		if(goods == null || goods == undefined || goods == ''){
			$.messager.alert('提示','请选择要修改的信息！','warning');
			return false;
		}
		if(goods.length > 1){
			$.messager.alert('提示','一次只能修改一条信息！','warning');
			return false;
		}else{
			$('#editDiv').dialog({
			    title: '修改物料信息',
			    width: 360,
			    height: 450,
			    closed: false,
			    cache: false,
			    modal: true
			});
		}
		 $("#id").val(goods[0].id);
		 $("#number").val(goods[0].number);
		 $("#goodsName").val(goods[0].name);
		 $("#productPlace").val(goods[0].productPlace);
		 $("#size").val(goods[0].size);
		 $("#price").val(goods[0].price);
		 $("#goodsNum").val(goods[0].goodsNum);
		 $("#desc").val(goods[0].description);
		 $("#tipMsg").text("");
	}
	
	/**
	 * 点击“确认修改”按钮的事件监听
	 * @returns
	 */
	function submitBtnAction(){
		var $id = $("#id").val().trim();
		var $number = $("#number").val().trim();
		var $goodsName = $("#goodsName").val().trim();
		var $productPlace = $("#productPlace").val().trim();
		var $size = $("#size").val();
		var $price = $("#price").val();
		var $goodsNum = $("#goodsNum").val();
		var $desc = $("#desc").val();

		if(isEmpty($number)){
			$("#tipMsg").text("请输入商品编号！");
			return false;
		}
		if(isEmpty($goodsName)){
			$("#tipMsg").text("请输入商品名称！");
			return false;
		}
		if(isEmpty($productPlace)){
			$("#tipMsg").text("请输入产地！");
			return false;
		}
		if(!($price == null || $price == '') && isNaN($price)){//isNaN
			$("#tipMsg").text("价格只能是数字！");
			return false;
		}
		if(!($goodsNum == null || $goodsNum == '') && isNaN($goodsNum)){
			$("#tipMsg").text("商品数量只能是数字！");
			return false;
		}
		
		var $goods = {"id" : $id, "number" : $number, "goodsName" : $goodsName,
					  "productPlace" : $productPlace, "size": $size, "price" : $price,
					  "goodsNum" : $goodsNum, "desc" : $desc};
		var goodsJson = JSON.stringify($goods);
	    $.ajax({
	        type: "POST",
	        url: "editGoodsInformation",
	        data: goodsJson,
	        contentType: "application/json; charset=utf-8",
	        success: function () {          
	            $("#goodsManager").datagrid("reload");
	        },
	    	error:function(){
	    		$.messager.alert("提示！", "系统错误！");
	    	}
	    })
	    $('#editDiv').dialog('close');
	}
	
	/**
	 * 删除按钮的监听函数
	 * @returns
	 */
	function deleteBtnAction(){
		var goods = $("#goodsManager").datagrid("getSelections");
		if(goods.length == 0 || goods == null || goods == '' || goods == undefined){
			$.messager.alert('提示','请选择要删除的信息！','warning');
			return false;
		}else{
			var arr = new Array();
			for(var i = 0; i < goods.length; i++){
				arr.push(goods[i].id);
			}
			$.messager.confirm('提示','您确定要删除选中的记录吗？',function(r){   
			if (r){   
				 	$.ajax({
				 		type : "POST",
				 		url : "deleteGoods",
				 		data : {"id":arr},
				 		success : function(){
				 			$("#goodsManager").datagrid("reload");
				 		},
				 		error:function(){
				    		$.messager.alert("提示！", "系统错误！");
				    	}
				 	})
				}else{
					return false;
				}   
			}); 
		}
	}
})