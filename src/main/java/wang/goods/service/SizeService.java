package wang.goods.service;

import wang.goods.pojo.ProductSize;

import java.util.List;

/**
 * 商品尺码类型业务接口
 */

public interface SizeService {

    /**
     * 根据商品的id获取商品的尺码
     */
    List<ProductSize> getSizeListByProId(String proId);

    /**
     * 添加商品的尺码
     */
    Integer addProSize(List<ProductSize> sizes);
}
