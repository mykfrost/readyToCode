package com.example.android.readytocode;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.android.readytocode.models.DataItem;
import com.example.android.readytocode.sample.SampleDataProvider;

import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

//        String itemID = getIntent().getExtras().getString(DataItemAdapter.ITEM_ID_KEY);
//        DataItem item = SampleDataProvider.dataItemMap.get(itemID);

        DataItem item = Objects.requireNonNull(getIntent().getExtras()).getParcelable(DataItemAdapter.ITEM_KEY);

        if (item != null) {
            Toast.makeText(this,"Received Item " + item.getItemName(),Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this,"Didn't Receive any Data",Toast.LENGTH_SHORT).show();
        }
        TextView tvName = (TextView) findViewById(R.id.tvItemName);
        TextView tvPrice = (TextView) findViewById(R.id.tvPrice);
        TextView tvDescription = (TextView) findViewById(R.id.tvDescription);
        ImageView  itemImage = (ImageView) findViewById(R.id.itemImage);


        tvName.setText(item.getItemName());
        tvDescription.setText(item.getDescription());

        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.getDefault());
        tvPrice.setText(nf.format(item.getPrice()));

        InputStream inputStream = null;
        try {
            String imageFile = item.getImage();
            inputStream = getAssets().open(imageFile);
            Drawable d = Drawable.createFromStream(inputStream, null);
            itemImage.setImageDrawable(d);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}