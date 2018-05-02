package org.panda.jdto;

import java.util.List;

/**
 * 多字段合并
 * Created by luolibing on 2018/3/8.
 */
public interface MultiPropertyMerger<R> extends PropertyMerger {

    /**
     * 多个字段合并到一个
     * @param sources   需要合并的对象值
     * @param argParam  参数
     * @return
     */
    R mergeObjects(List<Object> sources, String[] argParam);
}
