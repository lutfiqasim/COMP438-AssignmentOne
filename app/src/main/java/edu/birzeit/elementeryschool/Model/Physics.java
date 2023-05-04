package edu.birzeit.elementeryschool.Model;

public abstract class Physics {
    private String context;
    private int score;
    private String encouraging_phrase;
    private  String hint;
    public Physics(String context, int score, String encouraging_phrase,String hint) {
        this.context = context;
        this.score = score;
        this.encouraging_phrase = encouraging_phrase;
        this.hint = hint;
    }

    abstract public String give_Encouraging_phrase();
    abstract public String giveHint();

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getEncouraging_phrase() {
        return encouraging_phrase;
    }

    public void setEncouraging_phrase(String encouraging_phrase) {
        this.encouraging_phrase = encouraging_phrase;
    }
    public String getHint(){
        return hint;
    }
    public void setHint(String hint){
        this.hint = hint;
    }
}
