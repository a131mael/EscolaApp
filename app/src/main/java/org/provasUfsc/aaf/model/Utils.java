package org.provasUfsc.aaf.model;

import android.content.Context;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URLEncoder;
import java.text.Normalizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Abimael Fidencio on 25/11/2016.
 */
public class Utils {

    public static void showMessage(Context context, String texto) {
        /*Context contexto = getApplicationContext();*/

        int duracao = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, texto, duracao);
        toast.show();
    }

    public static void save(String data, FileOutputStream fOut) {

        try {
            //    FileOutputStream fOut = openFileOutput(file, MODE_WORLD_READABLE);
            fOut.write(URLEncoder.encode(data, "UTF-8").getBytes());
            fOut.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public static String read(FileInputStream fin) {
        try {
            // FileInputStream fin = openFileInput(file);
            int c;
            String temp = "";
            while ((c = fin.read()) != -1) {
                temp = temp + Character.toString((char) c);
            }

            return URLEncoder.encode(temp, "UTF-8");

        } catch (Exception e) {
            return null;
        }

    }


    public static String removeSpecialCharacter(String value){
        CharSequence cs = new StringBuilder(value);
        return Normalizer.normalize(cs, Normalizer.Form.NFKD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "").replace(" ","");

    }

}