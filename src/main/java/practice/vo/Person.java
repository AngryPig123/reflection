package practice.vo;

/**
 * packageName    : practice.vo
 * fileName       : Person
 * author         : AngryPig123
 * date           : 24. 10. 23.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 10. 23.        AngryPig123       최초 생성
 */
public class Person {

    private final Name name;
    private final Phone phone;

    private Person(Name name, Phone phone) {
        this.name = name;
        this.phone = phone;
    }

    public static Person from(Name name, Phone phone) {
        return new Person(name, phone);
    }

    public Name getName() {
        return name;
    }

    public Phone getPhone() {
        return phone;
    }

}
