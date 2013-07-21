package info.noip.xfynx;

import java.util.Comparator;
import java.util.Date;

/**
 * @author xfynx
 */
public class KeyByDateCodeSite {
    public Date date;
    public long countryCode;
    public long siteId;

    KeyByDateCodeSite(Date date, long countryCode, long siteId) {
        this.date = date;
        this.countryCode = countryCode;
        this.siteId = siteId;
    }
}

class KeyByDateCodeSiteSort implements Comparator<KeyByDateCodeSite> {
    public int compare(KeyByDateCodeSite o1, KeyByDateCodeSite o2) {
        Date date1 = o1.date;
        Date date2 = o2.date;
        long countryCode1 = o1.countryCode;
        long countryCode2 = o2.countryCode;
        long siteId1 = o1.siteId;
        long siteId2 = o2.siteId;
        if (date1.getTime() < date2.getTime()) return 1;
        else if (date2.getTime() < date1.getTime()) return -1;
        else if (countryCode1 < countryCode2) return 1;
        else if (countryCode2 < countryCode1) return -1;
        else if (siteId1 < siteId2) return 1;
        else if (siteId2 < siteId1) return -1;
        else return 0;
    }
}
