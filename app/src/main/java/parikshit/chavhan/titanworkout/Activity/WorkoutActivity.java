package parikshit.chavhan.titanworkout.Activity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bumptech.glide.Glide;

import parikshit.chavhan.titanworkout.Adapter.LessionsAdapter;
import parikshit.chavhan.titanworkout.Domain.Workout;
import parikshit.chavhan.titanworkout.R;
import parikshit.chavhan.titanworkout.databinding.ActivityWorkoutBinding;

public class WorkoutActivity extends AppCompatActivity {
    ActivityWorkoutBinding binding;
    private Workout workout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityWorkoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        getObject();
        setVariable();

    }

    private void getObject() {
        workout= (Workout) getIntent().getSerializableExtra("object");
    }

    private void setVariable() {
        int resId=getResources().getIdentifier(workout.getPicPath(),"drawable",getPackageName());
        Glide.with(this)
                .load(resId)
                .into(binding.pic);
        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        binding.titleTxt.setText(workout.getTitle());
        binding.excerciseTxt.setText(workout.getLessions().size()+" Exercise");
        binding.kcalTxt.setText(workout.getKcal()+" Kcal");
        binding.descriptionTxt.setText(workout.getDescription());
        binding.duration.setText(workout.getDuration());
        binding.view3.setLayoutManager(new LinearLayoutManager(WorkoutActivity.this,LinearLayoutManager.VERTICAL,false));
        binding.view3.setAdapter(new LessionsAdapter(workout.getLessions()));

    }
}