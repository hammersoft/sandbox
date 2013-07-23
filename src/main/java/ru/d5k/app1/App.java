package ru.d5k.app1;

import java.util.Random;
import java.util.TreeSet;

public class App
{
    public static void main( String[] args )
    {
        Random r = new Random();
        TreeSet<String> logNames = new TreeSet<String>(new SortByTimestamp());
        long dateStart  = 1366342231000L;
        long dateFinish = 1374204631000L;
        for (int i=0; i<1000; i++){
            long randomDate = dateStart+((long)(r.nextDouble()*(dateFinish-dateStart)));
            logNames.add("log_"+randomDate);
        }

        for (String s : logNames){
            System.out.println(s);
        }
    }
}