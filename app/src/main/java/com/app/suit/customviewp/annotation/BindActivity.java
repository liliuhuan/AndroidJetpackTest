package com.app.suit.customviewp.annotation;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.app.suit.customviewp.R;
@Bind(value = R.layout.activity_bind)
public class BindActivity extends AppCompatActivity {
    @Bind(R.id.tv_first)
    TextView tvFirst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BindHandler.handerBind(this);
    }

    @Bind(R.id.btn)
    public void clickBtn(){
        Toast.makeText(this,"bind 事件",Toast.LENGTH_LONG).show();
        tvFirst.setText("bind 事件");
    }
}
