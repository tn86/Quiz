package com.example.quiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Ende extends AppCompatActivity {

    Button btnStartseite;
    TextView tVHighscoreAnzeige;

    SharedPreferences preferences;
    SharedPreferences.Editor preferencesEditor;

    int erreichtePunkte;
    final String KEY = "speicherPreferences";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ende);

        btnStartseite = (Button) findViewById(R.id.btnStartseite);
        btnStartseite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Menue.class);
                startActivity(intent);
            }
        });

        tVHighscoreAnzeige = (TextView) findViewById(R.id.tVHighscoreAnzeige);

        preferences = this.getSharedPreferences("highscore", MODE_PRIVATE);
        preferencesEditor = preferences.edit();

        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            erreichtePunkte = 0;
        } else {
            erreichtePunkte = extras.getInt("Punkte");
        }

        punkteAnzeigen();
    }

    private void punkteAnzeigen() {
        if (preferences.getInt(KEY,0) < erreichtePunkte) {
            tVHighscoreAnzeige.setText("NEUER HIGHSCORE! Deine erreichten Punkte sind: " + erreichtePunkte);

            preferencesEditor.putInt(KEY, erreichtePunkte);

        } else {
            tVHighscoreAnzeige.setText("Deine erreichten Punkte sind " + erreichtePunkte);
        }
    }
}
