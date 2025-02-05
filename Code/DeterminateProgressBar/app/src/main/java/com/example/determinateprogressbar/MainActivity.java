package com.example.determinateprogressbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressbar;
    Button btnincrease;
    int progressStatus;
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
        progressbar=findViewById(R.id.progressbar);
        btnincrease=findViewById(R.id.btnincrease);

        btnincrease.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        for(progressStatus=0;progressStatus<=100;progressStatus=progressStatus+10){

                            try {
                                progressbar.setProgress(progressStatus);
                                Thread.sleep(10000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                }
        );
    }
}