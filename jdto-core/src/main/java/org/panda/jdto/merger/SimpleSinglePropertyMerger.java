package org.panda.jdto.merger;

import org.panda.jdto.SinglePropertyMerger;

/**
 * 不做任何加工，只做简单的转换
 * Created by luolibing on 2018/3/21.
 */
public class SimpleSinglePropertyMerger implements SinglePropertyMerger {


    @Override
    public Object mergeObjects(Object value, String[] mergerParam) {
        return value;
    }
}
