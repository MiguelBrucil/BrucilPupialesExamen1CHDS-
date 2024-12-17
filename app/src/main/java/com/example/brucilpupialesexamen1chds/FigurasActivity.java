package com.example.brucilpupialesexamen1chds;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FigurasActivity extends AppCompatActivity {
    Spinner spnFigura;
    EditText etParametro1;
    Button btnCalcular;
    TextView tvResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_figuras);
        spnFigura = findViewById(R.id.spnFigura);
        etParametro1 = findViewById(R.id.etParametro1);
        btnCalcular = findViewById(R.id.btnCalcular);
        tvResultado = findViewById(R.id.tvResultado);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String figura = spnFigura.getSelectedItem().toString().toLowerCase();
                String n1 = etParametro1.getText().toString();
                if (!n1.isEmpty()) {
                    // Crear la URL para el servicio web con los parámetros adecuados
                    String url = "http://192.168.10.114:3002/perimetro/" + figura + "/" + n1;
                    obtenerServicioWeb(url);
                } else {
                    tvResultado.setText("Por favor ingrese el valor del lado.");
                }
            }
        });
    }

    private void obtenerServicioWeb(String URL) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Mostrar la respuesta del servidor (que es el cálculo)
                        tvResultado.setText("Resultado:\n" + response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Mostrar un mensaje de error si la solicitud falla
                        Toast.makeText(getApplicationContext(), "Error: " + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });

        // Agregar la solicitud a la cola de Volley
        Volley.newRequestQueue(this).add(stringRequest);
    }
}