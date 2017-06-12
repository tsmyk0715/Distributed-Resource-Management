package inf;

import java.util.List;


import pojo.Function;

public interface IFuncService {
	
	List<Function> queryFunctionByRoleId(int roleid) throws Exception;	

}
