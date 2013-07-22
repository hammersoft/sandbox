package main.java.com.company;

/**
 *
 */
public class App 
{
    public static void main( String[] args ){
		if(args.length==0){
			help();
		}
		for (String CLArgument : args) {
			     if(CLArgument.equals("-help")) {
					 help();
				 }else if(CLArgument.equals("-clickAndShowsStat")) {
					  LogParser logParser=new LogParser("C:\\Users\\WOLFY\\Desktop\\test.log");
				 }else{
					help();
					return;
				 }
			}
    }
	private static void help(){
		System.out.println("Command line options");
		System.out.println("'-help' to show this help");
		System.out.println("'-cllickAndShowsStat' to show statistics I2");
	}
}
