package com.app.suit.customviewp.design.dynamicproxy;

import android.util.Log;

import com.app.suit.customviewp.design.dynamicproxy.after.ApiGenerator;
import com.app.suit.customviewp.design.dynamicproxy.after.LoginApi;
import com.app.suit.customviewp.design.dynamicproxy.before.UserApi;
import com.app.suit.customviewp.design.dynamicproxy.entity.UserBean;

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
 * @date：2019/8/15 9:55
 * @version:1.0.0
 * @description: TestRequest
 */
public class TestRequest {
    public static void main(String[] a) {
        UserBean userBean = UserApi.login("123", "456");
        System.out.println(userBean.toString());

        LoginApi api = ApiGenerator.generateApi(LoginApi.class);
        UserBean login = api.login("123", "456");
        System.out.println( login.toString());
    }
}
