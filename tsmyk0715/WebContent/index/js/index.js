function doSubmit(){
    var $username = $(".txtusernamecssclass").val();
    var $password = $(".txtpasswordcssclass").val();
    var $identify = $("#DropExpiration").val();
    if(isEmpty($username)){
        $(".errorMessageClass").text("用户名不能为空！");
        return false;
    }else{
        if(isNaN($username) || !isInt($username) || $username.length != 6){
            $(".errorMessageClass").text("用户名不正确，为6位数字！");
            return false;
        }
    }
    if(isEmpty($password)){
        $(".errorMessageClass").text("密码不能为空！");
        return false;
    }else{
        if($password.length > 16 || $password.length < 6){
            $(".errorMessageClass").text("密码长度为6~16个字符！");
            return false;
        }
    }
    if(isEmpty($identify)){
        $(".errorMessageClass").text("请选择身份！");
        return false;
    }
    return true;
}
