package com.example.group8_finalproject_w2019_mad3125;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.group8_finalproject_w2019_mad3125.Modal.Customer;

public class Login extends AppCompatActivity {
    Customer cs = new Customer();
    private EditText eduid;
    private EditText epass;
    private Button btnlogin;
    private Button btnSignup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eduid = findViewById(R.id.txtlogin);
        epass = findViewById(R.id.txtpass);
        btnlogin = findViewById(R.id.btnlogin);
        btnSignup = findViewById(R.id.btnSignup);
        Customer c1 = new Customer(11, "Gurminder", "Kaur", "123", "toronto", "gur@gmail.com", "etobicoke", 123456);
        cs.register(c1);


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = eduid.getText().toString();
                String password = epass.getText().toString();
                boolean check = cs.checklogin(email, password);
                if (check == true) {
                    Intent LoginIntent = new Intent(Login.this, MainMenu.class);
                    startActivity(LoginIntent);
                } else {

                    showDialog();

                }

            }

        });


        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(Login.this, Signup.class);
                startActivity(mIntent);
            }
        });


    }


    private void showDialog() {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);

        alertDialogBuilder.setTitle("Enter valid Id and Password");
        alertDialogBuilder

                .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }
}





