package com.example.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Spiel extends AppCompatActivity {

    Button btnAntwortEins, btnAntwortZwei, btnAntwortDrei, btnAntwortVier;
    TextView tVAnzeigeFrage, tVScore;
    int aktuelleFrage = 0;
    int punkte = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spiel);
        
        btnAntwortEins = (Button) findViewById(R.id.btnAntwortEins);
        btnAntwortZwei = (Button) findViewById(R.id.btnAntwortZwei);
        btnAntwortDrei = (Button) findViewById(R.id.btnAntwortDrei);
        btnAntwortVier = (Button) findViewById(R.id.btnAntwortVier);

        tVAnzeigeFrage = (TextView) findViewById(R.id.tVAnzeigeFrage);
        tVScore = (TextView) findViewById(R.id.tVScore);

        btnAntwortEins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnAntwortPressed(view);
            }
        });
        btnAntwortZwei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnAntwortPressed(view);
            }
        });
        btnAntwortDrei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnAntwortPressed(view);
            }
        });
        btnAntwortVier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnAntwortPressed(view);
            }
        });

        frageLaden();
    }

    private void frageLaden() {
        Fragen fragenC = new Fragen();
        ArrayList<String[]> fragen = fragenC.getFragen();
        String[] frage = fragen.get(aktuelleFrage);

        tVAnzeigeFrage.setText(frage[0]);

        int zufallszahl = (int) (Math.random() * (4-1) + 1);

        switch (zufallszahl) {
            case 1:
                btnAntwortEins.setText(frage[1]);
                btnAntwortZwei.setText(frage[2]);
                btnAntwortDrei.setText(frage[3]);
                btnAntwortVier.setText(frage[4]);
                break;
            case 2:
                btnAntwortEins.setText(frage[4]);
                btnAntwortZwei.setText(frage[1]);
                btnAntwortDrei.setText(frage[2]);
                btnAntwortVier.setText(frage[3]);
                break;
            case 3:
                btnAntwortEins.setText(frage[3]);
                btnAntwortZwei.setText(frage[4]);
                btnAntwortDrei.setText(frage[1]);
                btnAntwortVier.setText(frage[2]);
                break;
            case 4:
                btnAntwortEins.setText(frage[2]);
                btnAntwortZwei.setText(frage[3]);
                btnAntwortDrei.setText(frage[4]);
                btnAntwortVier.setText(frage[1]);
                break;
        }
        tVScore.setText("Punkte: " + punkte);
    }

    private void btnAntwortPressed(View view) {
        switch (view.getId()){
            case R.id.btnAntwortEins:
                if(fragenAuswerten(btnAntwortEins.getText().toString())){
                    punkte++;
                }
                if (aktuelleFrage >= 1) {
                    Intent intent = new Intent(this, Ende.class);
                    intent.putExtra("Punkte", punkte);
                    startActivity(intent);
                } else {
                    aktuelleFrage++;
                    frageLaden();
                }
                break;
            case R.id.btnAntwortZwei:
                if(fragenAuswerten(btnAntwortZwei.getText().toString())){
                    punkte++;
                }
                if (aktuelleFrage >= 1) {
                    Intent intent = new Intent(this, Ende.class);
                    intent.putExtra("Punkte", punkte);
                    startActivity(intent);
                } else {
                    aktuelleFrage++;
                    frageLaden();
                }
                break;
            case R.id.btnAntwortDrei:
                if(fragenAuswerten(btnAntwortDrei.getText().toString())){
                    punkte++;
                }
                if (aktuelleFrage >= 1) {
                    Intent intent = new Intent(this, Ende.class);
                    intent.putExtra("Punkte", punkte);
                    startActivity(intent);
                } else {
                    aktuelleFrage++;
                    frageLaden();
                }
                break;
            case R.id.btnAntwortVier:
                if(fragenAuswerten(btnAntwortVier.getText().toString())){
                    punkte++;
                }
                if (aktuelleFrage >= 1) {
                    Intent intent = new Intent(this, Ende.class);
                    intent.putExtra("Punkte", punkte);
                    startActivity(intent);
                } else {
                    aktuelleFrage++;
                    frageLaden();
                }
                break;
        }
    }

    private boolean fragenAuswerten(String btnText) {
        boolean frage = false;
        Fragen fragenC = new Fragen();
        ArrayList<String[]> fragen = fragenC.getFragen();
        String[] speicher = fragen.get(aktuelleFrage);
        if (speicher[1].equals(btnText)) {
            frage = true;
        }
        return frage;
    }
}
