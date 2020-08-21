package com.sambinelli.joquempow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static final int PEDRA = 0;
    public static final int PAPEL = 1;
    public static final int TESOURA = 2;
    public static final int[] opcoesJogo = {PEDRA, PAPEL, TESOURA};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view) {
        atualizaJogo(PEDRA);
    }

    public void selecionadoPapel(View view) {
        atualizaJogo(PAPEL);
    }

    public void selecionadoTesoura(View view) {
        atualizaJogo(TESOURA);
    }

    public void atualizaJogo(int opcaoJogador) {
        int opcaoApp = sortearOpcaoApp();
        atualizarImageOpcaoApp(opcaoApp);

        TextView textResultado = findViewById(R.id.textResultado);

        if (isEmpate(opcaoApp, opcaoJogador)) {
            textResultado.setText("Empatamos ;)");
        } else if (isAppGanhou(opcaoApp, opcaoJogador)) {
            textResultado.setText("Você perdeu :(");
        } else {
            textResultado.setText("Você ganhou :)");
        }

    }

    public int sortearOpcaoApp() {
        int numSorteadoApp = new Random().nextInt(3); // 0 1 2
        return opcoesJogo[numSorteadoApp];
    }

    public void atualizarImageOpcaoApp(int idImageSorteadaApp) {
        ImageView imageApp = findViewById(R.id.imageApp);
        switch (idImageSorteadaApp) {
            case PEDRA:
                imageApp.setImageResource(R.drawable.pedra);
                break;
            case PAPEL:
                imageApp.setImageResource(R.drawable.papel);
                break;
            case TESOURA:
                imageApp.setImageResource(R.drawable.tesoura);
                break;
        }
    }

    public boolean isEmpate(int opcaoApp, int opcaoJOgador) {
        return (opcaoApp == opcaoJOgador);
    }

    public boolean isAppGanhou(int opcaoApp, int opcaoJogador) {
        if ((opcaoApp == PEDRA && opcaoJogador == PAPEL ||
                (opcaoApp == PAPEL && opcaoJogador == TESOURA) ||
                (opcaoApp == TESOURA && opcaoJogador == PEDRA))) {
            return false;
        } else
            return true;

    }


}
