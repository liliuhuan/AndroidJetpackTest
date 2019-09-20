package com.app.suit.customviewp.test;

import android.support.annotation.StringDef;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

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
 * @date：2019/8/29 17:07
 * @version:1.0.0
 * @description: Numbers
 */
public class Numbers {
    public static final int ONE = 1;
    public static final int TWO = 2;
    public static final int THREE = 3;

    public static final String STR_ONE = "ONE";
    public static final String STR_TWO = "TWO";
    public static final String STR_THREE = "THREE";

    @IntDef({ONE, TWO, THREE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface NumbersInt {
    }

    @StringDef({STR_ONE, STR_TWO, STR_THREE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface NumbersString {

    }
}
