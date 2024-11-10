package practice.controller.method;

/**
 * packageName    : practice.dto.req
 * fileName       : Phone
 * author         : AngryPig123
 * date           : 24. 10. 20.
 * description    : Phone
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 10. 20.        AngryPig123       최초 생성
 */
public class Product {

    private String first;
    private String middle;
    private String last;

    protected Product(String first, String middle, String last) {
        this.first = first;
        this.middle = middle;
        this.last = last;
    }

    public static Product from(String first, String middle, String last) {
        return new Product(first, middle, last);
    }

    //  getter
    public String getFirst() {
        return first;
    }

    public String getMiddle() {
        return middle;
    }

    public String getLast() {
        return last;
    }

    //  setter
    public void setFirst(String first) {
        this.first = first;
    }

    public void setMiddle(String middle) {
        this.middle = middle;
    }

    public void setLast(String last) {
        this.last = last;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "first='" + first + '\'' +
                ", middle='" + middle + '\'' +
                ", last='" + last + '\'' +
                '}';
    }

}
