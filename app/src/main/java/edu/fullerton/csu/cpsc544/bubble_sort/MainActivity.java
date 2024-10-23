package edu.fullerton.csu.cpsc544.bubble_sort;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.fullerton.csu.cpsc544.bubble_sort.algorithm.BubbleSort;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.order_type), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        List <Integer> nums = new ArrayList<>();

        Button generate_numbers = findViewById(R.id.generate_random_button);
        generate_numbers.setOnClickListener(v -> {
            GenerateRandomNumbersButton(nums);
        });

        Button submit = findViewById(R.id.submit);
        submit.setOnClickListener(v -> {
            handleUserInput(nums);
        });

    }

    // User input
    public void handleUserInput(List <Integer> nums)
    {
        nums = ConvertUserInputStringToList();
        UserInputErrorCheck(nums, GetRange());

        TextView view = findViewById(R.id.output_view);
        SpannableStringBuilder content = new SpannableStringBuilder();

        @SuppressLint("UseSwitchCompatOrMaterialCode") Switch tgl
                = findViewById(R.id.ascending_or_descending);

        BubbleSort bubblesort = new BubbleSort();

        if(tgl.isChecked()) BubbleSort.ascending(nums);
        else BubbleSort.descending(nums);

        content.append(bubblesort.toString());

        view.setText(content);
    }

    @SuppressLint("SetTextI18n")
    private void GenerateRandomNumbersButton(List <Integer> nums)
    {
        // TextView rangeInput = findViewById(R.id.range_input);
        int rng = GetRange();

        // Check handled in GetRange()
        /*
        if(rng < 3 || rng > 8)
            rng = GenerateNumbers(3, 8);

        rangeInput.setText(Integer.toString(rng));
        */

        nums.clear();
        for(int i = 0; i < rng; i++)
            nums.add(GenerateNumbers(-10000, 10000));

        SetUserInputText(nums);
    }

    private Integer GenerateNumbers(int min, int max)
    {
        return (int) ((Math.random() * (max - min)) + min);
    }

    private List<Integer> ConvertUserInputStringToList()
    {
        TextView list = findViewById(R.id.num_array);
        String str = list.getText().toString();
        List <Integer> result = new ArrayList<>();

        str = str.replaceAll("[+.^:,]"," ");

       Scanner scanner = new Scanner(str);
       while(scanner.hasNextInt())
           result.add(scanner.nextInt());

       if(result.isEmpty())
           GenerateRandomNumbersButton(result);

        TextView rangeInput = findViewById(R.id.range_input);
        UserInputErrorCheck(result, Integer.parseInt(rangeInput.getText().toString()));

        SetUserInputText(result);

        return result;
    }

    private void UserInputErrorCheck(List <Integer> result, int rng)
    {
        if(result.size() < rng)
            for(int i = result.size(); i < rng; i++)
                result.add(GenerateNumbers(-10000, 10000));

        while(result.size() > rng)
            for(int i = rng; i < result.size(); i++)
                result.remove(result.size() - 1);

        while(result.size() < 3)
            result.add(GenerateNumbers(-10000, 10000));

        while(result.size() > 8)
            result.remove(result.size() - 1);
    }

    private void SetUserInputText(List <Integer> nums)
    {
        TextView userInputField = findViewById(R.id.num_array);
        userInputField.setText(" ");

        SpannableStringBuilder content = new SpannableStringBuilder();
        for(int i = 0; i < nums.size(); i++)
            content.append(nums.get(i).toString()).append(i < nums.size() - 1 ? ", " : " ");

        userInputField.setText(content);
    }

    public void SetToggleText(View v)
    {
        @SuppressLint("UseSwitchCompatOrMaterialCode") Switch tgl
                = findViewById(R.id.ascending_or_descending);
        tgl.setText(getResources().getString(
                tgl.isChecked() ? R.string.ascending :
                        R.string.descending));
    }

    @SuppressLint("SetTextI18n")
    public Integer GetRange()
    {
        TextView rangeInput = findViewById(R.id.range_input);
        String result = rangeInput.getText().toString();
        int rng = result.matches("") ? GenerateNumbers(3, 8)
                : Integer.parseInt(rangeInput.getText().toString());

        // Error popup for input != [3, 8]
        if (rng < 3 || rng > 8) {
            Toast.makeText(this, "Warning: Input must be a number between 3 and 8.", Toast.LENGTH_LONG).show();
            if (rng < 3) rng = 3;
            else rng = 8;
            rangeInput.setText(Integer.toString(rng));
        }

        return rng;
    }
}