package org.panda.jdto.impl;

import org.panda.jdto.PropertyMerger;
import org.panda.jdto.merger.PropertyMergerManager;
import org.panda.jdto.utils.InstancePool;

/**
 * User: luolibing
 * Date: 2018/3/22 19:51
 */
public class SimplePropertyMergerManager implements PropertyMergerManager {

    private InstancePool instancePool;

    public SimplePropertyMergerManager() {
        instancePool = InstancePool.getInstance();
    }

    @Override
    public <T extends PropertyMerger> T getPropertyMerger(Class<T> mergerType) {
        return instancePool.getInstance(mergerType);
    }
}
