package com.app.suit.customviewp.design.factory;

import com.app.suit.customviewp.design.factory.color.Color;
import com.app.suit.customviewp.design.factory.color.ColorFactory;
import com.app.suit.customviewp.design.factory.shape.Shape;
import com.app.suit.customviewp.design.factory.shape.ShapeFactory;

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
 * @date：2019/8/5 14:24
 * @version:1.0.0
 * @description: TestFactory
 */
public class TestFactory {

    public static void main(String[] args) {

        ShapeFactory shapeFactory = new ShapeFactory();
        //获取 Circle 的对象，并调用它的 draw 方法
        Shape shape1 = shapeFactory.getShape(FactoryType.CIRCLE);

        //调用 Circle 的 draw 方法
        shape1.draw();

        //获取 Rectangle 的对象，并调用它的 draw 方法
        Shape shape2 = shapeFactory.getShape(FactoryType.RECTANGLE);

        //调用 Rectangle 的 draw 方法
        shape2.draw();

        //获取 Square 的对象，并调用它的 draw 方法
        Shape shape3 = shapeFactory.getShape(FactoryType.CIRCLE);

        //调用 Square 的 draw 方法
        shape3.draw();

        //获取颜色工厂
        IFactory factory = FactoryProducer.getFactory("COLOR");
        if (factory instanceof ColorFactory){
            ColorFactory colorFactory = (ColorFactory) factory;
            //获取颜色为 Red 的对象
            Color color1 = colorFactory.getColor(FactoryType.RED);

            //调用 Red 的 fill 方法
            color1.fill();

            //获取颜色为 Green 的对象
            Color color2 = colorFactory.getColor(FactoryType.GREEN);

            //调用 Green 的 fill 方法
            color2.fill();

            //获取颜色为 Blue 的对象
            Color color3 = colorFactory.getColor(FactoryType.BLUE);

            //调用 Blue 的 fill 方法
            color3.fill();
        }
    }
}
