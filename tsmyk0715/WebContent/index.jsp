<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
					"http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>分销资源管理系统</title>
<link href="index/css/login.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="common/js/jquery.min.js"></script>
<script type="text/javascript" src="common/js/tools.js"></script>
<script type="text/javascript" src="index/js/index.js"></script>
<script type="text/javascript">
if (window != top) {  
    top.location.href = location.href;  
}
</script>
</head>
<body id="userlogin_body" background="#e4ebeb" bgcolor="#ececec">
 <form action="doLogin" method="post" onsubmit="return doSubmit();">
  <div id="user_login">
	<dl>
	  <dd id="user_top">
		<ul>
		  <li class="user_top_l"></li>
		  <li class="user_top_c"></li>
		  <li class="user_top_r"></li>
		</ul>
	  </dd>
	  <dd id="user_main">
		<ul>
		  <li class="user_main_l"></li>
		  <li class="user_main_c">
		    <div class="user_main_box">
			  <ul>
				<li class="user_main_text">用户名： </li>
				<li class="user_main_input">
				  <input name="TxtUserName" maxlength="6" id="TxtUserName" class="txtusernamecssclass"> 
				</li>
			  </ul>
			  <ul>
			    <li class="user_main_text">密&nbsp;&nbsp;&nbsp;&nbsp;码： </li>
			    <li class="user_main_ input">
			      <input type="password" name="TxtPassword" id="TxtPassword" class="txtpasswordcssclass">
			     </li>
			  </ul>
			  <ul>
				<li class="user_main_text">身&nbsp;&nbsp;&nbsp;&nbsp;份： </li>
				<li class="user_main_input">
				  <select name="identitfy" id="DropExpiration"> 
				    <option selected="" value="">请选择身份</option>
				    <option value="admin">系统管理员</option> 
				    <option value="general_manager">总部</option> 
				    <option value="area_manager">一级分销商</option>
				    <option value="province_manager">二级分销商</option>
				    <!-- <option value="city_manager">三级分销商</option> -->
				  </select>
				 </li>
			  </ul>
			  <ul style="height: 15px;">
			    <li></li>
			  </ul>
			  <ul style="margin-left: 60px;">
			  	<li><font class="errorMessageClass">${errorMessage}</font></li>
			  </ul>
			</div>
		  </li>
		  <li class="user_main_r">
		    <input type="image" name="IbtnEnter" src="index/images/user_botton.gif" class="ibtnentercssclass">
		   </li>
		</ul>
	  </dd>
	  <dd id="user_bottom">
	    <ul>
	      <li class="user_bottom_l"></li>
		  <li class="user_bottom_c"></li>
		  <li class="user_bottom_r"></li>
	    </ul>
	  </dd>
	</dl>
</div>
</form>
</body>
</html>