package wang.goods.controller;

import wang.goods.pojo.DdgProduct;
import wang.goods.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * 添加及修改商品信息，增删改
 */
@Controller
@RequestMapping("/product/")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("addUI")
    public String addProductUI(){
        return "product/addUI";
    }

    @RequestMapping("add")
    @ResponseBody
    public Integer addProduct(DdgProduct product,
                             @RequestParam("htmlFile") MultipartFile htmlFile){
        InputStream inputStream = null;
        boolean empty = htmlFile.isEmpty();
        Integer result;
        if (!empty) {
            try {
                inputStream = htmlFile.getInputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        result = productService.addProduct(inputStream , product);
        return result;
    }


}
