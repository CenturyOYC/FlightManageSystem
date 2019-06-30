package code;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Load {
	public static FlightDB flightDB;
	public static UserDB userDB;
    public Manager manager;
    public Load() {
    	flightDB=new FlightDB();
        userDB=new UserDB();
        manager=new Manager(flightDB,userDB);
    }
    //���ļ����������
    public static void LoadedFlightDB() throws IOException {
    	try {
    		BufferedReader reader=new BufferedReader(new FileReader(new File("FlightDB.txt")));
    		String in=reader.readLine();
    	    String[] group=new String[11];
    	    String code;
    	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	    Date startTime;
    	    Date endTime;
    	    String startPlace;
    		String endPlace;
    		int numberOfFc;
    		int numberOfBc;
    		int numberOfBoughtFc;
    		int numberOfBoughtBc;
    		double priceOfFc;
    		double priceOfBc;
    	    while(in!=null) {
    	    	in=in.substring(5);
    	    	group=in.split("/");
    	    	code=group[0];
    	    	startTime=format.parse(group[1]);
    			endTime=format.parse(group[2]);
    			startPlace=group[3];
    			endPlace=group[4];
    		    numberOfFc=Integer.valueOf(group[5]);
    			numberOfBc=Integer.valueOf(group[6]);
    			numberOfBoughtFc=Integer.valueOf(group[7]);
    			numberOfBoughtBc=Integer.valueOf(group[8]);
    			priceOfFc=Double.valueOf(group[9]);
    			priceOfBc=Double.valueOf(group[10]);
    			flightDB.addFlight(new Flight(code,startTime,endTime,startPlace,
    	    			endPlace,numberOfFc,numberOfBc,numberOfBoughtFc,
    	    			numberOfBoughtBc,priceOfFc,priceOfBc));
    			in=reader.readLine();
    	    }
    	    reader.close();
           } catch (FileNotFoundException | ParseException e) {
    		// TODO �Զ����ɵ� catch ��
    		e.printStackTrace();
    	}
    }
    //������
    public static void LoadedUserDB() throws IOException {
    	BufferedReader reader=new BufferedReader(new FileReader(new File("UserDB.txt")));
	    String in=reader.readLine();
	    String[] group;
	    String name;
	    String password;
	    double wallet;
	    HashMap<Flight,String> prepaid;
	    while(in!=null) {
	    	prepaid = new HashMap<Flight,String>();
	    	group=in.split("/");
	    	System.out.println(group.length);
	    	name=group[0];
	    	password=group[1];
	    	wallet=Double.valueOf(group[2]);
	    	for(int i=0;i<group.length;i++) 
	    		System.out.println(group[i]);
	    	for(int i=3;i<group.length;i+=2) {
	    		prepaid.put(flightDB.getFlightByCode(group[i]), group[i+1]);
	    		//prepaid.put(f, group[i+1]);
	    	}
	    	
	    	userDB.addUser(new User(name,password,flightDB,wallet,prepaid));
	    	in=reader.readLine();
	    }
	    reader.close();
    }    //��ȡ����
    public void putInformation() throws IOException {
    	OutputStream f1 = new FileOutputStream("FlightDB.txt");
    	OutputStream f2 = new FileOutputStream("UserDB.txt");
    	OutputStreamWriter writer1 = new OutputStreamWriter(f1);
    	OutputStreamWriter writer2 = new OutputStreamWriter(f2);
    	Iterator it=flightDB.getIterator();
    	Flight f=new Flight();
    	while (it.hasNext()) {
    		f=(Flight) it.next();
    		writer1.append(f.putInfo()+"\n");
    	}
    	writer1.close();
     	Iterator it2=userDB.getIterator();
     	User u;
     	while (it2.hasNext()) {
    		u=(User) it2.next();
    		writer2.append(u.putInfo()+"\n");
    	}
     	writer2.close();
    	}
	public static void mainX() throws IOException {
		LoadedFlightDB();
		LoadedUserDB();
	}

}
