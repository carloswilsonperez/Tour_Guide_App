
package com.example.android.musical_structure_app;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_list);

        // Create a list of songs
        final ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song("Fantasy", "Mariah Carey", R.drawable.pop));
        songs.add(new Song("Rehab", "Amy Winehouse", R.drawable.pop));
        songs.add(new Song("Smells Like Teen Spirit", "Nirvana", R.drawable.pop));
        songs.add(new Song("Every Breath You Take", "The Police", R.drawable.pop));
        songs.add(new Song("Billy Jean", "Michael Jackson", R.drawable.pop));
        songs.add(new Song("I Will Always Love You", "Whitney Houston", R.drawable.pop));
        songs.add(new Song("Hotel California", "Eagles", R.drawable.pop));
        songs.add(new Song("Nothing Compares 2 U", "Sinead O'Connor", R.drawable.pop));
        songs.add(new Song("Baby One More Time", "Britney Spears", R.drawable.pop));
        songs.add(new Song("Beautiful", "Christina Aguilera", R.drawable.pop));

        // Create an {@link SongAdapter}, whose data source is a list of {@link Song}s. The
        // adapter knows how to create list items for each item in the list.
        SongAdapter adapter = new SongAdapter(this, songs, R.color.category_pop);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // music_list.xml layout file.
        ListView listView = findViewById(R.id.list);

        // Make the {@link ListView} use the {@link SongAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Song} in the list.
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the {@link Song} object at the given position the user clicked on
                Song songSelected = songs.get(position);

                Intent songDetail = new Intent(PopActivity.this, SongDetailActivity.class);
                songDetail.putExtra("imageId", songSelected.getImageResourceId());
                songDetail.putExtra("title", songSelected.getTitle());
                songDetail.putExtra("artist", songSelected.getArtist());
                startActivity(songDetail);
            }
        });
    }
}
