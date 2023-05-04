package edu.birzeit.elementeryschool;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Random;

import edu.birzeit.elementeryschool.Model.CalculateQuestions;
import edu.birzeit.elementeryschool.Model.DAPhysics;
import edu.birzeit.elementeryschool.Model.Physics;

public class Calculation extends AppCompatActivity {
    private TextView question;
    private Button btn;
    private ImageButton imgbtn;
    private RadioButton r1;
    private RadioButton r2;
    private RadioButton r3;
    private RadioButton r4;
    private  TextView motivation;
    private RadioGroup radiosGroup;
    private DAPhysics dataAccess = new DAPhysics();
    private CalculateQuestions currentQuestion;
    private int userScore =0;
    private  int questionNumber= 0;
    private List<Physics> questions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation);
        questions=dataAccess.getQuestionsByType("calculation Question");
        btn = (Button) findViewById(R.id.checkAnswer);
        imgbtn = (ImageButton) findViewById(R.id.imageButton);
        radiosGroup = (RadioGroup) findViewById(R.id.group1);
        r1 = (RadioButton) findViewById(R.id.choice1);
        r2 = (RadioButton) findViewById(R.id.choice2);
        r3 = (RadioButton) findViewById(R.id.choice3);
        r4 = (RadioButton) findViewById(R.id.choice4);
        question = (TextView)findViewById(R.id.question);
        motivation =(TextView) findViewById(R.id.motivation);
        goToNextQuestion();
    }

    public void CheckAnswer(View view) {
        boolean proceed =false;
        double userAns = Double.MAX_VALUE;
        try {
            int selectedId = radiosGroup.getCheckedRadioButtonId();
            RadioButton selected = findViewById(selectedId);
            userAns = Double.parseDouble(selected.getText().toString());
            radiosGroup.clearCheck();
        }catch (Exception e){
            if(btn.getText().equals("Try Again")){
                proceed=false;
            }else {
                proceed = true;
                Toast.makeText(getApplicationContext(), "Please Choose an answer", Toast.LENGTH_SHORT).show();
            }
        }
        if(!proceed) {
            if (userAns == currentQuestion.getAnswer() &&! btn.getText().equals("Try Again")) {
                userScore += currentQuestion.getScore();
                Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();

            } else if(btn.getText().equals("Try Again")) {

            }else{
                Toast.makeText(getApplicationContext(), "Wrong answer try again Next time", Toast.LENGTH_SHORT).show();
            }
            goToNextQuestion();

        }

    }

    public void ShowHint(View view) {
        Toast.makeText(getApplicationContext(),currentQuestion.getHint(),Toast.LENGTH_LONG).show();
    }
    private void goToNextQuestion(){
        btn.setText("Check Answer");

        imgbtn.setVisibility(View.VISIBLE);
        if(questionNumber <questions.size()) {
            radiosGroup.setVisibility(View.VISIBLE);
            currentQuestion = (CalculateQuestions) questions.get(questionNumber++);
            question.setText(currentQuestion.getContext());
            motivation.setText(currentQuestion.getEncouraging_phrase());
            Random rand = new Random();
            int[] random = new int[4];
            int x = questions.size();
            for(int i =0;i<random.length;i++) {
                int qNum = rand.nextInt(100);
                random[i] = qNum;
            }
            r1.setText(random[0]+"");
            r2.setText(random[1]+"");
            r3.setText(currentQuestion.getAnswer() + "");
            r4.setText(random[3]+"");

        }else{
            btn.setText("Try Again");
            imgbtn.setVisibility(View.GONE);
            questionNumber =0;
            radiosGroup.setVisibility(View.GONE);
            if(userScore>25)
                question.setText("Congratulations you have finished the test with score:"+userScore);
            else{
                question.setText("Try Harder next time you have finished the test with score:" +userScore);
            }
            userScore=0;
        }

    }
}