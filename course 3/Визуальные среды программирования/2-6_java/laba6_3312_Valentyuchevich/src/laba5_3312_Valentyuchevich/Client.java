package laba5_3312_Valentyuchevich;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;

public class Client extends PortSetting {
    private InetAddress clientIP;
    private InetAddress clientName;
    private int port;
    
    public Client() {
        super();
        this.clientName = PortSetting.NAME;
        this.clientIP = PortSetting.IP;
        this.port = PortSetting.PORT;
    }
    
    public void displayClientInfo() {
        System.out.println("=== Client Information ===");
        if (clientIP != null) {
            System.out.println("Client IP: " + clientIP.getHostAddress());
        }
        if (clientName != null) {
            System.out.println("Client Name: " + clientName.getHostName());
        }
    }
    
    public void startClient() throws Exception {
        System.out.println("Client: Connecting to server...");
        
        Socket s = new Socket(clientName, port);
        System.out.println("Client: Connected to server!");
        
        BufferedReader dis = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String msg = dis.readLine();
        System.out.println("Client received: " + msg);
        
        dis.close();
        s.close();
        System.out.println("Client: Connection closed");
    }
}