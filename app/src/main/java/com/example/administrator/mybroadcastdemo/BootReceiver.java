package com.example.administrator.mybroadcastdemo;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * 静态全局广播
 * 不要在类的构造方法中初始化
 */
public class BootReceiver extends BroadcastReceiver {

    private static final String TAG = "BootReceiver";

    /**
     * 接收到广播，就执行该方法
     * @param context
     * @param intent
     */
    @Override
    public void onReceive(Context context, Intent intent) {
        //  This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Log.d(TAG,"onReceive"+intent.getAction());//打印：接收的是哪种广播

//        //收到广播，启动服务
//        Intent serviceIntent = new Intent(context,DataService.class);
//
//        //传递数据
//        serviceIntent.putExtra("city","cs");
//        context.startService(serviceIntent);


        //设置闹铃
        AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        //定时执行
//        am.set();

        //周期性执行

        //待定的意图，将来要执行的意图；不能new
        PendingIntent operation = PendingIntent.getService(  //启动服务；会被反复启动，服务只有一份，多次调用onStart()
                context,
                0,
                new Intent(context,PullDataService.class),
                PendingIntent.FLAG_UPDATE_CURRENT
        );

        am.setRepeating(
                AlarmManager.RTC,  //执行方式
                System.currentTimeMillis(),  //当前立即触发执行
                30*100, //执行间隔
                operation  //要执行的操作
        );

    }
}
