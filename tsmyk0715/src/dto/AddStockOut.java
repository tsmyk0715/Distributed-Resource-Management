package dto;

/**
 * 添加出库单的包装类
 * @author tsmyk0715
 *
 */
public class AddStockOut {
	
	private String number;
	private int clientId;
	private int goodsId;
	private int goodsNum;
	private String date;
	private String desc;
	
	private int userid;
	
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
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
	public int getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	@Override
	public String toString() {
		return "AddStockOut [number=" + number + ", clientId=" + clientId + ", goodsId=" + goodsId + ", goodsNum="
				+ goodsNum + ", date=" + date + ", desc=" + desc + ", userid=" + userid + "]";
	}

	
}
