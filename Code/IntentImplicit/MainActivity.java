package com.example.intentimplicit;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnOpenWebPage,btnOpenDialPhone,btnOpenMap;
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
        btnOpenWebPage=findViewById(R.id.btnOpenWebPage);
        btnOpenDialPhone=findViewById(R.id.btnOpenDialPhone);
        btnOpenMap=findViewById(R.id.btnOpenMap);
        btnOpenWebPage.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Uri webpage=Uri.parse("https://www.google.com/search?q=cricket+score&oq=cricket&gs_lcrp=EgZjaHJvbWUqDAgAECMYJxiABBiKBTIMCAAQIxgnGIAEGIoFMhIIARAuGEMYgwEYsQMYgAQYigUyEAgCEAAYkQIYyQMYgAQYigUyDQgDEAAYkgMYgAQYigUyDQgEEAAYkgMYgAQYigUyDQgFEAAYgwEYsQMYgAQyFQgGEC4YQxiDARjUAhixAxiABBiKBTIVCAcQLhhDGIMBGNQCGLEDGIAEGIoFMhUICBAuGEMYgwEY1AIYsQMYgAQYigUyBwgJEAAYjwLSAQgxNjc4ajBqN6gCALACAA&sourceid=chrome&ie=UTF-8#sie=m;/g/11wxgqx_49;5;/m/03b06s;dt;fp;1;;;");
                        Intent myintent=new Intent(Intent.ACTION_VIEW,webpage);
                        startActivity(myintent);
                    }
                }
        );

        btnOpenDialPhone.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    Intent myintent=new Intent(Intent.ACTION_DIAL);
                    myintent.setData(Uri.parse("tel:702145856"));
                    startActivity(myintent);
                    }
                }
        );
        btnOpenMap.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Uri mapuri=Uri.parse("https://www.google.com/maps/place/Lower+Parel+Railway+Station,+Lower+Parel+Bridge,+Lower+Parel,+Mumbai,+Maharashtra+400013/@18.9958143,72.8276509,17z/data=!3m1!4b1!4m6!3m5!1s0x3be7cef30c480e03:0x41570c0bce0f5d68!8m2!3d18.9963823!4d72.8306846!16s%2Fg%2F11qs971kjk?entry=ttu&g_ep=EgoyMDI1MDIyNi4xIKXMDSoASAFQAw%3D%3D");
                        Intent myintent=new Intent(Intent.ACTION_VIEW,mapuri);
                        myintent.setPackage("com.google.android.apps.maps");
                        startActivity(myintent);
                    }
                }
        );
    }
}