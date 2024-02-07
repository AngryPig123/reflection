package ch2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

public class Main {

    //  Class.getDe

    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException {

        printConstructorData(Person.class); //  생성자 목록 확인

        Person noArgumentConstructors = createInstanceWithArguments(Person.class);
        System.out.println(noArgumentConstructors);

        Address address = createInstanceWithArguments(Address.class, "동작구", 104);
        System.out.println(address);

        Person allArgumentConstructors = createInstanceWithArguments(Person.class, address, "홍길동", 20);
        System.out.println(allArgumentConstructors);


    }

    public static <T> T createInstanceWithArguments(Class<T> clazz, Object... objects) throws InvocationTargetException, InstantiationException, IllegalAccessException {

        for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {    //  선언된 생성자를 가져온다.
            if (constructor.getParameterTypes().length == objects.length) { //  생성자의 필드 수와 인자의 길이를 비교해서 맞는 생성자 클래스를 반환한다, getParameterTypes(), getTypeParameters() * 주의
                return (T) constructor.newInstance(objects);
            }
        }
        System.out.println("not found");
        return null;
    }

    public static void printConstructorData(Class<?> clazz) {
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();    //  클래스에 정의된 모든 생성자를 가져온다.

        System.out.printf("class %s has %d declared constructors%n", clazz.getSimpleName(), constructors.length);

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
            this.name = name;
            this.age = age;
            this.address = address;
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
