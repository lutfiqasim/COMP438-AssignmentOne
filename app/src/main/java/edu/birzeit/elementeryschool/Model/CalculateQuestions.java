package edu.birzeit.elementeryschool.Model;

public class CalculateQuestions extends Physics{

    private int answer;

    public CalculateQuestions(String context, int score, String encouraging_phrase,String hint,int answer) {
        super(context, score, encouraging_phrase,hint);
        this.answer = answer;
    }

    public double getAnswer() {
        return answer;
    }
    @Override
    public String give_Encouraging_phrase() {
        return super.getEncouraging_phrase();
    }

    @Override
    public String giveHint() {
        return  super.getHint();
    }

}
