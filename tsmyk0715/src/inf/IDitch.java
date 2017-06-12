package inf;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import pojo.Customer;

/**
 * 分销商渠道管理模块的service层接口
 * @author tsmyk0715
 *
 */
public interface IDitch {

	/**
	 * 查询所有的分销商
	 * @return
	 */
	List<Customer> queryAllCustomer();
	
	/**
	 * 查询某个用户下的所有分销商
	 * @param userid
	 * @return
	 * @throws Exception
	 */
	List<Customer> queryCustomersByUserId(int userid) throws Exception;
	
	/**
	 * 根据客户的名称来查询客户
	 * @param customerName
	 * @return
	 */
	Customer queryCustomerByCusetomerName(String customerName);
	
	/**
	 * 根据Map参数进行查询分销商
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	List<Customer> queryCustomersByParamMap(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 修改客户信息
	 * @param param
	 * @throws Exception
	 */
	void editClientInfo (Map<String, Object> param) throws Exception;	
	
	/**
	 * 删除客户信息
	 * @param param
	 * @throws Exception
	 */
	void deleteClient(List<Integer> param) throws Exception;
	
	/**
	 * 添加客户信息
	 * @throws Exception
	 */
	void addClientInfo (@Param("c") Customer customer) throws Exception;

	/**
	 * 分消费的计算
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> ditchCostCount(int userid) throws Exception;
	
	/**
	 * 分销费用查询
	 * @param param
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> ditchCostCountSearch(Map<String, Object> param) throws Exception;
	
	/**
	 * 修改某个订单的返点
	 * @param fanDianValue
	 */
	void editFanDian(Map<String, Object> param) throws Exception;
}

