
package com.example.android.musical_structure_app;

import android.content.Context;
import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * {@link SongAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Song} objects.
 */
public class SongAdapter extends ArrayAdapter<Song>  {

    /** Resource ID for the background color for this list of songs */
    private int mColorResourceId;
    private Context mContext;

    /**
     * Create a new {@link SongAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param songs is the list of {@link Song}s to be displayed.
     * @param colorResourceId is the resource ID for the background color for this list of songs
     */
    public SongAdapter(Context context, ArrayList<Song> songs, int colorResourceId) {
        super(context, 0, songs);
        mColorResourceId = colorResourceId;
        mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.song_item_layout, parent, false);
        }

        // Get the {@link Song} object located at this position in the list
        Song currentSong = getItem(position);

        // Find the TextView in the song_item_layout.xml layout with the ID song_title.
        TextView songTitle = listItemView.findViewById(R.id.song_title);
        songTitle.setText(currentSong.getTitle());

        // Find the TextView in the song_item_layout.xml layout with the ID song_artist.
        TextView songArtist = listItemView.findViewById(R.id.song_artist);
        songArtist.setText(currentSong.getArtist());

        // Find the ImageView in the song_item_layout.xml layout with the ID song_image.
        ImageView songImage = listItemView.findViewById(R.id.song_image);
        // Check if an image is provided for this song or not
        if (currentSong.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            songImage.setImageResource(currentSong.getImageResourceId());

            // Color the png icons for better visual contrast
            int color = Color.parseColor("#FFFFFF"); //The color u want
            songImage.setColorFilter(color);

            // Make sure the view is visible
            songImage.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            songImage.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View songContainer = listItemView.findViewById(R.id.song_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        songContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;
    }
}