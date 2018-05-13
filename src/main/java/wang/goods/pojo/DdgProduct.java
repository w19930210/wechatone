package wang.goods.pojo;

import java.util.List;

/**
 * 前台商品信息Bean
 */
public class DdgProduct {

    //商品id
    private String id;
    //商品名称 ddg_name
    private String name;
    //商品卖价 ddg_price
    private Double price;
    //商品一次购买最低件数 ddg_number
    private Integer number;
    //每增加一件的价格 ddg_oneprice
    private Double onePrice;
    //结束时间 ddg_time
    private String time;

    //1688名称
    private String ali_name;
    //1688网址
    private String ali_html;
    //1688每件价格
    private Double ali_price;
    //1688邮费
    private Double ali_express;
    //1688起批量
    private Integer ali_number;
    //1688结束时间
    private String ali_time;

    //查看商品列表时商品左侧商品展示图
    private String leftImage;
    //距离商品结束的分钟数
    private Integer intervalTime;
    //距离结束的天数
    private Integer days;
    //距离结束的小时数
    private Integer hours;
    //距离结束的分钟数
    private Integer minutes;

    //商品的颜色分类
    List<ProductAttr> attrList;
    //商品的尺寸
    List<ProductSize> sizeList;
    //商品顶部左侧展示图
    List<ProductTopImage> topImageList;
    //商品详情图片展示图
    List<ProductInforImage> inforImageList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getOnePrice() {
        return onePrice;
    }

    public void setOnePrice(Double onePrice) {
        this.onePrice = onePrice;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAli_name() {
        return ali_name;
    }

    public void setAli_name(String ali_name) {
        this.ali_name = ali_name;
    }

    public String getAli_html() {
        return ali_html;
    }

    public void setAli_html(String ali_html) {
        this.ali_html = ali_html;
    }

    public Double getAli_price() {
        return ali_price;
    }

    public void setAli_price(Double ali_price) {
        this.ali_price = ali_price;
    }

    public Double getAli_express() {
        return ali_express;
    }

    public void setAli_express(Double ali_express) {
        this.ali_express = ali_express;
    }

    public Integer getAli_number() {
        return ali_number;
    }

    public void setAli_number(Integer ali_number) {
        this.ali_number = ali_number;
    }

    public String getAli_time() {
        return ali_time;
    }

    public void setAli_time(String ali_time) {
        this.ali_time = ali_time;
    }

    public List<ProductAttr> getAttrList() {
        return attrList;
    }

    public void setAttrList(List<ProductAttr> attrList) {
        this.attrList = attrList;
    }

    public List<ProductSize> getSizeList() {
        return sizeList;
    }

    public void setSizeList(List<ProductSize> sizeList) {
        this.sizeList = sizeList;
    }

    public List<ProductTopImage> getTopImageList() {
        return topImageList;
    }

    public void setTopImageList(List<ProductTopImage> topImageList) {
        this.topImageList = topImageList;
    }

    public List<ProductInforImage> getInforImageList() {
        return inforImageList;
    }

    public void setInforImageList(List<ProductInforImage> inforImageList) {
        this.inforImageList = inforImageList;
    }

    public String getLeftImage() {
        return leftImage;
    }

    public void setLeftImage(String leftImage) {
        this.leftImage = leftImage;
    }

    public Integer getIntervalTime() {
        return intervalTime;
    }

    public void setIntervalTime(Integer intervalTime) {
        this.intervalTime = intervalTime;
        this.days = intervalTime/60/24;
        this.hours = intervalTime%(60*24)/60 ;
        this.minutes = intervalTime%(24*60)%60;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }
}
