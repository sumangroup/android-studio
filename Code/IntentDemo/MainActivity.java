package com.example.intentdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edtusername,edtpassword;
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
        edtusername=findViewById(R.id.edtusername);
        edtpassword=findViewById(R.id.edtpassword);
        btnsubmit=findViewById(R.id.btnsubmit);

        btnsubmit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String username=edtusername.getText().toString();
                        String password=edtpassword.getText().toString();

                        if(username.equals("raju") && password.equals("123")){
                            //Toast.makeText(getApplicationContext(),"login successful",Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                            intent.putExtra("username",username);
                            startActivity(intent);

                        }
                        else{
                            Toast.makeText(getApplicationContext(),"login unsuccessful",Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
    }
}