package pojo;

/**
 * 管理员类
 * @author tsmyk0715
 *
 */
public class User {
	
	/*ID*/
	private int id;
	
	/*账户（用户名）*/
	private String account;
	
	/*姓名*/
	private String username;
	
	/*密码*/
	private String password;
	
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public int getId() {
		return id;
	}
	
	public static <T> void a(){}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User() {
		super();
	}

	public User(String account, String username, String password) {
		super();
		this.account = account;
		this.username = username;
		this.password = password;
	}

	public User(int id, String account, String username, String password) {
		super();
		this.id = id;
		this.account = account;
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", account=" + account + ", username=" + username + ", password=" + password + "]";
	}
}
