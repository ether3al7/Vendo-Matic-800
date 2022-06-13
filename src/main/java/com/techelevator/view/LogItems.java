package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;
public class LogItems {
    private String path;
    private File file;
    private PrintWriter writer;
    private SimpleDateFormat simpleDateFormat;
    private String pattern;


    //Constructor
    public LogItems(String path, File file, SimpleDateFormat simpleDateFormat, String pattern) {
        this.path = "capstone-1/Log.txt";                                   //
        this.file = new File(path);                              //
        this.simpleDateFormat = new SimpleDateFormat(pattern);   // Constructs a SimpleDateFormat using the default pattern and date format symbols for the default locale.
        this.pattern = "MM/dd/yyyy hh:mm:ss a";                  // Default date format symbols
        try {

            this.writer = new PrintWriter(new FileOutputStream(file), true);

        } catch (FileNotFoundException e) {

            System.out.println("This file was not found");
        }
    }

    //Method

    public LogItems (File file, String message){

        //Each purchase must generate a line in a file called Log.txt.
        //The audit entry must be in the format:
        // 01/01/2016 12:00:00 PM FEED MONEY: $5.00 $5.00
        // amount started , amount left over
        //>01/01/2016 12:00:15 PM FEED MONEY: $5.00 $10.00
        //>01/01/2016 12:00:20 PM Crunchie B4 $10.00 $8.50
        //>01/01/2016 12:01:25 PM Cowtales B2 $8.50 $7.50
        //>01/01/2016 12:01:35 PM GIVE CHANGE: $7.50 $0.00
        //>```

        Date date = new Date();

        try{
            String dateTime = simpleDateFormat.format(DateFormat.getDateTimeInstance());
       //     writer.println(dateTime = " " + message +  );

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }




    public LogItems(){
       // Date date = new Date();
        File file = new File("capstone-1/Log.txt");
     //  Logger logger = new Logger(file);

        try{
            String dateTime = simpleDateFormat.format(DateFormat.getDateTimeInstance());
            writer.println(dateTime);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
