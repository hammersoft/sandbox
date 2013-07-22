package main.java.com.company;
import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: WOLFY
 */
public class LogParser {
	private BufferedReader instrram ;
	public LogParser(String logFile){
		try{
			instrram=new BufferedReader(new FileReader(logFile));
			String readedLine;
			readedLine=instrram.readLine();
			//int counter=0;
			while((readedLine=instrram.readLine())!=null){
				//counter++;
			}
			//System.out.println("Counter= "+counter);
		}catch(Exception e){
			System.out.println("Not found file "+logFile);
		}
	}

}
