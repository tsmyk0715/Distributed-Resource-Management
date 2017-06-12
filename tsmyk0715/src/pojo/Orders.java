package pojo;

/**
 * 订单类
 * @author tsmyk0715
 *
 */
public class Orders {
	
	/*ID*/
	private int id;
	
	/*订单编号*/
	private String number;
	
	/*客户ID*/
	private int clientId;
	
	/*商品编号*/
	private int goodsId;
	
	/*商品数量*/
	private String goodsNum;
	
	/*生成订单的时间*/
	private String orderTime;
	
	/*发货时间*/
	private String sendTime;
	
	/*付款方式*/
	private String payType;
	
	/*备注*/
	private String description;

	/*用户ID*/
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

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(String goodsNum) {
		this.goodsNum = goodsNum;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Orders() {
		super();
	}

	public Orders(int id, String number, int clientId, int goodsId, String goodsNum, String orderTime, String sendTime,
			String payType, String description) {
		super();
		this.id = id;
		this.number = number;
		this.clientId = clientId;
		this.goodsId = goodsId;
		this.goodsNum = goodsNum;
		this.orderTime = orderTime;
		this.sendTime = sendTime;
		this.payType = payType;
		this.description = description;
	}

	public Orders(String number, int clientId, int goodsId, String goodsNum, String orderTime, String sendTime,
			String payType, String description) {
		super();
		this.number = number;
		this.clientId = clientId;
		this.goodsId = goodsId;
		this.goodsNum = goodsNum;
		this.orderTime = orderTime;
		this.sendTime = sendTime;
		this.payType = payType;
		this.description = description;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", number=" + number + ", clientId=" + clientId + ", goodsId=" + goodsId
				+ ", goodsNum=" + goodsNum + ", orderTime=" + orderTime + ", sendTime=" + sendTime + ", payType="
				+ payType + ", description=" + description + ", userId=" + userId + "]";
	}

}
