package dto;

public class User_Role {
	
	private String account;
	private String password;
	private String username;
	private int roleId;
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	@Override
	public String toString() {
		return "User_Role [account=" + account + ", password=" + password + ", username=" + username + ", roleId="
				+ roleId + "]";
	}
	
	
}
