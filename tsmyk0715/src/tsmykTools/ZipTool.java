package tsmykTools;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.apache.tools.zip.ZipOutputStream;

public class ZipTool {

	/**
	 * 压缩
	 * @param source 要压缩的文件，压缩后的zip文件名和路径与源文件相同, {E:\\哈哈.txt}
	 * @throws IOException
	 */
	public static void zip(String source) throws IOException{
		File sourceFile = new File(source);
		String fileName = sourceFile.getName();
		zip(source, fileName);
	}
	/**
	 * 压缩
	 * @param source 要压缩的文件或文件夹的路径  {E:\\哈哈.txt}
	 * @param zipFileName 压缩后的zip文件名,可以输入带有路径和不带有路径的形式  {E:\\哈哈 或 哈哈}
	 * @throws IOException
	 */
	public static void zip(String source, String zipFileName) throws IOException {
		File f = new File(source);
		String[] splitStr = zipFileName.split(":");
		if(splitStr.length > 1){
			//输入压缩的文件名带有路径的形式 : E:\\哈哈
			zipFileName = zipFileName + ".zip";
		}else{
			//输入压缩的文件名不带有路径的形式 : 哈哈
			String path = f.getAbsolutePath();
			
			path = path.substring(0, path.lastIndexOf("\\"));
			
			zipFileName = path + File.separator +zipFileName + ".zip";
		}
		ZipOutputStream zos = new ZipOutputStream(new File(zipFileName));
		zos.setEncoding("gb2312");
		if (f.isDirectory()) {
			//文件夹
			zipDirectory(source, zos, f.getName() + "/");
		} else {
			// 如果直接压缩文件
			zipDirectory(f.getPath(), zos, new File(f.getParent()).getName() + "/");
			zipFile(f.getPath(), zos, new File(f.getParent()).getName() + "/" + f.getName());
		}
		zos.closeEntry();
		zos.close();
	}

	/**
	 * 解压
	 * @param sourceFileName  要解压的zip文件  {E:\\哈哈.zip}
	 * @param desDir  解压后存放文件的路径 {E:\\ 或  E:\\哈哈->解压到哈哈文件夹下}
	 * @throws IOException  可能抛出的异常
	 */
	 public static void unZip(String sourceFileName, String desDir)
	         throws IOException {
	     // 创建压缩文件对象
	     ZipFile zf = new ZipFile(new File(sourceFileName));
	     // 获取压缩文件中的文件枚举
	     Enumeration<ZipEntry> en = zf.getEntries();
	     int length = 0;
	     byte[] b = new byte[2048];
	    // 提取压缩文件夹中的所有压缩实例对象
	     while (en.hasMoreElements()) {
	         ZipEntry ze = en.nextElement();
	         File f = new File(desDir + ze.getName());
	         if (ze.isDirectory()) {
	        	 f.mkdirs();
	         } else {
	             // 如果当前解压缩文件的父级文件夹没有创建的话，则创建好父级文件夹
	             if (!f.getParentFile().exists()) {
	            	 f.getParentFile().mkdirs();
                 }
		         // 将当前文件的内容写入解压后的文件夹中。
		         OutputStream outputStream = new FileOutputStream(f);
	             InputStream inputStream = zf.getInputStream(ze);
		         while ((length = inputStream.read(b)) > 0){
	                  outputStream.write(b, 0, length);
		         }
	             inputStream.close();
	             outputStream.close();
	         }
	     }
	    zf.close();
	 }
	 
	private static void zipFile(String sourceFileName, ZipOutputStream zos, 
								String tager) throws IOException {
		ZipEntry ze = new ZipEntry(tager);
		zos.putNextEntry(ze);
		// 读取要压缩文件并将其添加到压缩文件中
		FileInputStream fis = new FileInputStream(new File(sourceFileName));
		BufferedInputStream bis = new BufferedInputStream(fis);
		byte[] bf = new byte[2048];
		int location = 0;
		while ((location = bis.read(bf)) != -1) {
			zos.write(bf, 0, location);
		}
		fis.close();
	}

	private static void zipDirectory(String sourceDir, ZipOutputStream zos, String tager) throws IOException {
		ZipEntry ze = new ZipEntry(tager);
		zos.putNextEntry(ze);
		// 提取要压缩的文件夹中的所有文件
		File f = new File(sourceDir);
		File[] flist = f.listFiles();
		if (flist != null) {
			// 如果该文件夹下有文件则提取所有的文件进行压缩
			for (File fsub : flist) {
				if (fsub.isDirectory()) {
					// 如果是目录则进行目录压缩
					zipDirectory(fsub.getPath(), zos, tager + fsub.getName() + "/");
				} else {
					// 如果是文件，则进行文件压缩
					zipFile(fsub.getPath(), zos, tager + fsub.getName());
				}
			}
		}
	}
}
