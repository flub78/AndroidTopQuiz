package flub78.org.topquiz.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import flub78.org.topquiz.R;

public class GameActivity extends AppCompatActivity {

    private TextView mQuestionText;
    private Button mAnswer1Button;
    private Button mAnswer2Button;
    private Button mAnswer3Button;
    private Button mAnswer4Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mQuestionText = findViewById(R.id.activity_game_question_text);
        mAnswer1Button = findViewById(R.id.activity_game_answer1_btn);
        mAnswer2Button = findViewById(R.id.activity_game_answer2_btn);
        mAnswer3Button = findViewById(R.id.activity_game_answer3_btn);
        mAnswer4Button = findViewById(R.id.activity_game_answer4_btn);

    }
}