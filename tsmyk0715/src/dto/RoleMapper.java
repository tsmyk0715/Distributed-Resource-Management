package dto;

import java.util.HashMap;
import java.util.Map;

public abstract class RoleMapper {
	
	/**
	 * 系统管理员
	 */
	private static final String ADMIN = "admin";
	/**
	 * 总经理
	 */
	private static final String GENERAL_MANAGER = "general_manager";
	
	/**
	 * 一级分销商
	 */
	private static final String AREA_MANAGER = "area_manager";
	
	/**
	 * 二级分销商
	 */
	private static final String PROVINCE_MANAGER = "province_manager";
	
	/**
	 * 三级分销商
	 */
	private static final String CITY_MANAGER = "city_manager";

	
	
	public static String getRoleName (String roleName){
		Map<String, String> roleNameMap = new HashMap<>(); 
		roleNameMap.put(ADMIN, "系统管理员");
		roleNameMap.put(GENERAL_MANAGER, "总经理");
		roleNameMap.put(AREA_MANAGER, "一级分销商");
		roleNameMap.put(PROVINCE_MANAGER, "二级分销商");
		roleNameMap.put(CITY_MANAGER, "三级分销商");
		return roleNameMap.get(roleName);
	}
}
