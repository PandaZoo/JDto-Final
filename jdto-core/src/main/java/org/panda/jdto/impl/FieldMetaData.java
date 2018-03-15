package org.panda.jdto.impl;

import lombok.Data;
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



    private PropertyMerger valueMerger;



}
