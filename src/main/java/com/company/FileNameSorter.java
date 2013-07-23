package main.java.com.company;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: WOLFY
 */
public class FileNameSorter {
	private Calendar dateGenerator;

	public FileNameSorter(String logName){
		dateGenerator=Calendar.getInstance();
		dateGenerator.set(2010,1,1);
		long minimumTime=dateGenerator.getTimeInMillis();
		dateGenerator.set(2013,12,31);
		long maximumTime=dateGenerator.getTimeInMillis();
		long difMaxMinTime= maximumTime-minimumTime;

		long randomNumber;
		StringBuilder logNameCreator;
		TreeSet<String> logNamesSortTree=new TreeSet<String>(comparator);
		for (int i = 0; i < 1000; i++) {
			randomNumber=minimumTime+(long)(Math.random()*difMaxMinTime);
			logNameCreator=new StringBuilder(logName);
			logNameCreator.append("_");
			logNameCreator.append(randomNumber);
			boolean didNotAlreadyContain=logNamesSortTree.add(logNameCreator.toString());
			if(didNotAlreadyContain==false){
				i--;
			}
		}
		int counter=0;
		Iterator<String> sortTreeIterator=logNamesSortTree.descendingIterator();
		while(sortTreeIterator.hasNext()){
			counter++;
			System.out.println(sortTreeIterator.next());
		}
		System.out.println(counter);
	}
	Comparator<String> comparator=new Comparator<String>(){
		public int compare(String string1, String string2)
		{
			String[] dateString1= string1.split("_");
			String[] dateString2= string2.split("_");
			Long dateTime1=Long.valueOf(dateString1[1]);
			Long dateTime2=Long.valueOf(dateString2[1]);
			return dateTime2.compareTo(dateTime1);
		}
	};
}
