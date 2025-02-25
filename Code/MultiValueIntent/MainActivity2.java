package com.example.multivalueintent;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    TextView txtname,txtphone,txtemail,txtpassword,txtgender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txtname=findViewById(R.id.txtname);
        txtphone=findViewById(R.id.txtphone);
        txtemail=findViewById(R.id.txtemail);
        txtpassword=findViewById(R.id.txtpassword);
        txtgender=findViewById(R.id.txtgender);

        Intent myintent=getIntent();
        String name=myintent.getStringExtra("name");

        String email=myintent.getStringExtra("email");
        String password=myintent.getStringExtra("password");
        String gender=myintent.getStringExtra("gender");
        String phone=myintent.getStringExtra("phone");

        txtname.setText(name);
        txtemail.setText(email);
        txtpassword.setText(password);
        txtgender.setText(gender);
        txtphone.setText(phone);

    }
}