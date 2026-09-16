package com.sonou.connecteetusonou;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class form_inscription extends AppCompatActivity {

    private MaterialButton btnconnexion ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_form_inscription);

        btnconnexion= findViewById(R.id.btnconnexion);

        btnconnexion.setOnClickListener(View ->{
            Intent itent = new Intent(form_inscription.this , MainActivity.class);
            startActivity(itent);
            finish();
        });

    }
}