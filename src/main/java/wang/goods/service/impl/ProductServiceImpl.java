package wang.goods.service.impl;

import wang.goods.mapper.ProductMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import wang.goods.pojo.*;
import wang.goods.service.*;
import wang.utils.page.Page;
import wang.utils.page.PageView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 商品业务逻辑类
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    //商品Mapper
    private ProductMapper productMapper;
    @Autowired
    //商品信息提取类
    private ProductInfor productInfor;

    //商品颜色
    @Autowired
    private AttrService attrService;
    //商品尺码
    @Autowired
    private SizeService sizeService;
    //商品顶部展示图
    @Autowired
    private TopImageService topImageService;
    //商品详情展示图
    @Autowired
    private InforImageService inforImageService;

    /**
     * 客户分页获取商品列表
     * @param pageNum 当前页数
     * @param pageSize 每页显示的条数
     */
    public Page getAllGoods(Integer pageNum, Integer pageSize) {
        Page page = PageView.startDataPage(pageNum, pageSize);

        List<DdgProduct> result = productMapper.getAllGoods();
        String proId;
        for (DdgProduct product : result){
            proId = product.getId();
            ProductTopImage topImage = topImageService.getListProImageByProId(proId);
            product.setLeftImage(topImage.getImage());
        }
        return page;
    }

    /**
     * 客户获取今日上新的商品,即24小时内上新的商品
     */
    public Page getGoodsByToday(Integer pageNum, Integer pageSize) {
        Page page = PageView.startDataPage(pageNum, pageSize);
        List<DdgProduct> result = productMapper.getGoodsByToday();
        String proId;
        for (DdgProduct product : result){
            proId = product.getId();
            ProductTopImage topImage = topImageService.getListProImageByProId(proId);
            product.setLeftImage(topImage.getImage());
        }
        return page;
    }

    /**
     * 客户获取离结束还有24小时的商品
     */
    public Page getGoodsByLast(Integer pageNum, Integer pageSize) {
        Page page = PageView.startDataPage(pageNum, pageSize);
        List<DdgProduct> result = productMapper.getGoodsByLast();
        String proId;
        for (DdgProduct product : result){
            proId = product.getId();
            ProductTopImage topImage = topImageService.getListProImageByProId(proId);
            product.setLeftImage(topImage.getImage());
        }
        return page;
    }

    /**
     * 客户获取商品的详情，根据商品的id
     */
    public List<DdgProduct> getGoodsByProId(String proId) {
        if (proId == null || "".equals(proId))
            return new ArrayList<>();
        List<DdgProduct> result = productMapper.getGoodsByProId(proId);
        for (DdgProduct product : result){
            product.setAttrList(attrService.getAttrListByProId(proId));
            product.setSizeList(sizeService.getSizeListByProId(proId));
            product.setTopImageList(topImageService.getTopImageListByProId(proId));
            product.setInforImageList(inforImageService.getInforImageListByProId(proId));
        }
        return result;
    }

    /**
     * 接收页面传输过来的文件，解析成html网页
     * 分析数据入库
     */
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,
            timeout=36000,rollbackFor=Exception.class)
    public Integer addProduct(InputStream is, DdgProduct product) {
        if (product.getName() == null || "".equals(product.getName()))
            return 0;
        if (product.getPrice() == null)
            return 0;
        if (product.getOnePrice() == null)
            return 0;
        if (product.getAli_html() == null || "".equals(product.getAli_html()))
            return 0;
        if (is == null)
            return 0;
        //存储html数据缓存
        StringBuilder htmlBuilder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = reader.readLine()) != null) {
                htmlBuilder.append(line);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        String html = htmlBuilder.toString();
        if ("".equals(html))
            return 0;
        Document document = Jsoup.parse(html,"utf-8");

        //提取商品详情数据
        Integer result = productInfor.getProductInfoByHtml(product, document);
        if (result == 0)
            return 0;
        String id = String.valueOf(new Date().getTime());
        product.setId(id);
        Integer count = productMapper.addProduct(product);

        //提取商品的颜色
        List<ProductAttr> attrs = productInfor.getProductAttrByHtml(id, document);
        if (attrs != null && attrs.size() > 0)
            attrService.addProAttr(attrs);

        //提取商品的尺码
        List<ProductSize> sizes = productInfor.getProductSizeByHtml(id, document);
        if (sizes != null && sizes.size() > 0)
            sizeService.addProSize(sizes);

        //提取商品顶部左侧的5张展示图
        List<ProductTopImage> tops = productInfor.getProductTopImageByHtml(id,document);
        if (tops != null && tops.size() > 0)
            topImageService.addProTopImage(tops);

        //提取商品的详情图片
        List<ProductInforImage> infors = productInfor.getProductInforImageByHtml(id,document);
        if (infors != null && infors.size() > 0)
            inforImageService.addProInforImage(infors);

        return count;
    }




}
