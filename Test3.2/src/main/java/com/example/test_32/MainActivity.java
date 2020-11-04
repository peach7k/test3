package com.example.test_32;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button DiologButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DiologButton = findViewById(R.id.dialog);
        DiologButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.activity_l_dialog,null);
                EditText etUser = view.findViewById(R.id.et_username);
                EditText etPass = view.findViewById(R.id.et_passward);
                Button Cancel = view.findViewById(R.id.et_cancel);
                Button login = view.findViewById(R.id.et_login);
                builder.setView(view).show();
            }
        });
    }

}
