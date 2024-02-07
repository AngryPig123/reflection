package ch1;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<String> stringClass = String.class;
        Map<String, Integer> mapObject = new HashMap<>();
        Class<?> hashMapClass = mapObject.getClass();
        Class<?> squareClass = Class.forName("Main$Square");
        printClassInfo(stringClass, hashMapClass, squareClass, Collection.class, boolean.class, int[][].class, Color.class);
    }

    private static void printClassInfo(Class<?>... classes) {
        for (Class<?> clazz : classes) {
            System.out.println(
                    String.format(
                            "class name : %s, class package name : %s",
                            clazz.getSimpleName(),  //  클래스 이름
                            clazz.getPackageName()  //  패키지 이름
                    )
            );
            Class<?>[] implementedInterfaces = clazz.getInterfaces();   //  인터페이스 목록 가져오기
            for (Class<?> implementedInterface : implementedInterfaces) {
                System.out.println(
                        String.format(
                                "class %s implements : %s",
                                clazz.getSimpleName(),
                                implementedInterface.getSimpleName()    //  인터페이스 이름.
                        )
                );
            }

            //  각각 타입 체크
            System.out.println("is array : " + clazz.isArray());
            System.out.println("is primitive : " + clazz.isPrimitive());
            System.out.println("is enum : " + clazz.isEnum());
            System.out.println("is interface : " + clazz.isInterface());
            System.out.println("is anonymous : " + clazz.isAnonymousClass());
            
        }

    }

    public static class Square implements Drawable {
        @Override
        public int getNumberOfCorners() {
            return 4;
        }
    }

    private static interface Drawable {
        int getNumberOfCorners();
    }

    private enum Color {
        BLUE, RED, GREEN
    }

}