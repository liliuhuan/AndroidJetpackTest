package com.app.suit.customviewp.design.factory.color;

import com.app.suit.customviewp.design.factory.FactoryType;
import com.app.suit.customviewp.design.factory.IFactory;
import com.app.suit.customviewp.design.factory.color.Color;

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
 * @date：2019/8/16 14:15
 * @version:1.0.0
 * @description: IColorFactory
 */
public interface IColorFactory extends IFactory {
    Color getColor(FactoryType color);
}
