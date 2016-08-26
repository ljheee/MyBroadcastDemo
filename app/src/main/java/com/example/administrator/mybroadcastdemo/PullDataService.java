package com.example.administrator.mybroadcastdemo;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;


/**
 * 和普通的服务不同
 * 内置了一个子线程。默认在子程序执行，
 * 任务在队列中顺序执行，任务都执行结束了就销毁
 */
public class PullDataService extends IntentService {

    private static final String TAG = "PullDataService";

    public PullDataService() {
        super("PullDataService");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"onCreate");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    /**
     * 处理意图（子线程中执行）
     * @param intent    意图携带了要执行的操作
     */
    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG,"onHandleIntent:"+Thread.currentThread().getName());//证明该方法，在子线程中执行

    }

}
