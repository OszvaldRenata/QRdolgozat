package com.example.qrdolgozat;

import android.os.Build;
import android.os.Environment;

import androidx.annotation.RequiresApi;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Kiiras {
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static void kiir(String szoveg) throws IOException {

        Date datum = Calendar.getInstance().getTime();
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd, HH-mm-ss");
        String formedDate = dateformat.format(datum);

        String sor = String.format("%s,%s", szoveg, formedDate);

        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)){
            File file = new File(Environment.getExternalStorageState(),"scannedCodes.csv");
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            bw.append(sor);
            bw.append(System.lineSeparator());
            bw.close();
        }
    }
}
