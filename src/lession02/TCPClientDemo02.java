package lession02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TCPClientDemo02 {
    public static void main(String[] args) throws Exception {
        // 1. create a socket
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9000);
        // 2. create a output stream
        OutputStream os = socket.getOutputStream();

        // 3. read file
        FileInputStream fis = new FileInputStream(new File("statics/bart_simpson.jpg"));

        // 4. write file
        byte[] buffer = new byte[1024];
        int len = fis.read(buffer);
        while (len != -1)
        {
            os.write(buffer,0,len);
            len=fis.read(buffer);
//            os.write(buffer, 0, len);
//            fos.write(buffer,0, len);
        }

        // close resources
        fis.close();
        os.flush();
        os.close();
        socket.close();
    }
}
