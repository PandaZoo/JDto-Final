package org.panda.jdto.annotation;

import com.google.common.collect.Lists;
import org.panda.jdto.impl.BeanMetaData;
import org.panda.jdto.impl.FieldMetaData;
import org.panda.jdto.utils.BeanClassUtils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * User: luolibing
 * Date: 2018/3/16 10:59
 */
public abstract class BaseBeanMetaResolver {

    public final <T> BeanMetaData resolve(Class<T> classType) {
        Map<String, Method> getterMethodMap = BeanClassUtils.getAllGetterMethod(classType);
        Map<String, FieldMetaData> fieldMetaDataMap = new HashMap<>();
        getterMethodMap.forEach((p, m) -> {
            FieldMetaData fieldMetaData = buildFieldMetaData(p, m, classType);
            fieldMetaData.setTargetType(m.getReturnType());
            fieldMetaDataMap.put(p, fieldMetaData);
        });
        return BeanMetaData.builder().fieldMetaDataMap(fieldMetaDataMap).build();
    }

    public abstract FieldMetaData buildFieldMetaData(
            String propertyName, Method method, Class classType);

    FieldMetaData buildDefaultFieldMetaData(String propertyName) {
        LinkedList<String> sourceFields = Lists.newLinkedList();
        sourceFields.add(propertyName);
        return FieldMetaData.builder().sourceFields(sourceFields).build();
    }
}
