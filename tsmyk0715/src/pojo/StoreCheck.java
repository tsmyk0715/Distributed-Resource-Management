package pojo;

/**
 * 库存类
 * @author tsmyk0715
 *
 */
public class StoreCheck {

	/*ID*/
	private int id;

	/*商品ID*/
	private int goodsId;
	
	/*商品数量*/
	private int number;
	
	/*备注*/
	private String description;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public StoreCheck() {
		super();
	}

	public StoreCheck(int id, int goodsId, int number, String description) {
		super();
		this.id = id;
		this.goodsId = goodsId;
		this.number = number;
		this.description = description;
	}

	public StoreCheck(int goodsId, int number, String description) {
		super();
		this.goodsId = goodsId;
		this.number = number;
		this.description = description;
	}

	@Override
	public String toString() {
		return "StoreCheck [id=" + id + ", goodsId=" + goodsId + ", number=" + number + ", description=" + description
				+ "]";
	}
}
