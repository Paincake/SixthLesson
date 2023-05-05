package ru.mirea.ryazhevilya.sixthlesson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import ru.mirea.ryazhevilya.sixthlesson.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sharedPref =
                getSharedPreferences("mirea_settings", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        String groupName = sharedPref.getString("GROUP", "unknown");
        int listNumber = sharedPref.getInt("NUMBER", 0);
        String series = sharedPref.getString("SERIES", "unknown");
        if(!groupName.equals("unknown") || listNumber != 0 || !series.equals("unknown")){
            binding.editTextTextGroupNumber.setText(groupName);
            binding.editTextTextPersonListNumber.setText(String.valueOf(listNumber));
            binding.editTextTextPersonSeries.setText(series);
        }
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("GROUP", binding.editTextTextGroupNumber.getText().toString());
                editor.putInt("NUMBER", Integer.parseInt(binding.editTextTextPersonListNumber.getText().toString()));
                editor.putString("SERIES", binding.editTextTextPersonSeries.getText().toString());
                editor.apply();
            }
        });
    }
}