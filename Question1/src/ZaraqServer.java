
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class ZaraqServer {
    private static ServerSocket server;
    private static int port = 1616;
    
    
   public static void main(String args[]) throws IOException, ClassNotFoundException{
        
        server = new ServerSocket(port);
        
        while(true){
            System.out.println("Waiting for request ....");
            
            Socket socket = server.accept();
            
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            String message = (String) ois.readObject();
            System.out.println("Message Received: " + message);
            
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
           
            oos.writeObject("Message from Zaraq Server "+message);
            
            ois.close();
            oos.close();
            socket.close();
            
            if(message.equalsIgnoreCase("exit")) break;
        }
        System.out.println("Shutting down server!!");
        
        server.close();
    }
}
