package com.example.store;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.store.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityMainBinding acivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        LoginVM loginVM = new LoginVM(this);
        acivityMainBinding.setLoginVM(loginVM);

    }

}