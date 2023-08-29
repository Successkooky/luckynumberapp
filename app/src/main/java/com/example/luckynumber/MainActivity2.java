package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    TextView idTVLuckNumber,idTVNumber;

    Button idBtnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        idTVLuckNumber=findViewById(R.id.idTVLuckNumber);
        idTVNumber=findViewById(R.id.idTVNumber);
        idBtnShare=findViewById(R.id.idBtnShare);

        Intent intent=getIntent();
        String username=intent.getStringExtra("name");

        //Generate Random nos
        int random_num=generateRandom();
        idTVNumber.setText(""+ random_num);


        idBtnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareData(username,random_num);

            }
        });
    }
    public int generateRandom(){
        Random random=new Random();
        int upper_limit=1000;
        int randomNumber=random.nextInt(upper_limit);
        return randomNumber;
    }

    public void shareData(String username,int random_num){
        //Implicit Intent
        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT,username+"Got Lucky Today");
        intent.putExtra(Intent.EXTRA_TEXT,"His Lucky Number is"+random_num);
        startActivity(Intent.createChooser(intent,"Choose a Platform"));
    }
}