package org.panda.jdto.impl;

import org.panda.jdto.DTOBinder;
import org.panda.jdto.annotation.BaseBeanMetaResolver;
import org.panda.jdto.utils.BeanClassUtils;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 *
 * User: luolibing
 * Date: 2018/3/16 10:42
 */
public class SimpleBinderDelegate implements DTOBinder {

    private BaseBeanMetaResolver beanMetaResolver;

    @Override
    public <T> T bindFromBusinessObject(Class<T> dtoClass, Object... businessObject) {
        // 获取bean源数据
        BeanMetaData beanMetaData = beanMetaResolver.resolve(dtoClass);

        // 实例化实体
        T result = BeanClassUtils.createInstance(dtoClass);

        // 设置值
        Map<String, FieldMetaData> fieldMetaDataMap = beanMetaData.getFieldMetaDataMap();
        fieldMetaDataMap.forEach((fieldName, metaData) -> {
            // 根据fieldMeta以及businessObj获取到对应的值
            Object targetValue = buildTargetValue(metaData, result, businessObject);
            // 写入到对象当中
            doWritePropertyValue(metaData, result, targetValue);
        });
        return result;
    }

    @Override
    public <T> List<T> bindFromBusinessObjectList(Class<T> dtoClass, List[] businessObjs) {
        return null;
    }

    @Override
    public <T, C extends Collection> C bindFromBusinessObjectCollection(Class<T> dtoClass, C businessObjs) {
        return null;
    }

    @Override
    public <T> T extractFromDto(Class<T> businessObj, Object obj) {
        return null;
    }

    private <T> Object buildTargetValue(FieldMetaData fieldMetaData, T result, Object... businessObj) {
        return null;
    }

    private <T> void doWritePropertyValue(FieldMetaData fieldMetaData, T result, Object propertyValue) {

    }
}
