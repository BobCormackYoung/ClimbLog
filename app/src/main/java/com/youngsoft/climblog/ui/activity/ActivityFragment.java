package com.youngsoft.climblog.ui.activity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.youngsoft.climblog.R;
import com.youngsoft.climblog.data.ClimbLog;

import java.util.List;

public class ActivityFragment extends Fragment {

    private ActivityViewModel activityViewModel;
    NavController navController;
    RecyclerView recyclerView;
    AdapterActivityList adapterActivityList;

    private static final String TAG = "Floating Action Button";
    private static final String TRANSLATION_Y = "translationY";
    private FloatingActionButton fab;
    private boolean expanded = false;
    private View fabAction1;
    private View fabAction2;
    private View fabAction3;
    private float offset1;
    private float offset2;
    private float offset3;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //root view
        View root = inflater.inflate(R.layout.fragment_activity, container, false);

        //get the viewModel for the fragment
        activityViewModel = ViewModelProviders.of(this).get(ActivityViewModel.class);

        //Find the recyclerView for showing the data & set it up
        recyclerView = root.findViewById(R.id.rv_fragment_activity);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);

        //swipe to delete
        //new ItemTouchHelper(itemTouchHelperCallbackDelete).attachToRecyclerView(recyclerView);

        adapterActivityList = new AdapterActivityList();
        recyclerView.setAdapter(adapterActivityList);

        activityViewModel.getAllClimbLogsSortedByDate().observe(getViewLifecycleOwner(), new Observer<List<ClimbLog>>() {
            @Override
            public void onChanged(List<ClimbLog> climbLogs) {
                adapterActivityList.submitList(climbLogs);
            }
        });


        return root;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //find the navController for the view
        navController = Navigation.findNavController(view);

        /**
        //find the floating action button and set up actions for it
        FloatingActionButton floatingActionButton = view.findViewById(R.id.fab_add_climb);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_navigation_activity_to_navigation_addOutdoorClimb);
            }
        });
         **/

        //find the viewgroup representing the float action buttons
        //then find the actual buttons themselves
        final ViewGroup fabContainer = view.findViewById(R.id.fab_container);
        fab = view.findViewById(R.id.fab);
        fabAction1 = view.findViewById(R.id.fab_action_1);
        fabAction2 = view.findViewById(R.id.fab_action_2);
        fabAction3 = view.findViewById(R.id.fab_action_3);

        //assign onClick listeners to the action buttons
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expanded = !expanded;
                if (expanded) {
                    expandFab();
                } else {
                    collapseFab();
                }
            }
        });
        fabAction1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("FAB TEST","fab1");
                navController.navigate(R.id.action_navigation_activity_to_navigation_addOutdoorClimb);
            }
        });
        fabAction2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("FAB TEST","fab2");
                navController.navigate(R.id.action_navigation_activity_to_navigation_addOutdoorClimb);
            }
        });
        fabAction3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("FAB TEST","fab3");
            }
        });

        //use onPreDrawListener to determine vertical offset position relative to FAB
        fabContainer.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                fabContainer.getViewTreeObserver().removeOnPreDrawListener(this);
                offset1 = fab.getY() - fabAction1.getY();
                fabAction1.setTranslationY(offset1);
                offset2 = fab.getY() - fabAction2.getY();
                fabAction2.setTranslationY(offset2);
                offset3 = fab.getY() - fabAction3.getY();
                fabAction3.setTranslationY(offset3);
                return true;
            }
        });


    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        //reset expanded status when resuming
        expanded = false;
    }

    /**
     * method to collapse the floating action button
     */
    private void collapseFab() {
        //update FAB to be the animated minus - contains the rotation animations and start/stop SVG
        fab.setImageResource(R.drawable.ic_animated_minus);
        //new animator set to handle collapsing the multiple FABs
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(createCollapseAnimator(fabAction1, offset1),
                createCollapseAnimator(fabAction2, offset2),
                createCollapseAnimator(fabAction3, offset3));
        //start animations
        animatorSet.start();
        animateFab();
    }

    /**
     * method to expand the floating action button
     */
    private void expandFab() {
        //update FAB to be the animated plus - contains the rotation animations and start/stop SVG
        fab.setImageResource(R.drawable.ic_animated_plus);
        //new animator set to handle collapsing the multiple FABs
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(createExpandAnimator(fabAction1, offset1),
                createExpandAnimator(fabAction2, offset2),
                createExpandAnimator(fabAction3, offset3));
        //start animations
        animatorSet.start();
        animateFab();
    }

    /**
     * Create an animator to collapse the FAB views based on the view & the required offset
     * @param view the view that needs animating
     * @param offset the translation offset value
     * @return
     */
    private Animator createCollapseAnimator(View view, float offset) {
        return ObjectAnimator.ofFloat(view, TRANSLATION_Y, 0, offset)
                .setDuration(getResources().getInteger(android.R.integer.config_mediumAnimTime));
    }

    /**
     * Create an animator to collapse the FAB views based on the view & the required offset
     * @param view the view that needs animating
     * @param offset the translation offset value
     * @return
     */
    private Animator createExpandAnimator(View view, float offset) {
        return ObjectAnimator.ofFloat(view, TRANSLATION_Y, offset, 0)
                .setDuration(getResources().getInteger(android.R.integer.config_mediumAnimTime));
    }

    /**
     * Animate the floating action button
     */
    private void animateFab() {
        //get the drawable for the floating action button. If it is animatable, start the animation
        Drawable drawable = fab.getDrawable();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }
    }

    /**
    //callback to handle swiping to delete an item
    ItemTouchHelper.SimpleCallback itemTouchHelperCallbackDelete = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {

        private ColorDrawable background = new ColorDrawable();
        private int backgroundColor = Color.parseColor("#f44336");

        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
            Log.i("AF","OnChildDraw " + viewHolder.getAdapterPosition() +
                    " item id " + adapterActivityList.getCurrentList().get(viewHolder.getAdapterPosition()).getId() +
                    " item name " + adapterActivityList.getCurrentList().get(viewHolder.getAdapterPosition()).getName());

            //TODO: https://medium.com/@kitek/recyclerview-swipe-to-delete-easier-than-you-thought-cff67ff5e5f6
            //TODO: https://codeburst.io/android-swipe-menu-with-recyclerview-8f28a235ff28

            View itemView = viewHolder.itemView;
            int itemHeight = itemView.getBottom() - itemView.getTop();
            int backgroundCornerOffset = 20;

            // Draw the red delete background
            if (dX < 0) {
                background.setColor(backgroundColor);
                background.setBounds(itemView.getRight() + Math.round(dX) - backgroundCornerOffset, itemView.getTop(), itemView.getRight(), itemView.getBottom());
            } else {
                background.setBounds(0, 0, 0, 0);
            }
            background.draw(c);

            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            Log.i("AF","onSwiped " + viewHolder.getAdapterPosition() +
                    " item id " + adapterActivityList.getCurrentList().get(viewHolder.getAdapterPosition()).getId() +
                    " item name " + adapterActivityList.getCurrentList().get(viewHolder.getAdapterPosition()).getName());
        }
    };
        **/
}
