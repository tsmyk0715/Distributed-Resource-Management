package service;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.StoreDao;
import dto.AddStockOut;
import inf.IStoreService;
import pojo.Goods;

@Service(value="storeService")
public class StoreServiceImpl implements IStoreService {
	
	/**
	 * 自动注入库存数据访问层接口
	 */
	@Autowired
	private StoreDao storeDao;
	
	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(StoreServiceImpl.class);
	
	/**
	 * 查询所有的商品
	 */
	@Override
	public List<Goods> queryAllGoods(){
		
		logger.debug("GoodsService：查询所有的商品...");
		try {
			
			List<Goods> goodses = storeDao.queryAllGoods();
			
			logger.debug("GoodsService-查询到的商品：" + goodses);
			
			return goodses;
			
		} catch (Exception e) {
			logger.debug("GoodsService-查询失败：" + e);
		}
		return null;
	}

	
	/**
	 * 查询某个用户下商品
	 * @param userid
	 * @return
	 */
	public List<Goods> queryGoodsByUserId(int userid) throws Exception{
		
		logger.debug("GoodsService：查询某个用户下商品...");
		
		try {
			
			List<Goods> goodses = storeDao.queryGoodsByUserId(userid);
			
			logger.debug("GoodsService-查询到的商品：" + goodses);
			
			return goodses;
			
		} catch (Exception e) {
			logger.debug("GoodsService-查询某个用户下商品失败：" + e);
		}
		return null;
	}
	
	/**
	 * 通过参数来查询商品
	 * @param paramMap 参数集合
	 * @return
	 */
	public List<Goods> queryByParam(Map<String,Object> paramMap) throws Exception{	
		logger.debug("GoodsService：根据条件查询商品...");
		
		try {
			List<Goods> goodses = storeDao.queryByParam(paramMap);
			
			logger.debug("GoodsService：根据条件查询到的商品：" + goodses);
			
			return goodses;
			
		} catch (Exception e) {
			logger.debug("GoodsService-带参数的查询商品失败：" + e);
		}
		return null;
	}

	
	/**
	 * 查询出所有的出库单
	 */
	@Override
	public List<Map<String, Object>> queryAllStockOut(int userid) {
		
		logger.debug("StoreService：查询所有的出库单...");
		try {
			List<Map<String, Object>> allStockOut = storeDao.queryAllStockOut(userid);
			
			logger.debug("StoreService：查询到的出库单：" + allStockOut);

			return allStockOut;
		} catch (Exception e) {
			logger.debug("StoreService：查询出库单失败：" + e);
		}
		return null;
	}

	@Override
	public int queryAllCountStockOut() {
		
		logger.debug("StoreService：查询出库单的数量...");
		try {
			
			int count = storeDao.queryAllCountStockOut();
			
			logger.debug("StoreService：出库单的数量为：" + count);
			
			return count;
		} catch (Exception e) {
			logger.debug("StoreService：查询出库单数量失败：" + e);
		}
		return 0;
	}

	/**
	 * 通过参数查询出库单
	 * @return
	 */
	@Override
	public List<Map<String, Object>> queryStockOutByParam(Map<String, Object> paramMap) throws Exception {
		
		logger.debug("StoreService：通过参数查询出库单...");
		
		for(Entry e : paramMap.entrySet()){
			System.out.println("key:" + e.getKey()+"====>" + "value:" + e.getValue());
		}
		
		
		try {
			List<Map<String, Object>> allStockOut = storeDao.queryStockOutByParam(paramMap);
			
			logger.debug("StoreService：通过参数查询出库单：" + allStockOut);

			return allStockOut;
		} catch (Exception e) {
			logger.debug("StoreService：通过参数查询出库单失败：" + e);
		}
		return null;
	}

	/**
	 * 修改出库单
	 */
	@Override
	public void editStockOutInfo(Map<String, Object> paramMap) {
		
		logger.debug("StoreService：修改出库单...");
		
		try {
			storeDao.editStockOutInfo(paramMap);
		} catch (Exception e) {
			logger.debug("StoreService：修改出库单失败：" + e);
		}
	}

	/**
	 * 删除出库单
	 */
	@Override
	public void deleteStockOut(List<Integer> param) {
		logger.debug("StoreService：修改出库单...");
		
		try {
			storeDao.deleteStockOut(param);
		} catch (Exception e) {
			logger.debug("StoreService：查询出库单失败：" + e);
		}
	}

	/**
	 * 添加出库单
	 */
	@Override
	public void addStockOutProcess(AddStockOut aso) {
		try {
			storeDao.addStockOutProcess(aso);
		} catch (Exception e) {
			logger.debug("StoreService : 添加出库单失败：" + e);
		}
		
	}

	/**
	 * 更新商品信息
	 * @param paramMap 参数Map
	 */
	@Override
	public void editGoodsInfo(Map<String, Object> paramMap) throws Exception {
		
		logger.debug("StoreService：修改商品信息...");
		
		try {
			storeDao.editGoodsInfo(paramMap);
		} catch (Exception e) {
			logger.debug("StoreService：修改商品信息失败：" + e);
		}
			
	}

	/**
	 * 删除商品信息
	 */
	@Override
	public void deleteGoods(List<Integer> list) throws Exception {
		
		logger.debug("StoreService：刪除商品信息：要删除的商品ID集合为：" + list);
		
		try {
			storeDao.deleteGoods(list);
		} catch (Exception e) {
			logger.debug("StoreService：删除商品信息失败：" + e);
		}
	}
	
	
	/**
	 * 添加商品信息
	 */
	@Override
	public void processAddGoods(Goods goods) throws Exception {
		try {
			storeDao.processAddGoods(goods);
		} catch (Exception e) {
			logger.debug("StoreService : 添加商品信息失败：" + e);
		}
	}

	/**
	 * 根据商品名称来查询商品
	 * @param goodsName
	 * @return
	 * @throws Exception
	 */
	@Override
	public Goods queryGoodsByGoodsName(String goodsName) throws Exception {
		
		logger.debug("StoreController : 根据商品名称查询商品 ， 商品名称为：" + goodsName);
		try {
			return storeDao.queryGoodsByGoodsName(goodsName);
			
		} catch (Exception e) {
			logger.debug("StoreController : 根据商品名称查询商品失败：" + e);
		}
		
		return null;
	}

	
}
