package wang.goods.mapper;

import wang.goods.pojo.*;

import java.util.List;

/**
 * 商品mapper操作的接口
 */
public interface ProductMapper {

    //客户获取全部的商品
    List<DdgProduct> getAllGoods();

    //客户获取商品的详情，根据商品的id
    List<DdgProduct> getGoodsByProId(String proId);

    //客户获取今日上新的商品,即24小时内上新的商品
    List<DdgProduct> getGoodsByToday();

    //客户获取离结束还有24小时的商品
    List<DdgProduct> getGoodsByLast();

    //客户获取最新上架的商品(暂定3个)
    List<DdgProduct> getGoodsByNew();

    //添加商品的详情
    Integer addProduct(DdgProduct product);

}
