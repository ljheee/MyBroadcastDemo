package com.example.administrator.mybroadcastdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView textView;
    int n = 1;//计数器，是类成员变量，活动不销毁，一直存在
    DemoThread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);

    }

    @Override
    protected void onResume() {
        super.onResume();
        thread = new DemoThread();
        thread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        thread.isRunning = false;
    }


    class DemoThread extends  Thread{
        volatile  boolean isRunning = true;

        @Override
        public void run() {
            while (isRunning){
 //               textView.setText(String.valueOf(n++));
                //会出错，子线程不能访问UI。UI只能在主线程更新


                //解决：子线程发消息给主线程，让主线程操作UI
                //runOnUiThread封装了，调用post
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText(String.valueOf(n++));
                    }
                });

                //还可以用view.post()---不推荐
//                textView.post(new Runnable() {
//                    @Override
//                    public void run() {
//
//                    }
//                });

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
