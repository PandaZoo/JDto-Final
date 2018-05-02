package org.panda.jdto;

import org.panda.jdto.merger.PropertyMergerManager;

import java.util.List;

/**
 * User: luolibing
 * Date: 2018/3/22 20:47
 */
public interface MultiPropertyValueMerger<R> extends PropertyMergerManager {

    R mergeObjects(List<Object> value, String[] mergerParam);
}
