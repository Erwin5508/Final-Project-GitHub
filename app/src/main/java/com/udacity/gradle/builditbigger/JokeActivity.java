package com.udacity.gradle.builditbigger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.udacity.gradle.builditbigger.R;

public class JokeActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        textView = (TextView) findViewById(R.id.textview);
        textView.setText(getIntent().getStringExtra("joke"));
    }
}
