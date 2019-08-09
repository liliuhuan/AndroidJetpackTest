package com.app.suit.customviewp.databinding;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

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
 * @date：2019/8/8 17:04
 * @version:1.0.0
 * @description: UserPresenter
 */
public class UserPresenter {

    public void onUserNameClick(AppCompatActivity activity, User user) {
        Toast.makeText(activity, String.format("用户名：%s", user.getName()), Toast.LENGTH_SHORT).show();
    }

}
