package org.panda.jdto.annotation;

import org.panda.jdto.impl.BeanMetaData;
import org.panda.jdto.utils.BeanClassUtils;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * User: luolibing
 * Date: 2018/3/16 10:59
 */
public class BaseBeanMetaResolver {

    public final <T> BeanMetaData resolve(Class<T> classType) {
        BeanMetaData beanMetaData = new BeanMetaData();
        Map<String, Method> getterMethodMap = BeanClassUtils.getAllGetterMethod(classType);

        return beanMetaData;
    }
}
