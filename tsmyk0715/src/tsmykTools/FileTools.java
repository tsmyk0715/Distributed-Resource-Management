package tsmykTools;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileTools {
	
	/**
	 * 移动文件
	 * @param source 要移动的文件（不是文件夹）
	 * @param dest 移动的路径
	 * @return {true/false}
	 */
	public static boolean moveFile(String source, String dest){
		if(StringTools.isNotNull(source) && StringTools.isNotNull(dest)){
			File sourceFile = new File(source);
			if(!sourceFile.exists()){
				return false;
			}
			File destFile = new File(dest);
			if(!destFile.exists()){
				destFile.mkdirs();
			}
			File newFile = new File(destFile.getAbsolutePath() + 
					       File.separator + sourceFile.getName());
			sourceFile.renameTo(newFile);
			return true;
		}
		return false;
	}
	
	
	/**
	 * 删除指定的文件或目录
	 * @param folderPath 文件或目录的路径
	 * @return {true/false}
	 */
	public static boolean deleteFolder(String folderPath){
		try {
			File file = new File(folderPath);
			if(!file.exists()){
				return true;
			}else{
				if(file.isFile()){
					return deleteFile(folderPath);
				}else{
					return deleteDirectoy(folderPath);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private static boolean deleteFile(String filePath) throws Exception {
		File file = new File(filePath);
		if(!file.exists()){
			return true;
		}else if(file.isFile()){
			return file.delete();
		}
		return false;
	}

	private static boolean deleteDirectoy(String directoryPath) throws Exception {
		String filePath = directoryPath;
		if(!filePath.endsWith(File.separator)){
			filePath += File.separator;
		}
		File destFile = new File(filePath);
		if(!destFile.exists()){
			return true;
		}else if(destFile.isDirectory()){
			File[] files = destFile.listFiles();
			boolean flag = false;
			for (int i = 0; i < files.length; i++) {
				if(files[i].isFile()){
					flag = deleteFile(files[i].getAbsolutePath());
					if(!flag){
						break;
					}
				}else{
					flag = deleteDirectoy(files[i].getAbsolutePath());
					if(!flag){
						break;
					}
				}
			}
			if(!flag){
				return false;
			}
			return destFile.delete();
		}
		return false;
	}

	/**
	 * 关闭输出流
	 * @param os 输出流
	 */
	public static void closeOutputStream(OutputStream os){
		if(os != null){
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 关闭输入流
	 * @param is 输入流
	 */
	public static void colseInputStream(InputStream is){
		if(is != null){
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
