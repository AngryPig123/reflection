package practice.controller.jsonwriter;

import lombok.extern.slf4j.Slf4j;
import practice.vo.Name;
import practice.vo.Person;
import practice.vo.Phone;

import java.lang.reflect.Field;

/**
 * packageName    : practice.controller.json
 * fileName       : MyJackson
 * author         : AngryPig123
 * date           : 24. 10. 23.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 10. 23.        AngryPig123       최초 생성
 */
@Slf4j
public class MyJackson {


    public static void main(String[] args) throws IllegalAccessException {

        Name name = Name.from("길동", "홍");
        String nameStr = objectToJson(name, 0);
        log.info("nameStr = \n{}", nameStr);

        Phone phone = Phone.from("010","0000","0000");
        String phoneStr = objectToJson(phone, 0);
        log.info("phoneStr = \n{}", phoneStr);

        Person person = Person.from(name,phone);
        String personStr = objectToJson(person, 0);
        log.info("personStr = \n{}", personStr);

    }

    public static String objectToJson(Object instance, int indentSize) throws IllegalAccessException {

        Field[] fields = instance.getClass().getDeclaredFields();

        StringBuilder sb = new StringBuilder();
        sb.append(indent(indentSize));
        sb.append("{");
        sb.append("\n");

        for (int i = 0; i < fields.length; i++) {

            Field field = fields[i];
            field.setAccessible(true);

            if (field.isSynthetic()) {
                continue;
            }

            sb.append(indent(indentSize + 1));
            sb.append(formatStringValue(field.getName()));
            sb.append(":");

            if (field.getType().isPrimitive()) {
                sb.append(formatPrimitiveValue(field, instance));
            } else if (field.getType().equals(String.class)) {
                sb.append(formatStringValue(field.get(instance).toString()));
            } else {
                sb.append(objectToJson(field.get(instance), indentSize + 1));
            }

            if (fields.length - 1 != i) {
                sb.append(",");
            }
            sb.append("\n");
        }
        sb.append(indent(indentSize));
        return sb.append("}").toString();
    }

    private static String indent(int indentSize) {
        return "\t".repeat(Math.max(0, indentSize));
    }

    private static String formatPrimitiveValue(Field field, Object parentInstance) throws IllegalAccessException {
        if (field.getType().equals(boolean.class)
                || field.getType().equals(int.class)
                || field.getType().equals(long.class)
                || field.getType().equals(short.class)
        ) {
            return field.get(parentInstance).toString();
        } else if (field.getType().equals(float.class)
                || field.getType().equals(double.class)
        ) {
            return String.format("%.02f", field.get(parentInstance));
        }
        throw new RuntimeException(String.format("Type : %s is unsupported", field.getType().getName()));
    }

    private static String formatStringValue(String value) {
        return String.format("\"%s\"", value);
    }

}
