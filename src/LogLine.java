import java.util.Comparator;
//пока не успела переделать
class LogLine implements Comparator<String> {

    @Override
    public int compare(String obj1, String obj2){

        int k = obj1.split("_")[1].compareTo(obj2.split("_")[1]);
        if(k == 0) {
            return obj1.compareTo(obj2);
        }
        else {
            return k;
        }
    }

}