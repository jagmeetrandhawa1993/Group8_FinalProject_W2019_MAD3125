package com.example.group8_finalproject_w2019_mad3125;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonWriter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.group8_finalproject_w2019_mad3125.Modal.Users;
import com.example.group8_finalproject_w2019_mad3125.Utils.JsonUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

public class Signup extends AppCompatActivity {

    DatabaseHelper myDb;

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
        myDb = new DatabaseHelper(this);

        editTextname = findViewById(R.id.edtName);
        editTextid = findViewById(R.id.editemail);
        editTextpassword = findViewById(R.id.edtPassword);
        editTextaddress = findViewById(R.id.editAddress);
        editTextCardInfo = findViewById(R.id.editcard);

        btnsignup = findViewById(R.id.btnsignup);
        AddData();


    }
    public  void AddData() {
        btnsignup.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(editTextname.getText().toString(),
                                editTextid.getText().toString(),
                                editTextpassword.getText().toString(),editTextaddress.getText().toString(),editTextCardInfo.getText().toString() );
                        if(isInserted == true) {
                            Toast.makeText(Signup.this, "Data Inserted", Toast.LENGTH_LONG).show();
                            editTextname.setText(" ");
                            editTextid.setText(" ");
                            editTextpassword.setText(" ");
                            editTextaddress.setText(" ");
                            editTextCardInfo.setText(" ");
                            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Signup.this);
                            alertDialogBuilder.setTitle("Registration Successful");
                            alertDialogBuilder
                                    //.setMessage("Click yes to exit!")
                                   // .setCancelable(false)
                                    .setPositiveButton("OK",new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog,int id) {
                                            Intent intent=new Intent(Signup.this, MainActivity.class);
                                            startActivity(intent);
                                        }
                                    });


                            // create alert dialog
                            AlertDialog alertDialog = alertDialogBuilder.create();

                            // show it
                            alertDialog.show();
                        }

                        else
                            Toast.makeText(Signup.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

}
