package ru.d5k.app3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.*;

import static java.lang.System.exit;

public class App 
{
    public static void main( String[] args )
    {
        List<Record> logs = new ArrayList<Record>(); // список списков

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String path = "";
        System.out.print("Введите путь до лога: ");
        try {
            path = bufferedReader.readLine();
            if (path.equals("")) {
                path = "C:/Users/dimas/sandbox/2test.log"; // стандартный путь
                System.out.println("C:/Users/dimas/sandbox/2test.log");
            }
        } catch (IOException e) {
            System.out.println("Ошибка ввода. " + e.toString());
        }

        try {
            RandomAccessFile rFile = new RandomAccessFile(path, "r");
            rFile.readLine(); // первая строка не нужна, т.к. это названия полей
            System.out.print("Подождите. Читаю файл лога... ");
            while(rFile.getFilePointer()<rFile.length()){
                logs.add(parser(rFile.readLine()));
            }
            rFile.close();
        } catch(Exception e) {
            System.out.println("[ Fail ]" + e.toString());
            exit(0);
        }
        System.out.println("[ OK ]");

        String numberCountry="";
        try {
            while (isCorrectCountry(numberCountry)) {
                    System.out.print("Введите код страны[1-150]: ");
                numberCountry = bufferedReader.readLine();
                    if (numberCountry.equals("0")) {System.out.print("выход"); exit(0);}
            }
        } catch (IOException e) {
            System.out.println("Ошибка ввода. " + e.toString());
        }
        Long country = Long.parseLong(numberCountry);


        final HashMap<Long, Long> hMap = new HashMap<Long, Long>();
        for (List l : logs){
            Long site = Long.parseLong(l.get(Record.SITE).toString());

            if (country == Long.parseLong(l.get(Record.COUNTRY).toString()))
            if (hMap.containsKey(site)) hMap.put(site, hMap.get(site)+1);
                    else hMap.put(site, 1L);
        }

        TreeMap sortedMap = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int i1 = Integer.parseInt(hMap.get(o1).toString());
                int i2 = Integer.parseInt(hMap.get(o2).toString());

                if (i1 < i2) return 1;
                if (i1 > i2) return -1;
                return ((Long) o1).compareTo((Long) o2);
            }
        });

        sortedMap.putAll(hMap);
        Iterator i = sortedMap.entrySet().iterator();
        System.out.println("TOP-10 сайтов для страны №"+country);
        for (int j=1; i.hasNext() && j<=10; j++)
        {
            Map.Entry me = (Map.Entry)i.next();
            System.out.println(j+":\tсайт: "+me.getKey()+ ".\tпосещений: "+ me.getValue());
        }
    }

    public static Record parser(String s){
        StringTokenizer tokenizer = new StringTokenizer(s, "\t");

        return new Record(
                Long.parseLong(tokenizer.nextToken()), // DATE
                Long.parseLong(tokenizer.nextToken()), // COUNTRY
                Long.parseLong(tokenizer.nextToken()), // USER
                Long.parseLong(tokenizer.nextToken()), // SITE
                tokenizer.nextToken());                // TYPE
    }

    public static boolean isLong(String s) {
        try {
            Long.parseLong(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean isCorrectCountry(String s) {
        return !isLong(s) || Long.parseLong(s)<1 || Long.parseLong(s)>150;
    }
}