package ch2;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    //  Class.getDe

    public static void main(String[] args) {
        printConstructorData(Person.class);
    }

    public static void printConstructorData(Class<?> clazz) {
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();    //  클래스에 정의된 모든 생성자를 가져온다.

        System.out.println(String.format("class %s has %d declared constructors", clazz.getSimpleName(), constructors.length));

        for (int i = 0; i < constructors.length; i++) { //  정의된 생성자의 수 만큼 for 문을 돌린다.

            Class<?>[] parameterTypes = constructors[i].getParameterTypes();    //  생성자에 선언된 파라미터를 가져온다.

            List<String> parameterTypeNames =
                    Arrays.stream(parameterTypes)
                            .map(Class::getSimpleName)
                            .toList();

            System.out.println(parameterTypeNames);

        }

    }

    public static class Person {

        private final Address address;
        private final String name;
        private final int age;

        public Person() {
            this.address = null;
            this.name = "anonymous";
            this.age = 0;
        }

        public Person(String name) {
            this.address = null;
            this.name = name;
            this.age = 0;
        }

        public Person(String name, int age) {
            this.address = null;
            this.name = name;
            this.age = age;
        }

        public Person(Address address, String name, int age) {
            this.address = address;
            this.name = name;
            this.age = age;
        }

    }

    public static class Address {
        private String street;
        private int number;

        public Address(String street, int number) {
            this.street = street;
            this.number = number;
        }
    }

}
