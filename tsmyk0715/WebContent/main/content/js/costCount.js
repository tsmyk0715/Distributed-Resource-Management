
jQuery(document).ready(function(){
    jQuery(".mytab tr:first-child").find("th:first").addClass("ltb").end().find("th:last").addClass("rtb");
    jQuery(".mytab tr:even").find("td").addClass("td_bg");//给表格0、2、4、6偶数行的每列加背景颜色。表格行从0开始计
    jQuery(".mytab tr").find("td:first").addClass("l_bor");//给表格每行的列前都加丨线条，否则没有单元分隔线
    jQuery(".mytab tr").css("background","#ffffff").hover(
            function(){
                    this.className="write";
            },
            function(){
                    this.className="";
            }
    );
})

//检测字符串是否是整数
function isNumber(s){
	if (typeof(s) === "number") {
		return true;
	}
	var reg = /^([1-9]+[0-9]*)$/g;
	reg.lastIndex = 0;
	return reg.test(s);
}
/**
 * 修改返点费用的验证
 */
function vaildateInput(){
	var value = $("#inputText").val();
	if(value == null || value == ''){
		$("#tipMsg").text("请输入返点!");
		return false;
	}else{
		if(!isNumber(value)){
			$("#tipMsg").text("返点为数字!");
			return false;
		}else if(value < 0 || value > 100){
			$("#tipMsg").text("返点为1~100内的数字!");
			return false;
		}
	}
	return true;
}

