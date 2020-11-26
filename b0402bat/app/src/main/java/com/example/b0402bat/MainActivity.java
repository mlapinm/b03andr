package com.example.b0402bat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
          int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
          textView.setText(String.valueOf(level));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView);
        this.registerReceiver(this.mBroadcastReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
//        textView.setText("11");

    }
}