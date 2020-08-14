package com.sambinelli.sorteio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int total1 = 0;
    int total2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void alterarTexto (View v){
        TextView texto =  findViewById(R.id.lblSorteado);
        int sorteado = new Random().nextInt(11);
        texto.setText("Sorteado: " + sorteado);

    }

    public void incrementarJogador1(View v){
        TextView texto =  findViewById(R.id.lblJog1);
        total1++;
        texto.setText(total1+ " Pontos");

    }

    public void incrementarJogador2(View v){
        TextView texto =  findViewById(R.id.lblJog2);
        total2++;
        texto.setText(total2+ " Pontos");

    }

    public void novoJogo(View v){
        TextView texto1 =  findViewById(R.id.lblJog1);
        TextView texto2 =  findViewById(R.id.lblJog2);
        TextView textoSorteado =  findViewById(R.id.lblSorteado);
        total1=0;
        total2=0;
        texto1.setText(total1+ " Pontos");
        texto2.setText(total2+ " Pontos");
        textoSorteado.setText("Nenhum número sorteado");
    }


}
