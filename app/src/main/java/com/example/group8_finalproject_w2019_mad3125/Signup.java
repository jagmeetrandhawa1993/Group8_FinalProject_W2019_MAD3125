package com.example.group8_finalproject_w2019_mad3125;

import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonWriter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.group8_finalproject_w2019_mad3125.Modal.Users;
import com.example.group8_finalproject_w2019_mad3125.Utils.JsonUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

public class Signup extends AppCompatActivity {

private EditText editTextname;
private  EditText editTextid;
    private  EditText editTextpassword;
    private  EditText editTextaddress;
    private Button btnsignup;

    String name;
    String id;
    String password;
    String address;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        editTextname = findViewById(R.id.editTextName);
        editTextid = findViewById(R.id.editTextId);
        editTextpassword = findViewById(R.id.editTextPassword);
        editTextaddress = findViewById(R.id.editTextAddress);

        btnsignup = findViewById(R.id.btnSignup);





        btnsignup.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        name=editTextname.getText().toString();
        id=editTextid.getText().toString();
        password=editTextpassword.getText().toString();
        address=editTextaddress.getText().toString();




            JSONObject object = new JSONObject();
            try {
                object.put("name", "Jack Hack");
                object.put("id", "k@k.com");
                object.put("password", "123");
                object.put("address", "Punjab");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            System.out.println(object);



    }
});





    }

  /*  public void writeJsonStream(OutputStream out, List<Message> messages) throws IOException {
        JsonWriter writer = new JsonWriter(new OutputStreamWriter(out, "UTF-8"));
        writer.setIndent("  ");
        writeMessagesArray(writer, messages);
        writer.close();
    }

    public void writeMessagesArray(JsonWriter writer, List<Message> messages) throws IOException {
        writer.beginArray();
        for (Message message : messages) {
            writeMessage(writer, message);
        }
        writer.endArray();
    }

    public void writeMessage(JsonWriter writer, Message message) throws IOException {
        writer.beginObject();
        writer.name("name").value(name);

        writer.name("id").value(id);
        writer.name("password").value(password);
       writer.name("address").value(address);



    }



   public void writeDoublesArray(JsonWriter writer, List<Double> doubles) throws IOException {
        writer.beginArray();
        for (Double value : doubles) {
            writer.value(value);
        }
        writer.endArray();
    }

*/
}
