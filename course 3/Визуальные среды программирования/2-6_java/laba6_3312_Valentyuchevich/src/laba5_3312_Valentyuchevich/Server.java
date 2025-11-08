package laba5_3312_Valentyuchevich;
import java.io.IOException;
import java.io.PrintStream;
import java.net.*;

public class Server {
	
	private InetAddress serverIP;
	private InetAddress serverName;
	private int port;
	
	public Server() {
		super();
		this.serverName = PortSetting.NAME;
		this.serverIP = PortSetting.IP;
		this.port = PortSetting.PORT;
	}
	 public void displayServerInfo() {
	        System.out.println("=== Server Information ===");
	        if (serverIP != null) {
	            System.out.println("Server IP: " + serverIP.getHostAddress());
	        }
	        if (serverName != null) {
	            System.out.println("Server Name: " + serverName.getHostName());
	        }
	        System.out.println("Server Port: " + port);
	    }

	 public void startServer() throws Exception {
	        System.out.println("Server: Starting on port " + port + "...");
	        
	        try (ServerSocket ss = new ServerSocket(port)) {
	            System.out.println("Server: Waiting for client connection...");
	            
	            Socket s = ss.accept();
	            System.out.println("Server: Client connected from " + s.getInetAddress());
	            
	            PrintStream ps = new PrintStream(s.getOutputStream());
	            ps.println("Hello from server! Connection successful.");
	            System.out.println("Server: Message sent to client");
	            
	            Thread.sleep(500);
	            
	            ps.close();
	            s.close();
	            System.out.println("Server: Connection closed");
	        } catch (Exception e) {
	            System.out.println("Server error: " + e.getMessage());
	        }
	    }
}
