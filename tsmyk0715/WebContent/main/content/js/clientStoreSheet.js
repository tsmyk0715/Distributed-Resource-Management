jQuery(document).ready(function(){
    jQuery(".storeChectSheet tr:first-child").find("th:first").addClass("ltb").end().find("th:last").addClass("rtb");
    jQuery(".storeChectSheet tr:even").find("td").addClass("td_bg");//给表格0、2、4、6偶数行的每列加背景颜色。表格行从0开始计
    jQuery(".storeChectSheet tr").find("td:first").addClass("l_bor");//给表格每行的列前都加丨线条，否则没有单元分隔线
    jQuery(".storeChectSheet tr").css("background","#ffffff").hover(
            function(){
                    this.className="write";
            },
            function(){
                    this.className="";
            }
    );
})