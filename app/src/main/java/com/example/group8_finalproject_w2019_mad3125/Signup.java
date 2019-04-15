package com.example.group8_finalproject_w2019_mad3125;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends AppCompatActivity {


    private EditText editTextname;
    private EditText editTextid;
    private EditText editTextpassword;
    private EditText editTextaddress;
    private EditText editTextCardInfo;
    private Button btnsignup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        editTextname = findViewById(R.id.edtName);
        editTextid = findViewById(R.id.editemail);
        editTextpassword = findViewById(R.id.edtPassword);
        editTextaddress = findViewById(R.id.editAddress);
        editTextCardInfo = findViewById(R.id.editcard);

        btnsignup = findViewById(R.id.btnsignup);


    }
}

