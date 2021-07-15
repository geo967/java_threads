package com.example.threads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button startButton;
    Handler mainHandler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startButton=findViewById(R.id.start_thread);
    }

    public void startThread(View view){
      /* ThreadExample t= new ThreadExample(10);
       t.start();*/
        ExampleRunnable runnable=new ExampleRunnable(10);
        new Thread(runnable).start();
    }
    public void stopThread(View view){

    }
    static class ThreadExample extends Thread{
        int sec;
        ThreadExample(int sec){
            this.sec=sec;
        }
        @Override
        public void run() {
            for(int i=0;i<sec;i++){
                Log.d("MainActivity", "startThread: "+i);
                try{
                    Thread.sleep(1000);}
                catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
     class ExampleRunnable implements Runnable{

        int seconds;
        ExampleRunnable(int seconds){
            this.seconds=seconds;
        }
        @Override
        public void run() {
            for(int i=0;i<seconds;i++){
                if(i==5){
                   /* Handler threadHandler=new Handler(Looper.getMainLooper());
                    threadHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            startButton.setText("50%");
                        }
                    });
                    */
                   /* startButton.post(new Runnable() {
                        @Override
                        public void run() {
                            startButton.setText("50%");
                        }
                    });*/
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            startButton.setText("59%");
                        }
                    });
                }
                Log.d("MainActivity", "startThread: "+i);
                try{
                    Thread.sleep(1000);}
                catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}