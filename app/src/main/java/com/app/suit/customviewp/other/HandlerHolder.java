package com.app.suit.customviewp.other;

import android.os.Handler;
import android.os.Message;

import java.lang.ref.WeakReference;

/**
 * @author: 李刘欢
 * @date：2019/6/27 14:14
 * @version:1.0.0
 * @description: HandlerHolder
 */
public class HandlerHolder extends Handler {
    WeakReference<OnReceiveMessageListener> mListenerWeakReference;
    /**
     * @param listener 收到消息回调接口
     */
    HandlerHolder(OnReceiveMessageListener listener) {
        mListenerWeakReference = new WeakReference<>(listener);
    }

    @Override
    public void handleMessage(Message msg) {
        if (mListenerWeakReference!=null && mListenerWeakReference.get()!=null){
            mListenerWeakReference.get().handlerMessage(msg);
        }
    }
}
