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

public class Login extends AppCompatActivity {

    private static final String TAG = Login.class.getCanonicalName() ;
    private SharedPreferences sharedPreferences;



    private EditText eduid;
    private  EditText epass;
    private Button btnlogin;
    private Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eduid=findViewById(R.id.txtlogin);
        epass=findViewById(R.id.txtpass);
        btnlogin=findViewById(R.id.btnlogin);
        btnSignup = findViewById(R.id.btnSignup);



        sharedPreferences = getSharedPreferences("myPref",MODE_PRIVATE);

        if (sharedPreferences.contains("name"))
        {
            String name = sharedPreferences.getString("name", null);

            if (name != null)
            {
                Log.d(TAG, name);
                Log.i(TAG, name);
                Log.v(TAG, name);
                Log.w(TAG, name);
                Log.e(TAG, name);

                eduid.setText(name);

            }
        }


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    if (eduid.getText().length() != 0 && epass.getText().length() != 0)
                    {
                        String name = eduid.getText().toString();
                        String password = epass.getText().toString();
                        SharedPreferences.Editor mEditor = sharedPreferences.edit();
                        mEditor.putString("name", name);
                        mEditor.apply();
                        Intent mIntent = new Intent(Login.this, MainMenu.class);
                        startActivity(mIntent);
                    }
                    else
                        {

                        showDialog();

                    }

                }

        });


        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(Login.this,Signup.class);
                startActivity(mIntent);
            }
        });




    }



    private void showDialog()
    {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);

        alertDialogBuilder.setTitle("Enter valid Id and Password");
        alertDialogBuilder

                .setNegativeButton("OK",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }



}
