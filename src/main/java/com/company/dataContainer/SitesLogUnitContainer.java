package main.java.com.company.dataContainer;

import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: WOLFY
 */
public class SitesLogUnitContainer {
	private long date;
	private long countryCode;
	private long userId;
	private long siteId;
	private String type;
	private String formatedDate;
	private String formatedHashMapKey;

	/*
	public int typeID;
	public static final int SHOW=0;
	public static final int CLICK=1;
	SitesLogUnitContainer className.type=SitesLogUnitContainer.SHOW;    */

	public SitesLogUnitContainer(long date,long countryCode,long userId,long siteId,String type){
		this.date=date;
		this.countryCode=countryCode;
		this.userId=userId;
		this.siteId=siteId;
		this.type=type;

		Date dateClass = new Date(date);
		SimpleDateFormat formatter=new SimpleDateFormat("dd.MM.yyyy");
		formatedDate = formatter.format(dateClass);

		StringBuffer hashMapKey=new StringBuffer();
		SimpleDateFormat hashMapKeyGenerator=new SimpleDateFormat("ddMMyyyy");
		hashMapKey=hashMapKeyGenerator.format(dateClass,hashMapKey,new FieldPosition(0));
		hashMapKey.append(this.countryCode);
		hashMapKey.append(this.siteId);
		formatedHashMapKey = hashMapKey.toString();
	}
	public String getFormatedDate(){
		return formatedDate;
	}
	public String getHashMapKey(){
		return formatedHashMapKey;
	}
	public String getType() {
		return type;
	}
}
