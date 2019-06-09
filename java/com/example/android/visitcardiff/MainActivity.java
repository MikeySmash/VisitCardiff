package com.example.android.visitcardiff;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Displays a {@link ViewPager} where each page shows a different category.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Find view pager for fragment and create an adapter that knows which
         * fragment should be shown on each page
         */

        ViewPager viewPager = findViewById(R.id.viewpager);
        com.example.android.visitcardiff.CategoryAdapter adapter =
                new com.example.android.visitcardiff.CategoryAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);

        // Sets up custom toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
}