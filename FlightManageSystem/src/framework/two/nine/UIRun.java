package framework.two.nine;
import java.io.IOException;
import java.util.Iterator;

import code.*;
public class UIRun {
	public static void test(Load run) throws IOException {
		System.out.println(run.userDB.getUser("summber").displayPepaid());
		Iterator it =run.flightDB.getIterator();
		while(it.hasNext())
		System.out.println(((Flight)it.next()).toString());
	}
	public static void main(String[] args) throws IOException{
		Load run=new Load();
		int a=0;
		LoginUI main=new LoginUI(run.userDB,run.flightDB,run);
		run.mainX();
		//run.userDB.getUser("summber").addFlight("VN0032", "商务舱");
		//run.putInformation();
		//run.userDB.getUser("summber").addFlight("BC3091", "商务舱");
		//run.putInformation();
	}
}
