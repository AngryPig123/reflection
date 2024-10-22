package practice.controller;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * packageName    : practice.controller
 * fileName       : ClassAnalyzer
 * author         : AngryPig123
 * date           : 24. 10. 20.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 10. 20.        AngryPig123       최초 생성
 */
@Slf4j
public class ClassAnalyzer {

    private static final List<String> JDK_PACKAGE_PREFIXES =
            Arrays.asList("com.sun.", "java", "javax", "jdk", "org.w3c", "org.xml");

    public static void main(String[] args) {
        log.info("popup type info = {}", createPopupTypeInfoFromClass(List.class));
    }

    public static PopupTypeInfo createPopupTypeInfoFromClass(Class<?> inputClass) {
        PopupTypeInfo popupTypeInfo = new PopupTypeInfo();
        popupTypeInfo
                .setPrimitive(inputClass.isPrimitive())
                .setInterface(inputClass.isInterface())
                .setEnum(inputClass.isEnum())
                .setName(inputClass.getName())
                .setJdk(isJdkClass(inputClass))
                .addAllInheritedClassNames(getAllInheritedClassNames(inputClass));
        return popupTypeInfo;
    }

    public static boolean isJdkClass(Class<?> inputClass) {
        String packageName = inputClass.getPackageName();
        for (String jdkPackagePrefix : JDK_PACKAGE_PREFIXES) {
            if (packageName.startsWith(jdkPackagePrefix)) {
                return true;
            }
        }
        return false;
    }

    public static String[] getAllInheritedClassNames(Class<?> inputClass) {
        String[] inheritedClasses;
        if (inputClass.isInterface()) {
            inheritedClasses = Arrays.stream(inputClass.getInterfaces())
                    .map(Class::getSimpleName)
                    .toArray(String[]::new);
        } else {
            Class<?> inheritedClass = inputClass.getSuperclass();
            inheritedClasses = inheritedClass != null ?
                    new String[]{inputClass.getSuperclass().getSimpleName()}
                    : null;
        }
        return inheritedClasses;
    }

    public static class PopupTypeInfo {
        private boolean isPrimitive;
        private boolean isInterface;
        private boolean isEnum;

        private String name;
        private boolean isJdk;

        private final List<String> inheritedClassNames = new ArrayList<>();

        public PopupTypeInfo setPrimitive(boolean isPrimitive) {
            this.isPrimitive = isPrimitive;
            return this;
        }

        public PopupTypeInfo setInterface(boolean isInterface) {
            this.isInterface = isInterface;
            return this;
        }

        public PopupTypeInfo setEnum(boolean isEnum) {
            this.isEnum = isEnum;
            return this;
        }

        public PopupTypeInfo setName(String name) {
            this.name = name;
            return this;
        }

        public PopupTypeInfo setJdk(boolean isJdkType) {
            this.isJdk = isJdkType;
            return this;
        }

        public PopupTypeInfo addAllInheritedClassNames(String[] inheritedClassNames) {
            if (inheritedClassNames != null) {
                this.inheritedClassNames.addAll(Arrays.stream(inheritedClassNames)
                        .collect(Collectors.toList()));
            }
            return this;
        }

        public boolean isPrimitive() {
            return isPrimitive;
        }

        public boolean isInterface() {
            return isInterface;
        }

        public boolean isEnum() {
            return isEnum;
        }

        public String getName() {
            return name;
        }

        public boolean isJdk() {
            return isJdk;
        }

        public List<String> getInheritedClassNames() {
            return Collections.unmodifiableList(inheritedClassNames);
        }

        @Override
        public String toString() {
            return "PopupTypeInfo{" +
                    "isPrimitive=" + isPrimitive +
                    ", isInterface=" + isInterface +
                    ", isEnum=" + isEnum +
                    ", name='" + name + '\'' +
                    ", isJdk=" + isJdk +
                    ", inheritedClassNames=" + inheritedClassNames +
                    '}';
        }
    }
}

