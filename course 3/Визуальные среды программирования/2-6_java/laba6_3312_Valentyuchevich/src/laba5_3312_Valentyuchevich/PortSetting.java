package laba5_3312_Valentyuchevich;

import java.net.*;
import java.net.UnknownHostException;

public class PortSetting {
	
	static InetAddress IP;
	static InetAddress NAME;
	static int PORT = 8080;
	
	public PortSetting() {
		try {
			PortSetting.IP = setIP();
			PortSetting.NAME = setName();
		} catch (Exception e){
			PortSetting.IP = null;
			PortSetting.NAME = null;
			System.out.println("errro class builder!" + e);
			
		}
	};
	public InetAddress setIP() throws Exception {
		return(InetAddress.getLocalHost());
		};
		
	public InetAddress setName() throws Exception {
		return(InetAddress.getByName(null));
		};
	
	public static InetAddress getIP() {
		return IP;
	}
	
	public static InetAddress getHostName() {
		return NAME;
	}
}
