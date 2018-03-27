package org.panda.jdto.impl;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

/**
 * Created by luolibing on 2018/3/15.
 */
@Data
@Builder
public class BeanMetaData {

    private Map<String, FieldMetaData> fieldMetaDataMap;
}
