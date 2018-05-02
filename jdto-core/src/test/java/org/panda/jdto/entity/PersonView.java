package org.panda.jdto.entity;

import lombok.Data;
import org.panda.jdto.annotation.Source;
import org.panda.jdto.merger.WrapValueMerger;

/**
 * Created by luolibing on 2018/3/19.
 */
@Data
public class PersonView {

    private Long id;

    @Source(value = "name", merger = WrapValueMerger.class, mergerParam = "哈哈哈")
    private String name;
}
