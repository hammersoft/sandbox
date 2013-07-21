package ru.d5k.app3;


import java.util.ArrayList;

public class Record extends ArrayList {
    final static int DATE    = 0;
    final static int COUNTRY = 1;
    final static int USER    = 2;
    final static int SITE    = 3;
    final static int TYPE    = 4;

    public Record(Long date, Long countryCode, Long userId, Long siteId, String type){
        super(5);
        this.add(DATE, date);
        this.add(COUNTRY, countryCode);
        this.add(USER, userId);
        this.add(SITE, siteId);
        this.add(TYPE, type);
    }
}