package lession02;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerDemo02 {
    public static void main(String[] args) throws Exception {
        // 1. create server
        ServerSocket serverSocket = new ServerSocket(9000);
        // 2. listen
        Socket socket = serverSocket.accept();
        // 3. get input stream
        InputStream is = socket.getInputStream();
        // 4. output
        FileOutputStream fos = new FileOutputStream(new File("reserve.jpg"));
        byte[] buffer = new byte[1024];
        int len = is.read(buffer);
        while (len != -1)
        {
            fos.write(buffer,0,len);
            len = is.read(buffer);
        }

        // 5. close resources
        fos.close();
        is.close();
        socket.close();
        serverSocket.close();
    }
}