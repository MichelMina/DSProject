package Client;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;


public class Client {

    public static void main(String[] args) {

        try {
            //1.create client socket and connect to server
            Socket client = new Socket("127.0.0.1", 1234);
            //2.create comm streams
            DataInputStream dis
                    = new DataInputStream(client.getInputStream());
            DataOutputStream dos
                    = new DataOutputStream(client.getOutputStream());
            //3.perform I/O with server
            Scanner cin = new Scanner(System.in);
            while (true) {
                //receive msg from server
                String servercommand =  dis.readUTF();
                System.out.println("Server Says :" + servercommand);
                
                if(servercommand.equalsIgnoreCase("bye"))
                    break;
                
                String userInput = cin.nextLine();
                dos.writeUTF(userInput);
            }

            //4.terminate connection with server
            client.close();
            dis.close();
            dos.close();

        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
    }

}
