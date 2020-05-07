

//To make this code work you must create a MAVEN project in eclipse ide
//to know how to create a maven project or to make this code to work 
//you can watch this video :
//
//



import java.nio.file.FileSystems;
import java.nio.file.WatchService;
import java.nio.file.*;
import java.util.*;
import java.io.*;
import com.fazecast.*;
import com.fazecast.jSerialComm.SerialPort; 


public class start extends Thread{
public static void main(String[] args) throws IOException, InterruptedException {
	SerialPort sp=SerialPort.getCommPort("COM9");
	sp.setComPortParameters(9600, 8, 1, 0);
	sp.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0);
	
	Thread t=new Thread();
	
	
	if(sp.openPort()) {
		System.out.println("Port Opening success");
		
	}else {
		System.out.println("port opening failed");
		return;
	}
	t.sleep(10000);
	
	
	
	start ity=new start();
	ity.waitm(sp);
}
private synchronized void waitm(SerialPort ap) throws IOException, InterruptedException {
	while(true) {
		
		WatchService water= FileSystems.getDefault().newWatchService();
		File f=new File("C:\\xampp\\htdocs\\ark-pro\\data.txt");
		Scanner sc=new Scanner(f);
		
		
					int so=Integer.parseInt(sc.nextLine());
				ap.getOutputStream().write(so);
				sc.close();
			ap.getOutputStream().flush();
			System.out.println("num sent : ");
	//	ap.closePort();
		try {
			this.wait(1000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
}
