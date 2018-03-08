package org.panda.jdto;

import java.util.Collection;
import java.util.List;

/**
 * Created by luolibing on 2018/3/8.
 */
public interface DTOBinder {


    /**
     * 一个或者多个合并为1个dto
     * @param dtoClass
     * @param businessObject
     * @param <T>
     * @return
     */
    <T> T bindFromBusinessObject(Class<T> dtoClass, Object... businessObject);


    /**
     * 一个或者多个list合并为1个dto
     * @param dtoClass
     * @param businessObjs
     * @param <T>
     * @return
     */
    <T> List<T> bindFromBusinessObjectList(Class<T> dtoClass, List... businessObjs);


    /**
     * 将一个集合合并为一个
     * @param dtoClass
     * @param businessObjs
     * @param <T>
     * @param <C>
     * @return
     */
    <T, C extends Collection> C bindFromBusinessObjectCollection(Class<T> dtoClass, C businessObjs);


    /**
     * 从dto中抽取出一个业务对象
     * @param businessObj
     * @param obj
     * @param <T>
     * @return
     */
    <T> T extractFromDto(Class<T> businessObj, Object obj);
}
