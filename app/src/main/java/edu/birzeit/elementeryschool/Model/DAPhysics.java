package edu.birzeit.elementeryschool.Model;

import java.util.ArrayList;
import java.util.List;

public class DAPhysics {
    ArrayList<Physics> questions = new ArrayList<>();

    public DAPhysics(){
        //Type Questions
        questions.add(new TypeQuestions("What does the slope of a line in a position time graph represent?",5,
                "Failure is the opportunity to begin again more intelligently.","Displacement of the object",
                "Average Velocity"));
        questions.add(new TypeQuestions("What are the differences between distance and displacement?",5,
                "Success does not come to you, you go to it.","Scalar and Vector","Distance is a SCALAR while" +
                "Displacement is a VECTOR"));
        questions.add(new TypeQuestions("What is divided by time when calculating the average speed of an object?",5,
                "All happiness depends on courage and work","long way",
                "Distance"));
        questions.add(new TypeQuestions("What describes a uniform motion?",5,
                "There are no traffic jams on the extra mile.","same  distance is traveled during each time interval",
                "Constant Velocity"));
        questions.add(new TypeQuestions("What gives the values required to calculate the time taken to travel a certain distance?",5,
                "There is no substitute for hard work","velocity is displacement over time",
                "Displacement and Velocity"));
        questions.add(new TypeQuestions("What is the definition of displacement?",15,
                "The best way to predict your future is to create it","Sorry Nothing this time:)",
                "A vector quantity that describes the straight line distance between two points"));

        questions.add(new TypeQuestions("What is needed to calculate the average velocity of an object?",10,
                "The best way to predict your future is to create it","Sorry :)",
                "Displacement and Time"));

        //Calculation question

        questions.add(new CalculateQuestions("What is the initial velocity of an object that falls from rest from a tree?",
                10,"Failure is the opportunity to begin again more intelligently.",
                "to reach a hundred you have to start from zero",0));

        questions.add(new CalculateQuestions("What is the acceleration of a car that maintains a constant velocity of 100 km/hr for 10 secs?",
                10,"The journey is the reward.",
                "Remember that acceleration is the rate of change of velocity",0));

        questions.add(new CalculateQuestions("Ten seconds after starting from rest, an object falling freely downward on Earth will have a speed of about",
                10,"By perseverance, the snail reached the ark.",
                "Use the kinematic equation v = gt",100));

        questions.add(new CalculateQuestions("The average speed of a horse that gallops a distance of 10 km/hr in a time of 1 hour is ",
                10,"Procrastination is the thief of time.",
                "average speed is equal to the total distance traveled divided by the time ",10));

        questions.add(new CalculateQuestions("If a car increases its velocity from 0 to 60 km/hr in 10 seconds, its acceleration is ",
                10,"Procrastination is the thief of time.",
                "No hint :)",6));
    }

    public List<Physics> getQuestionsByType(String type){
        List<Physics> questionsToShow = new ArrayList<>();
        for (Physics p: questions){
            if(p instanceof CalculateQuestions && type.equals("calculation Question")){
                questionsToShow.add(p);
            } else if (p instanceof TypeQuestions && type.equals("type Question")) {
                questionsToShow.add(p);
            }
        }
        return  questionsToShow;
    }

    public String[] getCatagories(){
        String[] catagories = {"calculation Question" ,"type Question"};
        return catagories;
    }
}
