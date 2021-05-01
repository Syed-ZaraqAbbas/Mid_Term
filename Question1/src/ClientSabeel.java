
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
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
public class ClientSabeel {
     public static void main(String[] args) throws  IOException, InterruptedException, ClassNotFoundException{
        //get the localhost IP address, if server is running on some other IP, you need to use that
        InetAddress host = InetAddress.getLocalHost();
        Socket socket = null;
        ObjectOutputStream objOutStream = null;
        ObjectInputStream objInputStream = null;
        
            socket = new Socket(host.getHostName(), 1616);
            
            objOutStream = new ObjectOutputStream(socket.getOutputStream());
            System.out.println("Requesting ...");
            objOutStream.writeObject("");
            objInputStream = new ObjectInputStream(socket.getInputStream());
            String message = (String) objInputStream.readObject();
            System.out.println("Message: " + message);
            objInputStream.close();
            objOutStream.close();
            Thread.sleep(100);
    }
}
