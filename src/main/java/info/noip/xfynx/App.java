package info.noip.xfynx;

import java.util.HashMap;

public class App {
    private static void help() {
        System.out.println("use this keys:");
        System.out.println("-sort: sorting file names of logs;");
        System.out.println("-sccnt: statistic by shows and clicks by SiteId and Date;");
        System.out.println("-usrcnt: count of users by SiteId;");
        System.out.println("-vstcnt: count of visits by User;");
        System.out.println("-frqdct: frequency dictionary of visits by User;");
        System.out.println("-help: show this info.");
    }

    public static void main(String[] args) {
//        if (args.length < 1)
//            help();
//        for (String arg : args)
//            switch (arg) {
//                case "-sort":
//                    System.out.println("-sort: sorting file names of logs");
//                    break;
//                case "-sccnt":
//                    System.out.println("-sccnt: statistic by shows and clicks by SiteId and Date");
//                    LogObject logObject = new LogObject("log.txt");
//                    logObject.showParsed();
//                    break;
//                case "-usrcnt":
//                    System.out.println("-usrcnt: count of users by SiteId");
//                    break;
//                case "-vstcnt":
//                    System.out.println("-vstcnt: count of visits by User");
//                    break;
//                case "-frqdct":
//                    System.out.println("-frqdct: frequency dictionary of visits by User");
//                    break;
//                case "-help":
//                    help();
//                    break;
//                default:
//                    help();
//                    break;
//            }

        //logObject.logInformation.get(i).event;   типа как-то так использовать в итоге

        LogObject logObject = new LogObject("log.txt");
        //logObject.showParsed();

        HashMap<KeyByDateCodeSite, Event> hashMap = new HashMap<KeyByDateCodeSite, Event>();

        for (LogLine ls : logObject.logInformation) {
            Event event = new Event(0, 0);
            KeyByDateCodeSite key = new KeyByDateCodeSite(
                    ls.calendar, ls.countryCode, ls.siteId);
            if (hashMap.containsKey(key)) {
                event = hashMap.get(key);
            }
            event = event.setShowOrClick(ls, event);
            hashMap.put(key, event);

        }
        System.out.println(hashMap.toString());
//
//        TreeMap sortedMap = new TreeMap(new KeyByDateCodeSiteSort());
//        sortedMap.putAll(hashMap);
//
//        Iterator i = sortedMap.entrySet().iterator();
//        for (int j = 1; i.hasNext(); j++) {
//            Map.Entry me = (Map.Entry) i.next();
//            System.out.println(me.getKey() + " " + me.getValue());
//        }

    }


}
