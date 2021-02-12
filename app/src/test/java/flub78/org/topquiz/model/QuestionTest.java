package flub78.org.topquiz.model;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by <VOTRE-NOM> on <DATE-DU-JOUR>.
 */
public class QuestionTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void inccorect_question_raise_an_exception () {

        boolean exceptionRaised = false;

        try {
            Question question1 = new Question("Who is the creator of Android?",
                    Arrays.asList("Andy Rubin",
                            "Steve Wozniak",
                            "Jake Wharton",
                            "Paul Smith"),
                    12);

            System.out.println("This code is never reached");
        } catch (Exception e) {
            exceptionRaised = true;
            // e.printStackTrace();
        }
        Assert.assertTrue("Exception caught", exceptionRaised);
    }
}