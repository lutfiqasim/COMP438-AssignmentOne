package edu.birzeit.elementeryschool;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;
import java.util.Random;

import edu.birzeit.elementeryschool.Model.CalculateQuestions;
import edu.birzeit.elementeryschool.Model.DAPhysics;
import edu.birzeit.elementeryschool.Model.Physics;
import edu.birzeit.elementeryschool.Model.TypeQuestions;

public class Calculation extends AppCompatActivity {
    RecyclerView recyclerView;
    private DAPhysics dataAccess = new DAPhysics();

    private int userScore = 0;

    private int questionNumber = 0;
    private int questionShown = 0;
    public static int currentPos;
    private List<CalculateQuestions> questions;
    CalculationAdapters adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation);
        SharedPreferences sharedPreferences = getSharedPreferences("SchoolSystem", Context.MODE_PRIVATE);
        String q = sharedPreferences.getString("calculationQuestion", "");
        Gson gson = new Gson();
        questions = gson.fromJson(q, new TypeToken<List<CalculateQuestions>>() {
        }.getType());
//        Physics[] questions = dataAccess.getQuestionsByType("calculation Question").toArray(new Physics[0]);
        recyclerView = findViewById(R.id.calculationrecycler);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        adapter = new CalculationAdapter(questions, 0);
        adapter = new CalculationAdapters(getApplicationContext(), questions.toArray(new Physics[0]), 0);
        recyclerView.setAdapter(adapter);
        Button nextButton = findViewById(R.id.nextButton);


        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPos = adapter.getItemCount();// Get the current position
                System.out.println(currentPos);
                questionShown += currentPos;
                if (questionShown < questions.size()) {
                    adapter = new CalculationAdapters(getApplicationContext(), questions.toArray(new Physics[0]), currentPos); // Create a new adapter with the updated start position
                    recyclerView.setAdapter(adapter); // Set the new adapter
                } else {
                    showScore();
                }
            }
        });
    }

    private void showScore() {
        Intent intent = new Intent(Calculation.this, CalculationFinalScreen.class);
        if (CalculationAdapters.userScore > 20)
            intent.putExtra("Score", "Congratulations\nYour score is " + CalculationAdapters.userScore);
        else
            intent.putExtra("Score", "Try harder next time\nYour score is " + CalculationAdapters.userScore);
        CalculationAdapters.userScore = 0;
        startActivity(intent);
        finish();
    }

}