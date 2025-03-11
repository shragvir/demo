package com.example.app1;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ImageView imageView1;
    Button addview;

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
        imageView1=(ImageView)findViewById(R.id.imageView1);
        addview = findViewById(R.id.button);

        addview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable.ConstantState imgID = imageView1.getDrawable().getConstantState();
                Drawable.ConstantState imgID2 = getDrawable(R.drawable.cupcake).getConstantState();
                if(imgID==imgID2)
                {
                    imageView1.setImageResource(R.drawable.hapybday);
                }
                else
                    imageView1.setImageResource(R.drawable.cupcake);
            }
        });

    }
}