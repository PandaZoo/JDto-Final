package org.panda.jdto.annotation;

import org.panda.jdto.SinglePropertyMerger;

import java.lang.annotation.*;

/**
 * Created by luolibing on 2018/3/15.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER})
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
    Class<? extends SinglePropertyMerger> merger();


    /**
     * merger参数
     * @return
     */
    String[] mergerParam() default "";
}
