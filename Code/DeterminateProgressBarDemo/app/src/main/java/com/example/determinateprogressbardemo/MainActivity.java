package com.example.determinateprogressbardemo;

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
    Button btnprogress;
    int progressStatus=0;
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
        btnprogress=findViewById(R.id.btnprogress);



        btnprogress.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        progressStatus=progressStatus+10;
                        if(progressStatus>100){
                            progressStatus=100;
                        }
                       progressbar.setProgress(progressStatus);
                        /*
                        for(progressStatus=0;progressStatus<=100;progressStatus=progressStatus+10){
                            progressbar.setProgress(progressStatus);
                            try {
                                Thread.sleep(60000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }*/
                    }
                }
        );
    }
}