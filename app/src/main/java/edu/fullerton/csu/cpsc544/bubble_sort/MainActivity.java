package edu.fullerton.csu.cpsc544.bubble_sort;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        List <Integer> nums = new ArrayList<>();
        GenerateRandomNumbers(nums);

        SpannableStringBuilder content = new SpannableStringBuilder();

        for(Integer i : nums)
            content.append(i.toString()).append(" ");
        TextView view = findViewById(R.id.num_view);
        view.setText(content);
    }



    private void GenerateRandomNumbers(List <Integer> nums)
    {
        Random rnd = new Random();
        for(int i = 0; i < 10; i++)
            nums.add(rnd.nextInt(1000));
        //Collections.shuffle(nums);
    }
}