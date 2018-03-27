package org.panda.jdto.merger;

import org.panda.jdto.SinglePropertyMerger;
import org.panda.jdto.entity.Identity;

/**
 * User: luolibing
 * Date: 2018/3/27 10:16
 */
public class IdentityValueMerger implements SinglePropertyMerger<Identity, Long> {

    @Override
    public Identity mergeObjects(Long value, String[] mergerParam) {
        return new Identity(value);
    }
}
