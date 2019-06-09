package com.example.android.visitcardiff;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ContentAdapter extends ArrayAdapter<Content>  {

    /**
     * Create a new {@link ContentAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param contents is the list of {@link Content} to be displayed.
     */
    public ContentAdapter(Context context, ArrayList<Content> contents) {
        super(context, 0, contents);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Content} object located at this position in the list
        Content currentAttraction = getItem(position);

        // Sets the name of the attraction in list_view.xml
        TextView nameTextView = listItemView.findViewById(R.id.name_view);
        nameTextView.setText(currentAttraction.getmAttractionName());

        // Sets the name of the attraction in list_view.xml
        TextView summaryTextView = listItemView.findViewById(R.id.summary_view);
        summaryTextView.setText(currentAttraction.getmAttractionSummary());

        // Sets the small image in listview if one is present
        ImageView imageView = listItemView.findViewById(R.id.image_attraction_view);
        if (currentAttraction.hasImage()) {
            imageView.setImageResource(currentAttraction.getmSmallImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(View.GONE);
        }

       // Return the whole list item layout
        return listItemView;
    }
}