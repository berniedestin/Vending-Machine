package com.techelevator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;

public class Log {


    public static void main(String[] args) {
        System.out.println(getLogString());
    }


//    public Log() {
//
//    }
    public static String getLogString(){
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
        String date = dateFormat.format(current);


        return date;


    }
    public String  getTime(){
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
        String time = dateFormat.format(current);
        return time;
    }

    public String getFeedLog(BigDecimal money){
        String log = getTime() + " FEED MONEY: $" + money.setScale(2,BigDecimal.ROUND_HALF_UP) + " $" +
                VendingMachineCLI.getMachine().getBalance().setScale(2, BigDecimal.ROUND_HALF_UP);

        return log;
    }
    public String getPurchaseLog(Item item){
        String log = getTime() + " " + item.getName() + " $" + item.getPrice().setScale(2,BigDecimal.ROUND_HALF_UP) + " $" +
                VendingMachineCLI.getMachine().getBalance().setScale(2, BigDecimal.ROUND_HALF_UP);
        return log;
    }

    public String getChangeLog(){
        String log = getTime() + " GIVE CHANGE: $" + VendingMachineCLI.getMachine().getBalance().setScale(2, BigDecimal.ROUND_HALF_UP) + " $" +
                new BigDecimal(0).setScale(2, BigDecimal.ROUND_HALF_UP);
        return log;
    }

    public void writeToLog(String log){
        File writeFile = new File("capstone/src/log/Log.txt");
        try {
            if (!writeFile.exists()) {
                writeFile.createNewFile();
            }
        }catch (Exception e){
            System.out.println("Something went wrong creating the log file!");
        }
        try(PrintWriter writer = new PrintWriter(new FileOutputStream(writeFile,true))){
            writer.println(log);
        } catch (Exception e ){
            System.out.println("There was a problem writing to the log file!");
        }

    }
    public void writeToSalesLog(){

    }


}
