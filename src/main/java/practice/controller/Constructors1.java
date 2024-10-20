package practice.controller;

import lombok.extern.slf4j.Slf4j;
import practice.dto.req.Phone;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

/**
 * packageName    : practice.controller
 * fileName       : Constructors1
 * author         : AngryPig123
 * date           : 24. 10. 20.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 10. 20.        AngryPig123       최초 생성
 */
@Slf4j
public class Constructors1 {

    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        printConstructorData(Phone.class);
        printConstructorData(Person.class);
        printConstructorData(Address.class);
        Phone phone = createInstanceWithArguments(Phone.class, "010", "0000", "0000");
        log.info("phone = {}", phone);
    }

    @SuppressWarnings("unchecked")
    public static <T> T createInstanceWithArguments(Class<T> clazz, Object... args) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
            constructor.setAccessible(true);
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes.length == args.length) {
                boolean match = true;
                for (int i = 0; i < parameterTypes.length; i++) {
                    if (!parameterTypes[i].isAssignableFrom(args[i].getClass())) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return (T) constructor.newInstance(args);
                }
            }
        }
        return null;
    }

    public static void printConstructorData(Class<?> clazz) {
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        log.info("class {} has {} declared constructors", clazz.getSimpleName(), declaredConstructors.length);
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            Class<?>[] parameterTypes = declaredConstructor.getParameterTypes();
            List<String> parameterTypeNames =
                    Arrays.stream(parameterTypes)
                            .map(Class::getName)
                            .toList();
            log.info("parameterTypeNames = {}", parameterTypeNames);
        }
    }

    public static class Person {
        private final Address address;
        private final String name;
        private final int age;

        public Person() {
            this.name = "anonymous";
            this.age = 0;
            this.address = null;
        }

        public Person(String name) {
            this.name = name;
            this.age = 0;
            this.address = null;
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
            this.address = null;
        }

        public Person(Address address, String name, int age) {
            this.address = address;
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "address=" + address +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static class Address {
        private String street;
        private int number;

        public Address(String street, int number) {
            this.street = street;
            this.number = number;
        }

        @Override
        public String toString() {
            return "Address{" +
                    "street='" + street + '\'' +
                    ", number=" + number +
                    '}';
        }
    }

}
