package wang.goods.pojo;

/**
 * 商品顶部5张展示图
 */
public class ProductTopImage {

    //商品id
    private String id;
    //显示顺序(从上到下)
    private Integer level;
    //图片的链接
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
