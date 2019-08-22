package com.app.suit.customviewp.aidl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.app.suit.customviewp.IRemoteService;
import com.app.suit.customviewp.R;
import com.app.suit.customviewp.entity.MyData;

public class ClientActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "BinderSimple";

    private IRemoteService mRemoteService;

    private boolean mIsBound;
    private TextView mCallBackTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);


        mCallBackTv = (TextView) findViewById(R.id.tv_callback);
        mCallBackTv.setText(R.string.remote_service_unattached);

        findViewById(R.id.btn_bind).setOnClickListener(this);
        findViewById(R.id.btn_unbind).setOnClickListener(this);
        findViewById(R.id.btn_kill).setOnClickListener(this);
    }

    /**
     * 用语监控远程服务连接的状态
     */
    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mRemoteService = IRemoteService.Stub.asInterface(service);
            String pidInfo = null;
            try {
                MyData myData = mRemoteService.getMyData();
                pidInfo = "pid="+ mRemoteService.getPid() + ", data1 = "+ myData.getData1() + ", data2="+ myData.getData2();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            Log.i(TAG, "[ClientActivity] onServiceConnected  "+pidInfo);
            mCallBackTv.setText(pidInfo);
            Toast.makeText(ClientActivity.this, R.string.remote_service_connected, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i(TAG, "[ClientActivity] onServiceDisconnected");
            mCallBackTv.setText(R.string.remote_service_disconnected);
            mRemoteService = null;
            Toast.makeText(ClientActivity.this, R.string.remote_service_disconnected, Toast.LENGTH_SHORT).show();
        }
    };


    /**
     * 绑定远程服务
     */
    private void bindRemoteService(){
        Log.i(TAG, "[ClientActivity] bindRemoteService");
        Intent intent = new Intent(ClientActivity.this, RemoteService.class);
        intent.setAction(IRemoteService.class.getName());
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);

        mIsBound = true;
        mCallBackTv.setText(R.string.binding);
    }

    /**
     * 解除绑定远程服务
     */
    private void unbindRemoteService(){
        if(!mIsBound){
            return;
        }
        Log.i(TAG, "[ClientActivity] unbindRemoteService ==>");
        unbindService(mConnection);
        mIsBound = false;
        mCallBackTv.setText(R.string.unbinding);
    }

    /**
     * 杀死远程服务
     */
    private void killRemoteService(){
        Log.i(TAG, "[ClientActivity] killRemoteService");
        try {
            android.os.Process.killProcess(mRemoteService.getPid());
            mCallBackTv.setText(R.string.kill_success);
        } catch (RemoteException e) {
            e.printStackTrace();
            Toast.makeText(ClientActivity.this, R.string.kill_failure, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_bind:
                bindRemoteService();
                break;
            case R.id.btn_unbind:
                unbindRemoteService();
                break;
            case R.id.btn_kill:
                killRemoteService();
                break;
        }
    }
}
