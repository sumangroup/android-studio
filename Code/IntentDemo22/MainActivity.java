package com.example.intentdemo2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edtUname,edtPassword;
    Button btnSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        edtUname=findViewById(R.id.edtUname);
        edtPassword=findViewById(R.id.edtPassword);
        btnSubmit=findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String username=edtUname.getText().toString();
                        String password=edtPassword.getText().toString();

                        Intent myIntent=new Intent(MainActivity.this, MainActivity2.class);
                        myIntent.putExtra("username",username);
                        myIntent.putExtra("password",password);
                        startActivity(myIntent);
                    }
                }
        );
    }
}