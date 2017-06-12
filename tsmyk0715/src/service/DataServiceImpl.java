package service;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.DataDao;
import inf.IDataService;

/**
 * 数据统计管理模块service实现
 * @author tsmyk0715
 *
 */

@Service(value="dataService")
public class DataServiceImpl implements IDataService{

	/**
	 * 自动注入 DataDao
	 */
	@Autowired
	private DataDao dataDao;
	
	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(DataServiceImpl.class);
	
	
	/**
	 * 一月分销售订单
	 * @param userid
	 * @return
	 */
	@Override
	public List<Map<String, Object>> januaryOrder(int userid) throws Exception{
		
		logger.debug("DataService，查询 一月份销售订单。。。");
		
		try {
			
			List<Map<String, Object>> list = dataDao.januaryOrder(userid);
			 
			logger.debug("DataService，查询 一月份销售订单,查询结果为：" + list);
			
			return list;
			
		} catch (Exception e) {
			logger.debug("DataService， 查询一月份销售订单失败" + e);
		}
		return null;
	}

	/**
	 * 二月分销售订单
	 * @param userid
	 * @return
	 */
	@Override
	public List<Map<String, Object>> februaryOrder(int userid) throws Exception{
		
		logger.debug("DataService，查询 二月份销售订单。。。");
		
		try {
			
			List<Map<String, Object>> list = dataDao.februaryOrder(userid);
			 
			logger.debug("DataService，查询 二月份销售订单,查询结果为：" + list);
			
			return list;
			
		} catch (Exception e) {
			logger.debug("DataService， 查询二月份销售订单失败" + e);
		}
		return null;
	}

	/**
	 * 三月分销售订单
	 * @param userid
	 * @return
	 */
	@Override
	public List<Map<String, Object>> marchOrder(int userid) throws Exception{

		logger.debug("DataService，查询 三月份销售订单。。。");
		
		try {
			
			List<Map<String, Object>> list = dataDao.marchOrder(userid);
			 
			logger.debug("DataService，查询 三月份销售订单,查询结果为：" + list);
			
			return list;
			
		} catch (Exception e) {
			logger.debug("DataService， 查询三月份销售订单失败" + e);
		}
		return null;
	}

	/**
	 * 四月分销售订单
	 * @param userid
	 * @return
	 */
	@Override
	public List<Map<String, Object>> arpilOrder(int userid) throws Exception{
		
		logger.debug("DataService，查询 四月份销售订单。。。");
		
		try {
			
			List<Map<String, Object>> list = dataDao.arpilOrder(userid);
			 
			logger.debug("DataService，查询 四月份销售订单,查询结果为：" + list);
			
			return list;
			
		} catch (Exception e) {
			logger.debug("DataService， 查询四月份销售订单失败" + e);
		}
		return null;
	}

	/**
	 * 五月分销售订单
	 * @param userid
	 * @return
	 */
	@Override
	public List<Map<String, Object>> mayOrder(int userid) throws Exception {
		
		logger.debug("DataService，查询 五月份销售订单。。。");
		
		try {
			
			List<Map<String, Object>> list = dataDao.mayOrder(userid);
			 
			logger.debug("DataService，查询五月份销售订单,查询结果为：" + list);
			
			return list;
			
		} catch (Exception e) {
			logger.debug("DataService， 查询五月份销售订单失败" + e);
		}
		
		return null;
	}

	/**
	 * 六月分销售订单
	 * @param userid
	 * @return
	 */
	@Override
	public List<Map<String, Object>> juneOrder(int userid) throws Exception{

		logger.debug("DataService，查询六月份销售订单。。。");
		
		try {
			
			List<Map<String, Object>> list = dataDao.juneOrder(userid);
			 
			logger.debug("DataService，查询 六月份销售订单,查询结果为：" + list);
			
			return list;
			
		} catch (Exception e) {
			logger.debug("DataService， 查询六月份销售订单失败" + e);
		}
			
		return null;
	}

	/**
	 * 七月分销售订单
	 * @param userid
	 * @return
	 */
	@Override
	public List<Map<String, Object>> julyOrder(int userid) throws Exception{

		logger.debug("DataService，查询七月份销售订单。。。");
		
		try {
			
			List<Map<String, Object>> list = dataDao.julyOrder(userid);
			 
			logger.debug("DataService，查询七月份销售订单,查询结果为：" + list);
			
			return list;
			
		} catch (Exception e) {
			logger.debug("DataService， 查询七月份销售订单失败" + e);
		}
			
		return null;
	}
	

	/**
	 * 八月分销售订单
	 * @param userid
	 * @return
	 */
	@Override
	public List<Map<String, Object>> augustOrder(int userid) throws Exception{

		logger.debug("DataService，查询八月份销售订单。。。");
		
		try {
			
			List<Map<String, Object>> list = dataDao.augustOrder(userid);
			 
			logger.debug("DataService，查询八月份销售订单,查询结果为：" + list);
			
			return list;
			
		} catch (Exception e) {
			logger.debug("DataService， 查询八月份销售订单失败" + e);
		}
			
		return null;
	}
	
	/**
	 * 九月分销售订单
	 * @param userid
	 * @return
	 */
	@Override
	public List<Map<String, Object>> septemberOrder(int userid) throws Exception{
		
		logger.debug("DataService，查询九月份销售订单。。。");
		
		try {
			
			List<Map<String, Object>> list = dataDao.septemberOrder(userid);
			 
			logger.debug("DataService，查询九月份销售订单,查询结果为：" + list);
			
			return list;
			
		} catch (Exception e) {
			logger.debug("DataService， 查询九月份销售订单失败" + e);
		}
		
		return null;
	}

	/**
	 * 十月分销售订单
	 * @param userid
	 * @return
	 */
	@Override
	public List<Map<String, Object>> octoberOrder(int userid) throws Exception{
		
		logger.debug("DataService，查询十月份销售订单。。。");
		
		try {
			
			List<Map<String, Object>> list = dataDao.octoberOrder(userid);
			 
			logger.debug("DataService，查询十月份销售订单,查询结果为：" + list);
			
			return list;
			
		} catch (Exception e) {
			logger.debug("DataService， 查询十月份销售订单失败" + e);
		}
		
		return null;
	}

	/**
	 * 十一月分销售订单
	 * @param userid
	 * @return
	 */
	@Override
	public List<Map<String, Object>> novemberOrder(int userid) throws Exception{
		
		logger.debug("DataService，查询十一月份销售订单。。。");
		
		try {
			
			List<Map<String, Object>> list = dataDao.novemberOrder(userid);
			 
			logger.debug("DataService，查询十一月份销售订单,查询结果为：" + list);
			
			return list;
			
		} catch (Exception e) {
			logger.debug("DataService， 查询十一月份销售订单失败" + e);
		}
		
		return null;
	}

	/**
	 * 十二月分销售订单
	 * @param userid
	 * @return
	 */
	@Override
	public List<Map<String, Object>> decemberOrder(int userid) throws Exception{
		
		logger.debug("DataService，查询十二月份销售订单。。。");
		
		try {
			
			List<Map<String, Object>> list = dataDao.decemberOrder(userid);
			 
			logger.debug("DataService，查询十二月份销售订单,查询结果为：" + list);
			
			return list;
			
		} catch (Exception e) {
			logger.debug("DataService， 查询十二月份销售订单失败" + e);
		}
		
		return null;
	}

	/**
	 * 第一季度分销售订单
	 * @param userid
	 * @return
	 */
	@Override
	public List<Map<String, Object>> firstQuarterOrder(int userid) throws Exception{
		
		logger.debug("DataService，查询第一季度销售订单。。。");
		
		try {
			
			List<Map<String, Object>> list = dataDao.firstQuarterOrder(userid);
			 
			logger.debug("DataService，查询第一季度销售订单,查询结果为：" + list);
			
			return list;
			
		} catch (Exception e) {
			logger.debug("DataService， 查询第一季度销售订单失败" + e);
		}
		
		return null;
	}

	/**
	 * 第二季度销售订单
	 * @param userid
	 * @return
	 */
	@Override
	public List<Map<String, Object>> secondQuarterOrder(int userid) throws Exception{

		logger.debug("DataService，查询第二季度销售订单。。。");
		
		try {
			
			List<Map<String, Object>> list = dataDao.secondQuarterOrder(userid);
			 
			logger.debug("DataService，查询第二季度销售订单,查询结果为：" + list);
			
			return list;
			
		} catch (Exception e) {
			logger.debug("DataService， 查询第二季度销售订单失败" + e);
		}
			
		return null;
	}

	/**
	 * 第三季度销售订单
	 * @param userid
	 * @return
	 */
	@Override
	public List<Map<String, Object>> thirdQuarterOrder(int userid) throws Exception{
		
		logger.debug("DataService，查询第三季度销售订单。。。");
		
		try {
			
			List<Map<String, Object>> list = dataDao.thirdQuarterOrder(userid);
			 
			logger.debug("DataService，查询第三季度销售订单,查询结果为：" + list);
			
			return list;
			
		} catch (Exception e) {
			logger.debug("DataService， 查询第三季度销售订单失败" + e);
		}
		
		return null;
	}

	/**
	 * 第四季度销售订单
	 * @param userid
	 * @return
	 */
	@Override
	public List<Map<String, Object>> fourthQuarterOrder(int userid) throws Exception{
		
		logger.debug("DataService，查询第四季度销售订单。。。");
		
		try {
			
			List<Map<String, Object>> list = dataDao.fourthQuarterOrder(userid);
			 
			logger.debug("DataService，查询第四季度销售订单,查询结果为：" + list);
			
			return list;
			
		} catch (Exception e) {
			logger.debug("DataService， 查询第四季度销售订单失败" + e);
		}
		
		return null;
	}

	/**
	 * 查询分销商的库存报表
	 * @param userid
	 * @return
	 */
	@Override
	public List<Map<String, Object>> storeChectSheet(int userid) throws Exception{
		
		logger.debug("DataService，查询分销商的库存报表......");
		
		try {
			
			List<Map<String, Object>> list = dataDao.storeChectSheet(userid);
			
			logger.debug("DataService，查询分销商的库存报表， 查询到的值为： " + list);
			
			return list;
			
		} catch (Exception e) {
			logger.debug("DataService，查询分销商的库存报表失败" + e);
		}
		return null;
	}

	/**
	 * 管理员查询所有分销商的库存报表
	 */
	@Override
	public List<Map<String, Object>> allStoreChectSheet() throws Exception {

		logger.debug("DataService，查询分销商的库存报表......");
		
		try {
			
			List<Map<String, Object>> list = dataDao.allStoreChectSheet();
			
			logger.debug("DataService，查询分销商的库存报表， 查询到的值为： " + list);
			
			return list;
			
		} catch (Exception e) {
			logger.debug("DataService，管理员查询所有分销商的库存报表失败" + e);
		}
		
		return null;
	}

}
