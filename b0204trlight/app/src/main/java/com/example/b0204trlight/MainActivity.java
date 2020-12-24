package com.example.b0204trlight;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout b1, b2, b3;
    Button button1;
    private boolean start_stop = false;
    private int counter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.bulb1);
        b2 = findViewById(R.id.bulb2);
        b3 = findViewById(R.id.bulb3);
        button1 = findViewById(R.id.button1);

        b1.setBackgroundColor(Color.GREEN);

    }


    public void onClickStart(View view) {
        if(!start_stop){
            start_stop = true;
            button1.setText(getResources().getText(R.string.stop));

            new Thread(new Runnable() {
                @Override
                public void run() {
//                    b1.setBackgroundColor(getResources().getColor(R.color.teal_200));
                    while (start_stop){
                        counter++;
                        switch (counter){
                            case 1:
                                b1.setBackgroundColor(Color.GREEN);
                                b2.setBackgroundColor(getResources().getColor(R.color.teal_200));
                                b3.setBackgroundColor(getResources().getColor(R.color.teal_200));
                                break;
                            case 2:
                                b1.setBackgroundColor(getResources().getColor(R.color.teal_200));
                                b2.setBackgroundColor(Color.YELLOW);
                                b3.setBackgroundColor(getResources().getColor(R.color.teal_200));
                                break;
                            case 3:
                                b1.setBackgroundColor(getResources().getColor(R.color.teal_200));
                                b2.setBackgroundColor(getResources().getColor(R.color.teal_200));
                                b3.setBackgroundColor(Color.RED);
                                counter = 0;
                                break;
                        }
                        try{
                            Thread.sleep(1000);
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                }
            }).start();


        }else {
            start_stop = false;
            button1.setText(getResources().getText(R.string.start));
        }

    }
}