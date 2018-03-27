package org.panda.jdto.merger;

import org.panda.jdto.MultiPropertyValueMerger;

import java.util.List;

/**
 * User: luolibing
 * Date: 2018/3/27 14:11
 */
public class SimpleMultiPropertyMerger implements MultiPropertyValueMerger<Object> {

    @Override
    public Object mergeObjects(List<Object> value, String[] mergerParam) {
        return value != null && !value.isEmpty() ? value.get(0) : null;
    }
}
