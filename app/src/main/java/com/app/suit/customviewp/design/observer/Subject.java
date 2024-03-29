package com.app.suit.customviewp.design.observer;

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
 * @date：2019/8/6 11:34
 * @version:1.0.0
 * @description: Subject  被观察者
 */
class Subject {
    private List<Observer> observers = new ArrayList<Observer>();
    private int state;

     int getState() {
        return state;
    }

     void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

     void attach(Observer observer){
        observers.add(observer);
    }

     private void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
