//myTools 

//是否存在中文
function isExistChinese(str) {
    if(!str || str == ""){
    	return false;
    }
    for(var i = 0; i < str.length; i++){
    	if(str.charCodeAt(i) > 255){
    		return true;
    	}
    }
    return false;
}
//检测字符串是否包含特殊字符
function isExistSpecialChar(str){
	var pattern = new RegExp("[`~!@#$%^&*=|{}':;',\\[\\]<>/？~！@#￥%……&*（）；-|{}【】’；：‘“”’。，、？]");
	var result = str.match(pattern);
	return result;
}
//检测字符串是否是整数
function isNumber(str){
	if (typeof(str) === "number") {
		return true;
	}
	var reg = /^([1-9]+[0-9]*)$/g;
	reg.lastIndex = 0;
	return reg.test(s);
}
//检测是否是合法的邮箱地址
function isEmail(s){
  var reg = /^([-_A-Za-z0-9\.]+)@([_A-Za-z0-9]+\.)+[A-Za-z0-9]{2,3}$/
  reg.lastIndex = 0;
  return reg.test(s);
}
//检测是否是合法的时间
function isTime(s){
	var reg = /^(?:[0-1]\d|2[0-3])(?::[0-5]\d){2}$/g;
	reg.lastIndex = 0;
	return reg.test(s);
}
//检测是否是合法的“年月日时分秒：2017-10-10 10:20:20”的时间格式
function isFullTime(s){
	var reg = /^\d{4}[-]([0][1-9]|(1[0-2]))[-]([1-9]|([012]\d)|(3[01]))([ \t\n\x0B\f\r])(([0-1]{1}[0-9]{1})|([2]{1}[0-4]{1}))([:])(([0-5]{1}[0-9]{1}|[6]{1}[0]{1}))([:])((([0-5]{1}[0-9]{1}|[6]{1}[0]{1})))$/g
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
//是否为int
function isInt(n){
	var str = n.split(".");
	var len = str.length;
	if(len == 1){
		return true;
	}else{
		return false;
	}
}

