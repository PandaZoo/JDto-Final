package org.panda.jdto;

import java.util.List;

/**
 * User: luolibing
 * Date: 2018/3/22 20:47
 */
public interface MultiPropertyValueMerger<R> extends PropertyMerger {

    R mergeObjects(List<Object> value, String[] mergerParam);
}
