package edu.birzeit.elementeryschool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    Button slideShow;
    Button calculation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        slideShow = (Button) findViewById(R.id.slideShow);
        calculation = (Button) findViewById(R.id.calculation);

    }

    public void OpenSlideShow(View view) {
        Intent slideshowIntent = new Intent(MainActivity.this,Cards.class);
        startActivity(slideshowIntent);
    }

    public void OpenExercises(View view) {
        Intent excercisesIntent = new Intent(MainActivity.this,Calculation.class);
        startActivity(excercisesIntent);
    }
}