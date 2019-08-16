package com.app.suit.customviewp.design.builder.item;

import com.app.suit.customviewp.design.builder.pack.Packing;
import com.app.suit.customviewp.design.builder.pack.Wrapper;

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
 * @date：2019/8/5 14:52
 * @version:1.0.0
 * @description: Burger  汉堡包
 */
public abstract class Burger implements Item {
    @Override
    public Packing packing() {
        return new Wrapper();
    }
}
