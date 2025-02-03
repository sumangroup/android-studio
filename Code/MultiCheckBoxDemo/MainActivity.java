package com.example.multicheckboxdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    CheckBox chkc,chkcpp,chkjava,chkpython;
    Button btnSubmit;
    TextView txtres;
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
        chkc=findViewById(R.id.chkc);
        chkcpp=findViewById(R.id.chkcpp);
        chkjava=findViewById(R.id.chkjava);
        chkpython=findViewById(R.id.chkpython);
        txtres=findViewById(R.id.txtres);
        btnSubmit=findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        StringBuilder selectedOption=new StringBuilder("select Option:\n");
                        if(chkc.isChecked()){
                            selectedOption.append(chkc.getText().toString());
                            selectedOption.append("\n");
                        }
                        if(chkcpp.isChecked()){
                            selectedOption.append(chkcpp.getText().toString());
                            selectedOption.append("\n");
                        }
                        if(chkjava.isChecked()){
                            selectedOption.append(chkjava.getText().toString());
                            selectedOption.append("\n");
                        }
                        if(chkpython.isChecked()){
                            selectedOption.append(chkpython.getText().toString());
                            selectedOption.append("\n");
                        }
                        txtres.setText(selectedOption.toString()
                        );
                    }

                }
        );
    }
}