package wang.goods.mapper;

import wang.goods.pojo.ProductAttr;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品颜色Mapper
 */
public interface AttrMapper {

    /**
     * 根据商品的id获取商品的颜色类型
     */
    List<ProductAttr> getAttrListByProId(String proId);

    /**
     * 添加商品的颜色
     */
    Integer addProAttr(@Param("attrs")List<ProductAttr> attrs);
}
