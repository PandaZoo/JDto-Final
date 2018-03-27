package org.panda.jdto.annotation;

import org.panda.jdto.SinglePropertyMerger;
import org.panda.jdto.merger.SimpleSinglePropertyMerger;

import java.lang.annotation.*;

/**
 * 多个字段合并到一个
 * Created by luolibing on 2018/3/15.
 */
@Documented
@Repeatable(Sources.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
public @interface Source {

    /**
     * 需要映射的字段名称
     * @return
     */
    String value();


    /**
     * 字段merger
     * @return
     */
    Class<? extends SinglePropertyMerger> merger() default SimpleSinglePropertyMerger.class;


    /**
     * merger参数
     * @return
     */
    String[] mergerParam() default "";
}
