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
public class ToEatFragment extends Fragment {

    public ToEatFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.category_list, container, false);

        // Create a list of content for each attraction
        final ArrayList<Content> contents = new ArrayList<Content>();
        contents.add(new Content(
                R.string.name_ffresh,
                R.string.summary_ffresh,
                R.string.address_ffresh,
                R.string.phone_ffresh,
                R.drawable.ffresh_large,
                R.drawable.ffresh_small,
                R.string.website_ffresh,
                R.string.latitude_ffresh,
                R.string.longitude_ffresh));
        contents.add(new Content(
                R.string.name_anatonis,
                R.string.summary_anatonis,
                R.string.address_anatonis,
                R.string.phone_anatonis,
                R.drawable.anatonis_large,
                R.drawable.anatonis_small,
                R.string.website_anatonis,
                R.string.latitude_anatonis,
                R.string.longitude_anatonis));
        contents.add(new Content(
                R.string.name_madame_fromage,
                R.string.summary_madame_fromage,
                R.string.address_madame_fromage,
                R.string.phone_madame_fromage,
                R.drawable.madame_fromage_large,
                R.drawable.madame_fromage_small,
                R.string.website_madame_fromage,
                R.string.latitude_madame_fromage,
                R.string.longitude_madame_fromage));
        contents.add(new Content(
                R.string.name_potted_pig,
                R.string.summary_potted_pig,
                R.string.address_potted_pig,
                R.string.phone_potted_pig,
                R.drawable.potted_pig_large,
                R.drawable.potted_pig_small,
                R.string.website_potted_pig,
                R.string.latitude_potted_pig,
                R.string.longitude_potted_pig));
        contents.add(new Content(
                R.string.name_cafe_citta,
                R.string.summary_cafe_citta,
                R.string.address_cafe_citta,
                R.string.phone_cafe_citta,
                R.drawable.cafe_citta_large,
                R.drawable.cafe_citta_small,
                R.string.website_cafe_citta,
                R.string.latitude_cafe_citta,
                R.string.longitude_cafe_citta));
        contents.add(new Content(
                R.string.name_purple_poppadom,
                R.string.summary_purple_poppadom,
                R.string.address_purple_poppadom,
                R.string.phone_purple_poppadom,
                R.drawable.purple_poppadom_large,
                R.drawable.purple_poppadom_small,
                R.string.website_purple_poppadom,
                R.string.latitude_purple_poppadom,
                R.string.longitude_purple_poppadom));

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
