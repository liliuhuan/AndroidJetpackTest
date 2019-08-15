package com.app.suit.customviewp.design.dynamicproxy;

import com.app.suit.customviewp.design.dynamicproxy.entity.UserBean;
import com.google.gson.Gson;

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
 * @date：2019/8/15 9:49
 * @version:1.0.0
 * @description: VirtualHelper
 */
public class VirtualHelper {
    private static final Gson sGson = new Gson();

    public static String request(String url, Map<String, Object> params) {
        if (params != null) {
            if ("123".equals(params.get("username"))
                    && "456".equals(params.get("password"))) {
                UserBean userBean = new UserBean();
                userBean.address = "杭州";
                userBean.sex = "男";
                userBean.uId = "Id";
                userBean.username = "啊啊";
                return sGson.toJson(userBean);
            }
        }
        return null;
    }

}
