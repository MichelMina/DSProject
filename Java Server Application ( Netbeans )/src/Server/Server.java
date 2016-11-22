package Server;



import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.*;

class ClientHandler extends Thread {

    //field
    Socket c;

    public ClientHandler(Socket c) {
        this.c = c;
    }
    
    
    @Override
    public void run() {

        try {

            //3.create comm channel
            DataInputStream dis
                    = new DataInputStream(c.getInputStream());
            DataOutputStream dos
                    = new DataOutputStream(c.getOutputStream());
            while (true) {
                    //4.perform I/O
                //a.asks for account no.
                dos.writeUTF("Please enter account No.");
                String accountNo = dis.readUTF();
                //perform check with DB
                dos.writeUTF("Valid Account No." + accountNo
                        + "\nEnter Password");
                String psword = dis.readUTF();
                //perform check with DB
                dos.writeUTF("correct password" + psword
                        + "\nEnter Payment Amount");
                String paymentAmount = dis.readUTF();
                //perform check balance
                dos.writeUTF("Payment successful amount =" + paymentAmount
                        + "\nDo you want to perform another payment[Y/N]?");
                String choice = dis.readUTF();

                if (choice.equalsIgnoreCase("N")) {
                    dos.writeUTF("bye");
                    break;
                }
            }

            //5.terminate connection with client
            c.close();
            dis.close();
            dos.close();

        } 
        catch (Exception e) 
        {
            System.out.println("Something went wrong");
        }

    }

}

//PaymentSever
public class Server { 

    public static void main(String[] args) {
        try {
            
            //1.Create Server Socket
            ServerSocket server = new ServerSocket(1234);
            while (true) {
                //2.accept connection
                Socket c = server.accept();
                System.out.println("Client Arrived");
                ClientHandler ch = new ClientHandler(c);
                ch.start();

            }
            //6.Close the server if needed
            //server.close();

        } catch (Exception e) {
            System.out.println("Something Went Wrong");
        }

    }

}






