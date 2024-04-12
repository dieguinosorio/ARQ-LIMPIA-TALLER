package com.market.infrastructure.LogSystem;

import java.time.LocalDate;
import java.util.Date;

public class Log {
    private final String message;
    private final String statusCode;

    public Log(String message, String statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    //private final String classError;
    public void logger(){
        System.out.println("Status code:"+ statusCode +" Message :" + "Date: "+ LocalDate.now());
    }
}
