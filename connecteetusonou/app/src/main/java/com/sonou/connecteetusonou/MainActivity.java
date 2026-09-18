package com.sonou.connecteetusonou;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText login, password;
    private MaterialButton btn;
    private MaterialButton btninscription;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.login);
        password = findViewById(R.id.password);
        btn = findViewById(R.id.btnconnexion);
        btninscription = findViewById(R.id.btninscription);

        btn.setOnClickListener(view -> connexion());

        btninscription.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, form_inscription.class);
            startActivity(intent);
            // On ne fait pas finish() ici pour pouvoir revenir en arrière
        });
    }

    private void connexion() {
        // Correction : Utiliser des noms différents pour les variables locales
        // et utiliser getText().toString()
        String logText = login.getText().toString().trim();
        String passText = password.getText().toString().trim() ;

        if (logText.isEmpty() || passText.isEmpty()) {
            Toast.makeText(this, "Veuillez remplir les champs", Toast.LENGTH_SHORT).show();
            return;
        }

        Retrofitcli.executionretrofit().connexion(logText, passText).enqueue(new Callback<Modconnexion>() {
            @Override
            public void onResponse(Call<Modconnexion> call, Response<Modconnexion> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Connexion réussie", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor= getSharedPreferences("session" ,MODE_PRIVATE).edit();
                    editor.putString("login" , logText);
                    editor.apply();
                    Intent intent = new Intent(MainActivity.this , produits.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, "Échec identifiant incorrect: " + response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Modconnexion> call, Throwable t) {
                // Correction : Utiliser MainActivity.this au lieu de Modconnexion.this
                Toast.makeText(MainActivity.this, "Erreur réseau : " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
