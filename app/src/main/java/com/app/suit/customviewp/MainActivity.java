package com.app.suit.customviewp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import androidx.databinding.DataBindingUtil;

import com.app.suit.customviewp.aidl.ClientActivity;
import com.app.suit.customviewp.annotation.BindActivity;
import com.app.suit.customviewp.databinding.ActivityMainBinding;
import com.app.suit.customviewp.databinding.DataBindActivity;
import com.app.suit.customviewp.lifecycles.LifecyclesActivity;
import com.app.suit.customviewp.livedata.LiveDataActivity;
import com.app.suit.customviewp.room.RoomActivity;
import com.app.suit.customviewp.service.MyService;
import com.app.suit.customviewp.viewmodel.ViewModelActivity;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        FontsManager.initFormAssets(this, "fonts/condensedbold.ttf");
//        FontsManager.changeFonts(this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setAct(this);
        Log.e("t---", "MainActivity==" + Thread.currentThread().getName() + "--" + Thread.currentThread().getId());
    }


    public void toDatabinding() {
        toActivity(DataBindActivity.class);
    }

    public void toLifecycles() {
        toActivity(LifecyclesActivity.class);
    }

    public void toLiveData() {
        toActivity(LiveDataActivity.class);
    }

    public void toViewModel() {
        toActivity(ViewModelActivity.class);
    }

    public void toRoom() {
        toActivity(RoomActivity.class);
    }

    public void toBind() {
        toActivity(BindActivity.class);
    }
    public void toBinderService() {
        toActivity(ClientActivity.class);
    }

    private void toActivity(Class<?> A) {
        startActivity(new Intent(this, A));
    }


    public void toService() {
        Intent intent = new Intent(this, MyService.class);
        intent.setAction("com.app.suit.customviewp.service.MyService");
        startService(intent);
    }
}
