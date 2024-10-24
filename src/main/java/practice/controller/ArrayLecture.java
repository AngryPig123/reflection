package practice.controller;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Array;

/**
 * packageName    : practice.controller
 * fileName       : ArrayLecture
 * author         : AngryPig123
 * date           : 24. 10. 24.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 10. 24.        AngryPig123       최초 생성
 */

@Slf4j
public class ArrayLecture {

    public static void main(String[] args) {
        inspectArrayValues(new int[][][]{{{1, 2, 3}, {1, 2, 3}, {1, 2, 3},}, {{1, 2, 3}, {1, 2, 3}, {1, 2, 3}}});
    }

    public static void inspectArrayValues(Object arrayObject) {
        int arrayLength = Array.getLength(arrayObject);
        System.out.print("[");
        for (int i = 0; i < arrayLength; i++) {
            Object element = Array.get(arrayObject, i);
            if (element.getClass().isArray()) {
                inspectArrayValues(element);
            } else {
                System.out.print(element);
            }
            if (i != arrayLength - 1) {
                System.out.print(" , ");
            }
        }
        System.out.print("]");
    }

    //  getComponentType ??
    public static void inspectArrayObject(Object arrayObject) {
        Class<?> aClass = arrayObject.getClass();
        if (aClass.isArray()) {
            Class<?> componentType = aClass.getComponentType();
            log.info("componentType = {}", componentType.getTypeName());
        }

    }

}
