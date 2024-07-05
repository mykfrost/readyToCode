package com.example.android.readytocode;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.android.readytocode.models.DataItem;
import com.example.android.readytocode.sample.SampleDataProvider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CustomAdapter extends AppCompatActivity {
    List<DataItem> dataItemList = SampleDataProvider.dataItemList;
    List<String> itemNames = new ArrayList<>();
    ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_custom_adapter);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Sorting the data items
        Collections.sort(dataItemList, new Comparator<DataItem>() {
            @Override
            public int compare(DataItem o1, DataItem o2) {
                return o1.getItemName().compareTo(o2.getItemName());
            }
        });
        //Code for the custom listview
        DataItemAdapter adapter = new DataItemAdapter(this,dataItemList);
        listview = findViewById(android.R.id.list);
        listview.setAdapter(adapter);


    }
}