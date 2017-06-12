package controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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

import dto.RoleMapper;
import dto.User_Role;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import pojo.Role;
import pojo.User;
import service.RoleServiceImpl;
import service.UserServiceImpl;

@Controller
public class ContentController {
	
	private Logger logger = Logger.getLogger(ContentController.class);
	
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Autowired
	private RoleServiceImpl roleService;
	
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

		logger.debug("UserController : 获取当前用户，当前用户为 ：" + user);

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
	 * 查询所有用户
	 * @param pageNumber
	 * @param pageSize
	 * @param userParam
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value ="/regist")
	@ResponseBody
    public Object regist(@RequestParam("page") int pageNumber, 
    		@RequestParam("rows") int pageSize, User userParam) throws Exception {

		logger.debug("UserController，查询所有用户...");
		
		String account = request.getParameter("account");
		String name= request.getParameter("name");
		try {
			List<Map<String, Object>> list = null;
			if((account == null || account == "") && (name == null || name == "")){
				//查询所有
				list = userServiceImpl.queryAllUser_Role();
			}else{
				//根据参数进行查询
				Map<String, Object> param = new HashMap<>();
				param.put("account", account);
				param.put("name", name);
				list = userServiceImpl.queryAllUser_Role(param);
			}
			
			Map<String, Object> result = new HashMap<String, Object>() ; 
	        JSONArray arr = new JSONArray();
	        JSONObject json = new JSONObject();
	        for(int i = 0; i < list.size(); i++){
	        	json.put("id", list.get(i).get("id"));
	        	json.put("account", list.get(i).get("account"));
	        	json.put("password", list.get(i).get("password"));
	        	json.put("username", list.get(i).get("username"));
	        	json.put("roleName", RoleMapper.getRoleName((String)list.get(i).get("roleName")));
	            arr.add(json); 
	        }
		    result.put("total",userServiceImpl.getTotalCount());
		    result.put("rows", arr);   
		    
		    return JSONObject.fromObject(result);
			
		} catch (Exception e) {
			logger.debug("UserController，查询所有用户失败 : " + e);
		}
		return null;
    }
	
	/**
	 * 修改用户信息
	 * @param request
	 * @param test
	 * @param response
	 */
	@RequestMapping(value="/editUserInformation", method=RequestMethod.POST)
	public void editUserInformation(@RequestBody JSONObject data,HttpServletResponse response){
		
		logger.debug("ContentController, 修改用户信息，要修改的信息为：" + data);
		
		try {
			
			User t = (User) JSONObject.toBean(data, User.class);
			userServiceImpl.modifyUser(t);
			//ajax请求的话，必须向页面返回数据
			response.getWriter().write("ok");
			response.getWriter().flush();
		} catch (Exception e) {
			logger.debug("ContentController, 修改用户信息失败：" + e);
		}
	}
	
	/**
	 * 添加用户预处理
	 */
	@RequestMapping(value="/addUser")
	public ModelAndView preAddUser(HttpServletRequest request){
		try {
			String viewName = "../main/content/config/addUser";
			ModelAndView model = getCurrentUser(request, viewName);
			List<Role> list = roleService.queryAllRole();
			List<Role> result = new ArrayList<>();
			for(Role r : list){
				Role role = new Role(r.getRoleId(), RoleMapper.getRoleName(r.getRoleName()));
				result.add(role);
			}
			model.addObject("roles",result);
			return model;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 处理用户添加
	 * @param ur
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/addUserAction", method=RequestMethod.POST)
	public String processAddUser(User_Role ur) throws Exception{
		
		logger.debug("ContentController,添加用户，要添加的用户为：  " + ur);
		
		try {
			
			userServiceImpl.addUser(ur);
			
			return "redirect:userManager";
			
		} catch (Exception e) {
			logger.debug("ContentController,添加用户失败： " + e);
		}
		return null;
	}
	
	/**
	 * 删除用户信息
	 * @param response
	 * @param usersId
	 */
	@RequestMapping("/deleteUser")
	public void deleteUserInformation(HttpServletResponse response, @RequestParam(value = "usersId[]") String[] usersId){
		
		try {
			List<Integer> usersIdList = new ArrayList<>();
			for (int i = 0; i < usersId.length; i++) {
				usersIdList.add(Integer.parseInt(usersId[i]));
			}
			userServiceImpl.deleteUsers(usersIdList);
			response.getWriter().write("ok");
			response.getWriter().flush();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 密码修改预处理
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/passwordFix")
	public ModelAndView prepasswordFix(HttpServletRequest request) throws Exception{
		String viewName = "../main/content/config/passwordFix";
		return getCurrentUser(request, viewName);
	}
	
	/**
	 * 处理密码修改
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/fixPasswordAction", method=RequestMethod.POST)
	public String processfixPasswordAction() throws Exception{
		
		logger.debug("ContentController,密码修改.....");
		
		try {
			int userId = Integer.parseInt(request.getParameter("id"));
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			Map<String, Object> param = new HashMap<>();
			param.put("id", userId);
			param.put("username", username);
			param.put("password", password);
			
			userServiceImpl.fixPassword(param);
			
			return "redirect:fixPwdReturnSuccess?userid="+userId;
		} catch (Exception e) {
			logger.debug("ContentController,密码修改失败： " + e);
		}
		return null;
	}
	
	@RequestMapping("fixPwdReturnSuccess")
	public ModelAndView fixPwdReturnSuccess(@RequestParam("userid") int userId) throws Exception{
		User user = userServiceImpl.queryUserById2(userId);
		ModelAndView model = new ModelAndView();
		model.setViewName("../main/content/config/passwordFix");
		model.addObject("user", user);
		return model;
	}
	
	 protected HttpServletRequest request;           
	 protected HttpServletResponse aa;   
	 
	 @ModelAttribute            
	 public void setReqAndRes(HttpServletRequest request, HttpServletResponse response){     
	     this.request = request;               
	     this.aa = response;                
	 }
	
	/*@RequestMapping(value="/exportInformationExcel",method=RequestMethod.GET)
	public void exportInformationExcel(){
		System.out.println("dadfasd");
		userServiceImpl.exportInformationExcel(aa);
	}
	*/
}
