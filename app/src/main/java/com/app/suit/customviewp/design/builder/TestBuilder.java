package com.app.suit.customviewp.design.builder;

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
 * @date：2019/8/5 14:59
 * @version:1.0.0
 * @description: TestBuilder
 */
public class TestBuilder {

    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();
        /**
         * 生产a套餐
         */
        Meal meal = mealBuilder.prepareNonVegMeal();
        System.out.println("Non-Veg Meal");
        meal.showItems();
        System.out.println("Total Cost: " + meal.getCost());
        /**
         * 生产b套餐
         */
        Meal meal1 = mealBuilder.prepareVegMeal();
        System.out.println("\\n\\nVeg Meal");
        meal1.showItems();
        System.out.println("Total Cost: " + meal1.getCost());

    }
}
