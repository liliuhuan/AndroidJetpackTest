package com.app.suit.customviewp.test;

import android.widget.Filter;

import com.app.suit.customviewp.annotation.Bind;

import java.lang.reflect.Method;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
 * @date：2019/8/29 9:46
 * @version:1.0.0
 * @description: MutilThreadTest
 */
public class MutilThreadTest {
    //当使用volatile修饰某个变量时，它会保证对该变量的修改会立即被更新到内存中
    public static void main(String[] args) {
        Runnable t1 = new MyThread2(2);
        new Thread(t1,"t1").start();
        new Thread(t1,"t2").start();
        new Thread(t1,"t3").start();
        new Thread(t1,"t4").start();
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        String clazz = "com.lvr.annotation.AnnotationDemo";
        try {
            Method[] methods = MutilThreadTest.class.getClassLoader().loadClass(clazz).getMethods();
            for (Method m: methods) {
                if (m.isAnnotationPresent(Bind.class)){
                    Bind bind = m.getAnnotation(Bind.class);
                    System.out.println("method: "+ m);
                    System.out.println("name= "+ bind.value() );
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        test2();


    }
    private static int getInt(@Numbers.NumbersInt int a){
        return a;
    }

    private static String getString(@Numbers.NumbersString String b){
        return b;
    }
    private static void test2() {
        int a = getInt(Numbers.ONE);
        String b = getString(Numbers.STR_TWO);
    }


    ReentrantLock lock = new ReentrantLock();
    private void test(int i) {
        lock.lock();
        try {
            i++;
        } finally {
            lock.unlock();
        }
    }

    private void testSy(int i) {
        synchronized (MutilThreadTest.this) {
            i++;
        }
    }

    private synchronized void visit(){
        //同一时间只能有单线程进行访问
    }

    static class MyThread implements Runnable {
        private ReentrantLock lock = new ReentrantLock();

        public void run() {
            lock.lock();
            try{
                for(int i=0;i<5;i++){
                    System.out.println(Thread.currentThread().getName()+":"+i);
                }
            }finally{
                lock.unlock();
            }
        }
    }

    static class MyThread2 implements Runnable {
        private int count ;
        public MyThread2(int i) {
            this.count = i;
        }

        public void run() {
                synchronized (MyThread2.this){
                    for(int i=0;i<5;i++){
                        System.out.println(Thread.currentThread().getName()+":"+i+"----count-----" + count);
                    }
                }

        }
    }
}

