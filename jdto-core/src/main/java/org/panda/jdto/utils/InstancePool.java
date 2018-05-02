package org.panda.jdto.utils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * User: luolibing
 * Date: 2018/3/22 19:52
 */
public class InstancePool {

    private final static Map<Class, Object> objectPool = new ConcurrentHashMap<>();

    private final static InstancePool instance = new InstancePool();

    private InstancePool() {}

    public <T> T getInstance(Class<T> classType) {
        return (T) objectPool.computeIfAbsent(classType, (t) -> {
            try {
                return t.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public static InstancePool getInstance() {
        return instance;
    }
}
