package com.example.anushmp.threading;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    TextView startthread,stopthread,starttask2,update;
    workerthread worker;

    private static final String TAG = "bobbyknuckles";

    private Runnable task1 = new Runnable() {
        @Override
        public void run() {

            for (int i = 0; i < 10; i++) {

                //livetemplate

                SystemClock.sleep(1000);

                //update.setText(i + "");

                int finalI = i;
                runOnUiThread(() -> update.setText(finalI + ""));

                Log.d(TAG, "run: task1" + i);




            }

        }
    };

    private Runnable task2 = () -> {

        for (int i = 0; i < 10; i++) {
            SystemClock.sleep(1000);
            Log.d(TAG, "run: task2" + i);
        }

    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        startthread = findViewById(R.id.startThread);
        stopthread = findViewById(R.id.stopThread);
        starttask2 = findViewById(R.id.starttask2);
        update = findViewById(R.id.updates);

        worker = new workerthread();
        worker.start();


        startthread.setOnClickListener(v -> {

            worker.addtoqueue(task1);

            //work();
           // otherstuff();

        });


        stopthread.setOnClickListener( v -> {

                worker.l.quitSafely();
                //multiple things
                //work();
                //wo();
                //no();






        });

        starttask2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                worker.addtoqueue(task2);
            }
        });


    }

    //ufc mcdonalds software services onCreate
    //videophone execution. thread. video


    /*
    *
    *
    * Thread
    * Runnable
    * runonuithread()
    * process
    * Thread.sleep
    * Thread.run
    * Zygote
    *
    * feature phone runnable
    * cant start a thread more than once
    *
    * Thread.cancel
    * parallel sequential
    *
    * Looper.prepare
    * Looper.loop
    * android.os.handler
    *
    * Looper Handler MessageQueue
    *
    * stacks queues and Lists
    * motorola and nokia
    * lifo fifo
    *
    * handler takes a looper as an argument
    * handler.post
    * looper.mylooper
    * looper has a default messagequeue
    *
    * Thread stop
    * thread.looper.quit()
    * Every thread as a looper
    *
    * maple syrup
    * canadasyrup
    * wireless white
    * memory leaks
    *
    * */
}