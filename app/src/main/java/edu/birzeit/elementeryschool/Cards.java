package edu.birzeit.elementeryschool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.birzeit.elementeryschool.Model.DAPhysics;
import edu.birzeit.elementeryschool.Model.Physics;
import edu.birzeit.elementeryschool.Model.TypeQuestions;

public class Cards extends AppCompatActivity {
    private TextView text;
    private DAPhysics dataAccess = new DAPhysics();
    private List<TypeQuestions> questions;
    private int questionNo = 0;
    private TextView motivation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards);
        text = findViewById(R.id.info_text);
        motivation = findViewById(R.id.motivation);
        SharedPreferences sharedPreferences = getSharedPreferences("SchoolSystem", Context.MODE_PRIVATE);
        String q = sharedPreferences.getString("typeQuestions", "");
        Gson gson = new Gson();
        questions = gson.fromJson(q, new TypeToken<List<TypeQuestions>>() {
        }.getType());
    }

    public void ChangeCard(View view) {
        if (questionNo < questions.size()) {
            TypeQuestions tq = (TypeQuestions) questions.get(questionNo++);
            text.setText(tq.toString());
            motivation.setText(tq.getEncouraging_phrase());
        } else {
            text.setText(R.string.finalCardText);
            questionNo = 0;
        }
    }
}