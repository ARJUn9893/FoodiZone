package com.example.foodizone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.ClipData;
import android.os.Bundle;
import android.view.MenuItem;

//import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.example.foodizone.chefFoodPanel.ChefHomeFragment;
import com.example.foodizone.chefFoodPanel.ChefOrderFragment;
import com.example.foodizone.chefFoodPanel.ChefPendingOrderFragment;
import com.example.foodizone.chefFoodPanel.ChefProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import com.google.android.material.navigation.NavigationView;

public class  ChefFoodPanel_BottomNavigation extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef_food_panel_bottom_navigation);
        BottomNavigationView navigationView= findViewById(R.id.chef_bottom_navigation);
        navigationView.setOnNavigationItemSelectedListener(this::onNavigationItemSelected);


        String name = getIntent().getStringExtra("PAGE");
        if (name != null) {
            if (name.equalsIgnoreCase("Orderpage")) {
                loadcheffragment(new ChefPendingOrderFragment());
            } else if (name.equalsIgnoreCase("Confirmpage")) {
                loadcheffragment(new ChefOrderFragment());
            } else if (name.equalsIgnoreCase("AcceptOrderpage")) {
                loadcheffragment(new ChefHomeFragment());
            } else if (name.equalsIgnoreCase("Deliveredpage")) {
                loadcheffragment(new ChefHomeFragment());
            }
        } else {
            loadcheffragment(new ChefHomeFragment());
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()) {
            case R.id.chefHome:
                fragment = new ChefHomeFragment();
                break;

            case R.id.PendingOrders:
                fragment = new ChefPendingOrderFragment();
                break;

            case R.id.Orders:
                fragment = new ChefOrderFragment();
                break;
            case R.id.chefProfile:
                fragment = new ChefProfileFragment();
                break;
        }
        return loadcheffragment(fragment);
        
    }

    private boolean loadcheffragment(Fragment fragment) {

        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
            return true;
        }

        return false;
    }
}