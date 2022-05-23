package com.example.foodizone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.foodizone.customerFoodPanel.CustomerCartFragment;
import com.example.foodizone.customerFoodPanel.CustomerHomeFragment;
import com.example.foodizone.customerFoodPanel.CustomerOrdersFragment;
import com.example.foodizone.customerFoodPanel.CustomerProfileFragment;
import com.example.foodizone.customerFoodPanel.CustomerTrackFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CustomerFoodPanel_BottomNavigation extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_food_panel_bottom_navigation);

        BottomNavigationView navigationView = findViewById(R.id.bottom_navigation);
        navigationView.setOnNavigationItemSelectedListener(this::onNavigationItemSelected);

        String name = getIntent().getStringExtra("PAGE");
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (name != null) {
            if (name.equalsIgnoreCase("Homepage")) {
                loadFragment(new CustomerHomeFragment());
            } else if (name.equalsIgnoreCase("Preparingpage")) {
                loadFragment(new CustomerTrackFragment());
            } else if (name.equalsIgnoreCase("Preparedpage")) {
                loadFragment(new CustomerTrackFragment());
            } else if (name.equalsIgnoreCase("DeliverOrderpage")) {
                loadFragment(new CustomerTrackFragment());
            } else if (name.equalsIgnoreCase("ThankYoupage")) {
                loadFragment(new CustomerHomeFragment());
            }
        } else {
            loadFragment(new CustomerHomeFragment());
        }
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Fragment fragment = null;
        switch (item.getItemId()) {
            case R.id.cust_Home:
                fragment = new CustomerHomeFragment();
                break;


            case R.id.cart:
                fragment = new CustomerCartFragment();
                break;

            case R.id.cust_order:
                fragment = new CustomerOrdersFragment();
                break;

            case R.id.cust_track:
                fragment = new CustomerTrackFragment();
                break;

            case R.id.cust_profile:
                fragment = new CustomerProfileFragment();
                break;

        }
        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
            return true;
        }
        return false;
    }

}