package com.example.calculadoradeimc;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Calculo extends AppCompatActivity {
    EditText edtAltura, edtPeso;
    TextView textImc;
    TextView resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo);


        Button calcula;
        calcula = findViewById(R.id.btnCalcular);
        calcula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculaimc();
            }
        });
    }

    public void calculaimc() {

        double altura, altura2, peso, imc;

        try{
            edtAltura = findViewById(R.id.editAltura);
            edtPeso = findViewById(R.id.editPeso);
            textImc = findViewById(R.id.textImc);
            resultado = findViewById(R.id.textComplemento);

            altura = Double.parseDouble(edtAltura.getText().toString());
            peso = Double.parseDouble(edtPeso.getText().toString());

            altura2 = Math.pow(altura, 2);

            imc = peso / altura2;

            textImc.setText(String.format("%.1f", imc));

            if(imc < 18.5){
                resultado.setText("Você está Abaixo do peso.");
            }else if(imc >= 18.5 && imc <= 24.9){
                resultado.setText("Você está no Peso ideal.");
            }else if(imc >= 25 && imc <=29.9){
                resultado.setText("Você está com Pré-obesidade!");
            }else if(imc >= 30 && imc <= 34.9){
                resultado.setText("Você está com Obesidade Grau 1!");
            }else if(imc >= 35 && imc <=39.9){
                resultado.setText("Você está com Obesidade Grau 2!");
            }else if(imc > 40){
                resultado.setText("Você está com Obesidade Grau 3!");
            }
        }catch(Exception e){
            Toast.makeText(Calculo.this, "Preencha os dados!", Toast.LENGTH_LONG).show();
        }

    }



}


