package wang.goods.pojo;

/**
 * 商品详情图片实体类
 */
public class ProductInforImage {

    //商品id
    private String id;
    //展示顺序(从左至右)
    private Integer level;
    //图片路径
    private String image;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
