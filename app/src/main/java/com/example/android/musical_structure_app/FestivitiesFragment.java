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
        View rootView = inflater.inflate(R.layout.music_list, container, false);

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
        SongAdapter adapter = new SongAdapter(getActivity(), songs, R.color.category_rock);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // music_list.xml layout file.
        ListView listView = rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link SongAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Song} in the list.
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the {@link Song} object at the given position the user clicked on
                Song songSelected = songs.get(position);
            }
        });

        return rootView;
    }
}