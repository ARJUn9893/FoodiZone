package com.example.foodizone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.foodizone.customerFoodPanel.CustomerCartFragment;
import com.example.foodizone.customerFoodPanel.CustomerHomeFragment;
import com.example.foodizone.customerFoodPanel.CustomerOrdersFragment;
import com.example.foodizone.customerFoodPanel.CustomerProfileFragment;
import com.example.foodizone.customerFoodPanel.CustomerTrackFragment;
import com.example.foodizone.deliveryFoodPanel.DeliveryPendingOrderFragment;
import com.example.foodizone.deliveryFoodPanel.DeliveryShipOrderFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Delivery_FoodPanelBottomNavigation extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_food_panel_bottom_navigation);

        BottomNavigationView navigationView = findViewById(R.id.delivery_bottom_navigation);
        navigationView.setOnNavigationItemSelectedListener(this::onNavigationItemSelected);

        String name = getIntent().getStringExtra("PAGE");
        if (name != null) {
            if (name.equalsIgnoreCase("DeliveryOrderpage"))
            {
                loaddeliveryFragment(new DeliveryPendingOrderFragment());
            }

        } else {
            loaddeliveryFragment(new DeliveryPendingOrderFragment());
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Fragment fragment = null;
        switch (item.getItemId()) {

            case R.id.shiporders:
                fragment = new DeliveryShipOrderFragment();
                break;

            case R.id.pendingorders:
                fragment = new DeliveryPendingOrderFragment();
                break;

        }
        return loaddeliveryFragment(fragment);
    }

    private boolean loaddeliveryFragment(Fragment fragment) {

        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
            return true;
        }
        return false;
    }
}