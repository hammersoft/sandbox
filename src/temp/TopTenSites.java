package temp;

import java.util.*;

class TopTenSites {

    static class ReducedRecord{
        Long countryCode;
        Long siteId;

    }

    static class ValueComparator implements Comparator<Long> {

        Map<Long, Long> base;
        public ValueComparator(Map<Long, Long> base) {
            this.base = base;
        }


        public int compare(Long a, Long b) {
            if (base.get(a) >= base.get(b)) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    public static void main(String[] args) {
        List<Record> listOfLogs = new ArrayList<Record>();
        listOfLogs = Parser.readFile();

        List<ReducedRecord> listOfLogsReduced = new ArrayList<ReducedRecord>();

        for (Record item : listOfLogs) {
            ReducedRecord tempRec = new ReducedRecord();
            tempRec.countryCode = item.countryCode;
            tempRec.siteId = item.siteId;
            listOfLogsReduced.add(tempRec);
        }

        Collections.sort(listOfLogsReduced, new Comparator<ReducedRecord>() {
            @Override
            public int compare(ReducedRecord rec1, ReducedRecord rec2) {
                return (int) (rec1.countryCode - rec2.countryCode);
            }
        });

       /* for (ReducedRecord item : listOfLogsReduced) {
            System.out.println(item.countryCode + " "+item.siteId);

        }*/

        //int ii=0;
        //*********************************************
        for(int i=0; i<listOfLogsReduced.size()-1; i++) {
            List <Long> sites = new ArrayList <Long>();         //сайты в отдельно взятой стране

            while (listOfLogsReduced.get(i).countryCode.equals(listOfLogsReduced.get(i+1).countryCode)){
                sites.add(listOfLogsReduced.get(i).siteId);
                //System.out.println(i);
                if (i<listOfLogsReduced.size()-2) {i++;} else {break;}
            }

            //for(Long site: sites){
               // System.out.println(site + " " + ii + " " + i);
               // ii++;
              //  System.out.println("Site Size: "+sites.size());
            //}
        //********************************************

            System.out.println("Country: " + listOfLogsReduced.get(i).countryCode);

            Map<Long, Long> dictionaryOfSites = new HashMap<Long, Long>();
            ValueComparator bvc =  new ValueComparator(dictionaryOfSites);
            TreeMap<Long,Long> dictionaryOfSitesSorted = new TreeMap<Long,Long>(bvc);

            for (Long site : sites){
                if (!sites.isEmpty())
                    if (!dictionaryOfSites.containsKey(site))
                        dictionaryOfSites.put(site, 1L);
                    else
                        dictionaryOfSites.put(site, dictionaryOfSites.get(site) + 1);
            }

            dictionaryOfSitesSorted.putAll(dictionaryOfSites);

            int countOfSites = 0;
            for (Long key : dictionaryOfSitesSorted.keySet())
                if (countOfSites < 10) {
                    System.out.println (key + ": " + dictionaryOfSites.get(key));
                    countOfSites ++;
                } else {break;}
            }

    }
}
