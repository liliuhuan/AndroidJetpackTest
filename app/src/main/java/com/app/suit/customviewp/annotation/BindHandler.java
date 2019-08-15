package com.app.suit.customviewp.annotation;

import android.app.Activity;
import android.view.View;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
 * @date：2019/8/15 14:06
 * @version:1.0.0
 * @description: BindHandler
 */
public class BindHandler {

    public static void handerBind(Activity activity) {
        Class cls = activity.getClass();
        handleSetContentView(activity);
        handleFindView(cls.getDeclaredFields(), activity);
        handleClickEvent(cls.getDeclaredMethods(), activity);
    }

    /**
     * 绑定xml布局
     *
     * @param activity
     */
    private static void handleSetContentView(Activity activity) {
        Class<? extends Activity> cls = activity.getClass();
        if (cls.isAnnotationPresent(Bind.class)) {
            Bind bind = cls.getAnnotation(Bind.class);
            int layout = bind.value();
            if (layout != 0)
                activity.setContentView(layout);
        }
    }

    private static void handleFindView(Field[] fields, Activity activity) {
        if (fields == null || fields.length == 0) {
            return;
        }
        for (Field field : fields) {
            if (field.isAnnotationPresent(Bind.class) && View.class.isAssignableFrom(field.getType())) {
                Bind bind = field.getAnnotation(Bind.class);
                int value = bind.value();
                if (value != 0) {
                    View view = activity.findViewById(value);
                    field.setAccessible(true);
                    try {
                        //直接通过反射set进去
                        field.set(activity, view);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

    private static void handleClickEvent(Method[] methods, final Activity activity) {
        if (methods == null || methods.length == 0) return;
        for (final Method method : methods) {
            //找到被Bind注解且无参的所有方法（注意这里限制无参是为了与下面调用method.invoke(activity)的无参保持一致）
            if (method.isAnnotationPresent(Bind.class) && method.getParameterTypes().length == 0) {
                Bind bind = method.getAnnotation(Bind.class);
                int id = bind.value();
                if (id != 0) {
                    activity.findViewById(id).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            try {
                                method.invoke(activity);
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            }
        }
    }
}
