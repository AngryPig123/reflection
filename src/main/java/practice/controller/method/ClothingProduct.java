package practice.controller.method;

/**
 * @author shguddnr2@coremethod.co.kr
 * @version 1.0
 * @description
 * @since 24. 11. 10.
 */
public class ClothingProduct extends Product {

    private int size;
    private String color;

    public ClothingProduct(String first, String middle, String last, int size, String color) {
        super(first, middle, last);
        this.size = size;
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
