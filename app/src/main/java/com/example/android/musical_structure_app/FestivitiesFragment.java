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
 * Use the {@link FestivitiesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FestivitiesFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FestivitiesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FestivitiesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FestivitiesFragment newInstance(String param1, String param2) {
        FestivitiesFragment fragment = new FestivitiesFragment();
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
        String eventDate;

        title = "COME Festival";
        description = "COME Festival Internacional comes to Guadalajara every year to give a touch of unique flavor to local cuisine and introduce new dishes that will conquer even the most expert palate. With cooking demos, round tables, Guadalajara sets the table and flavors to enjoy a gastronomic feast.";
        eventDate = "March";
        tourItems.add(new TourItem(title, description, R.drawable.come));

        title = "Guadalajara International Film Festival";
        description = "With a diverse program, the International Film Festival in Guadalajara highlights the imagination of great artists and filmmakers. The FICG is a cultural event of great importance for Guadalajara and showcases the appreciation, dissemination, promotion and distribution of Mexican and Latin American cinema. It is a festival fit for in which film is presented as an industry, entertainment and art.";
        eventDate = "March";
        tourItems.add(new TourItem(title, description, R.drawable.festival_cine));

        title = "Tequila Festival";
        description = "More than 200 brands of tequila, music, art exhibits, food and tequila tastings await you during this two -day festival. Tequila Festival will delight your senses with the Mexican elixir that has transcended borders and makes Guadalajara proud of our history and tradition.";
        eventDate = "March";
        tourItems.add(new TourItem(title, description, R.drawable.festival_tequila));

        title = "Jalisco Jazz Festival";
        description = "The Jalisco Jazz Festival is a summer festival in Guadalajara that attracts the most influential artists of the international jazz scene. For several years now, the Jalisco Jazz Festival hosts hundreds of attendees with brilliant artistic shows that highlights the best music of the jazz scene.";
        eventDate = "July";
        tourItems.add(new TourItem(title, description, R.drawable.festival_jazz));

        title = "International Mariachi and Charrería Festival";
        description = "Named an \"Intangible Heritage of Humanity\" by UNESCO, the International Mariachi and Charrería Festival has become an experience full of tradition. Every year, since 1994, thousands of spectators attend the festival to enjoy performances by some of the best mariachis in the world, the National Charro Championship, and other culture related events.This festival has turned into a spectacular party filled with Mexican folklore.";
        eventDate = "September";
        tourItems.add(new TourItem(title, description, R.drawable.festival_mariachi));

        title = "Fiestas de Octubre";
        description = "With a broad range of great artists, the Fiestas de Octubre brings together nearly two million visitors per year. This month-long Guadalajara celebration started in 1965 and features Guadalajara’s best art, culture, entertainment, and cuisine.";
        eventDate = "October";
        tourItems.add(new TourItem(title, description, R.drawable.fiestas_octubre));

        title = "Guadalajara International Book Fair";
        description = "Since 1987, the Guadalajara International Book Fair has been responsible for turning our city into a intellectual epicenter. The festival’s program involves international authors from all continents and different languages. Open to the general public, the festival includes live music, art, film, theater and literature.";
        eventDate = "November";
        tourItems.add(new TourItem(title, description, R.drawable.feria_libro));

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