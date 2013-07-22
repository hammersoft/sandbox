package main.java.com.company.dataContainer;

import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: WOLFY
 */
public class SitesLogUnitContainer {
	public long date;
	public long countryCode;
	public long userId;
	public long siteId;
	public String type;
	private String DdMmYyyyDate;
	private String DdMmYyyyDateWithoutPoints;
	private static Calendar calendar=Calendar.getInstance();
	public SitesLogUnitContainer(){

	}
	public SitesLogUnitContainer(long date,long countryCode,long userId,long siteId,String type){
		this.date=date;
		this.countryCode=countryCode;
		this.userId=userId;
		this.siteId=siteId;
		this.type=type;
		calendar.setTimeInMillis(date);
		DdMmYyyyDate= new String(calendar.get(Calendar.DAY_OF_MONTH)+"."+calendar.get(Calendar.MONTH)+"."+calendar.get(Calendar.YEAR));
		DdMmYyyyDateWithoutPoints= new String(calendar.get(Calendar.DAY_OF_MONTH)+""+calendar.get(Calendar.MONTH)+calendar.get(Calendar.YEAR));
	}
	public String getDdMmYyyyDate(){
		return DdMmYyyyDate;
	}
	public String getDateCodeIdString(){
		return DdMmYyyyDateWithoutPoints+this.countryCode+this.siteId;
	}
}
