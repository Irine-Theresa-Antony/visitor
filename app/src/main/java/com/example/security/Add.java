package com.example.security;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Add extends AppCompatActivity {

    Button b3,b4;
    TextView t1,t2,t3,t4;
    String st1,st2,st3,st4,st5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add);

        t1=(TextView) findViewById(R.id.fname);
        t2=(TextView) findViewById(R.id.lname);
        t3=(TextView) findViewById(R.id.purpose);
        t4=(TextView) findViewById(R.id.whom);
        b3=(Button) findViewById(R.id.s1);
        b4=(Button) findViewById(R.id.go);

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               st1=t1.getText().toString();
               st2=t2.getText().toString();
               st3=t3.getText().toString();
               st4=t4.getText().toString();
                st5=st1+st2+st3+st4;
                Toast.makeText(getApplicationContext(),st5,Toast.LENGTH_LONG).show();
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ob2=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(ob2);
            }
        });
    }
}