package com.app.suit.customviewp.test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: 李刘欢
 * @date：2019/6/20 9:51
 * @version:1.0.0
 * @description: TestClass
 */
public class TestClass {
    public static  void main(String[] args) throws NoSuchFieldException {
        getClassInfo();
        getFieldInfo();
    }

    private static void getFieldInfo() throws NoSuchFieldException {
        Class<Cat> class1 = Cat.class;
        class1.isAnnotation();
        class1.getDeclaredAnnotations();

        Field[] declaredFields = class1.getDeclaredFields();
        Field[] mFields = class1.getFields();
        class1.getDeclaredField("name");

        List list = new ArrayList();
    }

    private static void getClassInfo() {
        try {
            Class<?> aClass = Class.forName("com.app.suit.customviewp.test.Cat");
            try {
                Cat c = (Cat) aClass.newInstance();
            } catch (IllegalAccessException e) {

                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
            Class<Cat> catClass = Cat.class;
            Class<? super Cat> superclass = Cat.class.getSuperclass();
            Class<? extends Cat> aClass1 = new Cat().getClass();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
