package com.example.smarthomeapp.presentation.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.smarthomeapp.R;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        ButterKnife.bind(this);
    }

    protected abstract int getContentViewId();
}
