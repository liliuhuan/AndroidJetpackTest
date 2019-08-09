package com.app.suit.customviewp.lifecycles;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import androidx.databinding.DataBindingUtil;

import com.app.suit.customviewp.R;
import com.app.suit.customviewp.databinding.ActivityLifecyclesBinding;
/***********************************************************
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
 **************************************************************
 * @author: 李刘欢
 * @date：2019/8/9 10:40
 * @version:1.0.0
 * @description: LifecyclesActivity.java  监控生命周期
 */

public class LifecyclesActivity extends AppCompatActivity implements LifecycleOwner {

    private LifecycleRegistry mLifecycleRegistry;
    private ActivityLifecyclesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycles);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_lifecycles);
        mLifecycleRegistry = new LifecycleRegistry(this);
        getLifecycle().addObserver(new MyObserver(binding));
    }

    @Override
    public Lifecycle getLifecycle() {
        return mLifecycleRegistry;
    }
}
