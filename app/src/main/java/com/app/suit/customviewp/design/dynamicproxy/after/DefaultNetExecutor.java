package com.app.suit.customviewp.design.dynamicproxy.after;

import com.app.suit.customviewp.design.dynamicproxy.VirtualHelper;
import com.google.gson.Gson;

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
 * @date：2019/8/15 10:06
 * @version:1.0.0
 * @description: DefaultNetExecutor
 */
public class DefaultNetExecutor implements INetExecutor {
    private static final Gson sGson = new Gson();
    @Override
    public <T> T execute(IRequest request) {
        String response = VirtualHelper.request(request.url(), request.params());
        return (T) sGson.fromJson(response, request.responseCls());
    }
}
