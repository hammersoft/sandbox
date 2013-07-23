package temp;

import java.util.*;

class TopTenSites {

    static class ReducedRecord{
        private Long countryCode;
        private Long siteId;

        Long getCountryCode() {
            return countryCode;
        }
        void setCountryCode(Long countryCode) {
            this.countryCode = countryCode;
        }

        Long getSiteId() {
            return siteId;
        }
        void setSiteId(Long siteId) {
            this.siteId = siteId;
        }
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
        listOfLogs = Parse.parseFile();

        List<ReducedRecord> listOfLogsReduced = new ArrayList<ReducedRecord>();

        for (Record item : listOfLogs) {
            ReducedRecord tempRec = new ReducedRecord();
            tempRec.countryCode = item.getCountryCode();
            tempRec.siteId = item.getSiteId();
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
        for(int i=0; i<listOfLogsReduced.size()-1; i++) {       //чудо-цикл, который вскоре будет переписан
            List <Long> sites = new ArrayList <Long>();         //сайты в отдельно взятой стране

            while (listOfLogsReduced.get(i).countryCode.equals(listOfLogsReduced.get(i+1).countryCode)){
                sites.add(listOfLogsReduced.get(i).siteId);
                if (i<listOfLogsReduced.size()-2 ) {i++;} else {break;}
            }

            //for(Long site: sites){
               // System.out.println(site + " " + ii + " " + i);
               // ii++;
              //  System.out.println("Site Size: "+sites.size());
            //}
        //********************************************

            System.out.println("Country: " + listOfLogsReduced.get(i).countryCode);

            Map<Long, Long> mapOfSites = new HashMap<Long, Long>();
            ValueComparator bvc =  new ValueComparator(mapOfSites);
            TreeMap<Long,Long> mapOfSitesSorted = new TreeMap<Long,Long>(bvc);

            for (Long site : sites){
                if (!sites.isEmpty()){
                    if (!mapOfSites.containsKey(site)){
                        mapOfSites.put(site, 1L);
                    } else {
                        mapOfSites.put(site, mapOfSites.get(site) + 1);
                    }
                }
            }

            mapOfSitesSorted.putAll(mapOfSites);

            int countOfSites = 0;
            for (Long key : mapOfSitesSorted.keySet())
                if (countOfSites < 10) {
                    System.out.println(key + ": " + mapOfSites.get(key));
                    countOfSites ++;
                } else {break;}
            }
            // hashmap <Long, TreeMap<Long, Long>>
    }
}
