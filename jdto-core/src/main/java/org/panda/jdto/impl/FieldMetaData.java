package org.panda.jdto.impl;

import lombok.Builder;
import lombok.Data;
import org.panda.jdto.PropertyMerger;

import java.util.List;

/**
 * Created by luolibing on 2018/3/8.
 */
@Data
@Builder
public class FieldMetaData {

    /**
     * 来源于一个或者多个字段
     */
    private List<String> sourceFields;

    private Class[] mergers;

    /**
     * 字段的类型
     */
    private Class targetType;

    /**
     * 转换器
     */
    private Class<? extends PropertyMerger> valueMerger;

    /**
     * 合并参数
     */
    private String[] mergerParams;
}
