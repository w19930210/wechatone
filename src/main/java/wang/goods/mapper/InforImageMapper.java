package wang.goods.mapper;

import wang.goods.pojo.ProductInforImage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品详情展示图mapper接口
 */
public interface InforImageMapper {

    /**
     * 根据商品的id获取商品的详情展示图
     */
    List<ProductInforImage> getInforImageListByProId(String proId);

    /**
     * 添加商品详情图片
     */
    Integer addProInforImage(@Param("infors")List<ProductInforImage> infors);

}
