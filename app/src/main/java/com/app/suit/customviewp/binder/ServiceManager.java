package com.app.suit.customviewp.binder;

import android.os.Binder;
import android.os.IBinder;

import com.app.suit.customviewp.binder.service.MyService;

import java.util.LinkedHashMap;

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
 * @date：2019/8/22 14:19
 * @version:1.0.0
 * @description: ServiceManager
 */
public class ServiceManager {
    private static final LinkedHashMap<String,IBinder> link = new LinkedHashMap<>();
    public static IBinder getService(String serviceName) {
        return link.get(serviceName);
    }

    public static void addService(String serviceName, IBinder iBinder) {
        link.put(serviceName,iBinder);
    }
}
