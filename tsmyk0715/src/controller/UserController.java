package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dto.RoleMapper;
import inf.IFuncService;
import inf.IRoleService;
import inf.IUserService;
import pojo.Function;
import pojo.Role;
import pojo.User;
import service.UserServiceImpl;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

@Controller
public class UserController {
	
	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private IRoleService roleService;

	@Autowired
	private IFuncService funcService;
	
	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(UserController.class);
	
	
	/**
	 * 权限，登陆成功后进行赋值
	 */
	private String identitfy = "";
		
	/**
	 * 处理登陆逻辑
	 * @param request 请求
	 * @param returnDataMap 封装返回到页面的数据
	 * @return returnView 返回的试图名
	 * @throws Exception 异常
	 */
    @RequestMapping(value="/doLogin", method=RequestMethod.POST)
    public String processLogin(HttpServletRequest request , Map<String, Object> returnDataMap)
    	throws Exception
    {
    	String returnView = "../index";
    	try
    	{
    		 returnView = doLogin(request, returnDataMap);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return returnView;
    }
    
    private String doLogin(HttpServletRequest request , Map<String, Object> returnDataMap)
    		throws NumberFormatException, Exception
    {
    	String userAccountParam = request.getParameter("TxtUserName");
        String passwordParam = request.getParameter("TxtPassword");
        String identitfyParam = request.getParameter("identitfy");
        
        int userAccount = Integer.parseInt(userAccountParam);
        
        String returnView = "../index";
    	User user = userService.queryUserById(userAccount);
    	
        String passworDb = user.getPassword();
       
        returnDataMap.put("errorMessage", "用户名或密码错误!");

        if(user != null)
        {
        	if(passwordParam.equals(passworDb))
        	{
        		//密码匹配正确，再匹配身份是否正确.
        		Role role = roleService.queryRoleByUserId(user.getId());
        		if(identitfyParam.equals(role.getRoleName()))
        		{
        			returnDataMap.clear();
        			request.getSession().setMaxInactiveInterval(-1);//20秒 
        			request.getSession().setAttribute("currentUser", user);
        			String roleName = RoleMapper.getRoleName(role.getRoleName());
        			request.getSession().setAttribute("currentUserRole", roleName);
        			String roleParam = role.getRoleId() + ":" + role.getRoleName();
        			identitfy = new BASE64Encoder().encode(roleParam.getBytes());
        			returnView = "../main/main";
        		}
        		else
        		{
        			returnDataMap.put("errorMessage", "您的身份选择错误！");
        		}
        	}
        }  
        return returnView;
    }
    
    /**
     * 处理权限
     * @param identitfyParam 角色（json格式）
     * @param modelMap 封装返回到页面的数据
     * @return modelAndView
     * @throws Exception
     */
    @RequestMapping(value="/authorization")
    public ModelAndView processAuthor(ModelMap modelMap) throws Exception 
    {
		try
		{
			modelMap = doAuthor(modelMap);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("../main/meun/meun",modelMap);
    }
       
    private ModelMap doAuthor(ModelMap modelMap)
    	throws IOException, NumberFormatException, Exception
    {
    	byte[] identitfyByte = new BASE64Decoder().decodeBuffer(identitfy);
		String identitfyJson = new String(identitfyByte);
		String[] identitfy = identitfyJson.split(":");
		String roleId = identitfy[0];
		List<Function> funsList = funcService.queryFunctionByRoleId(Integer.parseInt(roleId));
		modelMap.addAttribute("fun", funsList);
		return modelMap;
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
     * 用户管理预处理
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/userManager")
    public ModelAndView preuserManager(HttpServletRequest request) throws Exception{
    	String viewName = "../main/content/config/userManager";
    	return getCurrentUser(request, viewName);
    }
}
