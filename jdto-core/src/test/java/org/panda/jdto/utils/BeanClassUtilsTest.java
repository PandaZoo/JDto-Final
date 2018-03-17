package org.panda.jdto.utils;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * User: luolibing
 * Date: 2018/3/17 14:33
 */
public class BeanClassUtilsTest {

    @Test
    public void getAllGetterMethod() {
        Map<String, Method> getterMethod = BeanClassUtils.getAllGetterMethod(Child.class);
        getterMethod.forEach((k, v) -> {
            System.out.println("propertyName = " + k +" , and value = " + v.getName());
        });
    }

    public class Parent {
        private Long id;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
    }

    public class Child extends Parent {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
