package practice.controller;

import lombok.extern.slf4j.Slf4j;
import practice.vo.Phone;

import java.util.HashMap;
import java.util.Map;

/**
 * packageName    : practice.controller
 * fileName       : Step1
 * author         : AngryPig123
 * date           : 24. 10. 20.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 10. 20.        AngryPig123       최초 생성
 */
@Slf4j
public class Step1 {

    public static void main(String[] args) throws ClassNotFoundException {
        Map<String, Integer> mapObject = new HashMap<>();
        Object object = Phone.from("010","2824","8203");
        Class<String> stringClass = String.class;
        Class<?> mapObjectClass = mapObject.getClass();
        Class<?> squareClass = Class.forName("practice.controller.Step1$Square");
        var circleObject = new Drawable() {
            @Override
            public int getNumberOfCorners() {
                return 0;
            }
        };

        printClassInfo(stringClass, mapObjectClass, squareClass, int[][].class, Color.class, circleObject.getClass(),object.getClass());
    }

    private static void printClassInfo(Class<?>... classes) {

        for (Class<?> aClass : classes) {
            System.out.println();
            log.info("class name : {}, class package name : {}", aClass.getSimpleName(), aClass.getPackageName());
            Class<?>[] interfaces = aClass.getInterfaces();
            for (Class<?> anInterface : interfaces) {
                log.info("class {} implements : {}", aClass.getSimpleName(), anInterface.getSimpleName());
            }

            log.info("is array = {}", aClass.isArray());
            log.info("is primitive = {}", aClass.isPrimitive());
            log.info("is enum = {}", aClass.isEnum());
            log.info("is interface = {}", aClass.isInterface());
            log.info("is anonymous = {}", aClass.isAnonymousClass());

            System.out.println();
        }

    }

    private static class Square implements Drawable {
        @Override
        public int getNumberOfCorners() {
            return 4;
        }
    }

    private static interface Drawable {
        int getNumberOfCorners();
    }

    private enum Color {
        BLUE,
        RED,
        GREEN
    }

}
