package com.creativestoreid.arf.holidayinsukabumi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AboutProfile extends AppCompatActivity {
    private String title = "About";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_profile);
        getSupportActionBar().setTitle(title);
    }
}
