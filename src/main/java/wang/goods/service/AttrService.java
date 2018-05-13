package wang.goods.service;

import wang.goods.pojo.ProductAttr;

import java.util.List;

/**
 * 商品颜色类型业务接口
 */
public interface AttrService {

    /**
     * 根据商品的id获取商品的颜色类型
     */
    List<ProductAttr> getAttrListByProId(String proId);

    /**
     * 添加商品的颜色
     */
    Integer addProAttr(List<ProductAttr> attrs);
}
