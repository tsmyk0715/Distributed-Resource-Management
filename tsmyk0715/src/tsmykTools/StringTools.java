package tsmykTools;

/**
 * 字符串处理工具
 * @author mengyuankan
 * @version 1.0
 * @see StringTools
 * @since 
 *
 */
public class StringTools {
	
	/**
	 * 判断是否为 null
	 * @param obj
	 * @return {true/false}
	 */
	public static boolean isNull(Object obj){
		return (obj == null || "null".equals(obj.toString().trim()) || "".equals(obj.toString().trim()));
	}
	
	/**
	 * 判断是否不为null
	 * @param obj
	 * @return {true/false}
	 */
	public static boolean isNotNull(Object obj){
		return !isNull(obj);
	}
	/**
	 * 判断是否不为null
	 * @param str
	 * @return {true/false}
	 */
	public static boolean isNotNull(String str){
		return !isNull(str);
	}
	
}
