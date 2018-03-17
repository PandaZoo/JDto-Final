package org.panda.jdto.annotation;

import org.panda.jdto.impl.BeanMetaData;
import org.panda.jdto.impl.FieldMetaData;
import org.panda.jdto.utils.BeanClassUtils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * User: luolibing
 * Date: 2018/3/16 10:59
 */
public abstract class BaseBeanMetaResolver {

    public final <T> BeanMetaData resolve(Class<T> classType) {
        BeanMetaData beanMetaData = new BeanMetaData();
        Map<String, Method> getterMethodMap = BeanClassUtils.getAllGetterMethod(classType);
        Map<String, FieldMetaData> fieldMetaDataMap = new HashMap<>();
        getterMethodMap.forEach((p, m) -> {
            FieldMetaData fieldMetaData = buildFieldMetaData(p, m, classType);
            fieldMetaData.setTargetType(m.getReturnType());
            fieldMetaDataMap.put(p, fieldMetaData);
        });
        beanMetaData.setFieldMetaDataMap(fieldMetaDataMap);
        return beanMetaData;
    }

    public abstract FieldMetaData buildFieldMetaData(
            String propertyName, Method method, Class classType);
}
