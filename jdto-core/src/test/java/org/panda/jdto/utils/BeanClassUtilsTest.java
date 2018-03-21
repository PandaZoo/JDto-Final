package org.panda.jdto.utils;

import org.junit.Assert;
import org.junit.Test;
import org.panda.jdto.entity.Person;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * User: luolibing
 * Date: 2018/3/17 14:33
 */
public class BeanClassUtilsTest {

    @Test
    public void getAllGetterMethod() {
        Map<String, Method> getterMethod = BeanClassUtils.getAllGetterMethod(Person.class);
        Assert.assertNotNull(getterMethod.get("id"));
        Assert.assertNotNull(getterMethod.get("name"));
    }

    @Test
    public void getField() {
        Field idField = BeanClassUtils.getField(Person.class, "id");
        Assert.assertNotNull(idField);
    }

}
