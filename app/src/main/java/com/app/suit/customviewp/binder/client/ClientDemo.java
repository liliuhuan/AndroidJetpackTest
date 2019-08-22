package com.app.suit.customviewp.binder.client;

import android.os.IBinder;
import android.os.RemoteException;

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
 * @date：2019/8/22 14:12
 * @version:1.0.0
 * @description: ClientDemo
 */
public class ClientDemo {
    public static void main(String[] args) throws RemoteException {
        System.out.println("Client start");
        IBinder binder = ServiceManager.getService("MyService"); //获取名为"MyService"的服务
        IMyService myService = new MyServiceProxy(binder); //创建MyServiceProxy对象
        myService.sayHello("binder"); //通过MyServiceProxy对象调用接口的方法
        System.out.println("Client end");
    }
}
