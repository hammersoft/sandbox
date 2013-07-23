package ru.d5k.app1;

import java.util.Comparator;

public class SortByTimestamp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        Long timeOfLog1 = Long.parseLong(o1.substring(o1.indexOf("_")+1));
        Long timeOfLog2 = Long.parseLong(o2.substring(o2.indexOf("_")+1));

        return timeOfLog1.compareTo(timeOfLog2);
    }
}
