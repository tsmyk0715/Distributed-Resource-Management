$(function(){
	
	//添加“修改”的事件监听
	$("#edit").click(eaitBtnAction);
	//添加"提交修改"的事件监听
	$("#okBtn").click(submitBtnAction);
	//添加“删除”的事件监听
	$("#delete").click(deleteBtnAction);
	//添加“添加”的事件监听
	$("#add").click(addBtnAction);
	//添加“提交添加”按钮事件监听
	$("#add_okBtn").click(addSubmitBtnAction);
	
	//添加“查询”按钮事件监听
	$("#search").click(searchSubmitBtnAction);
	
	//添加“导出”按钮事件监听
	$("#exportExcel").click(exportInformationExcelAction);
	
	/**
	 * 导出信息生成Excel表格
	 * @returns
	 */
	function exportInformationExcelAction(){
	   $.ajax({
	        type: "get",
	        url: "../../exportInformationExcel",
	        success: function () {          
	        	
	        },
	    	error:function(){
	    		$.messager.alert("提示！", "系统错误！");
	    	}
	    })
	}
	
	/**
	 * 查询提交按钮的监听函数
	 * @returns
	 */
	function searchSubmitBtnAction(){
		var $username = $("#search_username").val();
		var $lastname = $("#search_lastname").val();
		var $phone = $("#search_phone").val();
		var $email = $("#search_email").val();
		$('#dg').datagrid('load',{
			username:$username,
			lastname:$lastname,
			phone:$phone,
			email:$email
		});
	}
	
	/**
	 * 添加按钮的监听函数
	 * @returns
	 */
	function addBtnAction(){
		$('#addDialog').dialog({
		    title: '添加用户信息',
		    width: 360,
		    height: 260,
		    closed: false,
		    cache: false,
		    modal: true
		});
	}
	
	/**
	 * 添加提交按钮的监听函数
	 * @returns
	 */
	function addSubmitBtnAction(){
		var $username = $("#add_username").val();
		var $lastname = $("#add_lastname").val();
		var $phone = $("#add_phone").val();
		var $email = $("#add_email").val();
		var user = {"username":$username,"lastname":$lastname,"phone":$phone,"email":$email};
		var userJson = JSON.stringify(user);
		$.ajax({
			type:"post",
			url:"../../addUserInformation",
			data:userJson,
			contentType:"application/json; charset=utf-8",
			success:function(responseText){
				$("#dg").datagrid("reload");
				if("ok"==responseText){
					$.messager.alert("提示！", "添加用户成功！","info");
				}else{
					 $.messager.alert("提示！", "添加用户失败！","error");
				}
			},
			error:function(){
	    		$.messager.alert("提示！", "系统错误！");
	    	}
		})
		$('#addDialog').dialog('close');
	}
	
	/**
	 * 删除按钮的监听函数
	 * @returns
	 */
	function deleteBtnAction(){
		var users = $("#dg").datagrid("getSelections");
		if(users.length == 0 || users == null || users == '' || users == undefined){
			$.messager.alert('提示','请选择要删除的用户！','warning');
			return false;
		}else{
			var arr = new Array();
			for(var i = 0; i < users.length; i++){
				arr.push(users[i].id);
			}
			$.messager.confirm('提示','您确定要删除选中的记录吗？',function(r){   
			if (r){   
				 	$.ajax({
				 		type : "POST",
				 		url : "../../deleteUserInformation",
				 		data : {"usersId":arr},
				 		success : function(){
				 			$("#dg").datagrid("reload");
				 			$.messager.alert("提示！", "删除成功！");
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
	
	
	/**
	 * 修改按钮的监听函数
	 * @returns
	 */
	function eaitBtnAction(){
		var user = $("#dg").datagrid("getSelections");
		if(user == null || user == undefined){
			$.messager.alert('提示','请选择要修改的用户！','warning');
			return false;
		}
		if(user.length > 1){
			$.messager.alert('提示','一次只能修改一个用户！','warning');
			return false;
		}else{
			$('#dd').dialog({
			    title: '修改用户信息',
			    width: 360,
			    height: 260,
			    closed: false,
			    cache: false,
			    modal: true
			});
			$("#id").val(user[0].id);
			$("#username").val(user[0].username);
			$("#lastname").val(user[0].lastname);
			$("#phone").val(user[0].phone);
			$("#email").val(user[0].email);
		}
	}
	
	/**
	 * 点击“修改”按钮的事件监听
	 * @returns
	 */
	function submitBtnAction(){
		var id = $("#id").val();
		var username = $("#username").val();
		var lastname = $("#lastname").val();
		var phone = $("#phone").val();
		var email = $("#email").val();
		var user = {"id":id,"username":username,"lastname":lastname,"phone":phone,"email":email};
		var userJson = JSON.stringify(user);
	    $.ajax({
	        type: "POST",
	        url: "../../editUserInformation",
	        data: userJson,
	        contentType: "application/json; charset=utf-8",
	        success: function () {          
	            $("#dg").datagrid("reload");
	            $.messager.alert("提示！", "信息修改成功！");
	        },
	    	error:function(){
	    		$.messager.alert("提示！", "系统错误！");
	    	}
	    })
	    $('#dd').dialog('close');
	}
});