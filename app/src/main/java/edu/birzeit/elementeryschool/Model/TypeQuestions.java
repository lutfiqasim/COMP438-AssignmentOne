package edu.birzeit.elementeryschool.Model;

public class TypeQuestions extends Physics {
    private String answer;

    public TypeQuestions(String context, int score, String encouraging_phrase, String hint, String answer) {
        super(context, score, encouraging_phrase, hint);
        this.answer = answer;
    }

    @Override
    public String give_Encouraging_phrase() {
        return super.getEncouraging_phrase();
    }

    @Override
    public String giveHint() {
        return super.getHint();
    }

    @Override
    public String toString() {
        return super.getContext() + "\n\n" + "Answer: \n\n" + this.answer;
    }
}
