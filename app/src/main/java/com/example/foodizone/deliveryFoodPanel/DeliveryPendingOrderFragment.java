package com.example.foodizone.deliveryFoodPanel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.foodizone.R;

public class DeliveryPendingOrderFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        getActivity().setTitle("Pending Orders");
        View v = inflater.inflate(R.layout.fragment_deliverypendingorder, null);
        return v;
    }
}
