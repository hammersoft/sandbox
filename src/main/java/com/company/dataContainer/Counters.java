package main.java.com.company.dataContainer;

/**
 * Created with IntelliJ IDEA.
 * User: WOLFY
 */
public class Counters {
	private int showCount=0;
	private int clickCount=0;
	private String extraData;

	public Counters(String extraData){
		this.extraData = extraData;
	}
	public void increaseShowCount(){
		this.showCount++;
	}
	public void increaseClickCount(){
		this.clickCount++;
	}
	public int getShowCnt() {
		return showCount;
	}
	public int getClickCount() {
		return clickCount;
	}
	public String getExtraData() {
		return extraData;
	}
}
