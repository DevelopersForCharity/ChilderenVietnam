package com.example.android.childerenvietnam;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    Dialog ThisDialog;
    int LoginName = 0;
    int LoginPassword = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
    }

    /**
     * dialog
     */
    /**
     * button to get Dialog_register layout and generates the Dialog
     */

    public void register(View v) {
        ThisDialog = new Dialog(MainActivity.this);
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
    /**
     * button to save register dialog to SharedPreferences and on Login page
     */

    public void saveRegister(View v) {
        EditText Name = ThisDialog.findViewById(R.id.nameAccount);
        EditText password = ThisDialog.findViewById(R.id.passwordOne);

        SharedPrefName(Name.getText().toString());
        SharedPrefPassword(password.getText().toString());

        TextView nameLogin = findViewById(R.id.userNameLogin);
        TextView passwordLogin = findViewById(R.id.passwordLogin);


        SharedPreferences LoginPage = getApplicationContext().getSharedPreferences("ACCOUNT", 0);
        nameLogin.setText(LoginPage.getString("Account Name", null));
        passwordLogin.setText(LoginPage.getString("password", null));

        displayForAccountName(LoginName);
        displayForPassword(LoginPassword);

        ThisDialog.cancel();


    }
    /**
     * dialog ends
     */

    /**
     * SharedPreferences Name and Password
     */
    public void SharedPrefName(String name) {
        SharedPreferences prefs = getApplicationContext().getSharedPreferences("ACCOUNT", 0);
        SharedPreferences.Editor prefEDIT = prefs.edit();
        prefEDIT.putString("Account Name", name);
        prefEDIT.apply();
    }

    public void SharedPrefPassword(String password) {
        SharedPreferences prefs = getApplicationContext().getSharedPreferences("ACCOUNT", 0);
        SharedPreferences.Editor prefEDIT = prefs.edit();
        prefEDIT.putString("Password", password);
        prefEDIT.apply();
    }
    /**
     * displays the Name and password on the Login page
     */
    public void displayForAccountName(int NameLogin) {
        TextView Name = findViewById(R.id.userNameLogin);
        Name.setText(String.valueOf(NameLogin));
        SharedPreferences NameView = getApplicationContext().getSharedPreferences("ACCOUNT", 0);
        Name.setText(NameView.getString("Account Name", null));
    }

    public void displayForPassword(int PasswordLogin) {
        TextView Password = findViewById(R.id.passwordLogin);
        Password.setText(String.valueOf(PasswordLogin));
        SharedPreferences NameView = getApplicationContext().getSharedPreferences("ACCOUNT", 0);
        Password.setText(NameView.getString("Password", null));
    }


}

