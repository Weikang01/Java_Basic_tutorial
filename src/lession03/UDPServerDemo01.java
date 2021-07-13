package lession03;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServerDemo01 {
    public static void main(String[] args) throws Exception {
        // 1. public a port
        DatagramSocket socket = new DatagramSocket(9090);

        // 3. accept data package
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);

        socket.receive(packet); // block and accept

        System.out.println(packet.getAddress().getHostAddress());
        System.out.println(new String(packet.getData()));

        socket.close();
    }
}
