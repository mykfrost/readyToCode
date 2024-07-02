package com.example.android.readytocode;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.android.readytocode.models.DataItem;
import com.example.android.readytocode.sample.SampleDataProvider;

import java.util.List;

public class MainActivity extends AppCompatActivity {
TextView tvOut ;
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
//        DataItem item = new DataItem(null ,"Item Name","A description",
//                "A category",1,6.78,"bishop.jpg");
        tvOut.setText("");
        for (DataItem item: dataItemList) {
            tvOut.append(item.getItemName()+"\n");
        }
    }
}