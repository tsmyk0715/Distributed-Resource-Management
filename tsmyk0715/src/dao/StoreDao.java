package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import dto.AddStockOut;
import pojo.Goods;

/**
 * 库存模块的数据访问层接口
 * @author tsmyk0715
 *
 */
public interface StoreDao {
	
	/**
	 * 查询出所有的商品库存
	 * @return
	 */
	List<Goods> queryAllGoods();
	
	/**
	 * 查询某个用户下商品
	 * @param userid
	 * @return
	 */
	List<Goods> queryGoodsByUserId(int userid);
	
	/**
	 * 通过参数来查询商品
	 * @param paramMap 参数集合
	 * @return
	 */
	List<Goods> queryByParam(Map<String,Object> paramMap) throws Exception;
	
	/**
	 * 查询出所有的出库单
	 * @return
	 */
	List<Map<String, Object>> queryAllStockOut(int userid);
	
	/**
	 * 查询出库单的数量
	 * @return
	 */
	int queryAllCountStockOut();
	
	/**
	 * 通过参数查询出库单
	 * @return
	 */
	List<Map<String, Object>> queryStockOutByParam(Map<String, Object> paramMap) throws Exception;

	/**
	 * 修改出库单
	 * @param paramMap
	 */
	void editStockOutInfo(Map<String, Object> paramMap);
	
	/**
	 * 删除出库单
	 * @param list
	 */
	void deleteStockOut(List<Integer> list);
	
	
	/**
	 * 添加出库单
	 */
	void addStockOutProcess(@Param("aso") AddStockOut aso);
	
	/**
	 * 修改商品信息
	 * @param paramMap
	 * @throws Exception
	 */
	void editGoodsInfo(Map<String, Object> paramMap) throws Exception;

	/**
	 * 删除商品
	 * @param list 要删除商品的ID集合
	 */
	void deleteGoods(List<Integer> list);
	
	/**
	 * 添加商品信息
	 * @param goods
	 * @throws Exception
	 */
	void processAddGoods(@Param("g") Goods goods) throws Exception;
	
	/**
	 * 根据商品名称来查询商品
	 * @param goodsName
	 * @return
	 * @throws Exception
	 */
	Goods queryGoodsByGoodsName(String goodsName) throws Exception;
}
