package pojo;

/**
 * 权限嘞
 * @author tsmyk0715
 *
 */
public class Function {
	
	/*权限ID*/
	private int funId;
	
	/*权限所对应的URL地址*/
	private String funHref;
	
	/*权限名称*/
	private String funValue;
	
	public Function() {
		super();
	}
	
	public Function(int funId, String funHref, String funValue, int parentId) {
		super();
		this.funId = funId;
		this.funHref = funHref;
		this.funValue = funValue;
		this.parentId = parentId;
	}

	public int getFunId() {
		return funId;
	}
	public void setFunId(int funId) {
		this.funId = funId;
	}
	public String getFunHref() {
		return funHref;
	}
	public void setFunHref(String funHref) {
		this.funHref = funHref;
	}
	public String getFunValue() {
		return funValue;
	}
	public void setFunValue(String funValue) {
		this.funValue = funValue;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	private int parentId;

	@Override
	public String toString() {
		return "Function [funId=" + funId + ", funHref=" + funHref + ", funValue=" + funValue + ", parentId=" + parentId
				+ "]";
	}
}
