package wang.goods.service.impl;

import wang.goods.mapper.SizeMapper;
import wang.goods.pojo.ProductSize;
import wang.goods.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品颜色类型业务接口实现类
 */
@Service
public class SizeServiceImpl implements SizeService {

    @Autowired
    private SizeMapper sizeMapper;

    /**
     * 根据商品的id获取商品的尺码类型
     */
    public List<ProductSize> getSizeListByProId(String proId){
        return sizeMapper.getSizeListByProId(proId);
    }

    /**
     * 添加商品的尺码
     */
    public Integer addProSize(List<ProductSize> sizes){
        return sizeMapper.addProSize(sizes);
    }


}
