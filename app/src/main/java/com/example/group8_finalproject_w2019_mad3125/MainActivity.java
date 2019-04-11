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
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getCanonicalName() ;
    private SharedPreferences sharedPreferences;



    private EditText eduid;
    private  EditText epass;
    private Button btnlogin;


    String email;
    String pass;
    String lblerror;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eduid=findViewById(R.id.txtlogin);
        epass=findViewById(R.id.txtpass);
        btnlogin=findViewById(R.id.btnlogin);



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
                //  email=eduid.getText().toString();
                //  pass=epass.getText().toString();

                /*if (email.equals("j") && pass.equals("123")) {
                    lblerror = "Login sucess";
                    //navigate with intenet
                    // Intent mIntent=new Intent(MainActivity.this,MainMenu.class);
                    // mIntent.putExtra("name","jagmeet");
                    //startActivity(mIntent);


                    Toast.makeText(MainActivity.this, email, Toast.LENGTH_SHORT).show();

}
*/
                    if (eduid.getText().length() != 0 && epass.getText().length() != 0) {
                        String name = eduid.getText().toString();
                        String password = epass.getText().toString();

                        SharedPreferences.Editor mEditor = sharedPreferences.edit();

                        mEditor.putString("name", name);

                        //mEditor.remove("name");
                        //mEditor.clear();

                        mEditor.apply();
                        //mEditor.commit();

                        Intent mIntent = new Intent(MainActivity.this, Signup.class);
                        startActivity(mIntent);
                    } else {

                        showDialog();

                    }

                }

        });




    }



    private void showDialog()
    {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);

        // set title
        alertDialogBuilder.setTitle("Enter valid Id and Password");

        // set dialog message
        alertDialogBuilder
                .setMessage("Click yes to exit!")
                .setCancelable(false)
                .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // if this button is clicked, close
                        // current activity
                        MainActivity.this.finish();
                    }
                })
                .setNegativeButton("No",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // if this button is clicked, just close
                        // the dialog box and do nothing
                        dialog.cancel();
                    }
                });


        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();

    }



}
