package service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.DitchDao;
import inf.IDitch;
import pojo.Customer;

@Service(value="ditchService")
public class DitchServiceImpl implements IDitch {

	/**
	 * 自动注入分销商渠道管理模块的数据接口层
	 */
	@Autowired
	private DitchDao ditchDao;
	
	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(DitchServiceImpl.class);
	
	/**
	 * 查询所有的客户
	 */
	@Override
	public List<Customer> queryAllCustomer() {
		
		logger.debug("DitchService ：查询所有的客户...");
		try {
			
			List<Customer> customerList = ditchDao.queryAllCustomer();
			
			logger.debug("DitchService ：查询到的客户：" + customerList);
			
			return customerList;
		} catch (Exception e) {
			logger.debug("DitchService：查询所有的客户失败：" + e);
		}
		return null;
	}
	
	
	/**
	 * 查询某个用户下的所有分销商
	 * @param userid 
	 *              用户ID
	 * return  
	 * 		分销商的集合列表
	 */
	@Override
	public List<Customer> queryCustomersByUserId(int userid) throws Exception {
		
		logger.debug("DitchService : 查询某个用户下的分销商 ： 用户ID为： " + userid);
		
		try {
			
			List<Customer> list = ditchDao.queryCustomersByUserId(userid);
			
			logger.debug("DitchService : 查询某个用户下的分销商，查询结果为 ：" + list);
			
			return list;
		} catch (Exception e) {
			logger.debug("DitchService : 查询某个用户下的分销商失败： " + e);
		}
		
		return null;
	}
	
	
	/**
	 * 根据客户的名字查询客户
	 */
	public Customer queryCustomerByCusetomerName(String customerName) {
		
		logger.debug("DitchService : 根据客户名称查询客户 ，客户名称为 ：  " + customerName);
		try {
			return ditchDao.queryCustomerByCusetomerName(customerName);
		} catch (Exception e) {
			logger.debug("DitchService : 根据客户名称查询客户失败 ：" + e);
		}
		return null;
	}


	/**
	 * 根据Map参数进行查询分销商
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Customer> queryCustomersByParamMap(Map<String, Object> paramMap) throws Exception {
		
		logger.debug("DitchService : 根据Map参数进行查询分销商...");
		
		try {
		
			List<Customer> list = ditchDao.queryCustomersByParamMap(paramMap);
			
			logger.debug("DitchService : 根据Map参数进行查询分销商，查询到分销商为：" + list);
			
			return list;
			
		} catch (Exception e) {
			logger.debug("DitchService : 根据Map参数进行查询分销商失败" + e);
		}
		
		return null;
	}


	/**
	 * 修改客户信息
	 * @param param
	 * @throws Exception
	 */
	@Override
	public void editClientInfo(Map<String, Object> param) throws Exception {
		
		logger.debug("DitchService : 修改客户信息...");
		
		try {
			ditchDao.editClientInfo(param);
		} catch (Exception e) {
			logger.debug("DitchService : 修改客户信息失败" + e);
		}
		
	}


	@Override
	public void deleteClient(List<Integer> param) throws Exception {
		
		logger.debug("DitchService : 删除客户信息...");
		
		try {
			ditchDao.deleteClient(param);
		} catch (Exception e) {
			logger.debug("DitchService : 删除客户信息失败 ： " + e);
		}
	}

	/**
	 * 添加客户信息
	 * @throws Exception
	 */
	@Override
	public void addClientInfo(Customer customer) throws Exception {
		
		logger.debug("DitchService , 添加客户信息，要添加的客户信为 ；" + customer);
		
		try {
			
			ditchDao.addClientInfo(customer);
			
		} catch (Exception e) {
			logger.debug("DitchService , 添加客户信息失败..." + e);
		}
		
		
	}

	/**
	 * 分消费的计算
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> ditchCostCount(int userid) throws Exception {
		
		logger.debug("DitchService 分销费用的计算...userid ===> " + userid);
		
		try {
			
			List<Map<String, Object>> list = ditchDao.ditchCostCount(userid);
			
			logger.debug("DitchService 分销费用的计算. 查询结果为===> " + list);
			
			return list;
			
		} catch (Exception e) {
			logger.debug("DitchService 分销费用的计算失败..." + e);
		}
		
		return null;
	}

	/**
	 * 修改某个订单的返点
	 * @param fanDianValue
	 */
	@Override
	public void editFanDian(Map<String, Object> param) throws Exception {

		logger.debug("DitchService 修改返点的值...");
		
		try {
			
			ditchDao.editFanDian(param);
			
		} catch (Exception e) {
			logger.debug("DitchService 修改返点的值失败..." + e);
		}
		
	}


	/**
	 * 分销费用的查询
	 */
	@Override
	public List<Map<String, Object>> ditchCostCountSearch(Map<String, Object> param) throws Exception {
		
		logger.debug("DitchService , 分销费用的查询...");
		
		try {
			
			List<Map<String, Object>> list = ditchDao.ditchCostCountSearch(param);
			
			logger.debug("DitchService , 分销费用的查询..查询到的结果为：" + list);
			
			return list;
		} catch (Exception e) {
			logger.debug("DitchService , 分销费用的查询失败：" + e);
		}
		
		return null;
	}

}
