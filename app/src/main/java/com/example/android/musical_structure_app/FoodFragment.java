package com.example.android.musical_structure_app;

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
 * Use the {@link FoodFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FoodFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FoodFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FoodFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FoodFragment newInstance(String param1, String param2) {
        FoodFragment fragment = new FoodFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.tours_list, container, false);

        // Create a list of tourItems
        final ArrayList<TourItem> tourItems = new ArrayList<TourItem>();

        String title = "Pozole";
        String description = "Made with pork and hominy (dried corn), pozole is a traditional Mexican soup that is available at food stands, markets, and restaurants throughout Guadalajara. This dish is served at celebratory events such as Mexico's Independence Day, Quinceañeras, weddings, birthdays, and baptisms.";
        tourItems.add(new TourItem(title, description, R.drawable.pozole));

        title = "Enchiladas Tapatias";
        description = "The Spanish adjective tapatío means coming from the city or region of Guadalajara, and these simple enchiladas originate from Guadalajara.";
        tourItems.add(new TourItem(title, description, R.drawable.enchiladas_tapatias));

        title = "Chilaquiles";
        description = "Chilaquiles are a breakfast staple in Guadalajara. This hearty dish is typically served three different ways, either verde (green salsa), rojo (red salsa) or divorciados (a combination of red and green salsa).";
        tourItems.add(new TourItem(title, description, R.drawable.chilaquiles));


        title = "Guacamole";
        description = "A popular dip in America, Guacamole was first created by the Aztecs in what is now Mexico.";
        tourItems.add(new TourItem(title, description, R.drawable.guacamlole));

        // Create an {@link TourItemAdapter}, whose data source is a list of {@link TourItem}s. The
        // adapter knows how to create list items for each item in the list.
        TourItemAdapter adapter = new TourItemAdapter(getActivity(), tourItems, R.color.category_rock);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // tours_list.xml layout file.
        ListView listView = rootView.findViewById(R.id.list);

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