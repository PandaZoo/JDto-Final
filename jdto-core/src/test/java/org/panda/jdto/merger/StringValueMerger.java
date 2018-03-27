package org.panda.jdto.merger;

import org.panda.jdto.SinglePropertyMerger;

/**
 * User: luolibing
 * Date: 2018/3/27 10:04
 */
public class StringValueMerger implements SinglePropertyMerger<String, Object> {

    @Override
    public String mergeObjects(Object value, String[] mergerParam) {
        return String.valueOf(value);
    }
}
