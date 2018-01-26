package com.example.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menue extends AppCompatActivity {

    Button btnSpielen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menue);

        btnSpielen = (Button) findViewById(R.id.btnSpielen);
        btnSpielen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnSpielenPressed();
            }
        });
    }

    private void btnSpielenPressed() {
        Intent intent = new Intent(this, Spiel.class);
        startActivity(intent);
    }

}
