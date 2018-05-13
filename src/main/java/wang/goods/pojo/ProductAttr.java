package wang.goods.pojo;

/**
 * 商品对应的颜色
 */
public class ProductAttr {

    //商品id
    private String id;
    //商品颜色名称
    private String name;
    //颜色对应图片(这个可以没有,没有时为“==”)
    private String image;

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
