package com.dev_ver.hatchtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int timeV=30;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView=findViewById(R.id.time);
        SeekBar seekBar=findViewById(R.id.seekBar);
        seekBar.setMax(60);
        seekBar.setProgress(30);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekbar,int i,boolean b)
            {int minp=3;
            if(i<minp){i=minp;}
            textView.setText("00:"+String.valueOf(i));
            timeV=i;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });
        }

    public void btn(View view)
    { MediaPlayer mp= MediaPlayer.create(getApplicationContext(),R.raw.horn);
        TextView textView=findViewById(R.id.time);
        SeekBar seekBar=findViewById(R.id.seekBar);
        Button button=findViewById(R.id.buttonPanel);
        seekBar.setEnabled(false);
        button.setEnabled(false);

        new CountDownTimer(timeV*1000,1000)
        {
            @Override
            public void onTick(long millisUntilFinished) {
                timeV--;
                textView.setText("00:"+String.valueOf(timeV));
            }

            @Override
            public void onFinish() {
                mp.start();
                seekBar.setEnabled(true);
                textView.setText("00:30");
                seekBar.setProgress(30);
                button.setEnabled(true);

            }
        }.start();
    }
}