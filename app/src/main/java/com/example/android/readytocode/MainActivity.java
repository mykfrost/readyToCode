package com.example.android.readytocode;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.android.readytocode.models.DataItem;
import com.example.android.readytocode.sample.SampleDataProvider;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
TextView tvOut ;
Button next , customadapter;
List<DataItem> dataItemList = SampleDataProvider.dataItemList;

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

        tvOut = findViewById(R.id.tv_out);
        next = findViewById(R.id.buttonList);
        customadapter = findViewById(R.id.buttonCustomdapter);
//        DataItem item = new DataItem(null ,"Item Name","A description",
//                "A category",1,6.78,"bishop.jpg");
        tvOut.setText("");
        //sorting the data alphabetically
        Collections.sort(dataItemList, new Comparator<DataItem>() {
            @Override
            public int compare(DataItem o1, DataItem o2) {
                return o1.getItemName().compareTo(o2.getItemName());
            }
        });
        for (DataItem item: dataItemList) {
            tvOut.append(item.getItemName()+"\n");
        }

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(getApplicationContext(),MyListViewActivity.class);
                startActivity(next);
                Toast.makeText(getApplicationContext(),"Next Activity",Toast.LENGTH_SHORT).show();
            }
        });

        customadapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent custom  = new Intent(getApplicationContext(), CustomAdapter.class);
                startActivity(custom);
            }
        });
    }
}