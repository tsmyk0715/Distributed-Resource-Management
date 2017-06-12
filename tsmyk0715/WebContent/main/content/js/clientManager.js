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
	
	
	//检测是否是合法的电话号码 
	function isPhone(s){
		if (s.length < 7 || s.length > 18) {
			return false;
		}
		var reg = /^([0-9]|[/-])+$/g;
		reg.lastIndex = 0;
		return reg.test(s);
	}
	//是否为String
	function isString(s){
		return typeof s==="string";
	}
	//是否为空
	function isEmpty(s){
		return s===null || s===undefined || s=='' || (isString(s) && s=='');
	}
	//检测是否是合法的邮箱地址
	function isEmail(s){
	  var reg = /^([-_A-Za-z0-9\.]+)@([_A-Za-z0-9]+\.)+[A-Za-z0-9]{2,3}$/
	  reg.lastIndex = 0;
	  return reg.test(s);
	}
	//检测字符串是否是整数
	function isNumber(s){
		if (typeof(str) === "number") {
			return true;
		}
		var reg = /^([1-9]+[0-9]*)$/g;
		reg.lastIndex = 0;
		return reg.test(s);
	}
	
	/**
	 * 查询提交按钮的监听函数
	 * @returns
	 */
	function searchBtnAction(){
		var $number = $("#search_number").val().trim();
		var $clientName = $("#search_name").val().trim();
		var $address = $("#search_address").val().trim();
		var $telephone = $("#search_telephone").val().trim();
		var $connectionPerson = $("#search_connectPerson").val().trim();
		var $email = $("#search_email").val().trim();
		$('#clients').datagrid('load',{
			number:$number,
			clientName:$clientName,
			address:$address,
			telephone:$telephone,
			connectPerson:$connectionPerson,
			email:$email
		});
	}
	
	/**
	 * “清空按钮”的监听函数
	 */
	function clearBtnAction(){
		$("#search_number").val("");
		$("#search_name").val("");
		$("#search_address").val("");
		$("#search_telephone").val("");
		$("#search_connectPerson").val("");
		$("#search_email").val("");
	}
	
	/**
	 * 修改按钮的监听函数
	 * @returns
	 */
	function eaitBtnAction(){
		var clients = $("#clients").datagrid("getSelections");
		if(clients == null || clients == undefined || clients == ''){
			$.messager.alert('提示','请选择要修改的客户！','warning');
			return false;
		}
		if(clients.length > 1){
			$.messager.alert('提示','一次只能修改一个客户！','warning');
			return false;
		}else{
			$('#editDiv').dialog({
			    title: '修改客户信息',
			    width: 360,
			    height: 450,
			    closed: false,
			    cache: false,
			    modal: true
			});
		}
		 $("#id").val(clients[0].id);
		 $("#address").val(clients[0].address);
		 $("#telephone").val(clients[0].telephone);
		 $("#connectPerson").val(clients[0].connectperson);
		 $("#phone").val(clients[0].phone);
		 $("#email").val(clients[0].email);
		 $("#fax").val(clients[0].fax);
		 $("#desc").val(clients[0].description);
	}
	
	/**
	 * 点击“修改”按钮的事件监听
	 * @returns
	 */
	function submitBtnAction(){
		var $id = $("#id").val();
		var $address = $("#address").val();
		var $telephone = $("#telephone").val();
		var $connectPerson = $("#connectPerson").val();
		var $phone = $("#phone").val();
		var $email = $("#email").val();
		var $fax = $("#fax").val();
		var $desc = $("#desc").val();

		if(!isEmpty($telephone) && !isPhone($telephone)){
			$("#tipMsg").text("客户电话有误");
			return false;
		}else{
			$("#tipMsg").text("");
		}
		if(!isEmpty($phone) && !isPhone($phone)){
			$("#tipMsg").text("联系人电话有误");
			return false;
		}else{
			$("#tipMsg").text("");
		}
		if(!isEmpty($email) && !isEmail($email)){
			$("#tipMsg").text("邮箱输入有误");
			return false;
		}else{
			$("#tipMsg").text("");
		}
		if(!isEmpty($fax) && !isNumber($fax)){
			$("#tipMsg").text("传真输入有误");
		}else{
			$("#tipMsg").text("");
		}
		
		var $client = {"id" : $id, "address" : $address, "telephone" : $telephone, "connectPerson" : $connectPerson, 
				"phone": $phone,"email" : $email, "fax" : $fax, "desc" : $desc};
		var clientJson = JSON.stringify($client);
	    $.ajax({
	        type: "POST",
	        url: "editClientInformation",
	        data: clientJson,
	        contentType: "application/json; charset=utf-8",
	        success: function () {          
	            $("#clients").datagrid("reload");
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
		var clients = $("#clients").datagrid("getSelections");
		if(clients.length == 0 || clients == null || clients == '' || clients == undefined){
			$.messager.alert('提示','请选择要删除的客户！','warning');
			return false;
		}else{
			var arr = new Array();
			for(var i = 0; i < clients.length; i++){
				arr.push(clients[i].id);
			}
			$.messager.confirm('提示','您确定要删除选中的记录吗？',function(r){   
			if (r){   
				 	$.ajax({
				 		type : "POST",
				 		url : "deleteClient",
				 		data : {"id":arr},
				 		success : function(){
				 			$("#clients").datagrid("reload");
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