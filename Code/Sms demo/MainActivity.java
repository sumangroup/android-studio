package com.example.smsdemo1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText edtNumber,edtMsg,edtText;
    Button btnSend,btnEmail,btnSpeak;
    TextToSpeech textToSpeech;
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
        edtNumber=findViewById(R.id.edtNumber);
        edtMsg=findViewById(R.id.edtMsg);
        btnSend=findViewById(R.id.btnSend);
        btnEmail=findViewById(R.id.btnEmail);
        edtText=findViewById(R.id.edtText);
        btnSpeak=findViewById(R.id.btnSpeak);

        btnSend.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String number=edtNumber.getText().toString();
                        String msg=edtMsg.getText().toString();

                        try{
                            SmsManager smsManager=SmsManager.getDefault();
                            smsManager.sendTextMessage(number,null,msg,null,null);
                            Toast.makeText(getApplicationContext(), "Sms send", Toast.LENGTH_LONG).show();
                        } catch (Exception e) {
                            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
        btnEmail.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent emailIntent=new Intent(Intent.ACTION_SENDTO);
                        emailIntent.setData(Uri.parse("mailto:"));
                        emailIntent.putExtra(Intent.EXTRA_EMAIL,new String[]{"mail.sumangroup@gmail.com"});
                        emailIntent.putExtra(Intent.EXTRA_SUBJECT,"MAD");
                        emailIntent.putExtra(Intent.EXTRA_TEXT,"Hello sir");
                        startActivity(Intent.createChooser(emailIntent,"send email.."));
                    }
                }
        );
        textToSpeech=new TextToSpeech(getApplicationContext(),
                new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int i) {
                        if(i!=TextToSpeech.ERROR){
                            textToSpeech.setLanguage(Locale.CHINESE);
                        }
                    }
                });
        btnSpeak.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        textToSpeech.speak(edtText.getText().toString(), TextToSpeech.QUEUE_FLUSH,null);
                    }
                }
        );

    }
}