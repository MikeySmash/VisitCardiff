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
public class ToSeeFragment extends Fragment {

    public ToSeeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.category_list, container, false);

        // Create a list of content for each attraction
        final ArrayList<Content> contents = new ArrayList<Content>();
        contents.add(new Content(
                R.string.name_cardiff_castle,
                R.string.summary_cardiff_castle,
                R.string.address_cardiff_castle,
                R.string.phone_cardiff_castle,
                R.drawable.cardiff_castle_large,
                R.drawable.cardiff_castle_small,
                R.string.website_cardiff_castle,
                R.string.latitude_cardiff_castle,
                R.string.longitude_cardiff_castle));
        contents.add(new Content(
                R.string.name_principality,
                R.string.summary_principality,
                R.string.address_principality,
                R.string.phone_principality,
                R.drawable.principality_large,
                R.drawable.principality_small,
                R.string.website_principality,
                R.string.latitude_principality,
                R.string.longitude_principality));
        contents.add(new Content(
                R.string.name_stfagans,
                R.string.summary_stfagans,
                R.string.address_stfagans,
                R.string.phone_stfagans,
                R.drawable.stfagans_large,
                R.drawable.stfagans_small,
                R.string.website_stfagans,
                R.string.latitude_stfagans,
                R.string.longitude_stfagans));
        contents.add(new Content(
                R.string.name_millennium,
                R.string.summary_millennium,
                R.string.address_millennium,
                R.string.phone_millennium,
                R.drawable.millennium_large,
                R.drawable.millennium_small,
                R.string.website_millennium,
                R.string.latitude_millennium,
                R.string.longitude_millennium));
        contents.add(new Content(
                R.string.name_castell_coch,
                R.string.summary_castell_coch,
                R.string.address_castell_coch,
                R.string.phone_castell_coch,
                R.drawable.castell_coch_large,
                R.drawable.castell_coch_small,
                R.string.website_castell_coch,
                R.string.latitude_castell_coch,
                R.string.longitude_castell_coch));
        contents.add(new Content(
                R.string.name_museum,
                R.string.summary_museum,
                R.string.address_museum,
                R.string.phone_museum,
                R.drawable.museum_large,
                R.drawable.museum_small,
                R.string.website_museum,
                R.string.latitude_museum,
                R.string.longitude_museum));

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
