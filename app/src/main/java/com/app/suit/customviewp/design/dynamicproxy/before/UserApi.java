package com.app.suit.customviewp.design.dynamicproxy.before;

import com.app.suit.customviewp.design.dynamicproxy.entity.UserBean;
import com.app.suit.customviewp.design.dynamicproxy.VirtualHelper;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

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
 * @date：2019/8/15 9:54
 * @version:1.0.0
 * @description: UserApi
 */
public class UserApi {
    private static final String API_LOGIN = "http://***.***.***";
    private static final Gson sGson = new Gson();

    public static UserBean login(String username, String password) {
        Map<String, Object> params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);
        String response = VirtualHelper.request(API_LOGIN, params);
        //注，这里只是为了举例说明一下，就假设此时的数据结构就是跟User一致的
        return sGson.fromJson(response, UserBean.class);
    }

}
