package org.panda.jdto;

/**
 * 单字段合并
 * Created by luolibing on 2018/3/8.
 */
public interface SinglePropertyMerger<R, S> extends PropertyMerger {

    R mergeObjects(S value, String[] mergerParam);
}
