package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Objects;

public class physics1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physics1);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Physics - 2nd Collection");
    }
}