package com.app.suit.customviewp.design.iterator;

import java.util.ArrayList;
import java.util.Arrays;

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
 * @date：2019/8/6 11:10
 * @version:1.0.0
 * @description: testIterator
 */
public class testIterator {
    private static String[] names = {"Robert", "John", "Julie", "Lora"};
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList(Arrays.asList(names));
        NameRepository nameRepository = new NameRepository(list);
        Iterator<String> iterator = nameRepository.getIterator();
        while (iterator.hasNext()) {
            String name = iterator.next();
            if (name.equals("John")){
                iterator.remove();
            }
        }
        for (String s: list) {
            System.out.println("Name : " + s);
        }
    }
}
