$(function(){
	//添加“查询”按钮事件监听
	$("#search").click(searchBtnAction);
	//添加“清空”按钮事件监听
	$("#clear").click(clearBtnAction);
	//添加“导出”按钮事件监听
	$("#exportInfoExcel").click(exportExcelAction);
	
	/**
	 * 查询提交按钮的监听函数
	 * @returns
	 */
	function searchBtnAction(){
		var $number = $("#search_number").val().trim();
		var $name = $("#search_name").val().trim();
		var $place = $("#search_place").val().trim();
		$('#goods').datagrid('load',{
			number:$number,
			name:$name,
			place:$place,
		});
	}
	
	/**
	 * 清空按钮的监听函数
	 */
	function clearBtnAction(){
		$("#search_number").val("");
		$("#search_name").val("");
		$("#search_place").val("");
	}
	
	
	/**
	 * 导出按钮的监听函数
	 */
	function exportExcelAction(){
	  $.ajax({
	        type: "POST",
	        url: "exportInfoExcel",
	        contentType: "application/text; charset=utf-8",
	        success: function () {          
	            //$("#stockOut").datagrid("reload");
	        },
	    	error:function(){
	    		$.messager.alert("提示！", "系统错误！");
	    	}
	  })
	}
})