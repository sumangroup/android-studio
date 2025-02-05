package com.example.datepickerdemo2;

import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    DatePicker datepicker;
    TextView txtres;

    TimePicker timepicker;
    TextView txttime;
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
        datepicker=findViewById(R.id.datepicker);
        txtres=findViewById(R.id.txtres);

        Calendar cal=Calendar.getInstance();
       int years=cal.get(Calendar.YEAR);
       int months=cal.get(Calendar.MONTH);
       int days=cal.get(Calendar.DAY_OF_MONTH);
       int hours=cal.get(Calendar.HOUR_OF_DAY);
       int minutes=cal.get(Calendar.MINUTE);

       datepicker.init(years, months, days, new DatePicker.OnDateChangedListener() {
           @Override
           public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
               String date=i+"/"+(i1+1)+"/"+i2;
               txtres.setText(date);
           }
       });
       txtres.setText(years+"/"+(months+1)+"/"+days);

       // this code for timepicker
        timepicker=findViewById(R.id.timepicker);
        txttime=findViewById(R.id.txttime);

        timepicker.setIs24HourView(true);
        timepicker.setHour(hours);
        timepicker.setMinute(minutes);

        timepicker.setOnTimeChangedListener(
                new TimePicker.OnTimeChangedListener() {
                    @Override
                    public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                        txttime.setText(i+":"+i1);
                    }
                }
        );
        txttime.setText(hours+":"+minutes);
    }
}