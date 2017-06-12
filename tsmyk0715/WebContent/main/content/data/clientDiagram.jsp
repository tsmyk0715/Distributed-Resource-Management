<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
<script type="text/javascript" src="../../../tsmyk0715/common/js/echarts.js"></script>
<script type="text/javascript" src="../../../tsmyk0715/common/js/jquery.min.js"></script>
	
<script type="text/javascript">
$().ready(function() {

	/**
	* 饼状图
	*/
    var pie = echarts.init(document.getElementById('pie'));
    //图表显示提示信息
    pie.showLoading();
    //定义图表options
    var options = {
        title : {
            text : '分销商地区分布',
            subtext : '饼状图',
            x : 'center'
        },
        tooltip : {
            trigger : 'item',
            formatter : "{a} <br/>{b} : {c} ({d}%)"
        },
        legend : {
            orient : 'vertical',
            left : 'left',
            data : []
        },
        series : [ {
            name : '访问来源',
            type : 'pie',
            data : []
        } ]
    };
    //通过Ajax获取数据
    $.ajax({
        type : "post",
        async : false, //同步执行
        url : "../../../tsmyk0715/showCilentDistributionPie",
        dataType : "json", //返回数据形式为json
        success : function(result) {
            if (result) {
                options.legend.data = result.legend;
                options.series[0].name = result.series[0].name;
                options.series[0].type = result.series[0].type;
                var serisdata = result.series[0].data;
                //遍历
                /* var datas = [];
                for ( var i = 0; i < serisdata.length; i++) {
                    datas.push({
                        name : serisdata[i].name,
                        value : serisdata[i].value
                    });
                }
                options.series[0].data = datas; */
                //jquery遍历
                var value = [];
                $.each(serisdata, function(i, p) {
                    value[i] = {
                       'name' : p['name'],
                       'value' : p['value']
                    };
                });
                options.series[0]['data'] = value;
                pie.hideLoading();
                pie.setOption(options);
            }
        },
        error : function(errorMsg) {
            alert("图表请求数据失败!");
        }
    });
    
    /**
    * 柱状图
    */
    var bar = echarts.init(document.getElementById('bar'));
    //图表显示提示信息
    bar.showLoading();
    //定义图表options
    var options = {
        color : [ '#3398DB' ],
        title : {
            text : "分销商地址分布图",
            subtext : "柱状图",
            sublink : ""
        },
        tooltip : {
            trigger : 'axis'
        },
        legend : {
            data : []
        },
        toolbox : {
            show : true,
            feature : {
                mark : false
            }
        },
        calculable : true,
        xAxis : [ {
            type : 'category',
            data : []
        } ],
        yAxis : [ {
            type : 'value',
            splitArea : {
                show : true
            }
        } ],
        series : [ {
            barWidth : '60%'
        } ]
    };

    //通过Ajax获取数据
    $.ajax({
        type : "post",
        async : false, //同步执行
        url : "../../../tsmyk0715/showCilentDistributionBar",
        dataType : "json", //返回数据形式为json
        success : function(result) {
            if (result) {
                options.xAxis[0].data = result.category;
                options.series = result.series;
                options.legend.data = result.legend;
                bar.hideLoading();
                bar.setOption(options);
            }
        },
        error : function(errorMsg) {
            alert("图表请求数据失败!");
        }
    });
});
</script>
	
</head>
<body>
	
<div  style="width: 1000px;height:400px;" >
    <div id="pie" style="width: 500px;height:500px;float: left;" ></div>
	
	<div id="bar" style="width: 500px;height:500px;float: right;" ></div>
</div>

</body>
</html>