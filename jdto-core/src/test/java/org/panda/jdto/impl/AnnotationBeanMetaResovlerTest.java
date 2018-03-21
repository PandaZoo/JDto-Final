package org.panda.jdto.impl;

import org.junit.Test;
import org.panda.jdto.annotation.AnnotationBeanMetaResolver;
import org.panda.jdto.annotation.BaseBeanMetaResolver;
import org.panda.jdto.entity.Person;

/**
 * Created by luolibing on 2018/3/21.
 */
public class AnnotationBeanMetaResovlerTest {

    private BaseBeanMetaResolver beanMetaResolver = new AnnotationBeanMetaResolver();


    @Test
    public void test() {
        BeanMetaData beanMetaData = beanMetaResolver.resolve(Person.class);
        System.out.println(beanMetaData);
    }
}
