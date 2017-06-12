$(function(){
	
	//添加“查询”按钮事件监听
	$("#search").click(searchBtnAction);
	//添加“清空条件”按钮事件监听
	$("#clear").click(clearBtnAction);
	
	/**
	 * 查询提交按钮的监听函数
	 * @returns
	*/
	function searchBtnAction(){
		var $start_yingfu = $("#start_yingfu").val().trim();
		var $end_yingfu = $("#end_yingfu").val().trim();
		var $start_fandian = $("#start_fandian").val().trim();
		var $end_fandian = $("#end_fandian").val().trim();
		var $start_shiji = $("#start_shiji").val().trim();
		var $end_shiji = $("#end_shiji").val().trim();
		$('#costCount').datagrid('load',{
			start_yingfu:$start_yingfu,
			end_yingfu:$end_yingfu,
			start_fandian:$start_fandian,
			end_fandian:$end_fandian,
			start_shiji:$start_shiji,
			end_shiji:$end_shiji
		});
	}
	
	/**
	 * "清空条件按钮的监听函数"
	 */
	function clearBtnAction(){
		$("#start_yingfu").val("");
		$("#end_yingfu").val("");
		$("#start_fandian").val("");
		$("#end_fandian").val("");
		$("#start_shiji").val("");
		$("#end_shiji").val("");
	}
})