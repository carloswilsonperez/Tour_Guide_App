
package com.example.android.tour_guide_app;

import android.content.Context;

import androidx.core.content.ContextCompat;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * {@link TourItemAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link TourItem} objects.
 */
public class TourItemAdapter extends ArrayAdapter<TourItem>  {

    /** Resource ID for the background color for this list of tours */
    private int mColorResourceId;
    private Context mContext;

    /**
     * Create a new {@link TourItemAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param tourItems is the list of {@link TourItem}s to be displayed.
     * @param colorResourceId is the resource ID for the background color for this list of tourItems
     */
    public TourItemAdapter(Context context, ArrayList<TourItem> tourItems, int colorResourceId) {
        super(context, 0, tourItems);
        mColorResourceId = colorResourceId;
        mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.tour_item_layout, parent, false);
        }

        // Get the {@link TourItem} object located at this position in the list
        TourItem currentTourItem = getItem(position);

        ImageView tourItemImage = listItemView.findViewById(R.id.tour_item_image);
        // Check if an image is provided for this tour or not
        if (currentTourItem.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            tourItemImage.setImageResource(currentTourItem.getImageResourceId());

            // Make sure the view is visible
            tourItemImage.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            tourItemImage.setVisibility(View.GONE);
        }

        TextView tourItemTitle = listItemView.findViewById(R.id.tour_item_title);
        tourItemTitle.setText(currentTourItem.getTitle());

        TextView tourDescription = listItemView.findViewById(R.id.tour_item_description);
        tourDescription.setText(currentTourItem.getDescription());

        TextView when = listItemView.findViewById(R.id.tour_when);
        if (!TextUtils.isEmpty(currentTourItem.getmEventDate())) {
            when.setText(getContext().getString(R.string.when_prefix) + currentTourItem.getmEventDate());
        } else {
            when.setVisibility(View.GONE);
        }

        TextView address = listItemView.findViewById(R.id.tour_item_address);
        if (!TextUtils.isEmpty(currentTourItem.getmAddress())) {
            address.setText("ADDRESS: " + currentTourItem.getmAddress());
        } else {
            address.setVisibility(View.GONE);
        }

        TextView phone = listItemView.findViewById(R.id.tour_item_phone);
        if (!TextUtils.isEmpty(currentTourItem.getmPhone())) {
            phone.setText("PHONE: " + currentTourItem.getmPhone());
        } else {
            phone.setVisibility(View.GONE);
        }

        TextView officeHours = listItemView.findViewById(R.id.tour_item_office_hours);
        if (!TextUtils.isEmpty(currentTourItem.getmOfficeHours())) {
            officeHours.setText(currentTourItem.getmOfficeHours());
        } else {
            officeHours.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View tourItemContainer = listItemView.findViewById(R.id.tour_item_container);

        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        tourItemContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;
    }
}