package dao;

import java.util.List;
import java.util.Map;

/**
 * 数据统计管理模块数据接口层
 * @author tsmyk0715
 *
 */
public interface DataDao {
	/**
	 * 一月分销售订单
	 * @param userid
	 * @return
	 */
	List<Map<String, Object>> januaryOrder(int userid);
	/**
	 * 二月分销售订单
	 * @param userid
	 * @return
	 */
	List<Map<String, Object>> februaryOrder(int userid);
	/**
	 * 三月分销售订单
	 * @param userid
	 * @return
	 */
	List<Map<String, Object>> marchOrder(int userid);
	
	/**
	 * 死月分销售订单
	 * @param userid
	 * @return
	 */
	List<Map<String, Object>> arpilOrder(int userid);
	
	/**
	 * 五月分销售订单
	 * @param userid
	 * @return
	 */
	List<Map<String, Object>> mayOrder(int userid);
	
	/**
	 * 六月分销售订单
	 * @param userid
	 * @return
	 */
	List<Map<String, Object>> juneOrder(int userid);
	
	/**
	 * 七月分销售订单
	 * @param userid
	 * @return
	 */
	List<Map<String, Object>> julyOrder(int userid);
	
	/**
	 * 八月分销售订单
	 * @param userid
	 * @return
	 */
	List<Map<String, Object>> augustOrder(int userid);
	
	/**
	 * 九月分销售订单
	 * @param userid
	 * @return
	 */
	List<Map<String, Object>> septemberOrder(int userid);
	
	/**
	 * 十月分销售订单
	 * @param userid
	 * @return
	 */
	List<Map<String, Object>> octoberOrder(int userid);
	
	/**
	 * 十一月分销售订单
	 * @param userid
	 * @return
	 */
	List<Map<String, Object>> novemberOrder(int userid);
	
	/**
	 * 十二月分销售订单
	 * @param userid
	 * @return
	 */
	List<Map<String, Object>> decemberOrder(int userid);
	
	/**
	 * 第一季度分销售订单
	 * @param userid
	 * @return
	 */
	List<Map<String, Object>> firstQuarterOrder(int userid);
	
	/**
	 * 第二季度分销售订单
	 * @param userid
	 * @return
	 */
	List<Map<String, Object>> secondQuarterOrder(int userid);
	
	/**
	 * 第三季度分销售订单
	 * @param userid
	 * @return
	 */
	List<Map<String, Object>> thirdQuarterOrder(int userid);
	
	/**
	 * 第四季度分销售订单
	 * @param userid
	 * @return
	 */
	List<Map<String, Object>> fourthQuarterOrder(int userid);

	/**
	 * 查询分销商的库存报表
	 * @param userid
	 * @return
	 */
	List<Map<String, Object>> storeChectSheet(int userid);
	
	/**
	 * 管理员查询所有分销商的库存报表
	 * @return
	 */
	List<Map<String, Object>> allStoreChectSheet() throws Exception;
	
}
