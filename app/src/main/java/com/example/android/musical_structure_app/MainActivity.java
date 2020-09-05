
package com.example.android.musical_structure_app;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        // Create a list of music
        final ArrayList<Genre> categories = new ArrayList<Genre>();
        categories.add(new Genre("Rock", R.drawable.rock));
        categories.add(new Genre("Instrumental", R.drawable.instrumental));
        categories.add(new Genre("Classical", R.drawable.classical));
        categories.add(new Genre("Pop", R.drawable.pop));

        // Create an {@link SongAdapter}, whose data source is a list of {@link Song}s. The
        // adapter knows how to create list items for each item in the list.
        GenreAdapter adapter = new GenreAdapter(this, categories, R.color.category_classical);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // music_list.xml layout file.
        ListView listView = findViewById(R.id.category_list);

        // Make the {@link ListView} use the {@link SongAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Song} in the list.
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the {@link Song} object at the given position the user clicked on
                Genre categorySelected = categories.get(position);

                // Create a new intent to open the proper genre activity
                Intent genreIntent;

                switch (position) {
                    case 0:
                        genreIntent = new Intent(MainActivity.this, RockActivity.class);
                        break;
                    case 1:
                        genreIntent = new Intent(MainActivity.this, InstrumentalActivity.class);
                        break;
                    case 2:
                        genreIntent = new Intent(MainActivity.this, ClassicalActivity.class);
                        break;
                    case 3:
                        genreIntent = new Intent(MainActivity.this, PopActivity.class);
                        break;
                    default:
                        genreIntent = new Intent(MainActivity.this, RockActivity.class);
                }

                // Start the new activity
                startActivity(genreIntent);
            }
        });
    }
}
