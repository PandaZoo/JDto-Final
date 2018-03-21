package org.panda.jdto.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * User: luolibing
 * Date: 2018/3/16 11:26
 */
public class BeanClassUtils {

    /**
     * 获取到所有的getter方法
     * @param classType
     * @param <T>
     * @return
     */
    public static <T> Map<String, Method> getAllGetterMethod(Class<T> classType) {
        Map<String, Method> getters = new HashMap<>();
        for(Class currentClass = classType;
            currentClass != Object.class; currentClass = currentClass.getSuperclass()) {
            Method[] methods = currentClass.getDeclaredMethods();
            Stream.of(methods)
                    .filter(BeanClassUtils::isGetterMethod)
                    .forEach(m -> {
                        String propertyName = getPropertyName(m);
                        getters.put(propertyName, m);
                    });
        }
        return getters;
    }

    /**
     * 实例
     * @param classType
     * @param <T>
     * @return
     */
    public static <T> T createInstance(Class<T> classType) {
        try {
            return classType.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Field getField(Class classType, String propertyName) {

        for(Class current = classType;
            current != Object.class;
            current = current.getSuperclass()) {
            try {
                return current.getDeclaredField(propertyName);
            } catch (NoSuchFieldException e) {
            }
        }
        return (null);
    }

    private static boolean isGetterMethod(Method method) {
        return method.getName().startsWith("get") && method.getName().length() > 3;
    }

    private static String getPropertyName(Method method) {
        String methodName = method.getName();
        return methodName.substring(3, 4).toLowerCase() + methodName.substring(4);
    }
}
