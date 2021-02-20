package flub78.org.topquiz.model;

import java.util.List;

/**
 * Created by flub78 on february 2021.
 */
public class Question {


    public Question(String question, List<String> choiceList, int answerIndex) throws Exception {

        if (choiceList.size() < 2)
            throw new Exception("At least two answers are required");

        if ((answerIndex < 0) || (answerIndex >= choiceList.size()))
            throw new Exception("Bad index for answer index");

        mQuestion = question;
        mChoiceList = choiceList;
        mAnswerIndex = answerIndex;
    }

    private String mQuestion;

    private List<String> mChoiceList;

    private int mAnswerIndex;

    public String getQuestion() {
        return mQuestion;
    }

    public List<String> getChoiceList() {
        return mChoiceList;
    }

    public int getAnswerIndex() {
        return mAnswerIndex;
    }
}
