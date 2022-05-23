package com.example.foodizone.customerFoodPanel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.foodizone.R;
import com.example.foodizone.chefFoodPanel.UpdateDishModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;



public class CustomerHomeFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {


        RecyclerView recyclerView;
        private List<UpdateDishModel> updateDishModelList;
        private CustomerHomeAdapter adapter;
        String State, City, Area;
        DatabaseReference dataaa, databaseReference;
        SwipeRefreshLayout swipeRefreshLayout;
      //  SearchView searchView;


        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.fragment_customerhome,null);
            getActivity().setTitle("Home");
            setHasOptionsMenu(true);
            recyclerView = v.findViewById(R.id.recycle_menu);
            recyclerView.setHasFixedSize(true);
            Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.move);
            recyclerView.startAnimation(animation);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            updateDishModelList = new ArrayList<>();
            swipeRefreshLayout = (SwipeRefreshLayout) v.findViewById(R.id.swipelayout);
            swipeRefreshLayout.setOnRefreshListener(this);
            swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimaryDark, R.color.green);


            swipeRefreshLayout.post(new Runnable() {
                @Override
                public void run() {
                    swipeRefreshLayout.setRefreshing(true);
                    String userid = FirebaseAuth.getInstance().getCurrentUser().getUid();
                    dataaa = FirebaseDatabase.getInstance().getReference("Customer").child(userid);
                    dataaa.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            Customer cust = dataSnapshot.getValue(Customer.class);
                            State = cust.getState();
                            City = cust.getCity();
                            Area = cust.getArea();
                            customermenu();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
            });

            return v;
        }


        @Override
        public void onRefresh() {

            customermenu();
        }

        private void customermenu() {

            swipeRefreshLayout.setRefreshing(true);
            databaseReference = FirebaseDatabase.getInstance().getReference("FoodSupplyDetails").child(State).child(City).child(Area);
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    updateDishModelList.clear();
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                            UpdateDishModel updateDishModel = snapshot1.getValue(UpdateDishModel.class);
                            updateDishModelList.add(updateDishModel);
                        }
                    }
                    adapter = new CustomerHomeAdapter(getContext(), updateDishModelList);
                    recyclerView.setAdapter(adapter);
                    swipeRefreshLayout.setRefreshing(false);

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                    swipeRefreshLayout.setRefreshing(false);
                }
            });


        }

        private void search(final String searchtext) {

            ArrayList<UpdateDishModel> mylist = new ArrayList<>();
            for (UpdateDishModel object : updateDishModelList) {
                if (object.getDishes().toLowerCase().contains(searchtext.toLowerCase())) {
                    mylist.add(object);
                }
            }
            adapter = new CustomerHomeAdapter(getContext(), mylist);
            recyclerView.setAdapter(adapter);

        }



    }



