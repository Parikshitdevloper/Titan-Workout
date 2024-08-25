package parikshit.chavhan.titanworkout.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import parikshit.chavhan.titanworkout.Activity.WorkoutActivity;
import parikshit.chavhan.titanworkout.Domain.Workout;
import parikshit.chavhan.titanworkout.databinding.ViewholderWorkoutBinding;

public class WorkoutAdaptere extends RecyclerView.Adapter<WorkoutAdaptere.Viewholder> {
    private final ArrayList<Workout> list;
    private Context context;

    public WorkoutAdaptere(ArrayList<Workout> data) {
        this.list=data;
    }


    @NonNull
    @Override
    public WorkoutAdaptere.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        ViewholderWorkoutBinding binding=ViewholderWorkoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new Viewholder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder viewholder, int position) {
        viewholder.binding.titleTxt.setText(list.get(position).getTitle());
        int resId=context.getResources().getIdentifier(list.get(position).getPicPath(),"drawable",context.getPackageName());

        Glide.with(viewholder.itemView.getContext())
                .load(resId)
                .into(viewholder.binding.pic);
        viewholder.binding.excerciseTxt.setText(list.get(position).getLessions().size()+" Exercise");
        viewholder.binding.kcalTxt.setText(list.get(position).getKcal()+" kcal");
        viewholder.binding.duration.setText(list.get(position).getDuration());

        viewholder.binding.getRoot().setOnClickListener(v -> {
            Intent intent = new Intent(context, WorkoutActivity.class);
            intent.putExtra("object",list.get(position));
            context.startActivity(intent);

        });

    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        ViewholderWorkoutBinding binding;
        public Viewholder(ViewholderWorkoutBinding binding) {
            super(binding.getRoot());
            this.binding=binding;

        }
    }
}
