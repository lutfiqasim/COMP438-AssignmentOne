//package edu.birzeit.elementeryschool.Model;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.ImageButton;
//import android.widget.RadioButton;
//import android.widget.RadioGroup;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.cardview.widget.CardView;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.List;
//import java.util.Random;
//
//import edu.birzeit.elementeryschool.R;
//
//public class CalculationAdapter extends RecyclerView.Adapter<CalculationAdapter.ViewHolder> {
//
//    private Physics[] questions;
//    private CalculateQuestions currentQuestion;
//    private int startPosition;
//    private Button btn;
//    private ImageButton imgbtn;
//    private TextView motivation;
//    private RadioGroup radiosGroup;
//    public static int userScore = 0;
//
//
//    public CalculationAdapter(Physics[] questions, int startPosition) {
//        this.questions = questions;
//        this.startPosition = startPosition;
//    }
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_calculation, parent, false);
//        return new ViewHolder(cv);
//    }
//    //Add functionality to buttons and clicks
//    //Add a counter to count score
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        CardView cardView = holder.cardView;
//        int realPosition = startPosition + position;
//        TextView textView = (TextView) cardView.findViewById(R.id.question);
//        imgbtn = (ImageButton) holder.cardView.findViewById(R.id.imageButton);
//        btn = (Button) cardView.findViewById(R.id.checkAnswer);
//        if (realPosition < questions.length) {
//            imgbtn.setVisibility(View.VISIBLE);
//            CalculateQuestions currentQuestion = (CalculateQuestions) questions[realPosition];
//            textView.setText(currentQuestion.getContext());
//            radiosGroup = (RadioGroup) cardView.findViewById(R.id.group1);
//            RadioButton r1 = (RadioButton) cardView.findViewById(R.id.choice1);
//            RadioButton r2 = (RadioButton) cardView.findViewById(R.id.choice2);
//            RadioButton r3 = (RadioButton) cardView.findViewById(R.id.choice3);
//            RadioButton r4 = (RadioButton) cardView.findViewById(R.id.choice4);
////            question.setText(currentQuestion.getContext());
//            motivation = (TextView) cardView.findViewById(R.id.motivation);
//            motivation.setText(currentQuestion.getEncouraging_phrase());
//            // Set up click listeners for individual card views
//            imgbtn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Toast.makeText(holder.itemView.getContext(), currentQuestion.getHint(), Toast.LENGTH_LONG).show();
//                }
//            });
//            btn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    checkAnswer(cardView);
//                }
//            });
//            Random rand = new Random();
//            int[] random = new int[4];
//            int x = questions.length;
//            for (int i = 0; i < random.length; i++) {
//                int qNum = rand.nextInt(100);
//                random[i] = qNum;
//            }
//            r1.setText(random[0] + "");
//            r2.setText(random[1] + "");
//            r3.setText(currentQuestion.getAnswer() + "");
//            r4.setText(random[3] + "");
//        }
//
//    }
//
//    @Override
//    public int getItemCount() {
//        int remainingItems = questions.length - startPosition;
//        return Math.min(remainingItems, 3);
//    }
//
//    public static class ViewHolder extends RecyclerView.ViewHolder {
//        private CardView cardView;
//
//        public ViewHolder(CardView cardView) {
//            super(cardView);
//            this.cardView = cardView;
//        }
//
//
//    }
//
//    private void checkAnswer(CardView c) {
//        boolean proceed = false;
//        double userAns = Double.MAX_VALUE;
//        try {
//            int selectedId = radiosGroup.getCheckedRadioButtonId();
//            RadioButton selected = c.findViewById(selectedId);
//            userAns = Double.parseDouble(selected.getText().toString());
//            radiosGroup.clearCheck();
//        } catch (Exception e) {
//            if (btn.getText().equals("Try Again")) {
//                proceed = false;
//            } else {
//                proceed = true;
//                Toast.makeText(c.getContext(), "Please Choose an answer", Toast.LENGTH_SHORT).show();
//            }
//        }
//        if (!proceed) {
//            if (userAns == currentQuestion.getAnswer() && !btn.getText().equals("Try Again")) {
//                userScore += currentQuestion.getScore();
//                Toast.makeText(c.getContext(), "Correct", Toast.LENGTH_SHORT).show();
//
//            } else if (btn.getText().equals("Try Again")) {
//
//            } else {
//                Toast.makeText(c.getContext(), "Wrong answer try again Next time", Toast.LENGTH_SHORT).show();
//            }
//
//        }
//
//    }
//}
