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

import dto.AddStockOut;
import dto.PageBean;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import pojo.Customer;
import pojo.Goods;
import pojo.User;
import service.DitchServiceImpl;
import service.StoreServiceImpl;
import tsmykTools.ExportExcel_Map;

/**
 * 库存模块的控制层
 * @author tsmyk0715
 *
 */
@Controller
public class StoreController {

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
	private Logger logger = Logger.getLogger(StoreController.class);
	
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
	 * 库存初始化功能的预处理
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/storeInit")
	public ModelAndView preStoreInit() throws Exception{
		String viewName = "../main/content/store/storeInit";
		return getCurrentUser(request, viewName);
	}
    
	/**
	 * 查询所有的商品
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/queryAllGoods", method=RequestMethod.POST)
	@ResponseBody
	public Object queryAllGoods(@RequestParam("page") int pageNumber, 
    		@RequestParam("rows") int pageSize, @RequestParam("userid") int userid) throws Exception
	{
		logger.debug("StoreController，查询所有的商品...");
		
		String number = request.getParameter("number");
		String name = request.getParameter("name");
		String place = request.getParameter("place");
		
		Goods goodsPar = null;  
		//分页
		PageBean<Goods> pageBean = null ;
		
		if((number == null || number == "") 
				&& (name == null || name == "") 
				&& (place == null || place == "")){
			//查询所有的
			pageBean = this.queryByPage(pageNumber, pageSize, goodsPar,userid);
		}else{
			//根据查询条件进行查询
			Map<String,Object> paramMap = new HashMap<>();
			paramMap.put("number", number);
			paramMap.put("name", name);
			paramMap.put("place", place);
			paramMap.put("userid", userid);
			pageBean = this.queryByPage(pageNumber, pageSize, goodsPar,paramMap); 
		}

		//获取数据集
		List<Goods> goodses = pageBean.getList();

		logger.debug("goodsController-查询到的商品集合：" + goodses);
		
		Map<String, Object> resultMap = new HashMap<>();
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
	
		for(Goods goods : goodses)
		{
			jsonObject.put("id", goods.getId());
			jsonObject.put("number", goods.getNumber());
			jsonObject.put("name", goods.getName());
			jsonObject.put("productPlace", goods.getProductPlace());
			jsonObject.put("size", goods.getSize());
			jsonObject.put("_package", goods.getGoodsPackage());
			jsonObject.put("productCode", goods.getProductCode());
			jsonObject.put("promitCode", goods.getPromitCode());
			jsonObject.put("price", goods.getPrice());
			jsonObject.put("goodsNum", goods.getGoodsNum());
			jsonObject.put("available", goods.getAvailable());
			jsonObject.put("description", goods.getDescription());
			jsonArray.add(jsonObject);
		}
		resultMap.put("total",pageBean.getTotal());
		resultMap.put("rows", jsonArray);
		return JSONObject.fromObject(resultMap);
	}
	
	
	/**
	 * 查询出库单预处理
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/stockOut")
	public ModelAndView preStockOut() throws Exception{
		String viewName = "../main/content/store/stockOut";
		return getCurrentUser(request, viewName);
	}
	
	/**
	 * 查询出库单
	 * @param pageNum
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/queryAllStoctOut",method=RequestMethod.POST)
	@ResponseBody
	public Object queryAllStoceOut(@RequestParam("page") int pageNum,
			@RequestParam("rows") int pageSize, int userid) throws Exception
	{
		
		logger.debug("StoreController，查询所有的出库单...");
		
		try {
			
			String number = request.getParameter("number");
			String clientName = request.getParameter("clientName");
			String goodsName = request.getParameter("goodsName");
			
			List<Map<String, Object>> allStockOut = null;
			
			if((number == null || number == "") 
					&& (clientName == null || clientName == "") 
					&& (goodsName == null || goodsName == "")){
				//查询所有的
				allStockOut = storeService.queryAllStockOut(userid);
			}else{
				Map<String, Object> paramMap = new HashMap<>();
				paramMap.put("number", number);
				paramMap.put("clientName", clientName);
				paramMap.put("goodsName", goodsName);
				paramMap.put("userid", userid);
				
				allStockOut = storeService.queryStockOutByParam(paramMap);
			}
			
			logger.debug("StoreController：查询到的出库单：" + allStockOut);
			
			Map<String, Object> resultMap = new HashMap<>();
			JSONArray jsonArray = new JSONArray();
			JSONObject jsonObject = new JSONObject();
			
			for(int i = 0; i < allStockOut.size(); i++){
				jsonObject.put("id", allStockOut.get(i).get("id"));
				jsonObject.put("number", allStockOut.get(i).get("number"));
				jsonObject.put("clientId", allStockOut.get(i).get("clientId"));
				jsonObject.put("goodsId", allStockOut.get(i).get("goodsId"));
				jsonObject.put("customername", allStockOut.get(i).get("customername"));
				jsonObject.put("name", allStockOut.get(i).get("name"));
				jsonObject.put("size", allStockOut.get(i).get("size"));
				jsonObject.put("goodsNumber", allStockOut.get(i).get("goodsNumber"));
				jsonObject.put("outTime", allStockOut.get(i).get("outTime"));
				jsonObject.put("description", allStockOut.get(i).get("description"));
				jsonArray.add(jsonObject);
			}
			
			int stockOutCount = storeService.queryAllCountStockOut();
			
			resultMap.put("total",stockOutCount);
			resultMap.put("rows", jsonArray);
			return JSONObject.fromObject(resultMap);
			
		} catch (Exception e) {
			logger.debug("StoreController，查询所有的出库单失败：" + e);
		}
		return null;
	}
	
	/**
	 * 修改出库单信息
	 * @param request
	 * @param data
	 * @param response
	 */
	@RequestMapping(value="/editStockOutInformation",method=RequestMethod.POST)
	public void editStockOutInformation(HttpServletRequest request,
			@RequestBody JSONObject data,HttpServletResponse response){
		
		int id = Integer.parseInt(data.getString("id"));
		
		int goodsNum = Integer.parseInt(data.getString("goodsNum"));
		String desc = data.getString("desc");
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("id", id);
		paramMap.put("goodsNum", goodsNum);
		paramMap.put("desc", desc);
		
		try {
			storeService.editStockOutInfo(paramMap);
			//ajax请求的话，必须向页面返回数据
			response.getWriter().write("ok");
			response.getWriter().flush();
		} catch (Exception e) {
		}
		
	}
	
	/**
	 * 删除出库单
	 * @param response
	 * @param ids
	 */
	@RequestMapping(value="/deleteStoucOut", method=RequestMethod.POST)
	public void deleteStoucOut (HttpServletResponse response, 
			@RequestParam(value = "id[]") String[] ids){
		List<Integer> param = new ArrayList<>();
		for(int i = 0; i < ids.length; i++){
			param.add(Integer.parseInt(ids[i]));
		}
		try {
			storeService.deleteStockOut(param);
			response.getWriter().write("ok");
			response.getWriter().flush();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 添加出库单之前做的预处理
	 */
	@RequestMapping("/addStockOut")
	public ModelAndView addStockOut() throws Exception{
		
		logger.debug("StoreController：添加出库单...");
		
		try {
			
			User user = (User) request.getSession().getAttribute("currentUser");
			
			List<Goods> goodses = storeService.queryAllGoods();
			
			List<Customer> customers = ditchService.queryAllCustomer();
			
			ModelAndView model = new ModelAndView();
			
			if(user == null){
				model.setViewName("../index");
			}else{
				String viewName = "../main/content/store/addStockOut";
				model.setViewName(viewName);
				model.addObject("goodses", goodses);
				model.addObject("customers",customers);
				model.addObject("user", user);
			}
			return model;
			
		} catch (Exception e) {
			logger.debug("StoreController：添加出库单失败...");
		}
		return null;
	}
	
	
	/**
	 * 处理添加出库单
	 * @param aso
	 */
	@RequestMapping("/addStockOutAction")
	public String addStockOutProcess(AddStockOut aso) throws Exception{
		
		try {
			storeService.addStockOutProcess(aso);
			
			return "redirect:stockOut";
			
		} catch (Exception e) {
			logger.debug("StoreController： 处理添加出库单失败：" + e);
		}
		return null;
	}
	
	
	/**
	 * 物料维护管理预处理
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/goodsManager")
	public ModelAndView preGoodsManager() throws Exception{
		String viewName = "../main/content/store/goodsManager";
		return getCurrentUser(request, viewName);
	}
	
	/**
	 * 修改商品信息
	 * @param data
	 * @param response
	 */
	@RequestMapping(value="/editGoodsInformation", method=RequestMethod.POST)
	public void editGoodsInformation(@RequestBody JSONObject data, 
			HttpServletResponse response){
		
		logger.debug("StoreController : 修改商品信息：从页面获取到的信息 ：" + data);
		
		try {
			int id = data.getInt("id");
			String number = data.getString("number");
			String goodsName = data.getString("goodsName");
			String productPlace = data.getString("productPlace");
			String size = data.getString("size");
			String price = data.getString("price");
			String goodsNum = data.getString("goodsNum");
			String desc = data.getString("desc");
			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("id", id);
			paramMap.put("number", number);
			paramMap.put("goodsName", goodsName);
			paramMap.put("productPlace", productPlace);
			paramMap.put("goodsSize", size);
			paramMap.put("price", price);
			paramMap.put("goodsNum", goodsNum);
			paramMap.put("desc", desc);
			
			storeService.editGoodsInfo(paramMap);
		} catch (Exception e) {
			logger.debug("StoreController : 修改商品信息失败：" + e);
		}
	}
	
	/**
	 * 删除商品信息
	 * @param response
	 * @param ids
	 */
	@RequestMapping(value="/deleteGoods", method=RequestMethod.POST)
	public void deleteGoods(@RequestParam(value = "id[]") String[] ids){
		
		logger.debug("StroeController: 删除商品信息，要删除的商品ID为：" + ids.toString());
		
		List<Integer> param = new ArrayList<>();
		for(int i = 0; i < ids.length; i++){
			param.add(Integer.parseInt(ids[i]));
		}
		try {
			storeService.deleteGoods(param);
			response.getWriter().write("ok");
			response.getWriter().flush();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			logger.debug("StroeController: 删除商品信息失败：" + e);
		}
	}
	
	
	/**
	 * 添加商品信息之前的预处理
	 * @throws Exception
	 */
	@RequestMapping("/addGoods")
	public ModelAndView preproccessAddGoods(HttpServletRequest request) throws Exception{
		
		logger.debug("StoreController：添加商品信息...");
		try {
			
			ModelAndView model = new ModelAndView();
			
			User user = (User) request.getSession().getAttribute("currentUser");
			
			logger.debug("StoreController : 添加商品信息之前的预处理,当前用户的信息 : " + user);
			
			if(user == null){//session失效，跳到首页
				String viewName = "../index";
				model.setViewName(viewName);
			}else{
				String viewName = "../main/content/store/addGoods";
				model.setViewName(viewName);
				model.addObject("user",user);
			}
			return model;
			
		} catch (Exception e) {
			logger.debug("StoreController : 添加商品信息之前的预处理失败 : " + e);
		}
		
		return null;
	}
	
	/**
	 * 处理添加商品信息
	 * @param goods
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/addGoodsAction", method=RequestMethod.POST)
	public String processAddGoods(Goods goods,HttpServletRequest request) throws Exception{
		
		logger.debug("StoreController : 处理添加商品信息：要添加的商品为 ： " + goods);
		try {
			
			int uid = Integer.parseInt(request.getParameter("userId"));
			String available = request.getParameter("available");
			String description = request.getParameter("description");
			goods.setUserId(uid);
			if(available == null){
				goods.setAvailable("");
			}
			if(description == null){
				goods.setDescription("");
			}
			
			storeService.processAddGoods(goods);
			
			return "redirect:goodsManager";
			
		} catch (Exception e) {
			logger.debug("StoreController : 处理添加商品信息失败 ： " + e);
		}
		return null;
	}
	
	
	/**
	 * 导出库存信息到 Excel 表
	 * @return
	 */
	@RequestMapping("/exportExcel")//exportInfoExcel
	public void exportInfoExcel(HttpServletResponse resp){
		
		logger.debug("StoreController, 导出库存信息....");
		
		User user = (User) request.getSession().getAttribute("currentUser");
		if(user == null){
			return ;
		}
		List<Goods> exportExcelDataMap = null;
		List<Map<String, Object>> data = new ArrayList<>();
		try {
			exportExcelDataMap = storeService.queryGoodsByUserId(user.getId());
			for(Goods g : exportExcelDataMap){
				Map<String, Object> m = new LinkedHashMap<>();
				m.put("ID", g.getId());
				m.put("number", g.getNumber());
				m.put("name", g.getName());
				m.put("productPlace", g.getProductPlace());
				m.put("size", g.getSize());
				m.put("goodsPackage", g.getGoodsPackage());
				m.put("productCode", g.getProductCode());
				m.put("promitCode", g.getPromitCode());
				m.put("price", g.getPrice());
				m.put("goodsNum", g.getGoodsNum());
				m.put("description", g.getDescription());
				data.add(m);
			}
			
			String sheetName = "库存初始化信息";
			String[] headers = {"ID","商品编号","商品名称","产地","规格","包装","生产批号","批准文号","价格","商品数量","备注"};
			String exportExcelName = "库存初始化信息表";
			ExportExcel_Map.exportExcel(sheetName, data, headers, exportExcelName,resp);
		} catch (Exception e) {
			logger.debug("StoreController, 导出库存信息失败: " + e);
		}
	}
	
	
	/**
	 * 管理员导出所有的库存信息到 Excel 表
	 * @throws Exception
	 */
	@RequestMapping("/exportAllExcel")
	public void exportAllExcel() throws Exception{
		logger.debug("StoreController, 导出库存信息....");
		
		List<Goods> exportExcelDataMap = null;
		List<Map<String, Object>> data = new ArrayList<>();
		try {
			exportExcelDataMap = storeService.queryAllGoods();
			for(Goods g : exportExcelDataMap){
				Map<String, Object> m = new LinkedHashMap<>();
				m.put("ID", g.getId());
				m.put("number", g.getNumber());
				m.put("name", g.getName());
				m.put("productPlace", g.getProductPlace());
				m.put("size", g.getSize());
				m.put("goodsPackage", g.getGoodsPackage());
				m.put("productCode", g.getProductCode());
				m.put("promitCode", g.getPromitCode());
				m.put("price", g.getPrice());
				m.put("goodsNum", g.getGoodsNum());
				m.put("description", g.getDescription());
				m.put("userid", g.getUserId());
				data.add(m);
			}
			
			String sheetName = "库存初始化信息";
			String[] headers = {"ID","商品编号","商品名称","产地","规格","包装","生产批号","批准文号","价格","商品数量","备注","用户ID"};
			String exportExcelName = "库存初始化信息表";
			ExportExcel_Map.exportExcel(sheetName, data, headers, exportExcelName,response);
		} catch (Exception e) {
			logger.debug("StoreController, 导出库存信息失败: " + e);
		}
	}
	
	/**
	 * 处理分页
	 * @param pageNumber
	 * @param pageSize
	 * @param T 传入类型泛型
	 * @return
	 * @throws Exception
	 */
	public <T> PageBean<T> queryByPage(int pageNumber, int pageSize, T t ,int userid) throws Exception {
		List<T> list = null;
		PageHelper.startPage(pageNumber,pageSize);
		list = (List<T>) storeService.queryGoodsByUserId(userid);
		return new PageBean<T>(list);
	}
	
	/**
	 * 处理分页带参数
	 * @param pageNumber
	 * @param pageSize
	 * @param T 传入类型泛型
	 * @return
	 * @throws Exception
	 */
	public <T> PageBean<T> queryByPage(int pageNumber, int pageSize, T t,
			Map<String, Object> paramMap) throws Exception {
		List<T> list = null;  
		PageHelper.startPage(pageNumber,pageSize);
		list = (List<T>) storeService.queryByParam(paramMap);
		return new PageBean<T>(list);
	}
}
