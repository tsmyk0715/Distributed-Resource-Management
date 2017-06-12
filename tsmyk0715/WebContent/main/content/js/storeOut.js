$(function(){
	//添加“查询”按钮事件监听
	$("#search").click(searchBtnAction);
	//添加“清空”按钮事件监听
	$("#clear").click(clearBtnAction);
	//添加“修改”的事件监听
	$("#edit").click(eaitBtnAction);
	//添加"提交修改"的事件监听
	$("#okBtn").click(submitBtnAction);
	//添加“删除”的事件监听
	$("#delete").click(deleteBtnAction);
	
	/**
	 * 查询提交按钮的监听函数
	 * @returns
	 */
	function searchBtnAction(){
		var $number = $("#search_number").val().trim();
		var $clientName = $("#search_clientName").val().trim();
		var $goodsName = $("#search_goodsName").val().trim();
		$('#stockOut').datagrid('load',{
			number:$number,
			clientName:$clientName,
			goodsName:$goodsName,
		});
	}
	
	/**
	 * 清空按钮的监听函数
	 */
	function clearBtnAction(){
		$("#search_number").val("");
		$("#search_clientName").val("");
		$("#search_goodsName").val("");
	}
	/**
	 * 修改按钮的监听函数
	 * @returns
	 */
	function eaitBtnAction(){
		var stockOut = $("#stockOut").datagrid("getSelections");
		if(stockOut == null || stockOut == undefined || stockOut == ''){
			$.messager.alert('提示','请选择要修改的出库单！','warning');
			return false;
		}
		if(stockOut.length > 1){
			$.messager.alert('提示','一次只能修改一个出库单！','warning');
			return false;
		}else{
			$('#editDiv').dialog({
			    title: '修改出库单信息',
			    width: 360,
			    height: 200,
			    closed: false,
			    cache: false,
			    modal: true
			});
		}
		$("#id").val(stockOut[0].id);
		$("#goodsNum").val(stockOut[0].goodsNumber);
		$("#desc").val(stockOut[0].description);
		$("#tipMsg").text("");
	}
	
	/**
	 * 点击“修改”按钮的事件监听
	 * @returns
	 */
	function submitBtnAction(){
		var id = $("#id").val();
		var goodsNum = $("#goodsNum").val();
		var desc = $("#desc").val();
		if(goodsNum == null || goodsNum == ''){
			$("#tipMsg").text("商品数量不能为空！");
			return false;
		}
		
		var stockOut = {"id":id,"goodsNum":goodsNum,"desc":desc};
		var stockOutJson = JSON.stringify(stockOut);
	    $.ajax({
	        type: "POST",
	        url: "editStockOutInformation",
	        data: stockOutJson,
	        contentType: "application/json; charset=utf-8",
	        success: function () {          
	            $("#stockOut").datagrid("reload");
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
		var stockOut = $("#stockOut").datagrid("getSelections");
		if(stockOut.length == 0 || stockOut == null || stockOut == '' || stockOut == undefined){
			$.messager.alert('提示','请选择要删除的用户！','warning');
			return false;
		}else{
			var arr = new Array();
			for(var i = 0; i < stockOut.length; i++){
				arr.push(stockOut[i].id);
			}
			$.messager.confirm('提示','您确定要删除选中的记录吗？',function(r){   
			if (r){   
				 	$.ajax({
				 		type : "POST",
				 		url : "deleteStoucOut",
				 		data : {"id":arr},
				 		success : function(){
				 			$("#stockOut").datagrid("reload");
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