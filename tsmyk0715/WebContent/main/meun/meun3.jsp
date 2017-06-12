<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript" src="/tsmyk0715/common/js/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
		$(".div2").click(function(){ 
			$(this).next("div").slideToggle("slow")  
			.siblings(".div3:visible").slideUp("slow");
		});
});
</script>
<style>

body{margin:0;font-family:微软雅黑,黑体,宋体;}
.left{ 
	width:270px; 
	height:600px; 
	border-right:1px solid #CCCCCC ;#FFFFFF;
	font-size:14px; 
	text-align:left;
	background-color:#222d32;	
	color:#82a4d6;
	letter-spacing:2px;
}
.div1{
	text-align:center; 
	width:270px; 
	padding-top:10px;
}
.div2{
	height:40px; 
	line-height:40px;
	cursor: pointer; 
	font-size:14px; 
	position:relative;
	border-bottom:#ccc 1px dotted;
}
.jbsz {position: absolute; height: 20px; width: 20px; left: 20px; top: 10px; background:url(images/11.png);}
.xwzx {position: absolute; height: 20px; width: 20px; left: 20px; top: 10px; background:url(images/22.png);}
.zxcp {position: absolute; height: 20px; width: 20px; left: 20px; top: 10px; background:url(images/44.png);}
.lmtj {position: absolute; height: 20px; width: 20px; left: 20px; top: 10px; background:url(images/88.png);}
.config {position: absolute; height: 20px; width: 20px; left: 20px; top: 10px; background:url(images/99.png);}
.init {position: absolute; height: 20px; width: 20px; left: 20px; top: 10px; background:url(images/1.png);}

.div3{
	display: none;
	cursor:pointer; 
	font-size:13px;
	background-color:#222d39;
}
.div3 ul{margin:0;padding:0;}
.div3 li{ 
	height:35px; 
	line-height:30px; 
	list-style:none; 
	border-bottom:#ccc 1px dotted; 
	text-align:left;
}
.div3 li a{
	margin-left:35px;
}
.divd4{
	text-align:left; 
	margin-left:50px;
}

em{
	margin-left:1px;
}

a:link { text-decoration:none;color:#82a4d6}

a:hover { text-decoration:none;color:white} 

a:visited { text-decoration: none;color: #82a4d6}

</style>
</head>
<body>
<div class="left">
<div class="div1">
	<div class="left_top" style="margin-left: 10px;float: left;">
		<img src="images/gly.png" id="2">&nbsp;
		<div style="float: right; margin-top: 15px;">
    		${sessionScope.currentUserRole}
    	</div>		
	</div>
	<br><br><br>
	<div class="div2">
		<div class="jbsz"> 
		</div>
		<div class="divd4" onmouseover="this.style.color='white'"
			onmouseout="this.style.color='#82a4d6'">库存管理</div>
	</div>
	<div class="div3">
		<ul>
			<li>
				<a href="../../exportAllExcel" target="content">
					<img src="images/save.png">
					<em onmouseover="this.style.color='white'"
			onmouseout="this.style.color='#82a4d6'">打印所有库存信息</em>
				</a>
			</li>
		</ul>
	</div>
    <div class="div2"><div class="xwzx"> </div>
		<div class="divd4" onmouseover="this.style.color='white'"
			onmouseout="this.style.color='#82a4d6'">订单管理</div>
	</div>
    <div class="div3">
		<ul>
			<li>
				<a href="../../exportAllOrderExcel" target="content">
					<img src="images/save.png">
					<em onmouseover="this.style.color='white'"
			onmouseout="this.style.color='#82a4d6'">打印所有订单信息</em>
				</a>
			</li>
        </ul>
	</div>
    <div class="div2"><div class="zxcp"> </div>
		<div class="divd4" onmouseover="this.style.color='white'"
			onmouseout="this.style.color='#82a4d6'">分销渠道管理</div>
	</div>
    <div class="div3">
		<ul>
			<li>
				<a href="../../exportAllClientExcel" target="content">
					<img src="images/save.png">
					<em onmouseover="this.style.color='white'"
			onmouseout="this.style.color='#82a4d6'">打印所有分销商信息</em>
				</a>
			</li>
        </ul>
	</div>
	<div class="div2"><div class="lmtj"> </div> 
		<div class="divd4" onmouseover="this.style.color='white'"
			onmouseout="this.style.color='#82a4d6'">数据统计管理</div>
	</div>
    <div class="div3">
		<ul>
			<li>	
				<a href="../../exportAllStoreExcel" target="content">
					<img src="images/save.png">
					<em onmouseover="this.style.color='white'"
			onmouseout="this.style.color='#82a4d6'">打印所有库存报表</em>
				</a>
			</li>
        </ul>
	</div>
	<div class="div2" onmouseover="this.style.color='white'" onmouseout="this.style.color='#82a4d6'">
		<div class="config"> </div> 
		<div class="divd4" >系统设置模块</div> 
	</div>
    <div class="div3">
		<ul>
			<li>
				<a href="../../userManager" target="content">
					<img src="images/usermanager.png">
					<em onmouseover="this.style.color='white'"
			onmouseout="this.style.color='#82a4d6'">用户管理</em>
				</a>
			</li>
			<li>
				<a href="../../passwordFix" target="content">
					<img src="images/pwdfix.png">
					<em onmouseover="this.style.color='white'"
			onmouseout="this.style.color='#82a4d6'">个人信息修改</em>
				</a>
			</li>
        </ul>
	</div>
</div>
</div>
</body>
</html>