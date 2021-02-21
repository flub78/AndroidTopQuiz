package flub78.org.topquiz.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

import flub78.org.topquiz.R;
import flub78.org.topquiz.model.Question;
import flub78.org.topquiz.model.QuestionBank;

/**
 * Activity to ask questions and manage the answer
 */
public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mQuestionText;
    private Button mAnswerButton1;
    private Button mAnswerButton2;
    private Button mAnswerButton3;
    private Button mAnswerButton4;

    private QuestionBank mQuestionBank;
    private Question mCurrentQuestion;
    private int mNumberOfQuestions;

    private int mScore;
    public static final String BUNDLE_EXTRA_SCORE = "BUNDLE_EXTRA_SCORE";

    boolean mEnableTouchEvents = true;

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
        this.displayQuestion(mCurrentQuestion);
        mNumberOfQuestions = 4;
        mScore = 0;

        // Use the same listener for the four buttons.
        // The tag value will be used to distinguish the button triggered
        mAnswerButton1.setOnClickListener(this);
        mAnswerButton2.setOnClickListener(this);
        mAnswerButton3.setOnClickListener(this);
        mAnswerButton4.setOnClickListener(this);
    }

    /**
     * Called when an answer button has been clicked.
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
            Toast.makeText(getApplicationContext(),"Wrong answer", Toast.LENGTH_SHORT).show();
        }

        mEnableTouchEvents = false;

        // memory leak below
        // https://www.androiddesignpatterns.com/2013/01/inner-class-handler-memory-leak.html
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mEnableTouchEvents = true;

                // If this is the last question, ends the game.
                // Else, display the next question.
                if (--mNumberOfQuestions == 0) {
                    // End the game
                    endGame();
                } else {
                    mCurrentQuestion = mQuestionBank.getQuestion();
                    displayQuestion(mCurrentQuestion);
                }
            }
        }, 2000); // LENGTH_SHORT is usually 2 second long
    }

    /**
     * Disable screen during display of the toast message
     * @param ev
     * @return
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return mEnableTouchEvents && super.dispatchTouchEvent(ev);
    }

    private void endGame() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Well done!")
                .setMessage("Your score is " + mScore)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // End the activity
                        Intent intent = new Intent();
                        intent.putExtra(BUNDLE_EXTRA_SCORE, mScore);
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                })
                .setCancelable(false)
                .create()
                .show();
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

            Question question4 = new Question("When did the first man land on the moon?",
                    Arrays.asList("1958", "1962", "1967", "1969"),
                    3);

            Question question5 = new Question("What is the capital of Romania?",
                    Arrays.asList("Bucarest", "Warsaw", "Budapest", "Berlin"),
                    0);

            Question question6 = new Question("Who did the Mona Lisa paint?",
                    Arrays.asList("Michelangelo", "Leonardo Da Vinci", "Raphael", "Carravagio"),
                    1);

            Question question7 = new Question("In which city is the composer Frédéric Chopin buried?",
                    Arrays.asList("Strasbourg", "Warsaw", "Paris", "Moscow"),
                    2);

            Question question8 = new Question("What is the country top-level domain of Belgium?",
                    Arrays.asList(".bg", ".bm", ".bl", ".be"),
                    3);

            Question question9 = new Question("What is the house number of The Simpsons?",
                    Arrays.asList("42", "101", "666", "742"),
                    3);

            System.out.println("Returning a non empty question bank");
            return new QuestionBank(Arrays.asList(question1,
                    question2,
                    question3, question4, question5, question6, question7, question8, question9));

        } catch (Exception e) {
            // TODO: replace by an error dialog box
            System.out.println("Bug: please contact the developer with reference 142");
            e.printStackTrace();
        }
        return null;
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
        mAnswerButton4.setText(question.getChoiceList().get(3));

        // Use the tag property to 'name' the buttons
        mAnswerButton1.setTag(0);
        mAnswerButton2.setTag(1);
        mAnswerButton3.setTag(2);
        mAnswerButton4.setTag(3);
    }

}