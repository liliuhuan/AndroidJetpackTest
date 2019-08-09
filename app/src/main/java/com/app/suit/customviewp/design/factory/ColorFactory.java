package com.app.suit.customviewp.design.factory;

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
 * @date：2019/8/5 14:33
 * @version:1.0.0
 * @description: ColorFactory
 */
public class ColorFactory extends AbstractFactory {
    @Override
    public Color getColor(FactoryType color) {
        if(color == null){
            return null;
        }
        if(color.equals(FactoryType.RED)){
            return new Red();
        } else if(color.equals(FactoryType.GREEN)){
            return new Green();
        } else if(color.equals(FactoryType.BLUE)){
            return new Blue();
        }
        return null;
    }

    @Override
    public Shape getShape(FactoryType shape) {
        return null;
    }
}
