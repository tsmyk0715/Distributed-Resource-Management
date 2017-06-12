package inf;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import pojo.Orders;

/**
 * 订单模块的service层接口
 * @author tsmyk0715
 *
 */
public interface IOrderService {
	
	/**
	 * 查询所有的订单
	 * @return
	 */
	List<Orders> queryAllOrders(int userid);
	
	/**
	 * 管理员查询所有订单
	 * @return
	 */
	List<Map<String, Object>> queryAllOrdersByAdmin() throws Exception;
	
	/**
	 * 查询所有订单（可得到客户名称和商品名称）
	 */
	List<Map<String,Object>> queryAllOrderByParam(int userid);
	
	/**
	 * 查询该用户下的订单记录
	 * @return
	 * @throws Exception
	 */
	int getTotalCount(int userid) throws Exception;
	
	/**
	 * 新增订单信息
	 * @param o
	 * @throws Exception
	 */
	void addOrderAction(Orders o) throws Exception;
	
	/**
	 * 删除订单信息
	 * @param param
	 * @throws Exception
	 */
	void deleteOrders(List<Integer> param) throws Exception;
	
	/**
	 * 修改订单信息
	 * @throws Exception
	 */
	void editOrdersInformarion(Map<String,Object> paramMap) throws Exception;
	
	/**
	 * 根据参数查询订单
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> queryOrderByParamMap(Map<String, Object> searchMap) throws Exception;
}
