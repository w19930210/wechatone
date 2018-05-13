package wang.goods.service;

import wang.goods.pojo.*;
import wang.utils.DateUtile;
import wang.utils.NumberUtile;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 1688商品信息的处理类
 * Created by Administrator on 2018/4/25.
 */
@Service
public class ProductInfor {

    /**
     * 获取商品的基本信息，名称、价格、运费等
     */
    public Integer getProductInfoByHtml(DdgProduct product, Document document){
        //获取1688商品名称
        //JQuery选择器
        Elements elements = document.select("h1.d-title");
        //如果没有这个元素，则证明上传的txt是错误的
        if (elements.size() == 0)
            return 0;
        //将值放入对象中
        elements.forEach( element -> {
            product.setAli_name(element.text());
        });

        //获取1688商品每件价格
        elements = document.select(".price-now");
        if (elements.size() == 0)
            return 0;
        elements.forEach( element -> {
            product.setAli_price(NumberUtile.judgeDouble(element.text(), null));
        });
        if (product.getAli_price() == null)
            return 0;

        //获取1688起批量
        elements = document.select(".mod-detail-info-minimum div.obj-amount:not(span)");
        if (elements.size() == 0)
            return 0;
        elements.forEach( element -> {
            String htmlText = element.html();
            htmlText = htmlText.substring(0, htmlText.indexOf("<") - 1);
            product.setAli_number(NumberUtile.judgeInteger(htmlText,null));
        });
        if (product.getAli_number() == null)
            return 0;

        //获取1688商品邮费
        elements = document.select(".obj-carriage em");
        if (elements.size() == 0)
            return 0;
        elements.forEach( element -> {
            product.setAli_express(NumberUtile.judgeDouble(element.text(), null));
        });
        if (product.getAli_express() == null)
            return 0;

        //获取1688商品结束时间
        elements = document.select(".obj-timer span.unit-detail-timer");
        if (elements.size() == 0)
            return 0;
        elements.forEach( element -> {
            String htmlText = element.attr("data-unit-config");
            product.setAli_time(DateUtile.getStringByNumber(htmlText));
        });
        if (product.getAli_time() == null)
            return 0;
        return 1;
    }

    /**
     * 获取商品的颜色
     */
    public List<ProductAttr> getProductAttrByHtml(String proId, Document document){
        List<ProductAttr> list = new ArrayList<ProductAttr>();
        ProductAttr attr;
        String htmlText;
        //获取有图片的颜色
        Elements elements = document.select(".unit-detail-spec-operator img");
        if (elements.size() > 0){
           for(Element element : elements){
                attr = new ProductAttr();
                htmlText = element.attr("alt");
                if (htmlText == null || "".equals(htmlText))
                    return null;
                attr.setName(htmlText);
                htmlText = element.attr("src");
                if (htmlText == null || "".equals(htmlText))
                   return null;
                attr.setImage(htmlText);
                attr.setId(proId);
                list.add(attr);
            }
            return list;
        }
        //获取无图片的颜色
        elements = document.select("span.text-single-line");
        if (elements.size() > 0){
            for(Element element : elements){
                attr = new ProductAttr();
                htmlText = element.text();
                if (htmlText == null || "".equals(htmlText))
                    return null;
                attr.setName(htmlText);
                attr.setImage("==");
                attr.setId(proId);
                list.add(attr);
            }
            return list;
        }
        return list;
    }

    /**
     * 获取商品的尺码
     */
    public List<ProductSize> getProductSizeByHtml(String proId, Document document){
        List<ProductSize> list = new ArrayList<ProductSize>();
        String htmlText;
        ProductSize size;
        Elements elements = document.select(".table-sku td.name");
        if (elements.size() > 0){
            for(Element element : elements){
                htmlText = element.text();
                if (htmlText == null || "".equals(htmlText))
                    return null;
                size = new ProductSize();
                size.setId(proId);
                size.setSize(htmlText);
                list.add(size);
            }
            return list;
        }
        return null;
    }

    /**
     * 获取商品顶部展示图
     */
    public List<ProductTopImage> getProductTopImageByHtml(String proId, Document document){
        List<ProductTopImage> list = new ArrayList<ProductTopImage>();
        String htmlText;
        ProductTopImage image;
        Elements elements = document.select(".vertical-img img");
        if (elements.size() > 0){
            for(int i=1,length=elements.size();i<length;i++){
                htmlText = elements.get(i).attr("src");
                if (htmlText == null || "".equals(htmlText))
                    return null;
                image = new ProductTopImage();
                image.setId(proId);
                image.setLevel(i);
                image.setImage(htmlText);
                list.add(image);
            }
            return list;
        }
        return null;
    }

    /**
     * 获取商品详情图片
     */
    public List<ProductInforImage> getProductInforImageByHtml(String proId, Document document){
        List<ProductInforImage> list = new ArrayList<ProductInforImage>();
        String htmlText;
        ProductInforImage image;
        Elements elements = document.select(".desc-lazyload-container img");
        if (elements.size() > 0){
            for(int i=0,length=elements.size();i<length;i++){
                htmlText = elements.get(i).attr("src");
                if (htmlText == null || "".equals(htmlText))
                    return null;
                image = new ProductInforImage();
                image.setId(proId);
                image.setLevel(i);
                image.setImage(htmlText);
                list.add(image);
            }
            return list;
        }
        return null;
    }


}
