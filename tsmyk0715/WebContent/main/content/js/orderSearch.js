$(function(){
	
	//添加“查询”按钮事件监听
	$("#search").click(searchBtnAction);
	//添加“查询”按钮事件监听
	$("#clear").click(clearBtnAction);
	
	/**
	 * 查询提交按钮的监听函数
	 * @returns
	*/
	function searchBtnAction(){
		var $number = $("#search_number").val().trim();
		var $client = $("#search_client").val().trim();
		var $name = $("#search_name").val().trim();
		var $orderTime = $("#search_orderTime").val().trim();
		var $sendTime = $("#search_sendTime").val().trim();
		var $payType = $("#search_payType").val().trim();
		$('#orders').datagrid('load',{
			number:$number,
			client:$client,
			name:$name,
			orderTime:$orderTime,
			sendTime:$sendTime,
			payType:$payType
		});
	}
	
	function clearBtnAction(){
		$("#search_number").val("");
		$("#search_client").val("");
		$("#search_name").val("");
		$("#search_orderTime").val("");
		$("#search_sendTime").val("");
		$("#search_payType").val("");
	}
})