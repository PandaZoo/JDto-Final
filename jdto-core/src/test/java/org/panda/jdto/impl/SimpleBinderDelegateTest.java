package org.panda.jdto.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.panda.jdto.annotation.AnnotationBeanMetaResolver;
import org.panda.jdto.entity.MultiPersonView;
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
        simpleBinderDelegate.setPropertyMergerManager(new SimplePropertyMergerManager());
    }

    @Test
    public void bindFromBusinessObject() {
        Person person = new Person();
        person.setId(100L);
        person.setFirstName("luo");
        person.setSecondName("libing");
//        person.setName("luolibing");
        PersonView personView = simpleBinderDelegate.bindFromBusinessObject(PersonView.class, person);
        Assert.assertEquals(personView.getId().getValue(), person.getId());
        Assert.assertEquals(personView.getName(), "[哈哈哈] 我是 luolibing");
    }

    @Test
    public void multiBind() {
        Person person = new Person();
        person.setId(100L);
        person.setFirstName("luo");
        person.setSecondName("libing");
//        person.setName("luolibing");
        MultiPersonView personView = simpleBinderDelegate.bindFromBusinessObject(MultiPersonView.class, person);
        System.out.println(personView);
    }
}
