package com.sonou.connecteetusonou;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class form_inscription extends AppCompatActivity {

    private TextInputEditText Nom, prenom, login, motpasse, cfrmmotpasse;
    private Spinner sex;
    private MaterialButton btninscription ,btnconnexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_inscription);

        Nom = findViewById(R.id.Nom);
        prenom = findViewById(R.id.prenom);
        login = findViewById(R.id.login);
        motpasse = findViewById(R.id.motpasse);
        cfrmmotpasse = findViewById(R.id.cfrmmotpasse);
        sex = findViewById(R.id.sex);
        btninscription = findViewById(R.id.btninscription);
        btnconnexion = findViewById(R.id.btnconnexion);

        btninscription.setOnClickListener(v -> inscriptionutilisateur());

        btnconnexion.setOnClickListener(view ->{
            Intent intent = new Intent(form_inscription.this , MainActivity.class);
            startActivity(intent);
            finish();
        });
    }

    private void inscriptionutilisateur() {
        String nom = Nom.getText().toString().trim();
        String pre = prenom.getText().toString().trim();
        String log = login.getText().toString().trim();
        String sxe = sex.getSelectedItem().toString();
        String pass = motpasse.getText().toString().trim();
        String confirm = cfrmmotpasse.getText().toString().trim();

        if (nom.isEmpty() || pre.isEmpty() || log.isEmpty() || pass.isEmpty()) {
            Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!pass.equals(confirm)) {
            cfrmmotpasse.setError("Mots de passe différents");
            return;
        }

        Retrofitcli.executionretrofit().inscription(nom, pre, log, sxe, pass,confirm).enqueue(new Callback<ModInscription>() {
            @Override
            public void onResponse(Call<ModInscription> call, Response<ModInscription> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(form_inscription.this,  "Inscription réussie", Toast.LENGTH_SHORT).show();
                    Intent intent= new Intent(form_inscription.this , MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(form_inscription.this, "Erreur : " + response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ModInscription> call, Throwable t) {
                Toast.makeText(form_inscription.this, "Erreur réseau : " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
