package com.sonou.connecteetusonou;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class produits extends AppCompatActivity {

    private MaterialButton btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_produits);

        btn = findViewById(R.id.btnadd);

        btn.setOnClickListener(view ->{
            Intent intent = new Intent(produits.this , Page_principale.class);
            startActivity(intent);
        });

    }
}