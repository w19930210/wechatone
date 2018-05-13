package wang.goods.service.impl;

import wang.goods.mapper.TopImageMapper;
import wang.goods.pojo.ProductTopImage;
import wang.goods.service.TopImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品颜色类型业务接口实现类
 */
@Service
public class TopImageServiceImpl implements TopImageService {

    @Autowired
    private TopImageMapper topImageMapper;

    /**
     * 根据商品的id获取商品的颜色类型
     */
    public List<ProductTopImage> getTopImageListByProId(String proId){
        return topImageMapper.getTopImageListByProId(proId);
    }

    /**
     * 根据商品的id获取商品展示列表的左侧展示图一张
     */
    public ProductTopImage getListProImageByProId(String proId){
        return topImageMapper.getListProImageByProId(proId);
    }

    /**
     * 添加商品的颜色
     */
    public Integer addProTopImage(List<ProductTopImage> tops){
        return topImageMapper.addProTopImage(tops);
    }


}
