package com.example.administrator.mybroadcastdemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * 普通服务
 * 无内置线程
 * 自动调用停止才销毁
 * 可以在清单文件中， android:process=":data_service"指定让服务单独使用一个进程
 */
public class DataService extends Service {
    private static final String TAG = "DataService";

    public DataService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
