package com.youngsoft.climblog.ui.activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.youngsoft.climblog.R;
import com.youngsoft.climblog.data.ClimbLog;

import org.w3c.dom.Text;

import java.util.List;

public class AdapterActivityList extends ListAdapter<ClimbLog, AdapterActivityList.ClimbLogHolder> {

    private static final DiffUtil.ItemCallback<ClimbLog> DIFF_CALLBACK = new DiffUtil.ItemCallback<ClimbLog>() {
        @Override
        public boolean areItemsTheSame(@NonNull ClimbLog oldItem, @NonNull ClimbLog newItem) {
            return false;
        }

        @Override
        public boolean areContentsTheSame(@NonNull ClimbLog oldItem, @NonNull ClimbLog newItem) {
            return false;
        }
    };

    public AdapterActivityList() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public ClimbLogHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //create the viewHolder
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_climblog, parent, false);
        return new AdapterActivityList.ClimbLogHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ClimbLogHolder holder, int position) {

        //get the date for this position in the list
        ClimbLog currentClimbLog = getItem(position);
        holder.tvClimbId.setText("" + currentClimbLog.getId());
        holder.tvClimbDate.setText("" + currentClimbLog.getDate());;
        holder.tvClimbName.setText("" + currentClimbLog.getName());;
        holder.tvClimbLocation.setText("" + currentClimbLog.getLocation());;
        holder.tvGradeType.setText("" + currentClimbLog.getGradeTypeCode());;
        holder.tvGradeValue.setText("" + currentClimbLog.getGradeValueCode());;
        holder.tvAscentType.setText("" + currentClimbLog.getAscentTypeCode());;
        holder.tvClimbDiscipline.setText("" + currentClimbLog.getClimbDisciplineCode());;
    }


    public class ClimbLogHolder extends RecyclerView.ViewHolder{

        TextView tvClimbId;
        TextView tvClimbDate;
        TextView tvClimbName;
        TextView tvClimbLocation;
        TextView tvGradeType;
        TextView tvGradeValue;
        TextView tvAscentType;
        TextView tvClimbDiscipline;

        public ClimbLogHolder(@NonNull View itemView) {
            super(itemView);
            tvClimbId=itemView.findViewById(R.id.tv_climb_id);
            tvClimbDate=itemView.findViewById(R.id.tv_climb_date);
            tvClimbName=itemView.findViewById(R.id.tv_climb_name);
            tvClimbLocation=itemView.findViewById(R.id.tv_climb_location);
            tvGradeType=itemView.findViewById(R.id.tv_grade_type);
            tvGradeValue=itemView.findViewById(R.id.tv_grade_value);
            tvAscentType=itemView.findViewById(R.id.tv_ascent_type);
            tvClimbDiscipline=itemView.findViewById(R.id.tv_climb_id);
        }
    }

}
