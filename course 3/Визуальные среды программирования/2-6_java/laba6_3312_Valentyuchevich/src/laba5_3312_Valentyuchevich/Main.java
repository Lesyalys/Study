package laba5_3312_Valentyuchevich;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Starting Client-Server Application ===");
        
        PortSetting networkSettings = new PortSetting();
        
        System.out.println("\n--- Server Side ---");
        Server server = new Server();
        server.displayServerInfo();
        
        // в отдельном потоке
        Thread serverThread = new Thread(() -> {
            try {
                server.startServer();
            } catch (Exception e) {
                System.out.println("Server error: " + e.getMessage());
            }
        });
        serverThread.start();
        
        //время на запуск
        Thread.sleep(2000);
        
        System.out.println("\n--- Client Side ---");
        Client client = new Client();
        client.displayClientInfo();
        client.startClient();
        
        serverThread.join();
        System.out.println("\n=== Application Finished ===");
    }
}