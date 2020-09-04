package com.sambinelli.caracoroa;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void chamarResultadoActivity(View v){

        Intent intent = new Intent(getApplicationContext(), ResultadoActivity.class);

        int random = new Random().nextInt(2);
        intent.putExtra("valorSorteado", random);

        startActivity(intent);

    }
}
