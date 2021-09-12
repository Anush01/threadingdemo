package com.example.anushmp.threading;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;


public class workerthread extends Thread {

    Handler handler;
    private static final String TAG = "bobbyknuckles";
    Looper l;


    @Override
    public void run() {
        super.run();

        Looper.prepare();
        l = Looper.myLooper();
        handler = new Handler(l);

        for (int i = 0; i < 5; i++) {

            Log.d(TAG, "run: default loop" + i);

            SystemClock.sleep(1000);


        }


        Looper.loop();
        Log.d(TAG, "end of thread ");
    }


    public void addtoqueue(Runnable task) {

        if (handler != null) {
            handler.post(task);
        } // need a null check here. for handler.

    }
}
