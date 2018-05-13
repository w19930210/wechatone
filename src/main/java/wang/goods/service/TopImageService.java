package wang.goods.service;

import wang.goods.pojo.ProductTopImage;

import java.util.List;

/**
 * 商品顶部展示图业务接口
 */
public interface TopImageService {

    //根据商品的id获取商品顶部展示图
    List<ProductTopImage> getTopImageListByProId(String proId);

    //根据商品的id获取商品展示列表的左侧展示图一张
    ProductTopImage getListProImageByProId(String proId);

    //添加商品顶部展示图
    Integer addProTopImage(List<ProductTopImage> tops);
}
