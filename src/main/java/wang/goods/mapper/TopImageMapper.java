package wang.goods.mapper;

import wang.goods.pojo.ProductTopImage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品顶部展示图mapper接口
 */
public interface TopImageMapper {

    //根据商品的id获取商品的顶部展示图
    List<ProductTopImage> getTopImageListByProId(String proId);

    //根据商品的id获取商品展示列表的左侧展示图一张
    ProductTopImage getListProImageByProId(String proId);

    //添加商品顶部展示图
    Integer addProTopImage(@Param("tops") List<ProductTopImage> tops);

}
