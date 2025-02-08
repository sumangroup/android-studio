package com.example.studentregistration;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnsubmit;
    RadioGroup rdo1;
    EditText edtpassword,edtmail,edtname;
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
        btnsubmit=findViewById(R.id.btnsubmit);
        rdo1=findViewById(R.id.rdo1);
        edtpassword=findViewById(R.id.edtpassword);
        edtmail=findViewById(R.id.edtmail);
        edtname=findViewById(R.id.edtname);

        btnsubmit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name=edtname.getText().toString();
                        String mail=edtmail.getText().toString();
                        String password=edtpassword.getText().toString();
                        int selected=rdo1.getCheckedRadioButtonId();
                        if(selected!=-1){
                            RadioButton selectedRadioButton=findViewById(selected);
                            String rdotext=selectedRadioButton.getText().toString();
                            Toast.makeText(getApplicationContext(),name+" "+mail+" "+password+" "+rdotext,Toast.LENGTH_LONG).show();
                            Toast.makeText(getApplicationContext(),"Registration successfull",Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }
}