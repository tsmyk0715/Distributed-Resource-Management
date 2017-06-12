package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.ResolverUtil.Test;

import pojo.User;

public interface UserDao {
	
	List<User> queryAllUser();
	
	List<Map<String, Object>> queryAllUser_Role();
	
	User queryUserById(int userid) throws Exception;
	User queryUserById2(int userid) throws Exception;
	
	void modifyUser(User user) throws Exception;
	
	void deleteUsers(List<Integer> list) throws Exception;
	
	void addUser(@Param("user") User user) throws Exception;
	
	List<Map<String, Object>> queryUserByParamMap (Map<String, Object> map) throws Exception;

	int getTotalCount();
		
	//获取最大ID号
	int getMaxUserId();
	
	//插入数据到 user_role表
	void insert_user_role(Map<String, Object> param) throws Exception;
	
	void fixPassword(Map<String, Object> param) throws Exception;
}
