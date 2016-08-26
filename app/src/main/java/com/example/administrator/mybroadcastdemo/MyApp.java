package com.example.administrator.mybroadcastdemo;

import android.app.Application;
import android.content.Intent;

/**
 * 程序启动入点
 */
public class MyApp extends Application {

    /**
     * 自定义广播--广播名称
     */
    private static final String ACTION_DATA_SERVICE = "com.example.administrator.mybroadcastdemo.ACTION_DATA_SERVICE";

    @Override
    public void onCreate() {
        super.onCreate();

        //初始化

        //程序一启动，就发广播
        Intent intent =new Intent();
        intent.setAction(ACTION_DATA_SERVICE);//意图设置--发送什么广播

//        LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
        sendBroadcast(intent);
    }
}
