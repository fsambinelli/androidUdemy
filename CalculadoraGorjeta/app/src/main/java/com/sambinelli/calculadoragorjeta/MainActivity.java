package com.sambinelli.calculadoragorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextView percGorjeta, totalGorjeta, totalPagar;
    private EditText totalConta;
    private SeekBar seekBarGorjeta;

    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        percGorjeta = findViewById(R.id.textPercGorjeta);
        totalGorjeta = findViewById(R.id.textGorjeta);
        totalPagar = findViewById(R.id.textTotal);
        totalConta = findViewById(R.id.textValorConta);
        seekBarGorjeta = findViewById(R.id.seekBarGorjeta);

        seekBarGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                porcentagem = progress;
                percGorjeta.setText(Math.round(porcentagem) + " %");
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



    }

    public void calcular (){
        String valorRecuperado = totalConta.getText().toString();
        if (valorRecuperado == null || valorRecuperado.equals("")){
            Toast.makeText(getApplicationContext(), "Digite o valor primeiro", Toast.LENGTH_SHORT).show();
        }
        else {
            double valorDigitado = Double.parseDouble(valorRecuperado);
            double gorjeta = valorDigitado * (porcentagem/100);
            double total = valorDigitado + gorjeta;
            totalGorjeta.setText("R$ "+ gorjeta);
            totalPagar.setText("R$ "+ total);
        }
    }


}
