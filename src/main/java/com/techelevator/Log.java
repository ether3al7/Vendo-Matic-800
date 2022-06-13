package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Log {

   File file = new File("capstone-1/Log.txt");

    FileOutputStream output;

    {
        try {
            output = new FileOutputStream(file, true);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void log(){
      //  output.

    }



}
