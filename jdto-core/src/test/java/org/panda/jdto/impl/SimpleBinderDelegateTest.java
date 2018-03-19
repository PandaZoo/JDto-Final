package org.panda.jdto.impl;

import org.junit.Before;
import org.junit.Test;
import org.panda.jdto.annotation.AnnotationBeanMetaResolver;
import org.panda.jdto.entity.Person;
import org.panda.jdto.entity.PersonView;

/**
 * Created by luolibing on 2018/3/19.
 */
public class SimpleBinderDelegateTest {

    private SimpleBinderDelegate simpleBinderDelegate = new SimpleBinderDelegate();

    @Before
    public void setUp() {
        simpleBinderDelegate.setBeanMetaResolver(new AnnotationBeanMetaResolver());
    }

    @Test
    public void bindFromBusinessObject() {
        Person person = new Person();
        person.setId(100L);
        person.setFirstName("luo");
        person.setSecondName("libing");
        PersonView personView = simpleBinderDelegate.bindFromBusinessObject(PersonView.class, person);

    }
}
