package pojo;

/**
 * 客户类
 * @author tsmyk0715
 *
 */
public class Customer {
	
	/*ID*/
	private int id;

	/*客户编号*/
	private String number;
	
	/*客户名称*/
	private String customerName;
	
	/*客户邮编*/
	private String postCode;
	
	/*客户地址*/
	private String address;
	
	/*客户电话*/
	private String telephone;
	
	/*联系人*/
	private String connectPerson;
	
	/*联系人电话*/
	private String phone;
	
	/*开户银行*/
	private String bank;
	
	/*银行账户*/
	private String account;
	
	/*联系人邮箱*/
	private String email;
	
	/*公司传真*/
	private String fax;
	
	/*备注*/
	private String description;
	
	/*用户Id，属于哪个用户的客户*/
	private int userId;
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getConnectPerson() {
		return connectPerson;
	}

	public void setConnectPerson(String connectPerson) {
		this.connectPerson = connectPerson;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Customer() {
		super();
	}

	public Customer(int id, String number, String customerName, String postCode, String address, String telephone,
			String connectPerson, String phone, String bank, String account, String email, String fax,
			String description) {
		super();
		this.id = id;
		this.number = number;
		this.customerName = customerName;
		this.postCode = postCode;
		this.address = address;
		this.telephone = telephone;
		this.connectPerson = connectPerson;
		this.phone = phone;
		this.bank = bank;
		this.account = account;
		this.email = email;
		this.fax = fax;
		this.description = description;
	}

	public Customer(String number, String customerName, String postCode, String address, String telephone,
			String connectPerson, String phone, String bank, String account, String email, String fax,
			String description) {
		super();
		this.number = number;
		this.customerName = customerName;
		this.postCode = postCode;
		this.address = address;
		this.telephone = telephone;
		this.connectPerson = connectPerson;
		this.phone = phone;
		this.bank = bank;
		this.account = account;
		this.email = email;
		this.fax = fax;
		this.description = description;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", number=" + number + ", customerName=" + customerName + ", postCode=" + postCode
				+ ", address=" + address + ", telephone=" + telephone + ", connectPerson=" + connectPerson + ", phone="
				+ phone + ", bank=" + bank + ", account=" + account + ", email=" + email + ", fax=" + fax
				+ ", description=" + description + ", userId=" + userId + "]";
	}

}
