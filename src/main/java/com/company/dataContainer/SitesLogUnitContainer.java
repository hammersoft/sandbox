package main.java.com.company.dataContainer;

/**
 * Created with IntelliJ IDEA.
 * User: WOLFY
 */
public class SitesLogUnitContainer {
	public int date;
	public int countryCode;
	public int userId;
	public int siteId;
	public String type;
	public SitesLogUnitContainer(){

	}
	public SitesLogUnitContainer(int date,int countryCode,int userId,int siteId,String type){
		this.date=date;
		this.countryCode=countryCode;
		this.userId=userId;
		this.siteId=siteId;
		this.type=type;
	}
}
