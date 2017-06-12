package tsmykTools;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFComment;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.ClientAnchor.AnchorType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;

/**
 * POI导出Excel文档, POI版本:3.15
 * @author mengyuankan
 * @version 1.0
 * @see ExportExcel
 * @since
 */
public class ExportExcel{
	
	private static final String CLASS_PATH = 
			StringUtils.substringBeforeLast(ExportExcel.class.getResource("//").getPath(), "/");
	
	private static final String TEMP_PATH = "/temp";

	/**
	 * 导出Excel
	 * @param headers 表格属性列名数组
	 * @param dataset 需要显示的数据集合(集合中的对象符合javabean格式 )
	 * @param exportExcelName 导出excel的名字 
	 */
	public static <T> void exportExcel(String[] headers, Collection<T> dataset,
			String exportExcelName,HttpServletResponse response) {
		exportExcel("sheet1", headers, dataset, exportExcelName, "yyyy-MM-dd",response);
	}

	/**
	 * 导出Excel
	 * @param headers 表格属性列名数组
	 * @param dataset 需要显示的数据集合(集合中的对象符合javabean格 )
	 * @param exportExcelName 导出excel的名字 
	 * @param timePatern 如果有时间数据，设定输出格式
	 */
	public static <T> void exportExcel(String[] headers, Collection<T> dataset,
			String exportExcelName, String timePatern,
			HttpServletResponse response) {
		exportExcel("sheet", headers, dataset, exportExcelName, timePatern,response);
	}
	
	/**
	 * 导出Excel
	 * @param sheetName 表格标题名 
	 * @param headers 表格属性列名数组
	 * @param dataset 需要显示的数据集合(集合中的对象符合javabean格 )
	 * @param exportExcelName 导出excel的名字
	 */
	public static <T> void exportExcel(String sheetName, String[] headers, 
			Collection<T> dataset,String exportExcelName,
			HttpServletResponse response) {
		exportExcel(sheetName, headers, dataset, exportExcelName, "yyyy-MM-dd",response);
	}

	 /** 
     *  导出Excel
     * @param sheetName 表格标题名 
     * @param headers 表格属性列名数组
     * @param dataset 需要显示的数据集合(集合中的对象符合javabean格 )
     * @param exportExcelName 导出excel的名字
     * @param timePattern 如果有时间数据，设定输出格式
     * @param response 
     */ 
	@SuppressWarnings("unchecked")
	public  static <T>  void exportExcel(String sheetName, String[] headers,
			Collection<T> dataset, String exportExcelName, String timePattern,
			HttpServletResponse response) {
		// 声明一个工作薄
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 生成一个表格
		HSSFSheet sheet = workbook.createSheet(sheetName);
		// 设置表格默认列宽度为15个字节
		sheet.setDefaultColumnWidth(15);
		// 生成一个样式
		HSSFCellStyle style = workbook.createCellStyle();
		// 设置这些样式
		style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setBorderBottom(BorderStyle.THIN);
		style.setBorderLeft(BorderStyle.THIN);
		style.setBorderRight(BorderStyle.THIN);
		style.setBorderTop(BorderStyle.THIN);
		style.setAlignment(HorizontalAlignment.CENTER);
		// 生成一个字体
		HSSFFont font = workbook.createFont();
		font.setColor(HSSFColor.VIOLET.index);
		font.setFontHeightInPoints((short) 12);
		font.setBold(true);
		// 把字体应用到当前的样式
		style.setFont(font);
		// 生成并设置另一个样式
		HSSFCellStyle style2 = workbook.createCellStyle();
		style2.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
		style2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style2.setBorderBottom(BorderStyle.THIN);
		style2.setBorderLeft(BorderStyle.THIN);
		style2.setBorderRight(BorderStyle.THIN);
		style2.setBorderTop(BorderStyle.THIN);
		style2.setAlignment(HorizontalAlignment.CENTER);
		style2.setVerticalAlignment(VerticalAlignment.CENTER);
		// 生成另一个字体
		HSSFFont font2 = workbook.createFont();
		font2.setBold(true);
		// 把字体应用到当前的样式
		style2.setFont(font2);
		// 声明一个画图的顶级管理器
		HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
		// 定义注释的大小和位置,详见文档
		HSSFComment comment = patriarch.createComment(new HSSFClientAnchor(0,
				0, 0, 0, (short) 4, 2, (short) 6, 5));
		// 设置注释内容
		comment.setString(new HSSFRichTextString("可以添加注释！"));
		// 设置注释作者，当鼠标移动到单元格上是可以在状态栏中看到该内容.
		comment.setAuthor("myk");
		// 产生表格标题行
		HSSFRow row = sheet.createRow(0);
		for (short i = 0; i < headers.length; i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellStyle(style);
			HSSFRichTextString text = new HSSFRichTextString(headers[i]);
			cell.setCellValue(text);
		}
		// 遍历集合数据，产生数据行
		Iterator<T> it = dataset.iterator();
		int index = 0;
		while (it.hasNext()) {
			index++;
			row = sheet.createRow(index);
			T t = (T) it.next();
			// 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
			Field[] fields = t.getClass().getDeclaredFields();
			for (short i = 0; i < fields.length; i++) {
				HSSFCell cell = row.createCell(i);
				cell.setCellStyle(style2);
				Field field = fields[i];
				String fieldName = field.getName();
				String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
				try {
					Class<T> tCls = (Class<T>) t.getClass();
					Method getMethod = tCls.getMethod(getMethodName, new Class[] {});
					Object value = getMethod.invoke(t, new Object[] {});
					// 判断值的类型后进行强制类型转换
					String textValue = null;
					if (value instanceof Integer) {
						int intValue = (Integer) value;
						cell.setCellValue(intValue);
					} else if (value instanceof Float) {
						float fValue = (Float) value;
						 cell.setCellValue(fValue);
					} else if (value instanceof Double) {
						 double dValue = (Double) value;
						 cell.setCellValue(dValue);
					} else if (value instanceof Long) {
						 long longValue = (Long) value;
						 cell.setCellValue(longValue);
					} else if (value instanceof Date) {
						Date date = (Date) value;
						SimpleDateFormat sdf = new SimpleDateFormat(timePattern);
						textValue = sdf.format(date);
					}else if (value instanceof byte[]) {
						// 有图片时，设置行高为60px;
						row.setHeightInPoints(60);
						// 设置图片所在列宽度为80px,注意这里单位的一个换算
						sheet.setColumnWidth(i, (short) (35.7 * 80));
						// sheet.autoSizeColumn(i);
						byte[] bsValue = (byte[]) value;
						HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0,
								1023, 255, (short) 6, index, (short) 6, index);
						anchor.setAnchorType(AnchorType.MOVE_DONT_RESIZE);
						patriarch.createPicture(anchor, workbook.addPicture(
								bsValue, HSSFWorkbook.PICTURE_TYPE_JPEG));
					} else {
						// 其它数据类型都当作字符串简单处理
						textValue = value.toString();
					}
					// 如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成
					if (textValue != null) {
						Pattern p = Pattern.compile("^//d+(//.//d+)?$");
						Matcher matcher = p.matcher(textValue);
						if (matcher.matches()) {
							// 是数字当作double处理
							cell.setCellValue(Double.parseDouble(textValue));
						} else {
							HSSFRichTextString richString = new HSSFRichTextString(
									textValue);
							HSSFFont font3 = workbook.createFont();
							font3.setColor(HSSFColor.BLUE.index);
							richString.applyFont(font3);
							cell.setCellValue(richString);
						}
					}
					//return workbook;
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				} 
			}
		}
		OutputStream out = null;
		try {
			String tempPath = new StringBuffer(
					ExportExcel.CLASS_PATH).
					append(ExportExcel.TEMP_PATH).
					append("/").toString();
			new File(tempPath).delete();
			new File(tempPath).mkdirs();
			String filePath = tempPath + exportExcelName + ".xls";
			out = new FileOutputStream(filePath);
			workbook.write(out);
			download(filePath, response);;
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
		OutputStream out = null;
		InputStream fis = null;
		try {  
            // path是指欲下载的文件的路径。  
            File file = new File(downLoadFilePath);  
            // 取得文件名。  
            String filename = file.getName();  
            // 以流的形式下载文件。  
            fis = new BufferedInputStream(new FileInputStream(downLoadFilePath));  
            byte[] buffer = new byte[fis.available()];  
            fis.read(buffer);  
            // 清空response  
            response.reset();  
            // 设置response的Header  
            response.addHeader("Content-Disposition", "attachment;filename="  
                    + new String(filename.getBytes()));  
            response.addHeader("Content-Length", "" + file.length());  
            out = new BufferedOutputStream(response.getOutputStream());  
            response.setContentType("application/vnd.ms-excel;charset=gb2312");  
            out.write(buffer);  
            out.flush();  
        } catch (IOException ex) {  
            ex.printStackTrace();  
        } finally{
        	if(out != null){
        		try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
        	if(fis != null){
        		try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
        } 
    }  
}
