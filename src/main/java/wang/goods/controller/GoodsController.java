package wang.goods.controller;

import wang.utils.page.Page;
import org.springframework.web.bind.annotation.PathVariable;
import wang.goods.pojo.DdgProduct;
import wang.goods.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 获取商品信息，只做查询
 */
@Controller
@RequestMapping("/goods/")
public class GoodsController {

    @Autowired
    private ProductService productService;

    /**
     * 分页查询商品数据
     * @param pageNum 当前页数
     * @param pageSize 每页显示的条数
     */
    @RequestMapping("getAllGoods/{pageNum}/{pageSize}")
    @ResponseBody
    public Page getAllGoods(@PathVariable("pageNum")Integer pageNum
            , @PathVariable("pageSize")Integer pageSize){
        Page page = productService.getAllGoods(pageNum,pageSize);
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        return page;
    }

    /**
     * 获取今日(即上架24小时内)的商品
     */
    @RequestMapping("getGoodsByToday")
    @ResponseBody
    public List<DdgProduct> getGoodsByToday(){
        List<DdgProduct> list = productService.getGoodsByToday();
        return list;
    }

    /**
     * 获取即将售罄(即离技术还有24小时)的商品
     */
    @RequestMapping("getGoodsByLast")
    @ResponseBody
    public List<DdgProduct> getGoodsByLast(){
        List<DdgProduct> list = productService.getGoodsByLast();
        return list;
    }

    /**
     * 根据商品的id获取商品的详细信息
     */
    @RequestMapping("getGoodsByProId/{proId}")
    @ResponseBody
    public List<DdgProduct> getGoodsByProId(@PathVariable("proId")String proId){
        List<DdgProduct> list = productService.getGoodsByProId(proId);
        return list;
    }


}
