package com.sambinelli.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool, editPrecoGasolina;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool= findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina= findViewById(R.id.editPrecoGasolina);
        txtResultado = findViewById(R.id.txtResultado);

    }

    public void calcularPreco (View view){

        String precoAlcool =editPrecoAlcool.getText().toString();
        String precoGasolina =editPrecoGasolina.getText().toString();

        Boolean camposValidados = validarCampos(precoAlcool, precoGasolina);

        if (camposValidados) {
            Double valorAlcool = Double.parseDouble(precoAlcool);
            Double valorGasolina = Double.parseDouble(precoGasolina);
            Double resultado = valorAlcool/valorGasolina;

            // considerando 70%
            if (resultado >= 0.7) {
                txtResultado.setText("Melhor usar Gasolina!");
            }
            else {
                txtResultado.setText("Melhor usar Álcool!");
            }

        }
        else {
            txtResultado.setText("Preencha os preços primeiro!");
        }

    }

    public Boolean validarCampos (String pAlcool, String pGasolina){
        Boolean camposvalidados = true;

        if (pAlcool==null || pGasolina==null || pAlcool.equals("") || pGasolina.equals("")){
            camposvalidados = false;
        }

        return camposvalidados;

    }
}
