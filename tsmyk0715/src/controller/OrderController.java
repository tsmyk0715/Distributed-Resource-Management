package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;

import dto.PageBean;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import pojo.Customer;
import pojo.Goods;
import pojo.Orders;
import pojo.User;
import service.DitchServiceImpl;
import service.OrderServiceImpl;
import service.StoreServiceImpl;
import tsmykTools.ExportExcel_Map;

/**
 * 订单模块的控制层
 * 
 * @author tsmyk0715
 *
 */
@Controller
public class OrderController {

	/**
	 * 自动注入订单模块的service层实现
	 */
	@Autowired
	private OrderServiceImpl orderService;

	/**
	 * 自动注入库存模块的service层
	 */
	@Autowired
	private StoreServiceImpl storeService;

	/**
	 * 自动注入分销商渠道管理模块的service层
	 */
	@Autowired
	private DitchServiceImpl ditchService;

	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(OrderController.class);

	protected HttpServletRequest request;           
	protected HttpServletResponse response;   
	
	/**
	 * 在执行所有方法之前首先要执行的方法
	 * @param request
	 * @param response
	 */
    @ModelAttribute            
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response){     
	    this.request = request;               
	    this.response = response;                
	}
	
	
	/**
	 * 获取当前用户
	 * 
	 * @param request
	 * @param successViewName
	 * @return
	 * @throws Exception
	 */
	private ModelAndView getCurrentUser(HttpServletRequest request, String successViewName) throws Exception {

		User user = (User) request.getSession().getAttribute("currentUser");

		logger.debug("OrderController : 获取当前用户，当前用户为 ：" + user);

		ModelAndView model = new ModelAndView();

		if (user == null) {
			String viewName = "../index";
			model.setViewName(viewName);
		} else {
			model.setViewName(successViewName);
			model.addObject("user", user);
		}
		return model;
	}

	/**
	 * 查询所有订单之前的预处理
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/order")
	public ModelAndView preAueryAllOrders(HttpServletRequest request) throws Exception {
		String viewName = "../main/content/order/generateOrder";
		return getCurrentUser(request, viewName);
	}

	/**
	 * 查询所有订单
	 * 
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryAllOrders", method = RequestMethod.POST)
	@ResponseBody
	public Object queryAllOrders(@RequestParam("page") int pageNumber, @RequestParam("rows") int pageSize,
			@RequestParam("userid") int userid, HttpServletRequest request) throws Exception {

		logger.debug("OrderController : 查询所有订单...");

		int useridParam = userid;

		try {
			// 获取查询参数
			String number = request.getParameter("number");
			String clientName = request.getParameter("client");
			String goodsName = request.getParameter("name");
			String orderTime = request.getParameter("orderTime");
			String sendTime = request.getParameter("sendTime");
			String payType = request.getParameter("payType");

			// 获数据集
			List<Map<String, Object>> order = null;

			if ((number == null || number == "") && (clientName == null || clientName == "")
					&& (goodsName == null || goodsName == "") && (orderTime == null || orderTime == "")
					&& (sendTime == null || sendTime == "") && (payType == null || payType == "")) {
				// 查询所有的
				order = orderService.queryAllOrderByParam(useridParam);
			} else {
				// 根据参数来进行查询
				Map<String, Object> searchMap = new HashMap<>();

				searchMap.put("userid", useridParam);

				searchMap.put("number", number);
				searchMap.put("orderTime", orderTime);
				searchMap.put("sendTime", sendTime);
				searchMap.put("payType", payType);
				searchMap.put("clientName", clientName);
				searchMap.put("goodsName", goodsName);

				order = orderService.queryOrderByParamMap(searchMap);
			}

			logger.debug("OrderController-查询到的订单集合：" + order);

			Map<String, Object> resultMap = new HashMap<>();
			JSONArray jsonArray = new JSONArray();
			JSONObject jsonObject = new JSONObject();

			for (int i = 0; i < order.size(); i++) {
				jsonObject.put("id", order.get(i).get("id"));
				jsonObject.put("number", order.get(i).get("number"));
				jsonObject.put("customername", order.get(i).get("customername"));
				jsonObject.put("name", order.get(i).get("name"));
				jsonObject.put("size", order.get(i).get("size"));
				jsonObject.put("goodsNum", order.get(i).get("goodsNum"));
				jsonObject.put("orderTime", order.get(i).get("orderTime"));
				jsonObject.put("sendTime", order.get(i).get("sendTime"));
				jsonObject.put("payType", order.get(i).get("payType"));
				jsonObject.put("description", order.get(i).get("description"));
				jsonArray.add(jsonObject);
			}

			int count = orderService.getTotalCount(userid);

			resultMap.put("total", count);
			resultMap.put("rows", jsonArray);
			return JSONObject.fromObject(resultMap);

		} catch (Exception e) {
			logger.debug("OrderController-查询所有的订单失败：" + e);
		}

		return null;
	}

	/**
	 * 添加订单之前的预处理
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/addOrder")
	public ModelAndView preprocessAddOrder(HttpServletRequest request) throws Exception {
		logger.debug("OrderController：新增订单之前的预处理...");
		try {
			String viewName = "../main/content/order/addOrder";

			ModelAndView model = getCurrentUser(request, viewName);

			List<Goods> goodses = storeService.queryAllGoods();

			List<Customer> customers = ditchService.queryAllCustomer();

			model.addObject("goodses", goodses);
			model.addObject("customers", customers);
			return model;

		} catch (Exception e) {
			logger.debug("OrderController：新增订单之前的预处理失败 : " + e);
		}
		return null;
	}

	/**
	 * 处理新增订单
	 * 
	 * @param orders
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/addOrderAction", method = RequestMethod.POST)
	public String processAddOrderAction(Orders orders) throws Exception {

		logger.debug("OrderController : 处理新增订单信息 ： 要新增的订单信息为 ： " + orders);

		try {

			orderService.addOrderAction(orders);

			return "redirect:order";

		} catch (Exception e) {
			logger.debug("OrderController : 处理新增订单信息失败： " + e);
		}

		return null;
	}

	/**
	 * 订单管理预处理
	 * 
	 * @return
	 * @throws Exceptionm
	 */
	@RequestMapping("/orderManager")
	public ModelAndView preprocessOrderManager(HttpServletRequest request) throws Exception {
		String viewName = "../main/content/order/orderManager";
		return getCurrentUser(request, viewName);
	}

	/**
	 * 删除订单信息
	 */
	@RequestMapping(value = "/deleteOrders", method = RequestMethod.POST)
	public void deleteOrders(@RequestParam(value = "id[]") String[] ids, HttpServletResponse response)
			throws Exception {

		logger.debug("OrderController: 删除订单信息，要删除的订单ID为：" + ids.toString());

		List<Integer> param = new ArrayList<>();
		for (int i = 0; i < ids.length; i++) {
			param.add(Integer.parseInt(ids[i]));
		}
		try {
			orderService.deleteOrders(param);
			response.getWriter().write("ok");
			response.getWriter().flush();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			logger.debug("StroeController: 删除订单信息失败：" + e);
		}

	}

	/**
	 * 修改订单信息
	 * 
	 * @param data
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/editOrdersInformation", method = RequestMethod.POST)
	public void editOrdersInformation(@RequestBody JSONObject data, HttpServletResponse response) throws Exception {

		logger.debug("OrderController : 修改订单信息，要修改的订单信息为 ： " + data);

		Map<String, Object> paramMap = new HashMap<>();

		try {
			int id = Integer.parseInt(data.getString("id"));
			String number = data.getString("number");
			String goodsNum = data.getString("goodsNum");
			String sendTime = data.getString("sendTime");
			String payType = data.getString("payType");
			String desc = data.getString("desc");

			paramMap.put("id", id);
			paramMap.put("number", number);
			paramMap.put("goodsNum", goodsNum);
			paramMap.put("sendTime", sendTime);
			paramMap.put("payType", payType);
			paramMap.put("desc", desc);

			orderService.editOrdersInformarion(paramMap);

		} catch (Exception e) {
			logger.debug("OrderController : 修改订单信息失败 ： " + e);
		}

	}

	/**
	 * 查询订单之前的预处理
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/orderSearch")
	public ModelAndView preprocessSearchOrder(HttpServletRequest request) throws Exception {
		String viewName = "../main/content/order/orderSearch";
		return getCurrentUser(request, viewName);
	}

	/**
	 * 订单审核预处理
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/orderVerify")
	public ModelAndView preprocessorderVerify(HttpServletRequest request) throws Exception {
		String viewName = "../main/content/order/orderVerify";
		return getCurrentUser(request, viewName);
	}

	/**
	 * 处理订单审核
	 * 
	 * @return
	 */
	@RequestMapping(value = "/orderVerify", method = RequestMethod.POST)
	@ResponseBody
	public Object processOrderVerify(@RequestParam("page") int pageNumber, @RequestParam("rows") int pageSize,
			@RequestParam("userid") int userid, HttpServletRequest request) throws Exception {

		logger.debug("OrderController : 订单审核...");

		int useridParam = userid;

		try {
			// 获数据集
			List<Map<String, Object>> order = orderService.queryAllOrderByParam(useridParam);

			logger.debug("OrderController-查询到的订单集合：" + order);

			Map<String, Object> resultMap = new HashMap<>();
			JSONArray jsonArray = new JSONArray();
			JSONObject jsonObject = new JSONObject();

			for (int i = 0; i < order.size(); i++) {
				jsonObject.put("id", order.get(i).get("id"));
				jsonObject.put("number", order.get(i).get("number"));
				jsonObject.put("customername", order.get(i).get("customername"));
				jsonObject.put("name", order.get(i).get("name"));
				jsonObject.put("size", order.get(i).get("size"));
				jsonObject.put("goodsNum", order.get(i).get("goodsNum"));
				jsonObject.put("orderTime", order.get(i).get("orderTime"));
				jsonObject.put("sendTime", order.get(i).get("sendTime"));
				jsonObject.put("payType", order.get(i).get("payType"));
				jsonObject.put("verifySign", 0);
				jsonObject.put("description", order.get(i).get("description"));
				jsonArray.add(jsonObject);
			}

			int count = orderService.getTotalCount(userid);

			resultMap.put("total", count);
			resultMap.put("rows", jsonArray);
			return JSONObject.fromObject(resultMap);

		} catch (Exception e) {
			logger.debug("OrderController-订单审核失败：" + e);
		}
		return null;
	}

	
	/**
	 * 打印订单信息
	 */
	@RequestMapping("/exportOrderExcel")
	public void exportOrderExcel() throws Exception{
		logger.debug("OrderController，导出订单信息。。。。");
		try {
			
			User user = (User) request.getSession().getAttribute("currentUser");
			if(user == null){
				return ;
			}

			List<Map<String, Object>> data = orderService.queryAllOrderByParam(user.getId());
			
			List<Map<String, Object>> exportData = new ArrayList<>();
			
			for(Map<String, Object> map : data ){
				Map<String, Object> mapData = new LinkedHashMap<>();
				mapData.put("number",  map.get("number"));
				mapData.put("customername",  map.get("customername"));
				mapData.put("name",  map.get("name"));
				mapData.put("size",  map.get("size"));
				mapData.put("goodsNum",  map.get("goodsNum"));
				mapData.put("orderTime",  map.get("orderTime"));
				mapData.put("sendTime",  map.get("sendTime"));
				mapData.put("payType",  map.get("payType"));
				mapData.put("description",  map.get("description"));
				exportData.add(mapData);
			}
			
			String sheetName = "订单信息";
			String[] headers = {"订单编号","客户名称","商品名称","商品规格","商品数量","订单生成时间","发货时间","支付方式","备注"};
			String exportExcelName = "订单信息表";
			ExportExcel_Map.exportExcel(sheetName, exportData, headers, exportExcelName, response);
		} catch (Exception e) {
			logger.debug("OrderController，导出订单信息失败：" + e);
		}
	}
	
	
	/**
	 * 管理员打印所有的打印订单信息
	 * @throws Exception
	 */
	@RequestMapping("/exportAllOrderExcel")
	public void exportAllOrderExcel() throws Exception{
		logger.debug("OrderController，导出订单信息。。。。");
		try {

			List<Map<String, Object>> data = orderService.queryAllOrdersByAdmin();
			
			List<Map<String, Object>> exportData = new ArrayList<>();
			 
			for(Map<String, Object> map : data ){
				Map<String, Object> mapData = new LinkedHashMap<>();
				mapData.put("number",  map.get("number"));
				mapData.put("customername",  map.get("customername"));
				mapData.put("name",  map.get("name"));
				mapData.put("size",  map.get("size"));
				mapData.put("goodsNum",  map.get("goodsNum"));
				mapData.put("orderTime",  map.get("orderTime"));
				mapData.put("sendTime",  map.get("sendTime"));
				mapData.put("payType",  map.get("payType"));
				mapData.put("description",  map.get("description"));
				mapData.put("userid",  map.get("userid"));
				exportData.add(mapData);
			}
			
			String sheetName = "订单信息";
			String[] headers = {"订单编号","客户名称","商品名称","商品规格","商品数量","订单生成时间","发货时间","支付方式","备注","用户ID"};
			String exportExcelName = "订单信息表";
			ExportExcel_Map.exportExcel(sheetName, exportData, headers, exportExcelName, response);
		} catch (Exception e) {
			logger.debug("OrderController，导出订单信息失败：" + e);
		}
	}
	
	/**
	 * 处理分页
	 * 
	 * @param pageNumber
	 * @param pageSize
	 * @param T
	 *            传入类型泛型
	 * @return
	 * @throws Exception
	 */
	public <T> PageBean<T> queryByPage(int pageNumber, int pageSize, T t, int userid) throws Exception {
		List<T> list = null;
		PageHelper.startPage(pageNumber, pageSize);
		list = (List<T>) orderService.queryAllOrderByParam(userid);
		return new PageBean<T>(list);
	}
	
}
