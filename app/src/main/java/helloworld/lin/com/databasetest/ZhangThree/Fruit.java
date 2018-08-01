package helloworld.lin.com.databasetest.ZhangThree;

/**
 * Created by W50V on 2018/7/30.
 */

public class Fruit {
    private String name;
    private  int imageId;

    public Fruit(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
