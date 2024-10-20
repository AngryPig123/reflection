package practice.dto.req;

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
public class Phone {

    private final String first;
    private final String middle;
    private final String last;

    private Phone(String first, String middle, String last) {
        this.first = first;
        this.middle = middle;
        this.last = last;
    }

    public static Phone from(String first, String middle, String last) {
        return new Phone(first, middle, last);
    }

    public String getFirst() {
        return first;
    }

    public String getMiddle() {
        return middle;
    }

    public String getLast() {
        return last;
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
