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
		for (String argument : args) {
			     if(argument.equals("-help")||argument.equals("-h")) {
					 help();
				 }else if(argument.equals("-fileNamesSort")||argument.equals("-issue1")) {
					 FileNameSorter issueClass=new FileNameSorter("socdem");
				 }else if(argument.equals("-clickAndShowsStat")||argument.equals("-issue2")) {
					  LogParser logParser=new LogParser("test.log");
				 }else{
					help();
					return;
				 }
			}
    }
	private static void help(){
		System.out.println("Command line options");
		System.out.println("'-help' or '-h' to show this help");
		System.out.println("'-fileNamesSort' or '-issue1' to show statistics I1");
		System.out.println("'-clickAndShowsStat' or '-issue2' to show statistics I2");
	}
}
