package com.example.android.visitcardiff;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ToDoFragment extends Fragment {

    public ToDoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.category_list, container, false);

        // Create a list of content for each attraction
        final ArrayList<Content> contents = new ArrayList<Content>();
        contents.add(new Content(
                R.string.name_chapter,
                R.string.summary_chapter,
                R.string.address_chapter,
                R.string.phone_chapter,
                R.drawable.chapter_large,
                R.drawable.chapter_small,
                R.string.website_chapter,
                R.string.latitude_chapter,
                R.string.longitude_chapter));
        contents.add(new Content(
                R.string.name_ciww,
                R.string.summary_ciww,
                R.string.address_ciww,
                R.string.phone_ciww,
                R.drawable.ciww_large,
                R.drawable.ciww_small,
                R.string.website_ciww,
                R.string.latitude_ciww,
                R.string.longitude_ciww));
        contents.add(new Content(
                R.string.name_escape_rooms,
                R.string.summary_escape_rooms,
                R.string.address_escape_rooms,
                R.string.phone_escape_rooms,
                R.drawable.escape_rooms_large,
                R.drawable.escape_rooms_small,
                R.string.website_escape_rooms,
                R.string.latitude_escape_rooms,
                R.string.longitude_escape_rooms));
        contents.add(new Content(
                R.string.name_ice_arena,
                R.string.summary_ice_arena,
                R.string.address_ice_arena,
                R.string.phone_ice_arena,
                R.drawable.ice_arena_large,
                R.drawable.ice_arena_small,
                R.string.website_ice_arena,
                R.string.latitude_ice_arena,
                R.string.longitude_ice_arena));
        contents.add(new Content(
                R.string.name_new_theatre,
                R.string.summary_new_theatre,
                R.string.address_new_theatre,
                R.string.phone_new_theatre,
                R.drawable.new_theatre_large,
                R.drawable.new_theatre_small,
                R.string.website_new_theatre,
                R.string.latitude_new_theatre,
                R.string.longitude_new_theatre));
        contents.add(new Content(
                R.string.name_techniquest,
                R.string.summary_techniquest,
                R.string.address_techniquest,
                R.string.phone_techniquest,
                R.drawable.techniquest_large,
                R.drawable.techniquest_small,
                R.string.website_techniquest,
                R.string.latitude_techniquest,
                R.string.longitude_techniquest));

        // Creates adapter for the list
        ContentAdapter adapter = new ContentAdapter(getActivity(), contents);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        // Sets up on clicks for items in list view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent,
                                    View v, int position, long id) {
                // Finds current position in content array
                Content currentAttraction = contents.get(position);
                Context context = v.getContext();
                Intent intent = new Intent(context, AttractionDetailsActivity.class);

                // Sends name, summary, address, telephone and large attraction image (if there is one) to next activity
                intent.putExtra("name", currentAttraction.getmAttractionName());
                intent.putExtra("summary", currentAttraction.getmAttractionSummary());
                intent.putExtra("address", currentAttraction.getmAttractionAddress());
                intent.putExtra("imageLarge", currentAttraction.getmAttractionImageResourceId());
                intent.putExtra("phone", currentAttraction.getmAttractionPhone());
                intent.putExtra("website", currentAttraction.getmAttractionWebsite());
                intent.putExtra("latitude", currentAttraction.getmLatitudeId());
                intent.putExtra("longitude", currentAttraction.getmLongitudeId());

                startActivity(intent);
            }
        });

        return rootView;
    }

}
