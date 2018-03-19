package org.panda.jdto.annotation;

import org.panda.jdto.impl.FieldMetaData;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
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

        // 使用注解内容填充fieldMetaData

        return fieldMetaData;
    }

    private Map<String, Annotation> readAnnotations() {
        return null;
    }
}
