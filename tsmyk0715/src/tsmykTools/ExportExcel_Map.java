package tsmykTools;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public final class ExportExcel_Map {
	
	private static final String CLASS_PATH = 
			StringUtils.substringBeforeLast(ExportExcel_Map.class.getResource("//").getPath(), "/");
	
	private static final String TEMP_PATH = "/temp";
	
	
	/** 
     *  导出Excel
     * @param sheetName sheet名字 
     * @param headers 表格标题列名数组
     * @param dataList 需要显示的数据集合， Map<String, Object> 必须是 LinkedHashMap 才能保证数据与标题才能对得上
     * @param exportExcelName 导出excel的名字
     * @param response 
     */ 
	public static void exportExcel(String sheetName, List<Map<String, Object>> dataList,
				String[] headers,String exportExcelName,HttpServletResponse response) {
		// 声明一个工作薄
		XSSFWorkbook  workbook = new XSSFWorkbook();
		// 生成一个表格
		XSSFSheet sheet = workbook.createSheet(sheetName);
		// 设置表格默认列宽度为15个字节
		sheet.setDefaultColumnWidth(15);
		
		// 生成表格中非标题栏的样式
		XSSFCellStyle style = workbook.createCellStyle();
		// 设置这些样式
		style.setFillForegroundColor(HSSFColor.WHITE.index);//背景色
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setBorderBottom(BorderStyle.THIN);
		style.setBorderLeft(BorderStyle.THIN);
		style.setBorderRight(BorderStyle.THIN);
		style.setBorderTop(BorderStyle.THIN);
		style.setAlignment(HorizontalAlignment.CENTER);
		// 生成表格中非标题栏的字体
		XSSFFont font = workbook.createFont();
		font.setColor(HSSFColor.BLACK.index);
		font.setFontHeightInPoints((short) 12);
		font.setBold(true);
		// 把字体应用到当前的样式
		style.setFont(font);
		
		// 设置表格标题栏的样式
		XSSFCellStyle titleStyle = workbook.createCellStyle();
		titleStyle.setFillForegroundColor(HSSFColor.BLUE_GREY.index);
		titleStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		titleStyle.setBorderBottom(BorderStyle.THIN);
		titleStyle.setBorderLeft(BorderStyle.THIN);
		titleStyle.setBorderRight(BorderStyle.THIN);
		titleStyle.setBorderTop(BorderStyle.THIN);
		titleStyle.setAlignment(HorizontalAlignment.CENTER);
		titleStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		// 设置标题栏字体
		XSSFFont titleFont = workbook.createFont();
		titleFont.setColor(HSSFColor.WHITE.index);
		titleFont.setFontHeightInPoints((short) 12);
		titleFont.setBold(true);
		// 把字体应用到当前的样式
		titleStyle.setFont(titleFont);
		
		// 声明一个画图的顶级管理器
		//XSSFDrawing patriarch = sheet.createDrawingPatriarch();
		// 定义注释的大小和位置
		//XSSFComment comment = patriarch.createCellComment(
		//							new XSSFClientAnchor(0,0, 0, 0, (short) 4, 2, (short) 6, 5));
		// 设置注释内容
		//comment.setString(new XSSFRichTextString("可以添加注释！"));
		// 设置注释作者，当鼠标移动到单元格上是可以在状态栏中看到该内容.
		//comment.setAuthor("myk0715");
		
		// 产生表格标题行
		XSSFRow row = sheet.createRow(0);
		for (short i = 0; i < headers.length; i++) {
			XSSFCell cell = row.createCell(i);
			cell.setCellStyle(titleStyle);
			XSSFRichTextString text = new XSSFRichTextString(headers[i]);
			cell.setCellValue(text);
		}
		// 遍历集合数据，产生数据行
		
		Iterator<Map<String, Object>> it = dataList.iterator();
		int index = 0;
		while (it.hasNext()) {
			index++;
			row = sheet.createRow(index);
			Map<String, Object> data = it.next();
			int i = 0;
			for(String key : data.keySet()){
				XSSFCell cell = row.createCell(i);
				cell.setCellStyle(style);
				XSSFRichTextString text = new XSSFRichTextString(data.get(key)+"");
				cell.setCellValue(text);
				i++;
			}
		}
		OutputStream out = null;
		try {
			String tempPath = new StringBuffer(
					ExportExcel_Map.CLASS_PATH).
					append(ExportExcel_Map.TEMP_PATH).
					append("/").toString();
			new File(tempPath).delete();
			new File(tempPath).mkdirs();
			String filePath = tempPath + exportExcelName + ".xlsx";
			out = new FileOutputStream(filePath);
			workbook.write(out);
			download(filePath, response);
			new File(filePath).delete();//下载完成后删除服务器中的文件
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(workbook != null){
				try {
					workbook.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(out != null){
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private static void download(String downLoadFilePath, HttpServletResponse response) {  
        
		InputStream is = null;
		OutputStream os = null;
		try {  
            // downLoadFilePath是指欲下载的文件的路径。  
            File file = new File(downLoadFilePath);  
            // 以流的形式下载文件。  
            is = new BufferedInputStream(new FileInputStream(downLoadFilePath));  
            byte[] buffer = new byte[is.available()];  
            is.read(buffer);  
            // 清空response  
            response.reset();  
            // 设置response的Header
            String str = System.currentTimeMillis()+"";
            response.addHeader("Content-Disposition", "attachment;filename=" + str + ".xlsx");
            response.addHeader("Content-Length", "" + file.length());  
            os = new BufferedOutputStream(  
                    response.getOutputStream());    
            response.setContentType("application/vnd.ms-excel;charset=gb2312");  
            os.write(buffer);  
            os.flush();  
        } catch (IOException ex) {  
            ex.printStackTrace();  
        } finally{
        	if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
        	if(is != null){
        		try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
        } 
    } 
}
