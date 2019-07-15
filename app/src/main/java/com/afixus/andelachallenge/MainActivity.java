package com.afixus.andelachallenge;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnabout;
    Button btnmyprofile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnabout = findViewById(R.id.btnaboutid);
        btnmyprofile = findViewById(R.id.btnprofid);
 btnabout.setOnClickListener(new View.OnClickListener() {//this button opens activity2
     @Override
     public void onClick(View v) {
         Intent intent = new Intent(getApplicationContext(), Activity3.class);
         startActivity(intent);
     }
 });

 btnmyprofile.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View v) {
         Intent intent = new Intent(getApplicationContext(), MyProfile.class);
         startActivity(intent);
     }
 });

    }
}
