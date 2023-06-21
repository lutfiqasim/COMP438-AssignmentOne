package edu.birzeit.elementeryschool;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Animation imageanim, txtanim;
    private TextView txt;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        img = (ImageView) findViewById(R.id.img);
        imageanim = AnimationUtils.loadAnimation(this, R.anim.imageanim);
        img.setAnimation(imageanim);
        txt = (TextView) findViewById(R.id.txt);
        txtanim = AnimationUtils.loadAnimation(this, R.anim.textanim);
        txt.setAnimation(txtanim);
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(mainIntent);
                finish();
            }
        }, 5000);
    }


}