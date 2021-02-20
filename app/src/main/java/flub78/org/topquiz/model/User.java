package flub78.org.topquiz.model;

import android.widget.Button;

import java.util.List;

/**
 * Created by <VOTRE-NOM> on <DATE-DU-JOUR>.
 */
public class User {

    // public interface
    /**
    public User(String firstNamme) {

        mFirstNamme = firstNamme;
     }
     */

    public String getFirstNamme() {
        return mFirstNamme;
    }

    public void setFirstNamme(String firstNamme) {
        mFirstNamme = firstNamme;
    }

    // private part
    private String mFirstNamme;
}
