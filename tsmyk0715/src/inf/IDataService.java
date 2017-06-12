package inf;

import java.util.List;
import java.util.Map;

/**
 * 数据统计管理模块service接口层
 * @author tsmyk0715
 *
 */
public interface IDataService {
	/**
	 * 一月分销售订单
	 * @param userid
	 * @return
	 * @throws Exception 
	 */
	List<Map<String, Object>> januaryOrder(int userid) throws Exception;
	/**
	 * 二月分销售订单
	 * @param userid
	 * @return
	 */
	List<Map<String, Object>> februaryOrder(int userid) throws Exception;
	/**
	 * 三月分销售订单
	 * @param userid
	 * @return
	 */
	List<Map<String, Object>> marchOrder(int userid) throws Exception;
	
	/**
	 * 死月分销售订单
	 * @param userid
	 * @return
	 */
	List<Map<String, Object>> arpilOrder(int userid) throws Exception;
	
	/**
	 * 五月分销售订单
	 * @param userid
	 * @return
	 */
	List<Map<String, Object>> mayOrder(int userid) throws Exception;
	
	/**
	 * 六月分销售订单
	 * @param userid
	 * @return
	 */
	List<Map<String, Object>> juneOrder(int userid) throws Exception;
	
	/**
	 * 七月分销售订单
	 * @param userid
	 * @return
	 */
	List<Map<String, Object>> julyOrder(int userid) throws Exception;
	
	/**
	 * 八月分销售订单
	 * @param userid
	 * @return
	 */
	List<Map<String, Object>> augustOrder(int userid) throws Exception;
	
	/**
	 * 九月分销售订单
	 * @param userid
	 * @return
	 */
	List<Map<String, Object>> septemberOrder(int userid) throws Exception;
	
	/**
	 * 十月分销售订单
	 * @param userid
	 * @return
	 */
	List<Map<String, Object>> octoberOrder(int userid) throws Exception;
	
	/**
	 * 十一月分销售订单
	 * @param userid
	 * @return
	 */
	List<Map<String, Object>> novemberOrder(int userid) throws Exception;
	
	/**
	 * 十二月分销售订单
	 * @param userid
	 * @return
	 */
	List<Map<String, Object>> decemberOrder(int userid) throws Exception;
	
	/**
	 * 第一季度分销售订单
	 * @param userid
	 * @return
	 */
	List<Map<String, Object>> firstQuarterOrder(int userid) throws Exception;
	
	/**
	 * 第二季度分销售订单
	 * @param userid
	 * @return
	 */
	List<Map<String, Object>> secondQuarterOrder(int userid) throws Exception;
	
	/**
	 * 第三季度分销售订单
	 * @param userid
	 * @return
	 */
	List<Map<String, Object>> thirdQuarterOrder(int userid) throws Exception;
	
	/**
	 * 第四季度分销售订单
	 * @param userid
	 * @return
	 */
	List<Map<String, Object>> fourthQuarterOrder(int userid) throws Exception;

	/**
	 * 查询分销商的库存报表
	 * @param userid
	 * @return
	 */
	List<Map<String, Object>> storeChectSheet(int userid) throws Exception;
	
	/**
	 * 管理员查询所有分销商的库存报表
	 * @return
	 */
	List<Map<String, Object>> allStoreChectSheet() throws Exception;
	
}
