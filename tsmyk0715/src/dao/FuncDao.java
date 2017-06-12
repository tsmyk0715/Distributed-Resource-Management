package dao;

import java.util.List;


import pojo.Function;

public interface FuncDao {
	
	List<Function> queryFunctionByRoleId(int roleid) throws Exception;	
	
}
