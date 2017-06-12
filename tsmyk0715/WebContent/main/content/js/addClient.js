//检测字符串是否是整数
function isNumber(s){
	if (typeof(str) === "number") {
		return true;
	}
	var reg = /^([1-9]+[0-9]*)$/g;
	reg.lastIndex = 0;
	return reg.test(s);
}
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

function checkInput(){
	var number = $("#number").val();
	if(isEmpty(number)){
		$("#numberMsg").text("请输入客户编号！");
		return false;
	}else{
		$("#numberMsg").text("");
	}
	if(!isEmpty(number) && !isNumber(number)){
		$("#numberMsg").text("客户编号为数字！");
		return false;
	}
	
	var clientName = $("#customerName").val();
	if(clientName == null || clientName == ''){
		$("#customerNamerMsg").text("请输入客户名称！");
		return false;
	}else{
		$("#customerNamerMsg").text('');
	}
	
	var telephone = $("#telephone").val();
	if(isEmpty(telephone)){
		$("#telephoneMsg").text("请输入客户电话！");
		return false;
	}else{
		$("#telephoneMsg").text("");
	}
	if(!isEmpty(telephone) && !isPhone(telephone)){
		$("#telephoneMsg").text("客户电话输入有误！");
		return false;
	}
	
	var phone = $("#phone").val();
	if(!isEmpty(phone) && !isPhone(phone)){
		$("#phoneMsg").text("联系人电话输入有误！");
		return false;
	}
	
	var email = $("#email").val();
	if(!isEmpty(email) && !isEmail(email)){
		$("#emailMsg").text("邮箱格式输入有误！");
		return false;
	}
	return true;
}