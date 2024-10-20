package practice.controller;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * packageName    : practice.controller
 * fileName       : Exercise
 * author         : AngryPig123
 * date           : 24. 10. 20.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 10. 20.        AngryPig123       최초 생성
 */
@Slf4j
public class Exercise {

    /**
     * Returns all the interfaces that the current input class implements.
     * Note: If the input is an interface itself, the method returns all the interfaces the
     * input interface extends.
     */
    public static Set<Class<?>> findAllImplementedInterfaces(Class<?> input) {

        Set<Class<?>> allImplementedInterfaces = new HashSet<>();
        Class<?>[] inputInterfaces = input.getInterfaces();

        for (Class<?> currentInterface : inputInterfaces) {
            allImplementedInterfaces.add(currentInterface);
            allImplementedInterfaces.addAll(findAllImplementedInterfaces(currentInterface));
        }

        Class<?> superclass = input.getSuperclass();
        if (superclass != null) {
            allImplementedInterfaces.addAll(findAllImplementedInterfaces(superclass));
        }

        return allImplementedInterfaces;

    }
}
