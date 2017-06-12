package inf;

import java.util.List;
import java.util.Map;

import dto.PageBean;
import dto.User_Role;
import pojo.User;

public interface IUserService {

	List<User> queryAllUser();

	User queryUserById(int userid) throws Exception;
	User queryUserById2(int userid) throws Exception;
	void modifyUser(User User) throws Exception;

	void deleteUsers(List<Integer> list) throws Exception;

	void addUser(User_Role ur) throws Exception;

	List<Map<String, Object>> queryAllUser_Role();

	List<Map<String, Object>> queryAllUser_Role(Map<String, Object> map);

	int getTotalCount();

	int getMaxUserId();

	void fixPassword(Map<String, Object> param) throws Exception;
}
