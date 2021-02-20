package flub78.org.topquiz.model;

import android.widget.Button;

import java.util.List;

/**
 * Created by <VOTRE-NOM> on <DATE-DU-JOUR>.
 */
public class User {

    // No constructor to initialize firstName, as it is only known when the user
    // enters his/her name

    // public interface
    public String getFirstNamme() {
        return mFirstNamme;
    }

    public void setFirstNamme(String firstNamme) {
        mFirstNamme = firstNamme;
    }

    // private part
    private String mFirstNamme;
}
