package org.panda.jdto.impl;

import org.panda.jdto.DTOBinder;

import java.util.Collection;
import java.util.List;

/**
 * Created by luolibing on 2018/3/8.
 */
public class SimpleDtoBinder implements DTOBinder {
    public <T> T bindFromBusinessObject(Class<T> dtoClass, Object... businessObject) {
        return null;
    }

    public <T> List<T> bindFromBusinessObjectList(Class<T> dtoClass, List[] businessObjs) {
        return null;
    }

    public <T, C extends Collection> C bindFromBusinessObjectCollection(Class<T> dtoClass, C businessObjs) {
        return null;
    }

    public <T> T extractFromDto(Class<T> businessObj, Object obj) {
        return null;
    }
}
