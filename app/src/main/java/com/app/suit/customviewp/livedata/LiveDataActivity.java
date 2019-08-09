package com.app.suit.customviewp.livedata;

import android.arch.core.util.Function;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.Transformations;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import androidx.databinding.DataBindingUtil;

import com.app.suit.customviewp.R;
import com.app.suit.customviewp.databinding.ActivityLiveDataBinding;
import com.app.suit.customviewp.databinding.User;

import java.math.BigDecimal;
import java.util.Random;

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
 * @date：2019/8/9 10:39
 * @version:1.0.0
 * @description: LiveDataActivity.java   LiveData 是一个可观测的数据持有类，
 */

public class LiveDataActivity extends AppCompatActivity implements Observer<Integer> {
    MutableLiveData<Integer> liveData;
    private ActivityLiveDataBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_live_data);
        binding.setAct(this);

        liveData = new MutableLiveData<>();
//        liveData.observe(this, this);
        Transformations.map(liveData, new Function<Integer, String>() {
            @Override
            public String apply(Integer input) {
                return input + "";
            }
        }).observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                binding.setNumber(Integer.valueOf(s));
            }
        });

        MutableLiveData<String> userIdLiveData = new MutableLiveData<>();
        LiveData<User> userLiveData = Transformations.switchMap(userIdLiveData, new Function<String, LiveData<User>>() {
            @Override
            public LiveData<User> apply(String input) {
                return null;
            }
        });


        StockLiveData.get("1").observe(this, new Observer<BigDecimal>() {
            @Override
            public void onChanged(@Nullable BigDecimal bigDecimal) {
                Log.e("t---", "LiveDataActivity---" + bigDecimal);
            }
        });
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_content, LiveDataFragment.newInstance("1", "2")).commit();


    }

    @Override
    public void onChanged(@Nullable Integer integer) {
        binding.setNumber(integer);
        StockLiveData stockLiveData = StockLiveData.get("1");
        stockLiveData.setValue(BigDecimal.valueOf(integer));
    }

    public void changeNumber() {
        int i = new Random().nextInt(100);
        /**
         * UI
         */
        liveData.setValue(i);
        /**
         * thead
         *         liveData.postValue(i);
         */
    }
}
