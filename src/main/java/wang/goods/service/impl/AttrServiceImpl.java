package wang.goods.service.impl;

import wang.goods.mapper.AttrMapper;
import wang.goods.pojo.ProductAttr;
import wang.goods.service.AttrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品颜色类型业务接口实现类
 */
@Service
public class AttrServiceImpl implements AttrService {

    @Autowired
    private AttrMapper attrMapper;

    /**
     * 根据商品的id获取商品的颜色类型
     */
    public List<ProductAttr> getAttrListByProId(String proId){
        return attrMapper.getAttrListByProId(proId);
    }

    /**
     * 添加商品的颜色
     */
    public Integer addProAttr(List<ProductAttr> attrs){
        return attrMapper.addProAttr(attrs);
    }


}
