package com.example.vk8_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Context context = null;
    TextView text = null;
    TextView text2 = null;
    SeekBar seekbar = null;
    int value = 0;

    BottleDispenser bottledispenser = BottleDispenser.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;
        text = (TextView) findViewById(R.id.textView);
        text2 = (TextView) findViewById(R.id.textView2);
        seekbar = (SeekBar) findViewById(R.id.seekBar);

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                text2.setText(value);
                value = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void addMoney(View v){
        bottledispenser.addMoney(text);
    }

    public void buyBottle(View v){
        bottledispenser.buyBottle(text);
    }

    public void returnMoney(View v){
        bottledispenser.returnMoney(text);
    }

        /*public void listBottles(View v){
            bottledispenser.listBottles(text);
        }*/

}