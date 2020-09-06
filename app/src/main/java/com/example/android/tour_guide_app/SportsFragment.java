package com.example.android.tour_guide_app;

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
 * Use the {@link SportsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SportsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SportsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SportsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SportsFragment newInstance(String param1, String param2) {
        SportsFragment fragment = new SportsFragment();
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

        String title;
        String description;
        String eventDate = null;
        String address = null;
        String phone = null;
        String officeHours = null;

        title = "Charreada";
        description = "The sport of charreada is considered a \"living history\" of Mexico and is the national sport. This competitive sport is similar to rodeo and its origins date back to the 19th Century when Mexico's haciendas were widespread throughout the country.";
        eventDate = "All Year";
        tourItems.add(new TourItem(title, description, eventDate, address, phone, officeHours, R.drawable.charreria));

        title = "Soccer";
        description = "Club Deportivo, commonly known as Chivas, is a professional soccer club based in Guadalajara. The team was founded by Edgar Everaert, who arrived in Mexico in 1906. In 1908, with the approval of Everaert and the players, the team was renamed as Club Deportivo Guadalajara to reflect a sense of loyalty within Guadalajara's locals. In that same year, the team declared it would only field Mexican-born players.";
        eventDate = "All Year";
        tourItems.add(new TourItem(title, description, eventDate, address, phone, officeHours, R.drawable.soccer));

        title = "Wrestling";
        description = "Lucha Libre is a form of professional wrestling developed in Mexico. This lively sport has become an internationally recognized symbol of Mexican pop culture. The history of Mexican wrestlinig dates back to 1863 when Enrique Ugartechea, the first Mexican wrestler, developed the Mexican lucha libre style inspired by Greco-Roman wrestling. Today, lucha libre wrestlers are known as luchadores.";
        eventDate = "All Year";
        tourItems.add(new TourItem(title, description, eventDate, address, phone, officeHours, R.drawable.wrestling));

        // Create an {@link TourItemAdapter}, whose data source is a list of {@link TourItem}s. The
        // adapter knows how to create list items for each item in the list.
        TourItemAdapter adapter = new TourItemAdapter(getActivity(), tourItems, R.color.category_instrumental);

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