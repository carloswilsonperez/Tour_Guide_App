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
 * Use the {@link PlacesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlacesFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PlacesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PlacesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PlacesFragment newInstance(String param1, String param2) {
        PlacesFragment fragment = new PlacesFragment();
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

        title = "Catedral de Guadalajara";
        description = "Guadalajara's cathedral is the city's most beloved and conspicuous landmark with distinctive neo-Gothic towers built after an earthquake toppled the originals in the mid-19th century. Begun in 1588 and consecrated in 1618, the building is almost as old as the city itself. Time your visit right and you will see light filter through the stained-glass renderings of The Last Supper and hear a working pipe organ rumble sweetly from the rafters.";
        eventDate = "All Year.";
        address = "Alcalde Ave. #10 (between Hildalgo Ave. and Morelos) Guadalajara, 44100.";
        phone = "+(33) 3613 7168.";
        officeHours = "08:00AM - 08:00PM.";
        tourItems.add(new TourItem(title, description, eventDate, address, phone, officeHours, R.drawable.catedral_guadalajara));

        title = "Hospicio Cabañas";
        description = "The Hospicos Cabañas was built at the beginning of the 19th centurey to provide care and shelter for the disadvantaged – orphans, seniors, the handicapped and chronic invalids. This large complex which incorporates several unusual features designed specifically to meet the needs of its occupants, was unique for its time.";
        eventDate = "All Year.";
        address = "Cabanas No. 8 Col. Las Fresas, Plaza tapatia C.P. 44369.";
        phone = "(33) 3818 2800 ext. 31642.";
        officeHours = "10:00AM - 06:00PM.";
        tourItems.add(new TourItem(title, description, eventDate, address, phone, officeHours, R.drawable.hospicio_cabanas));

        title = "Basilica de Zapopan";
        description = "Zapopan's pride and joy, the Basilica de Zapopan, built in 1730, is home to Nuestra Senora de Zapopan, a petite statue of the Virgin visited by pilgrims year-round. During the Fiestas de Octubre, thousands of kneeling faithful from the Jalisco region crawl behind the statue as it is carried from the basilica to Guadalajara's central cathedral.";
        eventDate = "All Year.";
        address = "Evan Briseno #152, Guadalajara.";
        phone = "+52 (33) 3633 6614.";
        officeHours = "09:00AM - 08:00PM.";
        tourItems.add(new TourItem(title, description, eventDate, address, phone, officeHours, R.drawable.catedral_zapopan));

        title = "Andares";
        description = "Andaras is a shopping mall located in the Zapopan district of Guadalajara. This outdoor and indoor shopping center opened on November 19, 2008 and has been drawing local and visiting shoppers ever since. All the well recognized international luxury and commercial brands as well as independent retailers are housed there. ";
        eventDate = "All Year.";
        address = "Blvd. Puerto de Hierro #4965, Guadalajara, 45116.";
        phone = "+(33) 3648 2280.";
        officeHours = "11:00AM - 10:00PM.";
        tourItems.add(new TourItem(title, description, eventDate, address, phone, officeHours, R.drawable.andares));

        title = "Museo de las Artes";
        description = "To scratch your modernist itch if you've overdosed on classic art, head three blocks west of Parque Revolucion to this museum housed in a French renaissance building that formaearly served as the admin buildings for the University of Guadalajara.";
        eventDate = "All Year.";
        address = "Av Jauarez #975, Guadalajara.";
        phone = "+(33) 3134 1664.";
        officeHours = "Tuesday to Sunday from 10:00AM - 6:00PM.";
        tourItems.add(new TourItem(title, description, eventDate, address, phone, officeHours, R.drawable.museo_artes));

        // Create an {@link TourItemAdapter}, whose data source is a list of {@link TourItem}s. The
        // adapter knows how to create list items for each item in the list.
        TourItemAdapter adapter = new TourItemAdapter(getActivity(), tourItems, R.color.category_pop);

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