package pojo;

/**
 * 商品类
 * @author tsmyk0715
 *
 */
public class Goods {
	
	/*ID*/
	private int id;
	
	/*商品编号*/
	private String number;
	
	/*商品名称*/
	private String name;
	
	/*产地*/
	private String productPlace;
	
	/*规格*/
	private String size;
	
	/*包装*/
	private String goodsPackage;
	
	/*生产编号*/
	private String productCode;
	
	/*批准文号*/
	private String promitCode;
	
	/*价格*/
	private String price;
	
	/*状态*/
	private String available;
	
	/*备注*/
	private String description;
	
	/*商品数量*/
	private String goodsNum;
	
	/*用户ID*/
	private int userId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(String goodsNum) {
		this.goodsNum = goodsNum;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProductPlace() {
		return productPlace;
	}

	public void setProductPlace(String productPlace) {
		this.productPlace = productPlace;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	
	public String getGoodsPackage() {
		return goodsPackage;
	}

	public void setGoodsPackage(String goodsPackage) {
		this.goodsPackage = goodsPackage;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getPromitCode() {
		return promitCode;
	}

	public void setPromitCode(String promitCode) {
		this.promitCode = promitCode;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getAvailable() {
		return available;
	}

	public void setAvailable(String available) {
		this.available = available;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Goods() {
		super();
	}

	@Override
	public String toString() {
		return "Goods [id=" + id + ", number=" + number + ", name=" + name + ", productPlace=" + productPlace
				+ ", size=" + size + ", goodsPackage=" + goodsPackage + ", productCode=" + productCode + ", promitCode="
				+ promitCode + ", price=" + price + ", available=" + available + ", description=" + description
				+ ", goodsNum=" + goodsNum + ", userId=" + userId + "]";
	}


}
