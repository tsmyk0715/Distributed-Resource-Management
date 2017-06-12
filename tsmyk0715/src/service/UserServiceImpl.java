package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import dao.UserDao;
import dto.PageBean;
import dto.User_Role;
import inf.IUserService;
import pojo.User;

@Transactional
public class UserServiceImpl implements IUserService {

	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	private Logger logger = Logger.getLogger(UserServiceImpl.class);

	@Override
	public List<User> queryAllUser() {
		List<User> usersList = userDao.queryAllUser();
		System.out.println(usersList.toString());
		return usersList;
	}

	@Override
	public User queryUserById(int userid) {
		try {
			return userDao.queryUserById(userid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	/**
	 * 分页信息查询
	 * @param pageNumber
	 * @param pageSize
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public PageBean<User> queryTestByPage(int pageNumber, int pageSize, User user) throws Exception {
		List<User> list = null;
		PageHelper.startPage(pageNumber,pageSize);
		list = userDao.queryAllUser();
		return new PageBean<User>(list);
	}
	
	/**
	 * 分页信息查询
	 * @param pageNumber
	 * @param pageSize
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public PageBean<User> queryTestByPage(int pageNumber, int pageSize, Map<String, Object> map) throws Exception {
		List<User> list = null;
		PageHelper.startPage(pageNumber,pageSize);
		return new PageBean<User>(list);
	}
	
	
	/*public void exportInformationExcel(HttpServletResponse response){
		try {
			List<User> dataset = userDao.queryTestByPage();
			String sheetName = "test";
			String[] headers = {"ID","username","lastname","phone","email"};
			String exportExcelName = "test";
			ExportExcel.exportExcel(sheetName, headers, dataset, 
					exportExcelName, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
*/
	
	/**
	 * 修改用户信息
	 */
	@Override
	public void modifyUser(User user) throws Exception {
		
		logger.debug("UserService. 修改用户信息..,要修改的用户为 ： " + user);
		
		try {
			
			userDao.modifyUser(user);
			
		} catch (Exception e) {
			logger.debug("UserService. 修改用户信息失败：" + e);
		}
		
	}

	@Override
	public void deleteUsers(List<Integer> list) throws Exception {
		logger.debug("UserService, 删除用户。。。");
		try {
			userDao.deleteUsers(list);
		} catch (Exception e) {
			logger.debug("UserService, 删除用户失败： " + e);
		}
	}

	@Override
	public void addUser(User_Role ur) throws Exception {
		logger.debug("UserService, 添加用户。。。");
		try {
			User user = new User(ur.getAccount(), ur.getUsername(), ur.getPassword());
			userDao.addUser(user);
			int userId = this.getMaxUserId();
			int roleId = ur.getRoleId();
			Map<String, Object> param = new HashMap<>();
			param.put("userId", userId);
			param.put("roleId", roleId);
			userDao.insert_user_role(param);
		} catch (Exception e) {
			logger.debug("UserService, 添加用户失败：" + e);
		}
	}


	@Override
	public List<Map<String, Object>> queryAllUser_Role() {
		try {
			return userDao.queryAllUser_Role();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Map<String, Object>> queryAllUser_Role(Map<String, Object> map) {
		try {
			return userDao.queryUserByParamMap(map);
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public int getTotalCount() {
		try {
			return userDao.getTotalCount();
		} catch (Exception e) {
		}
		return 0;
	}

	@Override
	public int getMaxUserId() {
		try {
			return userDao.getMaxUserId();
		} catch (Exception e) {
		}
		return 0;
	}

	@Override
	public void fixPassword(Map<String, Object> param) throws Exception {
		
		try {
			userDao.fixPassword(param);
		} catch (Exception e) {
		}
	}

	@Override
	public User queryUserById2(int userid) throws Exception {
		try {
			return userDao.queryUserById2(userid);
		} catch (Exception e) {
		}
		return null;
	}

	
}
