package pojo;

/**
 * 出库单类
 * @author tsmyk0715
 *
 */
public class StockOutSheet {

	/*ID*/
	private int id;
	
	/*出库单编号*/
	private String number;
	
	/*客户ID*/
	private int clientId;
	
	/*商品ID*/
	private int goodsId;
	
	/*商品数量*/
	private int goodsNumber;
	
	/*出库时间*/
	private String outTime;
	
	/*备注*/
	private String description;

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

	public int getGoodsNumber() {
		return goodsNumber;
	}

	public void setGoodsNumber(int goodsNumber) {
		this.goodsNumber = goodsNumber;
	}

	public String getOutTime() {
		return outTime;
	}

	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public StockOutSheet() {
		super();
	}

	public StockOutSheet(int id, String number, int clientId, int goodsId, int goodsNumber, String outTime,
			String description) {
		super();
		this.id = id;
		this.number = number;
		this.clientId = clientId;
		this.goodsId = goodsId;
		this.goodsNumber = goodsNumber;
		this.outTime = outTime;
		this.description = description;
	}

	public StockOutSheet(String number, int clientId, int goodsId, int goodsNumber, String outTime,
			String description) {
		super();
		this.number = number;
		this.clientId = clientId;
		this.goodsId = goodsId;
		this.goodsNumber = goodsNumber;
		this.outTime = outTime;
		this.description = description;
	}

	@Override
	public String toString() {
		return "StockOutSheet [id=" + id + ", number=" + number + ", clientId=" + clientId + ", goodsId=" + goodsId
				+ ", goodsNumber=" + goodsNumber + ", outTime=" + outTime + ", description=" + description + "]";
	}
}
