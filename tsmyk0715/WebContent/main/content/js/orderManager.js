$(function(){
	
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
	
	//检测字符串是否是整数
	function isNumber(str){
		if (typeof(str) === "number") {
			return true;
		}
		var reg = /^([1-9]+[0-9]*)$/g;
		reg.lastIndex = 0;
		return reg.test(str);
	}
	
	/**
	 * 修改按钮的监听函数
	 * @returns
	*/
	function eaitBtnAction(){
		var orders = $("#orders").datagrid("getSelections");
		if(orders == null || orders == undefined || orders == ''){
			$.messager.alert('提示','请选择要修改的订单！','warning');
			return false;
		}
		if(orders.length > 1){
			$.messager.alert('提示','一次只能修改一个订单！','warning');
			return false;
		}else{
			$('#editDiv').dialog({
			    title: '修改订单信息',
			    width: 360,
			    height: 400,
			    closed: false,
			    cache: false,
			    modal: true
			});
		}
		$("#id").val(orders[0].id);
		$("#number").val(orders[0].number);
		$("#goodsNum").val(orders[0].goodsNum);
		$("#sendTime").val(orders[0].sendTime);
		$("#payType").val(orders[0].payType);
		$("#desc").val(orders[0].description);
	}
	 
	/**
	 * 点击“确认修改”按钮的事件监听
	 * @returns
	 */
	function submitBtnAction(){
		
		var $id = $("#id").val();
		var $number = $("#number").val();
		var $goodsNum = $("#goodsNum").val();
		var $sendTime = $("#sendTime").val();
		var $payType = $("#payType").val();
		var $desc = $("#desc").val();
		
		if(isEmpty($number) || isEmpty($goodsNum)){
			$("#tipMsg").text("红色星号为必填项！");
			return false;
		}
		if(!isEmpty($goodsNum) && !isNumber($goodsNum)){
			$("#tipMsg").text("数量填写不正确！");
			return false;
		}
		var orders = {"id":$id,"number":$number,"goodsNum":$goodsNum,"sendTime":$sendTime,"payType":$payType,"desc":$desc};
		var ordersJson = JSON.stringify(orders);

		$.ajax({
	        type: "POST",
	        url: "editOrdersInformation",
	        data: ordersJson,
	        contentType: "application/json; charset=utf-8",
	        success: function () {          
	            $("#orders").datagrid("reload");
	            //$.messager.alert("提示！", "信息修改成功！");
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
		var orders = $("#orders").datagrid("getSelections");
		if(orders.length == 0 || orders == null || orders == '' || orders == undefined){
			$.messager.alert('提示','请选择要删除的用户！','warning');
			return false;
		}else{
			var arr = new Array();
			for(var i = 0; i < orders.length; i++){
				arr.push(orders[i].id);
			}
			$.messager.confirm('提示','您确定要删除选中的记录吗？',function(r){   
			if (r){   
				 	$.ajax({
				 		type : "POST",
				 		url : "deleteOrders",
				 		data : {"id":arr},
				 		success : function(){
				 			$("#orders").datagrid("reload");
				 			//$.messager.alert("提示！", "删除成功！");
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