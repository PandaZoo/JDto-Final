package org.panda.jdto.entity;

import lombok.Data;
import org.panda.jdto.annotation.Source;

/**
 * Created by luolibing on 2018/3/19.
 */
@Data
public class PersonView {

    private Long id;

    @Source(value = "name")
    private String name;
}
