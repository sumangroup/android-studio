package com.example.databaseexample1;
// imp
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;


import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edtName,edtId;

    Button btnInsert,btnUpdate,btnDelete,btnViewData;

    ListView listViewData;

    DatabaseHelper db;

     private void displayData(){
         Cursor cursor=db.getAllData();
         ArrayList<String> dataList=new ArrayList<String>();

         while(cursor.moveToNext()){
             int id=cursor.getInt(0);
             String name=cursor.getString(1);
             dataList.add("ID: "+id+",Name: "+name);
         }
         cursor.close();

         ArrayAdapter<String> adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,dataList);
         listViewData.setAdapter(adapter);

     }
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
        db=new DatabaseHelper(this);
        edtName=findViewById(R.id.edtName);
        edtId=findViewById(R.id.edtId);

        btnInsert=findViewById(R.id.btnInsert);
        btnUpdate=findViewById(R.id.btnUpdate);
        btnDelete=findViewById(R.id.btnDelete);
        btnViewData=findViewById(R.id.btnViewData);

        listViewData=findViewById(R.id.listViewData);

        btnInsert.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name=edtName.getText().toString();
                        db.insert(name);
                        edtName.setText("");
                        displayData();
                    }
                }
        );
        btnUpdate.setOnClickListener(view -> {
            String name=edtName.getText().toString();
            int id=Integer.parseInt(edtId.getText().toString()) ;
            db.update(id,name);
            edtName.setText("");
            edtId.setText("");
            displayData();
        });

        btnDelete.setOnClickListener(view -> {
            int id=Integer.parseInt(edtId.getText().toString()) ;
            db.delete(id);
            edtId.setText("");
            displayData();
        });

        btnViewData.setOnClickListener(view -> {
            displayData();
        });
    }


}