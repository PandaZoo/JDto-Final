package org.panda.jdto.impl;

import org.panda.jdto.DTOBinder;
import org.panda.jdto.MultiPropertyValueMerger;
import org.panda.jdto.PropertyMerger;
import org.panda.jdto.SinglePropertyMerger;
import org.panda.jdto.annotation.BaseBeanMetaResolver;
import org.panda.jdto.merger.PropertyMergerManager;
import org.panda.jdto.utils.BeanClassUtils;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * User: luolibing
 * Date: 2018/3/16 10:42
 */
public class SimpleBinderDelegate implements DTOBinder {

    private BaseBeanMetaResolver beanMetaResolver;

    private PropertyMergerManager propertyMergerManager;

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
            Object targetValue = buildTargetValue(metaData, businessObject);
            // 写入到对象当中
            doWritePropertyValue(fieldName, metaData.getTargetType(), result, targetValue);
        });
        return result;
    }

    private <T> void doWritePropertyValue(String propertyName, Class targetType, T object, Object propertyValue) {
        BeanClassUtils.setProperty(propertyName, targetType, object, propertyValue);
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

    private Object buildTargetValue(FieldMetaData fieldMetaData, Object... businessObj) {

        // 获取到源字段的值
        List<Object> sourceValues = getSourceValues(fieldMetaData, businessObj);

        Class<? extends PropertyMerger> valueMerger = fieldMetaData.getValueMerger();

        PropertyMerger propertyMerger = propertyMergerManager.getPropertyMerger(valueMerger);

        // 单个的
        if(propertyMerger instanceof SinglePropertyMerger) {
            return ((SinglePropertyMerger) propertyMerger).mergeObjects(
                    sourceValues.get(0), fieldMetaData.getMergerParams());
        } else if(propertyMerger instanceof MultiPropertyValueMerger) {
            return ((MultiPropertyValueMerger) propertyMerger).mergeObjects(
                    sourceValues, fieldMetaData.getMergerParams());
        } else {
            throw new RuntimeException("not support PropertyMerger [" + propertyMerger.getClass() + "]");
        }
    }

    private List<Object> getSourceValues(FieldMetaData fieldMetaData, Object...businessObjs) {

        // source对应的object
        List<String> sourceFields = fieldMetaData.getSourceFields();

        return IntStream.range(0, sourceFields.size()).boxed()
                .map(index -> BeanClassUtils.getValue(
                        sourceFields.get(index), businessObjs[index]))
                .collect(Collectors.toList());

    }

    public void setBeanMetaResolver(BaseBeanMetaResolver beanMetaResolver) {
        this.beanMetaResolver = beanMetaResolver;
    }

    public void setPropertyMergerManager(PropertyMergerManager propertyMergerManager) {
        this.propertyMergerManager = propertyMergerManager;
    }
}
