package service;

import java.util.List;

import dao.FuncDao;
import inf.IFuncService;
import pojo.Function;

public class FuncServiceImpl implements IFuncService {

	private FuncDao funcDao;

	public void setFuncDao(FuncDao funcDao) {
		this.funcDao = funcDao;
	}

	@Override
	public List<Function> queryFunctionByRoleId(int roleid) {
		try {
			return funcDao.queryFunctionByRoleId(roleid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
