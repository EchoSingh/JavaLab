import java.io.*;
import java.net.*;

public class ServerSide {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(3306);
            Socket s = ss.accept(); // establishes connection
            DataInputStream dis = new DataInputStream(s.getInputStream());
            String str = dis.readUTF();
            System.out.println("message= " + str);
            ss.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
