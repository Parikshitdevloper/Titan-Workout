package parikshit.chavhan.titanworkout.Adapter;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import parikshit.chavhan.titanworkout.Domain.Lession;
import parikshit.chavhan.titanworkout.databinding.ViewholderExerciseBinding;
import parikshit.chavhan.titanworkout.databinding.ViewholderWorkoutBinding;

public class LessionsAdapter extends RecyclerView.Adapter<LessionsAdapter.Viewholder> {

    private final ArrayList<Lession> list;
    private Context context;

    public LessionsAdapter(ArrayList<Lession> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public LessionsAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        ViewholderExerciseBinding binding= ViewholderExerciseBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new Viewholder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull LessionsAdapter.Viewholder holder, int position) {
        holder.binding.titleTxt.setText(list.get(position).getTitile());
        holder.binding.duration.setText(list.get(position).getDuration());

        int resId=context.getResources().getIdentifier(list.get(position).getPicPath(),"drawable",context.getPackageName());
        Glide.with(context)
                .load(resId)
                .into(holder.binding.pic);

        holder.binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent appIntent= new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:"+list.get(position).getLink()));
                Intent webIntent= new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.youtube.com/watch?v="+list.get(position).getLink()));

                try{

                }catch (ActivityNotFoundException ex){
                    context.startActivity(webIntent);
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    ViewholderExerciseBinding binding;
    public class Viewholder extends RecyclerView.ViewHolder {
        ViewholderExerciseBinding binding;
        public Viewholder(ViewholderExerciseBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
