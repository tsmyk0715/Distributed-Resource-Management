package inf;

import java.util.List;

import pojo.Role;

public interface IRoleService {
	
	Role queryRoleByUserId(int userid) throws Exception;
	
	List<Role> queryAllRole () throws Exception;

}
