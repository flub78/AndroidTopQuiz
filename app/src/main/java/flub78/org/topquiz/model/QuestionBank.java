package flub78.org.topquiz.model;

import java.util.Collections;
import java.util.List;

/**
 * Model for a set of questions
 */
public class QuestionBank {
    private List<Question> mQuestionList;
    private int mNextQuestionIndex = 0;

    public QuestionBank(List<Question> questionList) {
        // Shuffle the question list before storing it
        mQuestionList = questionList;
        Collections.shuffle(mQuestionList);
    }

    public Question getQuestion() {
        // Loop over the questions and return a new one at each call
        mNextQuestionIndex = (mNextQuestionIndex + 1) % mQuestionList.size();
        return mQuestionList.get(mNextQuestionIndex);
    }
}