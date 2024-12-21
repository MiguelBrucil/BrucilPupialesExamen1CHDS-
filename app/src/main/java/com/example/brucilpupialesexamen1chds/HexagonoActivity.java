package com.example.brucilpupialesexamen1chds;

import android.content.Intent;
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

public class HexagonoActivity extends AppCompatActivity {
    Button btnRequest, btnregresar;
    TextView txtVista, txtVista2;
    EditText etIngreso, etApotema;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hexagono);
        btnRequest = findViewById(R.id.btnCli);
        btnregresar = findViewById(R.id.btnVolver);
        txtVista = findViewById(R.id.txt_Cli);
        txtVista2 = findViewById(R.id.textView4);
        etIngreso = findViewById(R.id.tvtingreso);
        etApotema = findViewById(R.id.txtApotema);
        btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lado = etIngreso.getText().toString().trim();
                String apotema = etApotema.getText().toString().trim();


                if (lado.isEmpty() || apotema.isEmpty()) {
                    Toast.makeText(HexagonoActivity.this, "Por favor, ingrese los dos valores (lado y apotema)", Toast.LENGTH_SHORT).show();
                } else {

                    String url = "http://192.168.137.145:3002/hexagono/" + lado + "/" + apotema;


                    obtenerServicioWeb(url);
                }
            }
        });

        btnregresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HexagonoActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });
    }

    private void obtenerServicioWeb(String URL) {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        txtVista.setText(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "Error: " + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });

        Volley.newRequestQueue(this).add(stringRequest);
    }
}