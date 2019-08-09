package com.app.suit.customviewp.room;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import androidx.databinding.DataBindingUtil;

import com.app.suit.customviewp.R;
import com.app.suit.customviewp.databinding.ActivityRoomBinding;

import java.util.List;
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
 * @date：2019/8/9 14:43
 * @version:1.0.0
 * @description: RoomActivity.java   Room是一个对象关系映射(ORM)库。Room抽象了SQLite的使用，可以在充分利用SQLite的同时访问流畅的数据库。
 */

public class RoomActivity extends AppCompatActivity implements Observer<List<Word>> {

    private WordViewModel model;
    private ActivityRoomBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_room);
        binding.setAct(this);
        model = ViewModelProviders.of(this).get(WordViewModel.class);
        model.getAllWord().observe(this, this);
    }

    public void delete() {
        model.deleteAll();
    }

    public void changeWord() {
        Word mWord = new Word();
        mWord.setWord(String.valueOf(new Random().nextInt(100)));
        LiveData<List<Word>> allWord = model.getAllWord();
        boolean contains = allWord.getValue().contains(mWord);
        if (!contains) model.insert(mWord);
    }

    @Override
    public void onChanged(@Nullable List<Word> words) {
        if (words == null || words.size() == 0){
            binding.setText("");
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RoomActivity---\n");
        for (int i = 0; i < words.size(); i++) {
            Log.e("t----", "RoomActivity--" + words.get(i).getWord());
            stringBuilder.append(words.get(i).getWord()).append("---\n");
        }

        binding.setText(stringBuilder.toString());
    }
}
