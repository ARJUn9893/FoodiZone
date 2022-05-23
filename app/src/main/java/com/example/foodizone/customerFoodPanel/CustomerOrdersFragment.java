package com.example.foodizone.customerFoodPanel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.foodizone.R;

public class CustomerOrdersFragment extends Fragment {

    //TextView Pendingorder, Payableorder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        getActivity().setTitle("Orders");
        View v = inflater.inflate(R.layout.fragment_customerorders, null);
        return v;

    }
}
