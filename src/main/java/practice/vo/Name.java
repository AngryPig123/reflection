package practice.vo;

/**
 * packageName    : practice.vo
 * fileName       : Name
 * author         : AngryPig123
 * date           : 24. 10. 23.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 10. 23.        AngryPig123       최초 생성
 */
public class Name {

    private final String first;
    private final String last;

    private Name(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public static Name from(String first, String last) {
        return new Name(first, last);
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    public String fullName() {
        return String.format("%s %s", last, first);
    }

}
