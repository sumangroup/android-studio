package com.example.radiobuttondemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    RadioGroup radiogroup;
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
        radiogroup=findViewById(R.id.radiogroup);
        txtres=findViewById(R.id.txtres);
        btnSubmit=findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int selectId=radiogroup.getCheckedRadioButtonId();
                        if(selectId!=-1){
                            RadioButton radioButton=findViewById(selectId);
                            txtres.setText("You select is: "+radioButton.getText().toString());
                        }
                        else{
                            txtres.setText("plz select any one option");
                        }
                    }
                }
        );
    }
}