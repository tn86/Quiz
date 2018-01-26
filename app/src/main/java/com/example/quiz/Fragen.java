package com.example.quiz;

import java.util.ArrayList;

/**
 * Created by T on 26.01.2018.
 */

public class Fragen {

    ArrayList<String[]> fragen;

    public Fragen() {
        fragen = new ArrayList<>(2);

        listeFuellen();
    }

    private void listeFuellen() {
        String[] frage1 = new String[5];
        frage1[0] = "Was ist Java?";
        frage1[1] = "Objektorientierte Programmiersprache";
        frage1[2] = "Kaffeesorte";
        frage1[3] = "EU-Mitgliedsstaat";
        frage1[4] = "Fluggesellschaft";

        String[] frage2 = new String[5];
        frage2[0] = "Mit welcher Programmiersprache arbeitet Android Studio?";
        frage2[1] = "Java";
        frage2[2] = "C#";
        frage2[3] = "Python";
        frage2[4] = "Swift";

        fragen.add(0, frage1);
        fragen.add(1, frage2);
    }

    public ArrayList<String[]> getFragen() {
        return fragen;
    }
}
