package wang.goods.mapper;

import wang.goods.pojo.ProductSize;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品尺码Mapper
 */
public interface SizeMapper {

    /**
     * 根据商品的id获取商品的尺码类型
     */
    List<ProductSize> getSizeListByProId(String proId);

    /**
     * 添加商品的尺码
     */
    Integer addProSize(@Param("sizes")List<ProductSize> sizes);
}
