package wang.goods.service;

import wang.goods.pojo.ProductInforImage;

import java.util.List;

/**
 * 商品详情展示图业务接口
 */
public interface InforImageService {

    /**
     * 根据商品的id获取商品详情展示图
     */
    List<ProductInforImage> getInforImageListByProId(String proId);

    /**
     * 添加商品详情图片
     */
    Integer addProInforImage(List<ProductInforImage> infors);
}
