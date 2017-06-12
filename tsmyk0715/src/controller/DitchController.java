package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
import pojo.User;
import service.DitchServiceImpl;
import service.OrderServiceImpl;
import tsmykTools.ExportExcel_Map;

/**
 * 分销商渠道管理模块的控制层
 * 
 * @author tsmyk0715
 *
 */
@Controller
public class DitchController {

	/**
	 * 自动注入分销商渠道管理的service层
	 */
	@Autowired
	private DitchServiceImpl ditchService;

	@Autowired
	private OrderServiceImpl orderService;
	
	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(DitchController.class);

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
	 * 分销商管理预处理
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/clientManager")
	public ModelAndView preprocessClientManager(HttpServletRequest request) throws Exception {
		String viewName = "../main/content/ditch/clientManager";
		return getCurrentUser(request, viewName);
	}

	/**
	 * 查询某个用户下的分销商
	 * 
	 * @param pageNumer
	 * @param pageSize
	 * @param userid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryCustomersByUserId", method = RequestMethod.POST)
	@ResponseBody
	public Object qeuryCustomersByUserId(@RequestParam("page") int pageNumer, @RequestParam("rows") int pageSize,
			@RequestParam("userid") int userid, HttpServletRequest request) throws Exception {

		logger.debug("DitchController: 查询某个用户下的分销商...");

		Customer customer = null;

		Map<String, Object> resultMap = new HashMap<>();
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();

		// 获取查询参数
		String number = request.getParameter("number");
		String clientName = request.getParameter("clientName");
		String address = request.getParameter("address");
		String telephone = request.getParameter("telephone");
		String connectPerson = request.getParameter("connectPerson");
		String email = request.getParameter("email");

		try {

			PageBean<Customer> pageBean = null;

			if ((number == null || number == "") && (clientName == null || clientName == "")
					&& (address == null || address == "") && (telephone == null || telephone == "")
					&& (connectPerson == null || connectPerson == "") && (email == null || email == "")) {
				// 查询参数为空，则查询所有
				pageBean = this.queryByPage(pageNumer, pageSize, customer, userid);
			} else {
				// 根据参数进行查询
				Map<String, Object> paramMap = new HashMap<>();
				paramMap.put("userid", userid);
				paramMap.put("number", number);
				paramMap.put("clientName", clientName);
				paramMap.put("address", address);
				paramMap.put("telephone", telephone);
				paramMap.put("connectPerson", connectPerson);
				paramMap.put("email", email);
				pageBean = this.queryByPageByParamMap(pageNumer, pageSize, customer, paramMap);
			}

			List<Customer> customers = pageBean.getList();

			logger.debug("DitchController: 查询某个用户下的分销商 : 查询到的分销商为：" + customers);

			for (Customer c : customers) {
				jsonObject.put("id", c.getId());
				jsonObject.put("number", c.getNumber());
				jsonObject.put("customername", c.getCustomerName());
				jsonObject.put("postcode", c.getPostCode());
				jsonObject.put("address", c.getAddress());
				jsonObject.put("telephone", c.getTelephone());
				jsonObject.put("connectperson", c.getConnectPerson());
				jsonObject.put("phone", c.getPhone());
				jsonObject.put("bank", c.getBank());
				jsonObject.put("account", c.getAccount());
				jsonObject.put("email", c.getEmail());
				jsonObject.put("fax", c.getFax());
				jsonObject.put("description", c.getDescription());

				jsonArray.add(jsonObject);
			}

			resultMap.put("total", pageBean.getTotal());
			resultMap.put("rows", jsonArray);

			return JSONObject.fromObject(resultMap);
		} catch (Exception e) {
			logger.debug("DitchController: 查询某个用户下的分销商失败：" + e);
		}

		return null;

	}

	/**
	 * 修改客户信息
	 * 
	 * @param data
	 * @param response
	 */
	@RequestMapping(value = "/editClientInformation", method = RequestMethod.POST)
	public void editClientInformation(@RequestBody JSONObject data, HttpServletResponse response) {

		logger.debug("DitchController : 修改客户信息，修改参数为 ：" + data);

		Map<String, Object> param = new HashMap<>();

		try {
			int id = data.getInt("id");
			String address = data.getString("address");
			String telephone = data.getString("telephone");
			String connectPerson = data.getString("connectPerson");
			String phone = data.getString("phone");
			String email = data.getString("email");
			String fax = data.getString("fax");
			String desc = data.getString("desc");

			param.put("id", id);
			param.put("address", address);
			param.put("telephone", telephone);
			param.put("connectPerson", connectPerson);
			param.put("phone", phone);
			param.put("email", email);
			param.put("fax", fax);
			param.put("description", desc);

			ditchService.editClientInfo(param);

		} catch (Exception e) {
			logger.debug("DitchController : 修改客户信息失败" + e);
		}
	}

	/**
	 * 添加客户信息
	 * 
	 * @param customer
	 * @return
	 */
	@RequestMapping(value = "/addClientAction", method = RequestMethod.POST)
	public String addClientAction(Customer customer) {

		logger.debug("DitchController 添加客户信息 ，要添加的客户信息为：" + customer);

		try {

			ditchService.addClientInfo(customer);

			return "redirect:clientManager";

		} catch (Exception e) {
			logger.debug("DitchController 添加客户信息失败：" + e);
		}

		return null;
	}

	/**
	 * 删除客户信息
	 * 
	 * @param ids
	 * @param response
	 */
	@RequestMapping(value = "/deleteClient", method = RequestMethod.POST)
	public void deleteClient(@RequestParam(value = "id[]") String[] ids, HttpServletResponse response) {

		logger.debug("DitchController: 删除客户信息，要删除的客户ID为：" + ids.toString());

		try {
			List<Integer> param = new ArrayList<>();
			for (int i = 0; i < ids.length; i++) {
				param.add(Integer.parseInt(ids[i]));
			}
			ditchService.deleteClient(param);
			// response.getWriter().write("ok");
			// response.getWriter().flush();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			logger.debug("DitchController: 删除客户信息失败：" + e);
		}

	}

	/**
	 * 添加客户之前的预处理
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("addClient")
	public ModelAndView preprocessAddClient(HttpServletRequest request) {
		String viewName = "../main/content/ditch/addClient";
		try {
			return getCurrentUser(request, viewName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 分销费用的审核的预处理
	 * 
	 * @param userid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/costVerify")
	public ModelAndView preCostVerify(HttpServletRequest request) throws Exception {
		String viewName = "../main/content/ditch/costVerify";
		return getCurrentUser(request, viewName);
	}
	
	@RequestMapping(value="/processCostVerify", method=RequestMethod.POST)
	@ResponseBody
	public Object processCostVerify(@RequestParam("page") int pageNumer, @RequestParam("rows") int pageSize,
			@RequestParam("userid") int userid, HttpServletRequest request) throws Exception{
		
		String start_yingfu = request.getParameter("start_yingfu");
		String end_yingfu = request.getParameter("end_yingfu");
		String start_fandian = request.getParameter("start_fandian");
		String end_fandian = request.getParameter("end_fandian");
		String start_shiji = request.getParameter("start_shiji");
		String end_shiji = request.getParameter("end_shiji");
		
		List<Map<String, Object>> list = null;
		
		if((start_yingfu == null || start_yingfu == "")
			&& (end_yingfu == null || end_yingfu =="")
			&& (start_fandian == null || start_fandian == "")
			&& (end_fandian == null || end_fandian == "")
			&& (start_shiji == null || start_shiji == "")
			&& (end_shiji == null || end_shiji == "")){
			//查询所有
			list = ditchService.ditchCostCount(userid);
		}else{
			//根据参数进行查询
			Map<String, Object> param = new HashMap<>();
			param.put("userid", userid);
			param.put("start_yingfu", start_yingfu);
			param.put("end_yingfu", end_yingfu);
			param.put("start_fandian", start_fandian);
			param.put("end_fandian", end_fandian);
			param.put("start_shiji", start_shiji);
			param.put("end_shiji", end_shiji);
			list = ditchService.ditchCostCountSearch(param);
		}
		
		
		Map<String, Object> resultMap = new HashMap<>();
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		
		for (int i = 0; i < list.size(); i++) {
			jsonObject.put("id", list.get(i).get("id"));
			jsonObject.put("number", list.get(i).get("number"));
			jsonObject.put("customername", list.get(i).get("customername"));
			jsonObject.put("name", list.get(i).get("name"));
			jsonObject.put("size", list.get(i).get("size"));
			jsonObject.put("price", list.get(i).get("price"));
			jsonObject.put("goodsNum", list.get(i).get("goodsNum"));
			jsonObject.put("truePay", list.get(i).get("truePay"));
			jsonObject.put("fandian", list.get(i).get("fandian"));
			jsonObject.put("fandianjine", list.get(i).get("fandianjine"));
			jsonObject.put("shijifukuan", list.get(i).get("shijifukuan"));
			jsonObject.put("shijishouokuan", list.get(i).get("shijifukuan"));
			jsonArray.add(jsonObject);
		}
		resultMap.put("total", orderService.getTotalCount(userid));
		resultMap.put("rows", jsonArray);
		return JSONObject.fromObject(resultMap);
	}

	/**
	 * 分销费用的计算
	 * 
	 * @param userid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/costCount")
	public ModelAndView processCostCount(HttpServletRequest request) throws Exception {

		logger.debug("DitchController ,分销费用的计算 ...");
			
		try {
			
			User user = (User) request.getSession().getAttribute("currentUser");

			ModelAndView model = new ModelAndView();

			if (user == null) {
				model.setViewName("../index");
			} else {
				int userid = user.getId();

				List<Map<String, Object>> list = ditchService.ditchCostCount(userid);
				String viewName = "../main/content/ditch/costCount";
				model.setViewName(viewName);
				model.addObject("user", user);
				model.addObject("list", list);
			}
			return model;
			
		} catch (Exception e) {
			logger.debug("DitchController ,分销费用的计算失败 ...");
		}
		return null;
	}
	
	/**
	 * 分消费查询预处理
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/costSearch")
	public ModelAndView preCostSearch(HttpServletRequest request) throws Exception{
		String viewName = "../main/content/ditch/costSearch";
		return getCurrentUser(request, viewName);
	}
	
	
	/**
	 * 修改返点费用
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/editFanDian", method=RequestMethod.POST)
	public String editFanDian(HttpServletRequest request) throws Exception{
		
		try {
			logger.debug("DitchController , 修改返点 ...");
			
			//获取修改的返点的值
			String inputText = request.getParameter("inputText");
			//要修改哪个订单的返点
			String orderId = request.getParameter("fandian");
			
			Map<String, Object> param = new HashMap<>();
			param.put("fanDianValue", inputText);
			param.put("orderId", orderId);
			
			ditchService.editFanDian(param);
			
			return "redirect:costCount";
			
		} catch (Exception e) {
			logger.debug("DitchController , 修改返点失败 ：" + e);
		}
		return null;
	}
	
	/**
	 * 付款结算预处理
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/payManager")
	public ModelAndView prePayManager(HttpServletRequest request) throws Exception{
		String viewName = "../main/content/ditch/payManager";
		return getCurrentUser(request, viewName);
	} 
	
	
	/**
	 * 打印分销商信息
	 * @throws Excetion
	 */
	@RequestMapping("/exportClientExcel")
	public void exportClientExcel () throws Exception{

		logger.debug("DitchController, 导出分销商信息....");
		
		User user = (User) request.getSession().getAttribute("currentUser");
		if(user == null){
			return ;
		}
		List<Customer> exportExcelDataMap = null;
		List<Map<String, Object>> data = new ArrayList<>();
		try {
			exportExcelDataMap = ditchService.queryCustomersByUserId(user.getId());
			for(Customer g : exportExcelDataMap){
				Map<String, Object> m = new LinkedHashMap<>();
				m.put("number", g.getNumber());
				m.put("name", g.getCustomerName());
				m.put("postCode", g.getPostCode());
				m.put("address", g.getAddress());
				m.put("telephone", g.getTelephone());
				m.put("connectPerson", g.getConnectPerson());
				m.put("phone", g.getPhone());
				m.put("bank", g.getBank());
				m.put("account", g.getAccount());
				m.put("email", g.getEmail());
				m.put("fax", g.getFax());
				m.put("description", g.getDescription());
				data.add(m);
			}
			String sheetName = "分销商信息";
			String[] headers = {"分销商编号","分销商名称","邮编","地址","客户电话","联系人","联系人电话","开户银行","银行账号","邮箱","传真","备注"};
			String exportExcelName = "库存初始化信息表";
			ExportExcel_Map.exportExcel(sheetName, data, headers, exportExcelName,response);
		} catch (Exception e) {
			logger.debug("StoreController, 导出库存信息失败: " + e);
		}
	}
	
	
	/**
	 * 管理员打印所有分销商信息
	 * @throws Exception
	 */
	@RequestMapping("/exportAllClientExcel")
	public void exportAllClientExcel() throws Exception{
		
		logger.debug("DitchController, 导出分销商信息....");
		
		List<Customer> exportExcelDataMap = null;
		List<Map<String, Object>> data = new ArrayList<>();
		try {
			exportExcelDataMap = ditchService.queryAllCustomer();
			for(Customer g : exportExcelDataMap){
				Map<String, Object> m = new LinkedHashMap<>();
				m.put("number", g.getNumber());
				m.put("name", g.getCustomerName());
				m.put("postCode", g.getPostCode());
				m.put("address", g.getAddress());
				m.put("telephone", g.getTelephone());
				m.put("connectPerson", g.getConnectPerson());
				m.put("phone", g.getPhone());
				m.put("bank", g.getBank());
				m.put("account", g.getAccount());
				m.put("email", g.getEmail());
				m.put("fax", g.getFax());
				m.put("description", g.getDescription());
				m.put("userid", g.getUserId());
				data.add(m);
			}
			String sheetName = "分销商信息";
			String[] headers = {"分销商编号","分销商名称","邮编","地址","客户电话","联系人","联系人电话","开户银行","银行账号","邮箱","传真","备注","用户ID"};
			String exportExcelName = "库存初始化信息表";
			ExportExcel_Map.exportExcel(sheetName, data, headers, exportExcelName,response);
		} catch (Exception e) {
			logger.debug("StoreController, 导出库存信息失败: " + e);
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
		list = (List<T>) ditchService.queryCustomersByUserId(userid);
		return new PageBean<T>(list);
	}

	/**
	 * 带Map参数的分页
	 * 
	 * @param pageNumer
	 * @param pageSize
	 * @param t
	 * @param paramMap
	 * @return
	 */
	public <T> PageBean queryByPageByParamMap(int pageNumer, int pageSize, T t, Map<String, Object> paramMap) {
		List<T> list = null;
		try {
			PageHelper.startPage(pageNumer, pageSize);
			list = (List<T>) ditchService.queryCustomersByParamMap(paramMap);
			return new PageBean<T>(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
