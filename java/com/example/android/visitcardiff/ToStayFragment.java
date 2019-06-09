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
public class ToStayFragment extends Fragment {

    public ToStayFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.category_list, container, false);

        // Create a list of content for each attraction
        final ArrayList<Content> contents = new ArrayList<Content>();
        contents.add(new Content(
                R.string.name_park_plaza,
                R.string.summary_park_plaza,
                R.string.address_park_plaza,
                R.string.phone_park_plaza,
                R.drawable.park_plaza_large,
                R.drawable.park_plaza_small,
                R.string.website_park_plaza,
                R.string.latitude_park_plaza,
                R.string.longitude_park_plaza));
        contents.add(new Content(
                R.string.name_hilton,
                R.string.summary_hilton,
                R.string.address_hilton,
                R.string.phone_hilton,
                R.drawable.hilton_large,
                R.drawable.hilton_small,
                R.string.website_hilton,
                R.string.latitude_hilton,
                R.string.longitude_hilton));
        contents.add(new Content(
                R.string.name_stdavids,
                R.string.summary_stdavids,
                R.string.address_stdavids,
                R.string.phone_stdavids,
                R.drawable.stdavids_large,
                R.drawable.stdavids_small,
                R.string.website_stdavids,
                R.string.latitude_stdavids,
                R.string.longitude_stdavids));
        contents.add(new Content(
                R.string.name_clayton,
                R.string.summary_clayton,
                R.string.address_clayton,
                R.string.phone_clayton,
                R.drawable.clayton_large,
                R.drawable.clayton_small,
                R.string.website_clayton,
                R.string.latitude_clayton,
                R.string.longitude_clayton));
        contents.add(new Content(
                R.string.name_mercure,
                R.string.summary_mercure,
                R.string.address_mercure,
                R.string.phone_mercure,
                R.drawable.mercure_large,
                R.drawable.mercure_small,
                R.string.website_mercure,
                R.string.latitude_mercure,
                R.string.longitude_mercure));
        contents.add(new Content(
                R.string.name_lincoln,
                R.string.summary_lincoln,
                R.string.address_lincoln,
                R.string.phone_lincoln,
                R.drawable.lincoln_large,
                R.drawable.lincoln_small,
                R.string.website_lincoln,
                R.string.latitude_lincoln,
                R.string.longitude_lincoln));

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
