package edu.birzeit.elementeryschool;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CalculationFinalScreen extends AppCompatActivity {
    Button goBack;
    Button retry;
    TextView score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculationfinalscreen);
        String result = checkForData(savedInstanceState);
        goBack = findViewById(R.id.goBack);
        retry = findViewById(R.id.Retry);
        score = findViewById(R.id.score);
        score.setText(result);

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CalculationFinalScreen.this, MainActivity2.class);
                startActivity(intent);
                finish();
            }
        });

        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CalculationFinalScreen.this, Calculation.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public String checkForData(Bundle savedInstanceState) {
        Intent intent = getIntent();
        String s = intent.getStringExtra("Score");
        return s != null ? s : "You haven't answerd questions";
    }

}
