package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button btn;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=findViewById(R.id.idEdtUserName);
        btn=findViewById(R.id.idBtnClickMe);
        textView=findViewById(R.id.idTVWelcome);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=editText.getText().toString();
                Intent intent=new Intent(getApplicationContext(), MainActivity2.class);
                intent.putExtra("name",username);  // Here name is the key for username to access it in the second activity
                startActivity(intent);
            }
        });

    }
}