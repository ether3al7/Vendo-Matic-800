package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Log {

    //>01/01/2016 12:00:15 PM FEED MONEY: $5.00 $10.00
    //>01/01/2016 12:00:20 PM Crunchie B4 $10.00 $8.50
    //>01/01/2016 12:01:25 PM Cowtales B2 $8.50 $7.50
    //>01/01/2016 12:01:35 PM GIVE CHANGE:   $7.50 $0.00
    // date        time        activity  strt amnt| end amnt
    File file = new File("capstone-1/Log.txt");
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss: a"); // lowercase hh for 12-hour format, a for am/pm
    LocalDateTime now = LocalDateTime.now(); //<-- getting local time

    public void log(String activity){ //<-- using one parameter for activity

        System.out.println(dtf.format(now) + " " + activity);
    }

    public void log(String productName, String code){ //<-- using 2 parameters for product name & code
        System.out.println(dtf.format(now) + " " + productName + " " + code);
    }



}
