package org.panda.jdto.annotation;

import org.panda.jdto.PropertyMerger;
import org.panda.jdto.impl.FieldMetaData;
import org.panda.jdto.merger.SimpleSinglePropertyMerger;
import org.panda.jdto.utils.BeanClassUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * DTO相关的注解帮助类
 * Created by luolibing on 2018/3/15.
 */
public class AnnotationBeanMetaResolver extends BaseBeanMetaResolver {

    @Override
    public FieldMetaData buildFieldMetaData(String propertyName, Method method, Class classType) {

        // 创建默认的FieldMetaData
        FieldMetaData fieldMetaData = buildDefaultFieldMetaData(propertyName);

        // 读取对应的注解信息
        Map<Class, Annotation> annotationMap = readAnnotations(classType, method, propertyName);

        // 使用注解内容填充fieldMetaData
        populateMerger(annotationMap, fieldMetaData);

        return fieldMetaData;
    }

    private void populateMerger(Map<Class, Annotation> annotationMap, FieldMetaData fieldMetaData) {

        Source source = (Source) annotationMap.get(Source.class);

        Class<? extends PropertyMerger> merger;
        // 单个字段的转换
        if(source != null) {
            merger = source.merger();
            fieldMetaData.setMergerParams(source.mergerParam());
        } else {
            merger = SimpleSinglePropertyMerger.class;
        }

        fieldMetaData.setValueMerger(merger);
    }

    private Map<Class, Annotation> readAnnotations(Class classType, Method method, String propertyName) {

        Map<Class, Annotation> resultMap = new HashMap<>();

        // 从方法上获取注解
        populateAnnotations(resultMap, method);

        // 从属性上获取注解
        Field matchedField = BeanClassUtils.getField(classType, propertyName);

        if(matchedField != null) {
            populateAnnotations(resultMap, matchedField);
        }

        return (resultMap);
    }


    /**
     * 获取到方法或者属性上的注解
     * @param annotationMap
     * @param element
     */
    private void populateAnnotations(Map<Class, Annotation> annotationMap, AnnotatedElement element) {
        // TODO 目前先支持一个注解
        populateAnnotation(annotationMap, Source.class, element);

    }


    private <T extends Annotation> void  populateAnnotation(Map<Class, Annotation> annotationMap,
                                    Class<T> annotationType,
                                    AnnotatedElement element) {
        T annotation = element.getAnnotation(annotationType);
        if(annotation != null) {
            annotationMap.put(annotationType, annotation);
        }
    }
}
