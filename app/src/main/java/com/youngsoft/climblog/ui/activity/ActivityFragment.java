package com.youngsoft.climblog.ui.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.youngsoft.climblog.R;
import com.youngsoft.climblog.data.ClimbLog;

import java.util.List;

public class ActivityFragment extends Fragment {

    private ActivityViewModel activityViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //root view
        View root = inflater.inflate(R.layout.fragment_activity, container, false);

        //find the floating action button and set up actions for it
        FloatingActionButton floatingActionButton = root.findViewById(R.id.fab_add_climb);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //bottomSheet = new BottomSheetDialogAddSugar();
                //Bundle inputs = new Bundle();
                //inputs.putInt("EntryId",-1);
                //bottomSheet.setArguments(inputs);
                //bottomSheet.show(getChildFragmentManager(), "sugarBottomSheet");
            }
        });

        //get the viewModel for the fragment
        activityViewModel = ViewModelProviders.of(this).get(ActivityViewModel.class);

        //Find the recyclerView for showing the data & set it up
        final RecyclerView recyclerView = root.findViewById(R.id.rv_fragment_activity);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);

        final AdapterActivityList adapterActivityList = new AdapterActivityList();
        recyclerView.setAdapter(adapterActivityList);

        activityViewModel.getAllClimbLogsSortedByDate().observe(getViewLifecycleOwner(), new Observer<List<ClimbLog>>() {
            @Override
            public void onChanged(List<ClimbLog> climbLogs) {
                adapterActivityList.submitList(climbLogs);
            }
        });

        return root;
    }
}
