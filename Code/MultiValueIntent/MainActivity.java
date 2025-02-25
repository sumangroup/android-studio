package com.example.multivalueintent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edtname,edtphone,edtemail,edtpassword,edtcpassword;
    RadioGroup rdo1;
    RadioButton rbtn;
    Button btnsubmit;

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
        edtname=findViewById(R.id.edtname);
        edtphone=findViewById(R.id.edtphone);
        edtemail=findViewById(R.id.edtemail);
        edtpassword=findViewById(R.id.edtpassword);
        edtcpassword=findViewById(R.id.edtcpassword);
        rdo1=findViewById(R.id.rdo1);
        btnsubmit=findViewById(R.id.btnsubmit);

        btnsubmit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name=edtname.getText().toString();
                        String phone=edtphone.getText().toString();
                        String email=edtemail.getText().toString();
                        String password=edtpassword.getText().toString();
                        String cpassword=edtcpassword.getText().toString();
                        int selectindex=rdo1.getCheckedRadioButtonId();
                        rbtn=findViewById(selectindex);
                        String gender=rbtn.getText().toString();

                        Intent myintent=new Intent(MainActivity.this,MainActivity2.class);
                        myintent.putExtra("name",name);
                        myintent.putExtra("phone",phone);
                        myintent.putExtra("email",email);
                        myintent.putExtra("password",password);
                        myintent.putExtra("cpassword",cpassword);
                        myintent.putExtra("gender",gender);

                        startActivity(myintent);
                    }
                }

        );

    }
}