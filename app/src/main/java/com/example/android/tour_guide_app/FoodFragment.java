package com.example.android.tour_guide_app;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FoodFragment} factory method to
 * create an instance of this fragment.
 */
public class FoodFragment extends Fragment {

    public FoodFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_food, container, false);

        // Create a list of tourItems
        final ArrayList<TourItem> tourItems = new ArrayList<TourItem>();

        String[] titles = getResources().getStringArray(R.array.cuisine_titles);
        String[] descriptions = getResources().getStringArray(R.array.cuisine_description);
        String[] eventDates = getResources().getStringArray(R.array.cuisine_dates);
        String[] addresses = getResources().getStringArray(R.array.cuisine_address);
        String[] phones = getResources().getStringArray(R.array.cuisine_phones);
        String[] officeHours = getResources().getStringArray(R.array.cuisine_office_hours);
        TypedArray images = getResources().obtainTypedArray(R.array.cuisine_images);

        int numberOfItems = titles.length;

        for(int i = 0; i < numberOfItems; i++) {
            tourItems.add(new TourItem(titles[i], descriptions[i], eventDates[i], addresses[i], phones[i], officeHours[i], images.getResourceId(i, -1)));
        }

        // Create an {@link TourItemAdapter}, whose data source is a list of {@link TourItem}s. The
        // adapter knows how to create list items for each item in the list.
        TourItemAdapter adapter = new TourItemAdapter(getActivity(), tourItems, R.color.category_rock);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // tours_list.xml layout file.
        ListView listView = rootView.findViewById(R.id.food_list);

        // Make the {@link ListView} use the {@link TourItemAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link TourItem} in the list.
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the {@link TourItem} object at the given position the user clicked on
                TourItem tourItemSelected = tourItems.get(position);
            }
        });

        return rootView;
    }
}