package org.panda.jdto.merger;

import org.panda.jdto.MultiPropertyMerger;

import java.util.List;
import java.util.Objects;

/**
 * Created by luolibing on 2018/5/2.
 */
public class SimpleMultiPropertyMerger implements MultiPropertyMerger<Object> {

    @Override
    public Object mergeObjects(List<Object> sources, String[] argParam) {
        if(sources == null) {
            return null;
        }
        return sources.stream().filter(Objects::nonNull).findFirst().orElse(null);
    }
}
