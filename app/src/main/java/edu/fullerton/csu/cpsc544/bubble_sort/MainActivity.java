package edu.fullerton.csu.cpsc544.bubble_sort;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
            GenerateRandomNumbers(nums);
        });

        Button submit = findViewById(R.id.submit);
        submit.setOnClickListener(v -> {
            handleUserInput(nums);
        });

        BubbleSort bubbleSort = new BubbleSort();
    }

    // User input
    public void handleUserInput(List <Integer> nums)
    {
        nums = ConvertUserInputStringToList();
        TextView view = findViewById(R.id.output_view);
        SpannableStringBuilder content = new SpannableStringBuilder();
        for(int i = 0; i < nums.size(); i++)
            content.append(nums.get(i).toString()).append(" ");

        view.setText(content);
    }

    private void GenerateRandomNumbers(List <Integer> nums)
    {
        TextView rangeInput = findViewById(R.id.range_input);
        String result = rangeInput.getText().toString();
        int rng = result.matches("") ? 3
                : Integer.parseInt(rangeInput.getText().toString());

        rangeInput.setText(Integer.toString(rng));

        Random rnd = new Random();

        nums.clear();
        for(int i = 0; i < rng; i++)
            nums.add(rnd.nextInt(1000));

        SetUserInputText(nums);
    }

    private List<Integer> ConvertUserInputStringToList()
    {
        TextView list = findViewById(R.id.num_array);
        String str = list.getText().toString();
        List <Integer> result = new ArrayList<>();

        str = str.replaceAll("[-+.^:,]"," ");

       Scanner scanner = new Scanner(str);
       while(scanner.hasNextInt())
           result.add(scanner.nextInt());

        return result;
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
}