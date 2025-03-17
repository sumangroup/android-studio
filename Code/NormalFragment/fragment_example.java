package com.example.normalfragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class fragment_example extends Fragment {

    TextView txtfrg;
    Button btnSubmit;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_example, container, false);
        txtfrg=view.findViewById(R.id.txtfrg);
        btnSubmit=view.findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        txtfrg.setText("I am update");
                    }
                }
        );
        return view;
    }
}