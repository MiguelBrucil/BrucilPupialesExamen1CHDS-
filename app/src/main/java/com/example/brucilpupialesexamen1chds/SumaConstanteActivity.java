package com.example.brucilpupialesexamen1chds;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class SumaConstanteActivity extends AppCompatActivity {
    Button btnRequest;
    TextView txtVista, txtVista2;
    EditText etIngreso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_suma_constante);
        btnRequest = findViewById(R.id.btnCli);
        txtVista = findViewById(R.id.txt_Cli);
        txtVista2 = findViewById(R.id.textView4);
        etIngreso = findViewById(R.id.tvtingreso);
        btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = etIngreso.getText().toString().trim(); // Obtener el valor del EditText

                // Validación del input
                if (input.isEmpty()) {
                    Toast.makeText(SumaConstanteActivity.this, "Por favor, ingrese un número", Toast.LENGTH_SHORT).show();
                } else {
                    // Construir la URL usando el número ingresado
                    String url = "http://192.168.10.114:3002/sumar/" + input;

                    // Llamada al método para obtener el servicio web
                    obtenerServicioWeb(url);
                }
            }
        });
    }

    private void obtenerServicioWeb(String URL) {
        // Creación de la petición GET
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Mostrar la respuesta en el TextView
                        txtVista.setText(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "Error: " + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });

        // Agregar la petición a la cola de Volley
        Volley.newRequestQueue(this).add(stringRequest);
    }
}