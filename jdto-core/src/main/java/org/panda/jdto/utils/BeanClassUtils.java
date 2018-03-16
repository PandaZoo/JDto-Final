package org.panda.jdto.utils;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * User: luolibing
 * Date: 2018/3/16 11:26
 */
@Slf4j
public class BeanClassUtils {

    public static <T> Map<String, Method> getAllGetterMethod(Class<T> classType) {
        Map<String, Method> getters = new HashMap<>();
        for(Class currentClass = classType;
            currentClass != Object.class; currentClass = classType.getSuperclass()) {
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

    public static <T> T createInstance(Class<T> classType) {
        try {
            return classType.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean isGetterMethod(Method method) {
        return true;
    }

    private static String getPropertyName(Method method) {
        return null;
    }
}
