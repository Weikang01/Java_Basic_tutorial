package lession03.chat;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UDPSenderDemo01 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(9999);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true)
        {
            String data = reader.readLine();
            byte[] bytes = data.getBytes();
            DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length, new InetSocketAddress("localhost", 8888));
            socket.send(packet);
            if (data.equals("close"))
                break;
        }

        socket.close();
    }
}
