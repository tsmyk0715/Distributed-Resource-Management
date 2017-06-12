package service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.OrderDao;
import inf.IOrderService;
import pojo.Orders;

@Service("orderService")
public class OrderServiceImpl implements IOrderService {
	
	/**
	 * 自动注入订单模块的数据接口层
	 */
	@Autowired
	private OrderDao orderDao;
	
	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(OrderServiceImpl.class);
	
	/**
	 * 查询所有的订单
	 */
	@Override
	public List<Orders> queryAllOrders(int userid) {
		
		logger.debug("OrderService : 查询所有订单...");
		try {
			
			List<Orders> list = orderDao.queryAllOrders(userid);
			
			logger.debug("OrderService : 查询得到的订单为：" + list);

			return list;
		} catch (Exception e) {
			logger.debug("OrderService : 查询订单失败：" + e);
		}
		return null;
	}

	/**
	 * 查询所有订单（可得到客户名称和商品名称）
	 */
	@Override
	public List<Map<String, Object>> queryAllOrderByParam(int userid) {
		
		logger.debug("OrderService : 查询所有订单...");
		try {
			
			List<Map<String, Object>> list = orderDao.queryAllOrderByParam(userid);
			
			logger.debug("OrderService : 查询得到的订单为：" + list);

			return list;
		} catch (Exception e) {
			logger.debug("OrderService : 查询订单失败：" + e);
		}
		return null;
	}

	/**
	 * 查询该用户下的订单记录
	 * @return
	 * @throws Exception
	 */
	@Override
	public int getTotalCount(int userid) throws Exception {
		return orderDao.getTotalCount(userid);
	}

	/**
	 * 新增订单信息
	 * @param o
	 * @throws Exception
	 */
	@Override
	public void addOrderAction(Orders o) throws Exception {
		
		logger.debug("OrderService : 新增订单信息 ：要新增的订单信息为　：" + o);
		
		try {
			
			orderDao.addOrderAction(o);
			
		} catch (Exception e) {
			logger.debug("OrderService : 新增订单信息失败　：" + e);
		}
	}

	/**
	 * 删除订单信息
	 */
	@Override
	public void deleteOrders(List<Integer> param) throws Exception {
		
		logger.debug("OrderService : 删除订单信息，要删除的订单ID为 ： " + param.toString());
		
		try {
			orderDao.deleteOrders(param);
		} catch (Exception e) {
			logger.debug("OrderService : 删除订单信息失败 ： " + e);
		}
	}

	/**
	 * 修改订单信息
	 * @throws Exception
	 */
	@Override
	public void editOrdersInformarion(Map<String, Object> paramMap) 
			throws Exception {
		
		logger.debug("OrderService : 修改订单信息...");
		try {
			orderDao.editOrdersInformarion(paramMap);
		} catch (Exception e) {
			logger.debug("OrderService : 修改订单信息失败..." + e);
		}
			
	}
	/**
	 * 根据参数查询订单
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> queryOrderByParamMap(Map<String, Object> searchMap) 
			throws Exception {
		
		logger.debug("OrderService : 根据参数查询订单...");
		
		try {
			
			List<Map<String, Object>> resultMap =orderDao.queryOrderByParamMap(searchMap);

			logger.debug("OrderService : 根据参数查询订单.查询到的订单为 ： " + resultMap);
			
			return resultMap;
			
		} catch (Exception e) {
			logger.debug("OrderService : 根据参数查询订单失败...");
		}
		
		return null;
	}

	/**
	 * 管理员查询所有订单
	 * @return
	 */
	@Override
	public List<Map<String, Object>> queryAllOrdersByAdmin() throws Exception{
		
		logger.debug("OrderService : 管理员查询所有订单...");
		
		try {
			return orderDao.queryAllOrdersByAdmin();
		} catch (Exception e) {
			logger.debug("OrderService : 管理员查询所有订单失败...");
		}
		return null;
	}

}
