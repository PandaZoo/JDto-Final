package org.panda.jdto.merger;

import org.panda.jdto.PropertyMerger;

/**
 * User: luolibing
 * Date: 2018/3/22 19:50
 */
public interface PropertyMergerManager {

    <T extends PropertyMerger> T getPropertyMerger(Class<T> mergerType);
}
