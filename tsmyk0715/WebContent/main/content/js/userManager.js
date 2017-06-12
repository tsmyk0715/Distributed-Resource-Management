$(function(){
	//添加“查询”按钮事件监听
	$("#search").click(searchBtnAction);
	//添加“清空”按钮事件监听
	$("#clear").click(clearBtnAction);
	//添加“修改”按钮事件监听
	$("#edit").click(editUserInfoAction);
	//添加“确认修改”按钮事件监听
	$("#editOkBtn").click(editSubmitBtnAction);
	//添加“删除”按钮事件监听
	$("#delete").click(deleteBtnAction);
	
	/**
	 * 查询提交按钮的监听函数
	 * @returns
	 */
	function searchBtnAction(){
		var $account = $("#search_account").val().trim();
		var $name = $("#search_name").val().trim();
		$('#users').datagrid('load',{
			account:$account,
			name:$name
		});
	}
	
	/**
	 * 清空按钮的监听函数
	 */
	function clearBtnAction(){
		$("#search_account").val("");
		$("#search_name").val("");
	}
	
	/**
	 * 修改按钮的监听函数
	 */
	function editUserInfoAction(){
		var user = $("#users").datagrid("getSelections");
		if(user == null || user == undefined || user == ''){
			$.messager.alert('提示','请选择要修改的用户！','warning');
			return false;
		}
		if(user.length > 1){
			$.messager.alert('提示','一次只能修改一个用户！','warning');
			return false;
		}else{
			$('#editDialog').dialog({
			    title: '修改用户信息',
			    width: 300,
			    height: 180,
			    closed: false,
			    cache: false,
			    modal: true
			});
			$("#id").val(user[0].id);
			$("#username").val(user[0].username);
			$("#password").val(user[0].password);
			$("#tipMsg").text("");//清除错误提示信息
		}
	}
	
	/**
	 * 点击“确认修改”按钮的事件监听
	 * @returns
	 */
	function editSubmitBtnAction(){
		var $id = $("#id").val().trim();
		var $username = $("#username").val().trim();
		var $password = $("#password").val().trim();
		
		if($username == null || $username == ''){
			$("#tipMsg").text("姓名不能为空");
			return false;
		}
		if($password == null || $password == ''){
			$("#tipMsg").text("密码不能为空");
			return false;
		}
		
		var user = {"id":$id,"username":$username,"password":$password};
		var userJson = JSON.stringify(user);
	    $.ajax({
	        type: "POST",
	        url: "editUserInformation",
	        data: userJson,
	        contentType: "application/json; charset=utf-8",
	        success: function () {          
	            $("#users").datagrid("reload");
	        },
	    	error:function(){
	    		$.messager.alert("提示！", "系统错误！");
	    	}
	    })
	    $('#editDialog').dialog('close');
	}
	
	/**
	 * 删除按钮的监听函数
	 * @returns
	 */
	function deleteBtnAction(){
		var users = $("#users").datagrid("getSelections");
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
				 		url : "deleteUser",
				 		data : {"usersId":arr},
				 		success : function(){
				 			$("#users").datagrid("reload");
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
});