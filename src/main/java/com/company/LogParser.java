package main.java.com.company;
import java.io.*;
import java.util.*;

import main.java.com.company.dataContainer.*;

/**
 * Created with IntelliJ IDEA.
 * User: WOLFY
 */
public class LogParser {
	private BufferedReader instream;
	public LogParser(String logFile){
		try{
			instream=new BufferedReader(new FileReader(logFile));
			String nextLine;
			nextLine=instream.readLine();
			int counter=0;
			HashMap<String,Counters> parsingResult = new HashMap<String, Counters>();
			String hashKey;
			SitesLogUnitContainer logContainer;
			LinkedList<String> hashMapKeys=new LinkedList<String>();
			while((nextLine=instream.readLine())!=null){
				logContainer = stringParse(nextLine);
				hashKey = logContainer.getHashMapKey();
				Counters counterToIncrease = parsingResult.get(hashKey);
				if(counterToIncrease==null){
					parsingResult.put(hashKey,new Counters( logContainer.getFormatedDate() ));
					counterToIncrease=parsingResult.get(hashKey);
					hashMapKeys.push(hashKey);
					counter++;
				}
				if(logContainer.getType().equals("click")){
					counterToIncrease.increaseClickCount();
				}else if(logContainer.getType().equals("show")){
					counterToIncrease.increaseShowCount();
				}
			}
			for(int i=0;i<counter;i++){
				String hashMapKey= hashMapKeys.pop();
				Counters counterToDisplay=parsingResult.get(hashMapKey) ;
				System.out.println(counterToDisplay.getExtraData() + " " + counterToDisplay.getShowCnt() + " " + counterToDisplay.getClickCount());
			}
			System.out.println(counter+" lines in statistics");
			instream.close();
		} catch (FileNotFoundException e){
			System.out.println("Not found file "+logFile);
		} catch (Exception e){
			System.out.println(e.toString());
		}
	}
	private SitesLogUnitContainer stringParse(String readString){
		String[] dataStrings =readString.split("\t");
		SitesLogUnitContainer dataContainer;
		try{
			dataContainer = new SitesLogUnitContainer(Long.valueOf(dataStrings[0]),Long.valueOf(dataStrings[1]),Long.valueOf(dataStrings[2]),Long.valueOf(dataStrings[3]),dataStrings[4]);
		}catch(Exception e){
			System.out.println(e.toString());
			dataContainer = new SitesLogUnitContainer(0,0,0,0,"Err");
		}
		return  dataContainer;
	}
}
