package controller;

import java.util.ArrayList;
import java.util.Arrays;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import dto.EchartData;
import dto.Series;
import pojo.Customer;
import pojo.User;
import service.DataServiceImpl;
import service.DitchServiceImpl;
import tsmykTools.ExportExcel_Map;

/**
 * 数据统计管理模块控制层
 * @author tsmyk0715
 *
 */

@Controller
public class DataController {
	
	/**
	 * 自动注入分销商渠道管理的service层
	 */
	@Autowired
	private DitchServiceImpl ditchService;
	
	/**
	 * 自动注入数据统计管理模块service层
	 */
	@Autowired
	private DataServiceImpl dataService;
	
	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(DataController.class);
	
	
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

		logger.debug("DataController : 获取当前用户，当前用户为 ：" + user);

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
	 * 分销商地区分布图预处理
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/clientDiagram")
	public ModelAndView preClientDiagram(HttpServletRequest request) throws Exception{
		String viewName = "../main/content/data/clientDiagram";
		return getCurrentUser(request, viewName);
	}
	
	
	/**
     * 分销商地区分布饼状图
     * @param <T>
     * @return
     */
    @RequestMapping("/showCilentDistributionPie")
    @ResponseBody
    public EchartData processPieData() throws Exception{
    	
    	logger.debug("DataController, 分销商的地区分布图，饼状图处理...");
        
    	try {
    		User user = (User) request.getSession().getAttribute("currentUser");
    		if(user != null){
    			List<String> legend = new ArrayList<String>();
    			List<Map> serisData=new ArrayList<Map>();
    			
    			List<Customer> list = ditchService.queryCustomersByUserId(user.getId());//;queryAllCustomer()
    			
    			//计算客户地址的个数
    			Map<String, Integer> addressNumber = new HashMap<>();
    			for(Customer cus : list){
    				addressNumber.put(cus.getAddress(), 
    						((addressNumber.get(cus.getAddress()) == null ?  0  : addressNumber.get(cus.getAddress()))+1));
    			}
    			for (Entry<String, Integer> entry : addressNumber.entrySet()) {
    				Map<String, Object> map =new HashMap<>();
    				legend.add(entry.getKey());
    				map.put("name", entry.getKey());
    				map.put("value", entry.getValue());
    				serisData.add(map);
    			}
    			List<Series> series = new ArrayList<Series>();// 纵坐标
    			series.add(new Series("总数比较", "pie",serisData));
    			EchartData data = new EchartData(legend,null, series);
    			return data;
    		}
		} catch (Exception e) {
			logger.debug("DataController, 分销商的地区分布图，饼状图处理失败 : " + e);
		}
        return null;
    }
    
    /**
     * 分销商地区分布柱状图
     * @return
     */
    @RequestMapping("/showCilentDistributionBar")
    @ResponseBody
    public EchartData processBarData() throws Exception{
    	
    	logger.debug("DataController, 分销商的地区分布图，柱状图处理...");
    	
    	try {
    		User user = (User) request.getSession().getAttribute("currentUser");
    		
    		if(user != null){
    			List<String> category = new ArrayList<>();
    			List<Integer> serisData=new ArrayList<>();
    			
    			List<Customer> list = ditchService.queryCustomersByUserId(user.getId());
    			
    			//计算客户地址的个数
    			Map<String, Integer> addressNumber = new HashMap<>();
    			for(Customer cus : list){
    				addressNumber.put(cus.getAddress(), 
    						((addressNumber.get(cus.getAddress()) == null ?  0  
    								: addressNumber.get(cus.getAddress()))+1));
    			}
    			for (Entry<String, Integer> entry : addressNumber.entrySet()) {
    				category.add(entry.getKey());
    				serisData.add(entry.getValue());
    			}
    			List<String> legend = new ArrayList<String>(Arrays.asList(new String[] { "总数比较" }));// 数据分组
    			List<Series> series = new ArrayList<Series>();// 纵坐标
    			series.add(new Series("该地区分销商数量", "bar", serisData));
    			EchartData data = new EchartData(legend, category, series);
    			return data;
    		}
		} catch (Exception e) {
			logger.debug("DataController, 分销商的地区分布图，柱状图处理失败：" + e) ;
		}
    	return null;
    }     
    
    
    /**
     * 月度/季度分销明细表
     * @return
     */
    @RequestMapping("/distrClearSheet")
    public ModelAndView distrClearSheet() throws Exception{
    	
    	logger.debug("DataController， 查询月度/季度分销明细表....");
    	
    	ModelAndView model = new ModelAndView();

    	try {
    		User user = (User) request.getSession().getAttribute("currentUser");
        	
        	if (user == null) {
    			model.setViewName("../index");
    		} else {
    			model.setViewName("../main/content/data/distrClearSheet");
    			List<Map<String, Object>> januaryOrder = dataService.januaryOrder(user.getId());
    			List<Map<String, Object>> februaryOrder = dataService.februaryOrder(user.getId());
    			List<Map<String, Object>> marchOrder = dataService.marchOrder(user.getId());
    			List<Map<String, Object>> arpilOrder = dataService.arpilOrder(user.getId());
    			List<Map<String, Object>> mayOrder = dataService.mayOrder(user.getId());
    			List<Map<String, Object>> juneOrder = dataService.juneOrder(user.getId());
    			List<Map<String, Object>> julyOrder = dataService.julyOrder(user.getId());
    			List<Map<String, Object>> augustOrder = dataService.augustOrder(user.getId());
    			List<Map<String, Object>> septemberOrder = dataService.septemberOrder(user.getId());
    			List<Map<String, Object>> octoberOrder = dataService.octoberOrder(user.getId());
    			List<Map<String, Object>> novemberOrder = dataService.novemberOrder(user.getId());
    			List<Map<String, Object>> decemberOrder = dataService.decemberOrder(user.getId());
    			List<Map<String, Object>> firstQuarterOrder = dataService.firstQuarterOrder(user.getId());
    			List<Map<String, Object>> secondQuarterOrder = dataService.secondQuarterOrder(user.getId());
    			List<Map<String, Object>> thirdQuarterOrder = dataService.thirdQuarterOrder(user.getId());
    			List<Map<String, Object>> fourthQuarterOrder = dataService.fourthQuarterOrder(user.getId());
    			
    			model.addObject("januaryOrder", januaryOrder);
    			model.addObject("februaryOrder", februaryOrder);
    			model.addObject("marchOrder", marchOrder);
    			model.addObject("arpilOrder", arpilOrder);
    			model.addObject("mayOrder", mayOrder);
    			model.addObject("juneOrder", juneOrder);
    			model.addObject("julyOrder", julyOrder);
    			model.addObject("augustOrder", augustOrder);
    			model.addObject("septemberOrder", septemberOrder);
    			model.addObject("octoberOrder", octoberOrder);
    			model.addObject("novemberOrder", novemberOrder);
    			model.addObject("decemberOrder", decemberOrder);
    			model.addObject("firstQuarterOrder", firstQuarterOrder);
    			model.addObject("secondQuarterOrder", secondQuarterOrder);
    			model.addObject("thirdQuarterOrder", thirdQuarterOrder);
    			model.addObject("fourthQuarterOrder", fourthQuarterOrder);
    		}
    		
        	return model;
		} catch (Exception e) {
			logger.debug("DataController， 查询月度/季度分销明细表失败：" + e);
		}
    	return null;
    }
    
    /**
     * 查询分销商的库存报表
     * @return
     * @throws Exception
     */
    @RequestMapping("/clientStoreSheet")
    public ModelAndView storeChectSheet() throws Exception{
    	
    	logger.debug("DataController，查询分销商的库存报表。。。。。 ");
    	
    	ModelAndView model = new ModelAndView();
    	
    	try {
			
    		User user = (User) request.getSession().getAttribute("currentUser");
        	
        	if (user == null) {
    			model.setViewName("../index");
    		}else{
    			model.setViewName("../main/content/data/clientStoreSheet");
    			List<Map<String, Object>> storeChectSheet = dataService.storeChectSheet(user.getId());
    			model.addObject("storeChectSheet",storeChectSheet);
    		}
        	
        	return model;
        	
		} catch (Exception e) {
			logger.debug("DataController，查询分销商的库存报表失败：" + e);
		}
    	return null;
    }
    
    
    /**
     * 打印分销商库存报表
     * @throws Exception
     */
    @RequestMapping("/exportStoreExcel")
    public void exportStoreExcel() throws Exception {
    	
    	logger.debug("DataController，导出分销商库存报表。。。。");
		try {
			User user = (User) request.getSession().getAttribute("currentUser");
			if(user == null){
				return ;
			}
			List<Map<String, Object>> data = dataService.storeChectSheet(user.getId());
			List<Map<String, Object>> exportData = new ArrayList<>();
			for(Map<String, Object> map : data ){
				Map<String, Object> mapData = new LinkedHashMap<>();
				mapData.put("number",  map.get("number"));
				mapData.put("name",  map.get("name"));
				mapData.put("productplace",  map.get("productplace"));
				mapData.put("size",  map.get("size"));
				mapData.put("price",  map.get("price"));
				mapData.put("originalStore",  map.get("originalStore"));
				mapData.put("goodsOrderNumber",  map.get("goodsOrderNumber"));
				mapData.put("surplusStore",  map.get("surplusStore"));
				mapData.put("originalMoney",  map.get("originalMoney"));
				mapData.put("surplsMoney",  map.get("surplsMoney"));
				exportData.add(mapData);
			}
			String sheetName = "库存报表";
			String[] headers = {"商品编号","商品名称","产地","型号","价格","原始库存","订购数量","剩余库存","期初余额","期末余额"};
			String exportExcelName = "库存报表";
			ExportExcel_Map.exportExcel(sheetName, exportData, headers, exportExcelName, response);
		} catch (Exception e) {
			logger.debug("OrderController，导出分销商库存报表：" + e);
		}
    }
    
    
    /**
     * 管理员打印所有分销商的库存报表
     * @throws Exception
     */
    @RequestMapping("/exportAllStoreExcel")
    public void exportAllStoreExcel() throws Exception{
    	
    	logger.debug("DataController，导出分销商库存报表。。。。");
		
    	try {

    		List<Map<String, Object>> data = dataService.allStoreChectSheet();
			List<Map<String, Object>> exportData = new ArrayList<>();
			for(Map<String, Object> map : data ){
				Map<String, Object> mapData = new LinkedHashMap<>();
				mapData.put("number",  map.get("number"));
				mapData.put("name",  map.get("name"));
				mapData.put("productplace",  map.get("productplace"));
				mapData.put("size",  map.get("size"));
				mapData.put("price",  map.get("price"));
				mapData.put("originalStore",  map.get("originalStore"));
				mapData.put("goodsOrderNumber",  map.get("goodsOrderNumber"));
				mapData.put("surplusStore",  map.get("surplusStore"));
				mapData.put("originalMoney",  map.get("originalMoney"));
				mapData.put("surplsMoney",  map.get("surplsMoney"));
				mapData.put("userid",  map.get("userid"));
				exportData.add(mapData);
			}
			String sheetName = "库存报表";
			String[] headers = {"商品编号","商品名称","产地","型号","价格","原始库存","订购数量","剩余库存","期初余额","期末余额","用户ID"};
			String exportExcelName = "库存报表";
			ExportExcel_Map.exportExcel(sheetName, exportData, headers, exportExcelName, response);
		} catch (Exception e) {
			logger.debug("OrderController，导出分销商库存报表：" + e);
		}
    }
    
}
