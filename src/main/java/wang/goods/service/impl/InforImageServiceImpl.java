package wang.goods.service.impl;

import wang.goods.mapper.InforImageMapper;
import wang.goods.pojo.ProductInforImage;
import wang.goods.service.InforImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品详情展示图业务接口实现类
 */
@Service
public class InforImageServiceImpl implements InforImageService {

    @Autowired
    private InforImageMapper inforImageMapper;

    /**
     * 根据商品的id获取商品详情展示图
     */
    public List<ProductInforImage> getInforImageListByProId(String proId){
        return inforImageMapper.getInforImageListByProId(proId);
    }

    /**
     * 添加商品详情图片
     */
    public Integer addProInforImage(List<ProductInforImage> infors){
        return inforImageMapper.addProInforImage(infors);
    }


}
