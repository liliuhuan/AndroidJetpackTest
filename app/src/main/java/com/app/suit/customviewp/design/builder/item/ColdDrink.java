package com.app.suit.customviewp.design.builder.item;


import com.app.suit.customviewp.design.builder.pack.Bottle;
import com.app.suit.customviewp.design.builder.pack.Packing;

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
 * @date：2019/8/5 14:53
 * @version:1.0.0
 * @description: ColdDrink
 */
public abstract class ColdDrink implements Item {
    @Override
    public Packing packing() {
        return new Bottle();
    }
}
