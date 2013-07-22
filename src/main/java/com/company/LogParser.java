package main.java.com.company;
import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;

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
			String readedLine;
			readedLine=instream.readLine();
			int counter=0;
			//Date date =new Date();
			//Calendar calendar=Calendar.getInstance();
			HashMap<String,Counters> parsedLog=new HashMap<String, Counters>();
			String HashKey;
			//System.out.println(ParsedLog.get("fr"));
			SitesLogUnitContainer LogContainer=null;
			LinkedList<String> linkList=new LinkedList<String>();
			while((readedLine=instream.readLine())!=null){
				LogContainer=StringParse(readedLine);
				HashKey= LogContainer.getDateCodeIdString();
				Counters gettedCounter=parsedLog.get(HashKey);
				if(gettedCounter==null){
					parsedLog.put(HashKey,new Counters());
					linkList.push(HashKey);
					gettedCounter=parsedLog.get(HashKey);
					counter++;
				};
				//System.out.println(gettedCounter.toString());
				if(LogContainer.type.equals("click")){
					gettedCounter.IncreaseClickCnt();
				}else if(LogContainer.type.equals("show")){
					gettedCounter.IncreaseShowCnt();
				}
			}
			for(int i=0;i<counter;i++){
				String HMapKey= linkList.pop();
				Counters gettedCounter=parsedLog.get(HMapKey) ;
				System.out.println(HMapKey.toString()+" "+gettedCounter.showCnt+" "+gettedCounter.clickCnt);
			}
			System.out.println(counter+" lines in statistics");
		}catch(Exception e){
			System.out.println(e.toString());
			System.out.println("Not found file "+logFile);
		}
	}
	private long toLong(String string){
		 return Long.valueOf(string);
	}
	private SitesLogUnitContainer StringParse(String readString){
		String[] readData =readString.split("\t");
		//System.out.println(readData[1]);
		SitesLogUnitContainer DataContainer=null;
		//DataContainer = new SitesLogUnitContainer();
		try{
			//System.out.println( toLong(readData[0]));
		DataContainer = new SitesLogUnitContainer(toLong(readData[0]),
				toLong(readData[1]),toLong(readData[2]),toLong(readData[3]),readData[4]);
		}catch(Exception e){
			System.out.println(e.toString());
		}
		return  DataContainer;
	}
}
