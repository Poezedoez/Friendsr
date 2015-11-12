package com.example.ragger.friendsr;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SingleDetails extends AppCompatActivity {

    String fullName;
    String description;
    int portrait;
    TextView tvFullName;
    TextView tvDescription;
    ImageView ivPortrait;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_details);

        this.tvFullName = (TextView) findViewById(R.id.tvFullName);
        this.tvDescription = (TextView) findViewById(R.id.tvDescription);
        this.ivPortrait = (ImageView) findViewById(R.id.ivPortait);

        // get content from previous activity
        Bundle extras = getIntent().getExtras();
        this.fullName = extras.getString("fullName");
        this.description = extras.getString("description");
        this.portrait = extras.getInt("portrait");

        // set values
        tvFullName.setText(fullName);
        tvDescription.setText(description);
        tvDescription.setMovementMethod(new ScrollingMovementMethod());
        ivPortrait.setImageResource(portrait);


    }

}
