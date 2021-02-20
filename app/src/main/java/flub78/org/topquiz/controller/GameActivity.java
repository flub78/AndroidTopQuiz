package flub78.org.topquiz.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

import flub78.org.topquiz.R;
import flub78.org.topquiz.model.Question;
import flub78.org.topquiz.model.QuestionBank;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mQuestionText;
    private Button mAnswerButton1;
    private Button mAnswerButton2;
    private Button mAnswerButton3;
    private Button mAnswerButton4;

    private QuestionBank mQuestionBank = this.initalizeQB();
    private Question mCurrentQuestion = mQuestionBank.getQuestion();

    private int mScore;
    private int mNumberOfQuestions;

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {

        int responseIndex = (int) v.getTag();

        if (responseIndex == mCurrentQuestion.getAnswerIndex()) {
            Toast.makeText(getApplicationContext(),"Correct", Toast.LENGTH_SHORT).show();
            mScore++;
        } else {
            Toast.makeText(getApplicationContext(),"Correct", Toast.LENGTH_SHORT).show();
        }
    }


    /**
     * Initialize and
     * @return a QuestionBank
     */
    private QuestionBank initalizeQB() {
        Question question1;
        try {
            question1 = new Question("Who is the creator of Android?",
                    Arrays.asList("Andy Rubin",
                            "Steve Wozniak",
                            "Jake Wharton",
                            "Paul Smith"),
                    0);

            Question question2 = new Question("When did the first man land on the moon?",
                    Arrays.asList("1958",
                            "1962",
                            "1967",
                            "1969"),
                    3);

            Question question3 = new Question("What is the house number of The Simpsons?",
                    Arrays.asList("42",
                            "101",
                            "666",
                            "742"),
                    3);

            System.out.println("Returning a non empty question bank");
            return new QuestionBank(Arrays.asList(question1,
                    question2,
                    question3));

        } catch (Exception e) {
            // TODO: replace by an error dialog box
            System.out.println("Bug: please contact the developer with reference 142");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Activity onCreate method
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        System.out.println("GameActivity::onCreate()");

        mQuestionText = findViewById(R.id.activity_game_question_text);
        mAnswerButton1 = findViewById(R.id.activity_game_answer1_btn);
        mAnswerButton2 = findViewById(R.id.activity_game_answer2_btn);
        mAnswerButton3 = findViewById(R.id.activity_game_answer3_btn);
        mAnswerButton4 = findViewById(R.id.activity_game_answer4_btn);

        mQuestionBank = this.initalizeQB();
        mCurrentQuestion = mQuestionBank.getQuestion();


        // Use the same listener for the four buttons.
        // The tag value will be used to distinguish the button triggered
        mAnswerButton1.setOnClickListener(this);
        mAnswerButton2.setOnClickListener(this);
        mAnswerButton3.setOnClickListener(this);
        mAnswerButton1.setOnClickListener(this);
    }

    /**
     * Set the text for the question text view and the four buttons
     * @param question
     */
    private void displayQuestion(final Question question) {
        mQuestionText.setText(question.getQuestion());

        mAnswerButton1.setText(question.getChoiceList().get(0));
        mAnswerButton2.setText(question.getChoiceList().get(1));
        mAnswerButton3.setText(question.getChoiceList().get(2));
        mAnswerButton4.setText(question.getChoiceList().get(4));

        // Use the tag property to 'name' the buttons
        mAnswerButton1.setTag(0);
        mAnswerButton2.setTag(1);
        mAnswerButton3.setTag(2);
        mAnswerButton4.setTag(3);
    }

}