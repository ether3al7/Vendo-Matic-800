package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Log {

    static File file = new File("capstone-1/src/main/java/Log.txt");
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a"); // lowercase hh for 12-hour format, a for am/pm
    LocalDateTime now = LocalDateTime.now(); //<-- getting local time

    // Rather than always creating a new instance of PrintWriter in the log() method,
    // move the local PrintWriter variable out of the method, and make it a static class variable.
     static FileOutputStream output;
     static PrintWriter writer;

    static { //<-- declaring static as "FileOutputStream output" is static
        try {
            output = new FileOutputStream(file); //<-- making sure file is found
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    // comments below are from pair program 4 readme, some lines are commented again when used

    //Rather than always creating a new instance of PrintWriter in the log() method,
    // move the local PrintWriter variable out of the method, and make it a static class variable.
    // Then, in the method, check if the variable is null. If it is,
    // create an instance of PrintWriter and assign it to the class variable.
    // The next time the log() method is called, the class variable is no longer null,
    // and the method can use the existing instance of PrintWriter to write the message.
    //Note: replace any call to the PrintWriter's close() method with a call to the flush() method.
    // This way, the file can be kept open and the log message written with each call.
    // Also, the append argument true can be removed from new FileOutputStream("logs/search.log")
    // if you'd like to start with a fresh log each time the application runs.

    public void log(String activity){ //<-- using one parameter for activity
        if (writer == null){       // Then, in the method, check if the variable is null. If it is,
                          // create an instance of PrintWriter and assign it to the class variable.

            try {
                writer = new PrintWriter(file); //<-- creating instance of PrintWriter
                writer.println(dtf.format(now) + " " + activity); //<--printing time, then activity in Log.txt

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else {
            writer.println(dtf.format(now) + " " + activity);
        }
        //Note: replace any call to the PrintWriter's close() method with a call to the flush() method.
        // This way, the file can be kept open and the log message written with each call.
         writer.flush(); //<-- using .flush to append when method called

    }
}
