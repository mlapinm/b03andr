package com.example.b0316curr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.DocumentsContract;
import android.util.Log;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private Document document;
    private Thread thread;
    private Runnable runnable;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.textView);

        textView.setText("OK2");
        Log.d("MyLog", "765");
//        Jsoup
        init();


    }

    private void init(){
        runnable = new Runnable() {
            @Override
            public void run() {
                getWeb();
            }
        };
        thread = new Thread(runnable);
        thread.start();
    }

    private void getWeb(){
        try {
            Log.d("MyLog", "1234");
            document = Jsoup.connect("https://minfin.com.ua/currency/").get();
            Log.d("MyLog", "Title : " + document.title());
            String string1 = "Title : " + document.title();
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    textView.setText(string1);
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}