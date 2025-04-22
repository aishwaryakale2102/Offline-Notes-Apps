package com.example.loginpage;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class NotesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        ImageView notesImageView = findViewById(R.id.notesImageView);

        // Get the note file name from Intent
        String fileName = getIntent().getStringExtra("fileName");

        if (fileName != null) {
            // Convert file name to drawable resource ID
            int imageResource = getResources().getIdentifier(fileName, "drawable", getPackageName());

            if (imageResource != 0) {
                notesImageView.setImageResource(imageResource);
            } else {
                Toast.makeText(this, "Image not found!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
