package edu.birzeit.elementeryschool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import java.util.List;

import edu.birzeit.elementeryschool.Model.DAPhysics;
import edu.birzeit.elementeryschool.Model.Physics;

public class MainActivity2 extends AppCompatActivity {
    private Button slideShow;
    private Button calculation;
    private List<Physics> typeQ;
    private List<Physics> calQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        slideShow = (Button) findViewById(R.id.slideShow);
        calculation = (Button) findViewById(R.id.calculation);
        DAPhysics questions = new DAPhysics();
        typeQ=questions.getQuestionsByType("type Question");
        calQ = questions.getQuestionsByType("calculation Question");
    }
    public void OpenSlideShow(View view) {
        Intent slideshowIntent = new Intent(MainActivity2.this, Cards.class);
        //Save data to sharedPreferences
        Gson gson = new Gson();
        String data = gson.toJson(typeQ);
        SharedPreferences sharedPreferences = this.getSharedPreferences("SchoolSystem", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("typeQuestions",data);
        editor.apply();
        startActivity(slideshowIntent);
    }

    public void OpenExercises(View view) {
        Intent excercisesIntent = new Intent(MainActivity2.this, Calculation.class);
        Gson gson  = new Gson();
        String data = gson.toJson(calQ);
        SharedPreferences sharedPreferences = this.getSharedPreferences("SchoolSystem",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("calculationQuestion",data);
        editor.apply();
        startActivity(excercisesIntent);
    }
}
