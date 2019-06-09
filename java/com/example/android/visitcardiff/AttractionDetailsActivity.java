package com.example.android.visitcardiff;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AttractionDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction_details);

        //collect our intent data to populate our layout
        Intent intent = getIntent();
        final Integer name = intent.getExtras().getInt("name");
        final Integer summary = intent.getExtras().getInt("summary");
        final Integer address = intent.getExtras().getInt("address");
        final Integer phone = intent.getExtras().getInt("phone");
        final Integer imageLarge = intent.getExtras().getInt("imageLarge");
        final Integer website = intent.getExtras().getInt("website");
        final Integer latitude = intent.getExtras().getInt("latitude");
        final Integer longitude = intent.getExtras().getInt("longitude");

        // Concatenates longitude and latitude for map location
        final String geoLocation = "geo:"+ getString(latitude) +","+getString(longitude)+"?q=Cardiff "  + getString(name) ;

        // Sets up toolbar
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Sets up collapsingToolbar
        CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(getString(name));

        // Sets the large image in the collapsible toolbar
        final ImageView imageView = findViewById(R.id.details_image);
        imageView.setImageResource(imageLarge);

        // Sets summary in About view
        TextView summaryView = findViewById(R.id.details_summary);
        summaryView.setText(summary);

        // Sets address in address view
        TextView addressView = findViewById(R.id.details_address);
        addressView.setText(address);

        View mapView = findViewById(R.id.go_to_map);
        // Opens map for current location using address view
        mapView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse(geoLocation);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                }
            }
        });

        // Sets telephone number in phone view
        TextView phoneView = findViewById(R.id.details_phone);
        phoneView.setText(phone);
        // Opens phone to call telephone number of attraction
        findViewById(R.id.go_to_phone).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", getString(phone), null)));
            }
        });

        // Sets website in website view
        TextView websiteView = findViewById(R.id.details_website);
        websiteView.setText(website);
        // Opens web browser for current attraction using website view
        findViewById(R.id.go_to_website).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webpage = Uri.parse(getString(website));
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

    }

}
