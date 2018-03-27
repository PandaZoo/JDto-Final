package org.panda.jdto.entity;

import lombok.Data;
import org.panda.jdto.annotation.Source;
import org.panda.jdto.annotation.Sources;
import org.panda.jdto.merger.StringConcatValueMerger;

/**
 * User: luolibing
 * Date: 2018/3/27 11:03
 */
@Data
public class MultiPersonView {

    private Long id;

    @Sources(value = {
            @Source(value = "firstName"),
            @Source(value = "secondName")
    }, merger = StringConcatValueMerger.class)
    private String name;
}
