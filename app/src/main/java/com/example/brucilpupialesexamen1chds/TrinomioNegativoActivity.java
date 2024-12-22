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

public class TrinomioNegativoActivity extends AppCompatActivity {
    Button btnRequest, btnregresar;
    TextView txtVista, txtVista2;
    EditText etIngresoA, etIngresoB,etIngresoC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_trinomio_negativo);
        btnRequest = findViewById(R.id.btnCli);
        btnregresar = findViewById(R.id.btnVolver);
        txtVista = findViewById(R.id.txt_Cli);
        txtVista2 = findViewById(R.id.textView4);
        etIngresoA = findViewById(R.id.txtIngresoA);
        etIngresoB = findViewById(R.id.txtIngresoB);
        etIngresoC = findViewById(R.id.txtIngresoC);
        btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String A = etIngresoA.getText().toString().trim();
                String B = etIngresoB.getText().toString().trim();
                String C = etIngresoC.getText().toString().trim();
                if (A.isEmpty() || B.isEmpty()|| C.isEmpty()) {
                    Toast.makeText(TrinomioNegativoActivity.this, "Por favor, ingrese los dos valores (lado y apotema)", Toast.LENGTH_SHORT).show();
                } else {
                    String url = "http://192.168.10.110:3002/trinomioN/" + A + "/" + B + "/"+C;


                    obtenerServicioWeb(url);
                }
            }
        });

        btnregresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TrinomioNegativoActivity.this, MenuActivity.class);
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
