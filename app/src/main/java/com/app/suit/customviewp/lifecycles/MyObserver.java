package com.app.suit.customviewp.lifecycles;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.util.Log;

import com.app.suit.customviewp.databinding.ActivityLifecyclesBinding;

import java.lang.ref.WeakReference;


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
 * @date：2019/8/9 9:26
 * @version:1.0.0
 * @description: MyObserver
 */
public class MyObserver implements LifecycleObserver {
    private WeakReference<ActivityLifecyclesBinding> weakReference;

    public MyObserver(ActivityLifecyclesBinding binding) {
        weakReference = new WeakReference<>(binding);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        Log.e("t----", "onCreate");
        weakReference.get().tvShow.setText("---onCreate");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        Log.e("t----", "onStart");
        weakReference.get().tvShow.append("\n---onStart");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        Log.e("t----", "onResume");
        weakReference.get().tvShow.append("\n---onResume");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        Log.e("t----", "onPause");
        weakReference.get().tvShow.append("\n---onPause");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        Log.e("t----", "onStop");
        weakReference.get().tvShow.append("\n---onStop");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        Log.e("t----", "onDestroy");
        weakReference.get().tvShow.append("\n---onDestroy");
    }

}