package com.example.group8_finalproject_w2019_mad3125.Utils;

import android.content.Context;
import android.view.View;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class JsonUtils {


  /*  public String loadJSONFromAsset() {
        String json ;
        try {
            InputStream is = getAssets().open("User.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    */


    public  static void writeToFile(Context context, String user, String str)
    {
        try{
            FileOutputStream fos = context.openFileOutput(user, Context.MODE_PRIVATE);
            fos.write(str.getBytes(), 0, str.length());
            fos.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }




}
