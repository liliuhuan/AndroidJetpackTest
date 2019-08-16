package com.app.suit.customviewp.reflect;

import com.app.suit.customviewp.databinding.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/************************************************************
 *
 *
 *                   .::::.
 *                  .::::::::.
 *                 :::::::::::  COME ON BABY
 *             ..:::::::::::'
 *           '::::::::::::'
 *             .::::::::::
 *        '::::::::::::::..
 *             ..::::::::::::.
 *           ``::::::::::::::::
 *            ::::``:::::::::'        .:::.
 *           ::::'   ':::::'       .::::::::.
 *         .::::'      ::::     .:::::::'::::.
 *        .:::'       :::::  .:::::::::' ':::::.
 *       .::'        :::::.:::::::::'      ':::::.
 *      .::'         ::::::::::::::'         ``::::.
 *  ...:::           ::::::::::::'              ``::.
 * ```` ':.          ':::::::::'                  ::::..
 *                    '.:::::'                    ':'````..
 *
 *************************************************************
 * @author: 李刘欢
 * @date：2019/8/15 10:51
 * @version:1.0.0
 * @description: ReflectTest
 */
public class ReflectTest {
    public static void main(String[] args) {
        /**
         * 类的获取
         */
        getClassDemo();
        /**
         * 创建对象
         */
        creatDemo();

        /**
         *读写对象属性
         */

        readDemo();

        /**
         * 反射的简单应用
         */
        testDemo();
    }

    //我们正在使用一个第三方的jar包，包含两个类User和Dog(见下)，而我们现在需求是，要调用一个User实例中dog的happy方法。
    private static void testDemo() {
        Dog user = new Dog();
        Class<Dog> userClass = Dog.class;
        try {
            Field field = userClass.getDeclaredField("dog");
            field.setAccessible(true);
            /**
             * dog  对象
             */
            Object dog = field.get(user);
            /**
             * dog 类文件
             */
            Class<?> dogClass = dog.getClass();
            Method method = dogClass.getDeclaredMethod("sleep");
            method.setAccessible(true);
            /**
             * 反射dog 对象的sleep方法
             */
            method.invoke(dog);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *  方法 用invoke   执行
     *  属性 用 set 更改属性
     */
    private static void readDemo() {
        TestDemo user = new TestDemo();
        Class cls = TestDemo.class;

        try {
            /**
             * 静 态属性
             */
            Field field = cls.getField("age");
            //读取静态属性
            int age = (int) field.get(null);
            //设置静态属性
            field.set(null, 10);

            /**
             * 共有成员属性
             */
            Field clsField = cls.getField("name");
            //读取成员属性
            String name = (String) clsField.get(user);
            //设置成员属性
            clsField.set(user, "大白");

            /**
             * 私有成员属性
             */
            Field sexField = cls.getDeclaredField("sex");
            //如果方法是 private修饰的，当你用反射去访问的时候  setAccessible(true); 之后 才能访问
            sexField.setAccessible(true);
            //读取私有成员属性
            String sex = (String) sexField.get(user);
            //设置私有成员属性
            sexField.set(user, "大白");

            /**
             * 静态方法
             */

            //注意，这里第一个参数是指方法名，后面的参数是可变长参数，是目标方法的对应参数类型
            //若目标方法是无参的，则不填
            Method sayMethod = cls.getMethod("say", String.class);
            //静态方法不依赖对象实例，所以第一个参数是null
            sayMethod.invoke(null, "胡巴");
            /**
             * 成员方法
             */
            Method plusMethod = cls.getMethod("plus", int.class, int.class);
            //如果该方法是非public的，则要在invoke之前调用 plusMethod.setAccessible(true);
            //注意，由于该方法是成员方法，它的执行依赖于一个User实例，所以第一个参数是user
            int result = (int) plusMethod.invoke(user, 2, 7);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class TestDemo {
        public static int age;
        public String name;
        private String sex;

        public static void say(String name) {
            System.out.println("My name is " + name);
        }

        public int plus(int a, int b) {
            return a + b;
        }
    }

    private static void creatDemo() {
        Class<User> cls = User.class;
        try {
            //1 通过 Class 创建公有的无参构造方法
            User user = cls.newInstance();

            //2 通过 Constructor 创建公有的无参构造方法
            Constructor<User> constructor = cls.getConstructor();
            User user2 = constructor.newInstance();

            //3 通过 Constructor 创建私有的无参构造方法
            Constructor<User> constructor2 = cls.getDeclaredConstructor();
            //注意，此处使用暴力反射，反射中该方法经常被使用
            constructor2.setAccessible(true);
            User user3 = constructor2.newInstance();

            //4 通过 Constructor 创建私有的含参构造方法
            Constructor<User> constructor3 = cls.getDeclaredConstructor(String.class, int.class);
            constructor3.setAccessible(true);
            //注意，此处传递的参数类型和上面的String.class和int.class保持一致
            User user4 = constructor3.newInstance("小莫", 3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void getClassDemo() {
        Class<Bean> aClass1 = Bean.class;

        Bean bean = new Bean();
        Class<? extends Bean> aClass = bean.getClass();

        //注意这里的参数是类的全限定名(即含有包名)
        try {
            Class cls2 = Class.forName("com.reflect.User");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        Class cls3 =  ClassLoader.findClass("com.reflect.User");
    }
}
