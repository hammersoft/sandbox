package main.java.com.company;

/**
 * Hello world!
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
					 help();
				 }else{
					help();
					return;
				 }
			}
		// System.out.println( "Hello World!" );
    }
	private static void help(){
		System.out.println("Command line options");
	}
}
