
package com.example.android.musical_structure_app;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ClassicalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_list);

        // Create a list of songs
        final ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song("Eine Kleine Nachtmusik", "Mozart", R.drawable.classical));
        songs.add(new Song("Fur Elise", "Beethoven", R.drawable.classical));
        songs.add(new Song("O Mio Babbino Caro", "Gianni Schicchi", R.drawable.classical));
        songs.add(new Song("Toccata And Fugue In D Minor", "J. S. Bach", R.drawable.classical));
        songs.add(new Song("Symphone No. 5 In C Minor", "Beethoven", R.drawable.classical));
        songs.add(new Song("The Four Seasons", "Vivaldi", R.drawable.classical));
        songs.add(new Song("Carmen", "Bizet", R.drawable.classical));
        songs.add(new Song("The Blue Danube", "Johan Strauss II", R.drawable.classical));
        songs.add(new Song("Bolero", "Ravel", R.drawable.classical));
        songs.add(new Song("Overture From The Mariage Of Figaro", "Mozart", R.drawable.classical));

        // Create an {@link SongAdapter}, whose data source is a list of {@link Song}s. The
        // adapter knows how to create list items for each item in the list.
        SongAdapter adapter = new SongAdapter(this, songs, R.color.category_classical);

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

                Intent songDetail = new Intent(ClassicalActivity.this, SongDetailActivity.class);
                songDetail.putExtra("imageId", songSelected.getImageResourceId());
                songDetail.putExtra("title", songSelected.getTitle());
                songDetail.putExtra("artist", songSelected.getArtist());
                startActivity(songDetail);
            }
        });
    }
}
