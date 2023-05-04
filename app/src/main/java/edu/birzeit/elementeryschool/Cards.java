package edu.birzeit.elementeryschool;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import edu.birzeit.elementeryschool.Model.DAPhysics;
import edu.birzeit.elementeryschool.Model.Physics;
import edu.birzeit.elementeryschool.Model.TypeQuestions;

public class Cards extends AppCompatActivity {
    private TextView text;
    private DAPhysics dataAccess = new DAPhysics();
    private List<Physics> questions;
    private int questionNo =0;
    private  TextView motivation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards);
        text = findViewById(R.id.info_text);
        motivation = findViewById(R.id.motivation);
        questions = dataAccess.getQuestionsByType("type Question");

    }

    public void ChangeCard(View view) {
        if(questionNo < questions.size()) {
            TypeQuestions tq = (TypeQuestions) questions.get(questionNo++);
            text.setText(tq.toString());
            motivation.setText(tq.getEncouraging_phrase());
        }else{
            questionNo =0;
        }
    }
}