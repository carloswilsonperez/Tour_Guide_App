
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
 * {@link GenreAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Genre} objects.
 */
public class GenreAdapter extends ArrayAdapter<Genre>  {

    /** Resource ID for the background color for this list of songs */
    private int mColorResourceId;

    /**
     * Create a new {@link GenreAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param categories is the list of {@link Song}s to be displayed.
     * @param colorResourceId is the resource ID for the background color for this list of music
     */
    public GenreAdapter(Context context, ArrayList<Genre> categories, int colorResourceId) {
        super(context, 0, categories);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.category_item_layout, parent, false);
        }

        // Get the {@link Song} object located at this position in the list
        Genre currentCategory = getItem(position);

        // Find the TextView in the song_item_layout.xml layout with the ID category_name.
        TextView categoryName = listItemView.findViewById(R.id.category_name);
        categoryName.setText(currentCategory.getGenre());

        // Find the ImageView in the song_item_layout.xml layout with the ID category_image.
        ImageView categoryImage = listItemView.findViewById(R.id.category_image);

        // Check if an image is provided for this song or not
        if (currentCategory.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            categoryImage.setImageResource(currentCategory.getImageResourceId());

            // Color the png icons for better visual contrast
            int color = Color.parseColor("#FFFFFF"); //The color u want
            categoryImage.setColorFilter(color);

            // Make sure the view is visible
            categoryImage.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            categoryImage.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View categoryContainer = listItemView.findViewById(R.id.category_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        categoryContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;
    }
}