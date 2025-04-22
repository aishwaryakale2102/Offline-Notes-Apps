package com.example.loginpage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    Button logout;
    MediaPlayer mediaPlayer;
    ListView listView;

    String[] subjects = {
            "Physics", "Chemistry", "Mathematics", "Computer Fundamentals",
            "C Programming", "English", "Engineering Drawing"
    };

    Class<?>[] activityClasses = {
            physics.class, chemistry.class, mathematics.class,
            computerfundamentals.class, CProgramming.class,
            English.class, engineeringdrawing.class
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Subject Notes");

        sharedPreferences = getSharedPreferences("UserSession", MODE_PRIVATE);

        // Redirect if not logged in
        if (!sharedPreferences.getBoolean("isLoggedIn", false)) {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish();
        }

        Toast.makeText(this, "Welcome to Subject Notes App!", Toast.LENGTH_SHORT).show();

        // Initialize ListView
        listView = findViewById(R.id.listView);
        mediaPlayer = MediaPlayer.create(this, R.raw.loading);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, subjects);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            mediaPlayer.start();
            Intent intent = new Intent(getApplicationContext(), activityClasses[position]);
            startActivity(intent);
        });

        // Initialize Logout Button
        logout = findViewById(R.id.logout);
        logout.setOnClickListener(v -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.apply();
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish();
        });
    }
}
