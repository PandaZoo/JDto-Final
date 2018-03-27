package org.panda.jdto.annotation;

import org.panda.jdto.MultiPropertyValueMerger;
import org.panda.jdto.merger.SimpleMultiPropertyMerger;

import java.lang.annotation.*;

/**
 * 多个字段合并到一个
 * User: luolibing
 * Date: 2018/3/27 10:25
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
public @interface Sources {

    Source[] value();

    Class<? extends MultiPropertyValueMerger> merger() default SimpleMultiPropertyMerger.class;

    String[] mergerParams() default "";
}
