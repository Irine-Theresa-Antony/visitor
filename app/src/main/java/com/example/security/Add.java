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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Add extends AppCompatActivity {

    Button b3,b4;
    TextView t1,t2,t3,t4;
    String st1,st2,st3,st4,st5,text="All the fields are mandatory",apiUrl="https://log-app-demo-api.onrender.com/addvisitor";
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
                if(st1.isEmpty()||st2.isEmpty()||st3.isEmpty()||st4.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),text,Toast.LENGTH_LONG).show();
                }
                else {
                    callApi();
                }
            }

            private void callApi() {

                JSONObject data=new JSONObject();
                try {
                    data.put("firstname",st1);
                    data.put("lastname",st2);
                    data.put("purpose",st3);
                    data.put("whomToMeet",st4);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
                JsonObjectRequest request=new JsonObjectRequest(
                        Request.Method.POST,
                        apiUrl,
                        data,
                        response -> Toast.makeText(getApplicationContext(),"Added Successfully",Toast.LENGTH_LONG).show(),
                        error -> Toast.makeText(getApplicationContext(),"Something went wrong",Toast.LENGTH_LONG).show()
                );

                RequestQueue queue= Volley.newRequestQueue(getApplicationContext());
                queue.add(request);
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

