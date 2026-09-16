package com.sonou.connecteetusonou;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText login , password;

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

        btn.setOnClickListener(view ->{
            String login_str = login.getText().toString();
            String pass = password.getText().toString();


            if  (login_str.isEmpty()){
                login.setError("veuillez entrez un login");
                login.requestFocus();
                return ;

            }

            if  (pass.isEmpty()){
                password.setError("veuillez entrez un password");
                password.requestFocus();
                return;

            }
            Toast.makeText(this, "Notre premier toast", Toast.LENGTH_SHORT).show();
        });

        btninscription.setOnClickListener(view ->{
            Intent intent = new Intent(MainActivity.this , form_inscription.class);
            startActivity(intent);
            finish();

        });


    }
}