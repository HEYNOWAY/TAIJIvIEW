package com.example.root.taijiview;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private TaijiView taijileft;
    private TaijiView taijiright;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        taijileft = (TaijiView) findViewById(R.id.taijiview);
        taijiright = (TaijiView) findViewById(R.id.taijiview2);
        final Handler handler = new Handler() {
            private float degrees = 0;
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                taijileft.setDegree(degrees += 5);
                taijiright.setDegree(degrees+=10);
                this.sendEmptyMessageDelayed(0, 80);
            }
        };

        handler.sendEmptyMessageDelayed(0, 20);

    }
}
