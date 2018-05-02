package org.panda.jdto.impl;

import lombok.Data;
import org.panda.jdto.MultiPropertyMerger;
import org.panda.jdto.PropertyMerger;

import java.util.List;

/**
 * Created by luolibing on 2018/3/8.
 */
@Data
public class FieldMetaData {

    /**
     * 来源于一个或者多个字段
     */
    private List<String> sourceFields;

    /**
     * 字段的类型
     */
    private Class targetType;

    /**
     * 转换器
     */
    private Class<? extends PropertyMerger> valueMerger;

    /**
     * 可以将单个元素合并看成只有1个值的多元素合并
     */
    private Class<? extends MultiPropertyMerger> propertyValueMerger;

    /**
     * 合并参数
     */
    private String[] mergerParams;
}
