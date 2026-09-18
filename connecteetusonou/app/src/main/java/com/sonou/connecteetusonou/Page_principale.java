package com.sonou.connecteetusonou;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Page_principale extends AppCompatActivity {
    
    private MaterialButton btnaddproducts;
    private TextInputEditText nom, ref, prix, qte;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_page_principale);
        
        nom = findViewById(R.id.Nom);
        ref = findViewById(R.id.ref);
        prix = findViewById(R.id.prix);
        qte = findViewById(R.id.qte);
        btnaddproducts = findViewById(R.id.btnaddproducts);

        btnaddproducts.setOnClickListener(view -> add());
    }

    private void add() {

        String nomStr = nom.getText().toString().trim();
        String refStr = ref.getText().toString().trim();
        String prixStr = prix.getText().toString().trim();
        String qteStr = qte.getText().toString().trim();


        Retrofitcli.executionretrofit().addproduits(nomStr , refStr, prixStr , qteStr).enqueue(new Callback<Modaddproduits>() {
            @Override
            public void onResponse(Call<Modaddproduits> call, Response<Modaddproduits> response) {

                if (response.isSuccessful()){
                    Toast.makeText(Page_principale.this,  "Ajout reussie", Toast.LENGTH_SHORT).show();
                    Intent intent= new Intent(Page_principale.this , produits.class);
                    startActivity(intent);

                }else {
                    Toast.makeText(Page_principale.this,  "Erreur" + response.code(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<Modaddproduits> call, Throwable t) {
                Toast.makeText(Page_principale.this, "Erreur réseau : " + t.getMessage(), Toast.LENGTH_SHORT).show();


            }
        });



    }
}
