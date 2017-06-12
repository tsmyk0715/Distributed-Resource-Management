package dao;

import java.util.List;

import pojo.Role;

public interface RoleDao {
	
	Role queryRoleByUserId(int userid) throws Exception;
	
	List<Role> queryAllRole () throws Exception;
}
