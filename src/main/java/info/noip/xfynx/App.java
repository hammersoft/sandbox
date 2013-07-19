package info.noip.xfynx;

public class App {
    private static void help() {
        System.out.println("use this keys:");
        System.out.println("-sort: sorting file names of logs");
        System.out.println("-scCnt: statistic by shows and clicks by SiteId and Date");
        System.out.println("-usrCnt: count of users by SiteId");
        System.out.println("-vstCnt: count of visits by User");
        System.out.println("-frqDct: frequency dictionary of visits by User");
        System.out.println("-help: show this info.");
    }

    public static void main(String[] args) {
        if (args.length < 1)
            help();
        for (String arg : args)
            switch (arg) {
                case "-sort":
                    System.out.println("-sort: sorting file names of logs");
                    break;
                case "-scCnt":
                    System.out.println("-scCnt: statistic by shows and clicks by SiteId and Date");
                    LogReader logReader = new LogReader("log.txt");
                    logReader.out();
                    break;
                case "-usrCnt":
                    System.out.println("-usrCnt: count of users by SiteId");
                    break;
                case "-vstCnt":
                    System.out.println("-vstCnt: count of visits by User");
                    break;
                case "-frqDct":
                    System.out.println("-frqDct: frequency dictionary of visits by User");
                    break;
                case "-help":
                    help();
                    break;
                default:
                    help();
                    break;
            }
        //LogReader logReader = new LogReader("d:/sandbox/log.txt");
    }
}
