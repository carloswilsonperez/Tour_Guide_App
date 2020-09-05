package com.example.android.musical_structure_app;

import android.content.Intent;
import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class SongDetailActivity extends AppCompatActivity {
    private int imageCategoryId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_detail_layout);

        // Programatic implementation of the Up button
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // Get the references to the detail song layout views
        ImageView songPoster = findViewById(R.id.image_poster_detail);
        TextView songTitle = findViewById(R.id.song_title_detail);
        TextView songArtist = findViewById(R.id.song_artist_detail);

        // Get the informatio from the parent intent
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }

        // get data via the key
        int imageId = extras.getInt("imageId");
        if (imageId != -1) {
            songPoster.setImageResource(imageId);

            // Color the png icons for better visual contrast
            int color = Color.parseColor("#FFFFFF"); //The color u want
            songPoster.setColorFilter(color);
            imageCategoryId = imageId;
        }

        String title = extras.getString("title");
        if (title != null) {
            // do something with the data
            songTitle.setText(title);
        }

        String artist = extras.getString("artist");
        if (artist != null) {
            // do something with the data
            songArtist.setText(artist);
        }
    }

    // Handling of the Up button functionality
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == android.R.id.home) {
            switch (imageCategoryId) {
                // Respond to the action bar's Up/Home button
                case R.drawable.rock:
                    startActivity(new Intent(this, RockActivity.class));
                    return true;
                case R.drawable.instrumental:
                    startActivity(new Intent(this, InstrumentalActivity.class));
                    return true;
                case R.drawable.classical:
                    startActivity(new Intent(this, ClassicalActivity.class));
                    return true;
                case R.drawable.pop:
                    startActivity(new Intent(this, PopActivity.class));
                    return true;
            }
        }

        return super.onOptionsItemSelected(item);
    }
}