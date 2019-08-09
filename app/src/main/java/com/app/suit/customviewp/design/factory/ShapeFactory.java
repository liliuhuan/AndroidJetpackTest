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
 * @date：2019/8/5 14:25
 * @version:1.0.0
 * @description: ShapeFactory
 */
public class ShapeFactory extends AbstractFactory{
    @Override
    public Color getColor(FactoryType color) {
        return null;
    }

    @Override
    public Shape getShape(FactoryType shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equals(FactoryType.CIRCLE)){
            return new Circle();
        } else if(shapeType.equals(FactoryType.RECTANGLE)){
            return new Rectangle();
        } else if(shapeType.equals(FactoryType.SQUARE)){
            return new Square();
        }
        return null;
    }
}
