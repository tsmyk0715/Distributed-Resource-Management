package service;

import java.util.List;

import dao.RoleDao;
import inf.IRoleService;
import pojo.Role;

public class RoleServiceImpl implements IRoleService{

	private RoleDao roleDao;

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	@Override
	public Role queryRoleByUserId(int userid) {
		try {
			return roleDao.queryRoleByUserId(userid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Role> queryAllRole() throws Exception {
		try {
			return roleDao.queryAllRole();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
