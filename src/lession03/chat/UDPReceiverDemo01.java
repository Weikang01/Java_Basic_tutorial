package lession03.chat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public class UDPReceiverDemo01 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(8888);

        while (true)
        {
            byte[] buffer = new byte[1024];

            DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length, new InetSocketAddress("localhost", 9999));
            socket.receive(packet);


            byte[] data = packet.getData();
            String dataStr = new String(data, 0, packet.getLength());
            System.out.println(dataStr);
            if (dataStr.equals("close")) {
                break;
            }
        }
        socket.close();
    }
}
