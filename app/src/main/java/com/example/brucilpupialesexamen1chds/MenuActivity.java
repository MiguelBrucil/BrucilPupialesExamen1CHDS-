package com.example.brucilpupialesexamen1chds;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MenuActivity extends AppCompatActivity {
    Button btnDatos, btnLista, btnSuma, btnSuma3, btnFiguras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu);
        btnDatos = findViewById(R.id.btnDatos);
        btnLista = findViewById(R.id.btnLista);
        btnSuma = findViewById(R.id.btnSuma);
        btnSuma3 = findViewById(R.id.btnSuma3);
        btnFiguras = findViewById(R.id.btnFiguras);
        btnDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, BibliografiaActivity.class);
                startActivity(intent);
            }
        });

        btnLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, SumaConstanteActivity.class);
                startActivity(intent);
            }
        });

        btnSuma3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, SumaActivity.class);
                startActivity(intent);
            }
        });

        btnFiguras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, CuadradoActivity.class);
                startActivity(intent);
            }
        });
    }
}
