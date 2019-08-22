package com.app.suit.customviewp.binder.service;

import android.os.Looper;

import com.app.suit.customviewp.binder.ServiceManager;


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
 * @date：2019/8/22 14:10
 * @version:1.0.0
 * @description: ServerDemo
 *
 * Server端
 *
 * ServerDemo.java：可执行程序
 * IMyService.java: 定义IMyService接口
 * MyService.java：定义MyService
 * Client端
 *
 * ClientDemo.java：可执行程序
 * IMyService.java: 与Server端完全一致
 * MyServiceProxy.java：定义MyServiceProxy
 */
public class ServerDemo {
    public static void main(String[] args) {
        System.out.println("MyService Start");
        //准备Looper循环执行
        Looper.prepareMainLooper();
        //设置为前台优先级
        android.os.Process.setThreadPriority(android.os.Process.THREAD_PRIORITY_FOREGROUND);
        //注册服务
        ServiceManager.addService("MyService", new MyService());
        Looper.loop();
    }
}
