package org.panda.jdto.merger;

import org.panda.jdto.MultiPropertyValueMerger;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * User: luolibing
 * Date: 2018/3/27 13:35
 */
public class StringConcatValueMerger implements MultiPropertyValueMerger<String> {

    @Override
    public String mergeObjects(List<Object> value, String[] mergerParam) {
        if(Objects.isNull(value)) {
            return null;
        }

        return value.stream().map(String::valueOf)
                .collect(Collectors.joining(""));
    }
}
