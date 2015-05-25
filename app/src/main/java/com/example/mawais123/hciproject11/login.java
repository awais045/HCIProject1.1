package com.example.mawais123.hciproject11;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class login extends ActionBarActivity {
    EditText editTextemail,editTextPassword;
    Button btnCreateAccount;
    LoginDataBaseAdapter loginDataBaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // get Instance  of Database Adapter
        loginDataBaseAdapter = new LoginDataBaseAdapter(this);
        loginDataBaseAdapter = loginDataBaseAdapter.open();

        // Get Refferences of Views
        editTextemail = (EditText) findViewById(R.id.editTextemail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);

        btnCreateAccount = (Button) findViewById(R.id.button5);

        btnCreateAccount.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub

                String userName = editTextemail.getText().toString();
                String password = editTextPassword.getText().toString();


                // Save the Data in Database
                loginDataBaseAdapter.insertEntry(userName, password);
                Toast.makeText(getApplicationContext(), "Account Successfully Created ", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();

        loginDataBaseAdapter.close();
    }
}