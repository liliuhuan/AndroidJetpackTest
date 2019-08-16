package com.app.suit.customviewp.databinding;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;

import com.app.suit.customviewp.R;
import com.app.suit.customviewp.databinding.dummy.DummyContent;

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
 * @date：2019/8/8 16:05
 * @version:1.0.0
 * @description: DataBindActivity.java  双向绑定数据类
 */

public class DataBindActivity extends AppCompatActivity implements ItemFragment.OnListFragmentInteractionListener {
    ActivityDataBindBinding binding;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_bind);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_bind);
        user = new User();
        user.setName("NAME---10");
        user.setAddress("ADDRESS---10");
        binding.setUser(user);
        binding.setResId(getResources().getColor(R.color.colorAccent));
        binding.setUserInfo(user);
        binding.setHandle(new GoodsHandler());
        binding.setPresenter(new UserPresenter());
        binding.setAct(this);
        binding.setResR(R.drawable.ic_launcher_background);

        getSupportFragmentManager().beginTransaction().replace(R.id.fl_content,new ItemFragment()).commit();
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {
        Toast.makeText(this,item.content ,Toast.LENGTH_LONG).show();
    }

    public class GoodsHandler {
        public void changeGoodsName() {
            Log.e("t---", "changeGoodsName");
            user.setName("code" + new Random().nextInt(100));
            user.setAddress("hi" + new Random().nextInt(100));
            int i = new Random().nextInt(100);
            user.setMale(i % 2 == 0);
        }

        public void changeAddress() {
            user.setAddress("hi" + new Random().nextInt(100));
        }

    }

    public void test() {
        user.setName("哈哈" + new Random().nextInt(100));
    }

    public void afterTextChanged(Editable s) {
        user.setName(s.toString());
    }

    @BindingAdapter("text")
    public static void setText(Button view, String text) {
        view.setText(String.format("%s-Button", text));
    }

    @BindingAdapter({"loadImage"})
    public static void loadImage(ImageView view, int resId) {
        view.setImageResource(resId);
    }
}
