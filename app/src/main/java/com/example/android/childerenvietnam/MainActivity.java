package com.example.android.childerenvietnam;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    Dialog ThisDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
    }

    public void register(View v) {
        ThisDialog = new Dialog(MainActivity.this);
        ThisDialog.setTitle("Title");
        ThisDialog.setContentView(R.layout.dialog_register);

        final EditText Name = ThisDialog.findViewById(R.id.nameAccount);
        final EditText passwordOne = ThisDialog.findViewById(R.id.passwordOne);
        final EditText passwordTwo = ThisDialog.findViewById(R.id.passwordSeccond);

        Button saveDialog = ThisDialog.findViewById(R.id.saveDialog);


        Name.setEnabled(true);
        passwordOne.setEnabled(true);
        passwordTwo.setEnabled(true);
        saveDialog.setEnabled(true);

        ThisDialog.show();

    }





}

