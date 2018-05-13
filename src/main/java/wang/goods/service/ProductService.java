package wang.goods.service;

import wang.utils.page.Page;
import wang.goods.pojo.DdgProduct;

import java.io.InputStream;
import java.util.List;

/**
 * 商品业务逻辑类接口
 */
public interface ProductService {

    //客户获取商品的详情
    Page getAllGoods(Integer pageNum, Integer pageSize);

    //客户获取今日上新的商品,即24小时内上新的商品
    Page getGoodsByToday(Integer pageNum, Integer pageSize);

    //客户获取离结束还有24小时的商品
    Page getGoodsByLast(Integer pageNum, Integer pageSize);

    //客户获取商品的详情，根据商品的id
    List<DdgProduct> getGoodsByProId(String proId);

    //添加上传的商品信息
    Integer addProduct(InputStream is, DdgProduct product);

}
