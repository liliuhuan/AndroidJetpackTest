package com.app.suit.customviewp.design.dynamicproxy.after;

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
 * @date：2019/8/15 10:04
 * @version:1.0.0
 * @description: Request
 */
public class Request implements IRequest {
    private String url;

    private Map<String, Object> params;

    private Class<?> responseCls;

    Request(String url, Map<String, Object> params, Class<?> responseCls) {
        this.url = url;
        this.params = params;
        this.responseCls = responseCls;
    }

    @Override
    public String url() {
        return url;
    }

    @Override
    public Map<String, Object> params() {
        return params;
    }

    @Override
    public Class<?> responseCls() {
        return responseCls;
    }
}
