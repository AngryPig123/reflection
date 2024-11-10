package practice.controller.method;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author shguddnr2@coremethod.co.kr
 * @version 1.0
 * @description
 * @since 24. 11. 10.
 */
@Slf4j
public class ProductTest {

    public static void main(String[] args) {
//        testGetters(Product.class);
//        testSetters(Product.class);
        testGetters(ClothingProduct.class);
        testSetters(ClothingProduct.class);
    }

    private static void testSetters(Class<?> dataClass) {
        List<Field> fields = getAllFields(dataClass);
        for (Field field : fields) {
            String setterName = "set" + capitalizeFirstLetter(field.getName());
            Method setterMethod = null;
            try {
                setterMethod = dataClass.getMethod(setterName, field.getType());
            } catch (NoSuchMethodException noSuchMethodException) {
                log.error("noSuchMethodException = ", noSuchMethodException);
                throw new IllegalStateException();
            }
            if (!setterMethod.getReturnType().equals(void.class)) {
                throw new IllegalStateException();
            }
        }
    }

    private static void testGetters(Class<?> dataClass) {

        List<Field> fields = getAllFields(dataClass);
        Map<String, Method> methodNameToMethod = mapMethodNameToMethod(dataClass);
        for (Field field : fields) {
            String getterName = "get" + capitalizeFirstLetter(field.getName());
            if (!methodNameToMethod.containsKey(getterName)) {
                throw new IllegalStateException();
            }
            Method getter = methodNameToMethod.get(getterName);
            if (!getter.getReturnType().equals(field.getType())) {
                throw new IllegalStateException();
            }
            if (getter.getParameterCount() > 0) {
                throw new IllegalStateException();
            }
        }
    }

    private static List<Field> getAllFields(Class<?> clazz) {
        if (clazz == null || clazz.equals(Object.class)) {
            return Collections.emptyList();
        }
        Field[] currentClassFields = clazz.getDeclaredFields();
        List<Field> inheritedFields = getAllFields(clazz.getSuperclass());
        List<Field> allFields = new ArrayList<>();
        allFields.addAll(Arrays.asList(currentClassFields));
        allFields.addAll(inheritedFields);
        return allFields;
    }

    private static String capitalizeFirstLetter(String fieldName) {
        return fieldName.substring(0, 1).toUpperCase().concat(fieldName.substring(1));
    }

    private static Map<String, Method> mapMethodNameToMethod(Class<?> dataClass) {
        Method[] allMethods = dataClass.getMethods();
        Map<String, Method> nameToMethod = new HashMap<>();
        for (Method method : allMethods) {
            nameToMethod.put(method.getName(), method);
        }
        return nameToMethod;
    }

}
