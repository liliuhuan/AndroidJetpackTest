package com.app.suit.customviewp.design.builder;

import com.app.suit.customviewp.design.builder.item.Item;

import java.util.ArrayList;
import java.util.List;

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
 * @date：2019/8/5 14:56
 * @version:1.0.0
 * @description: Meal
 */
 class Meal {
    private List<Item> items = new ArrayList<Item>();

     void addItem(Item item){
        items.add(item);
    }

     float getCost(){
        float cost = 0.0f;
        for (Item item : items) {
            cost += item.price();
        }
        return cost;
    }

    void showItems(){
        for (Item item : items) {
            System.out.print("Item : "+item.name());
            System.out.print(", Packing : "+item.packing().pack());
            System.out.println(", Price : "+item.price());
        }
    }
}
