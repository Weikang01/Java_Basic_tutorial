package lession03;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClientDemo01 {
    public static void main(String[] args) throws Exception {
        // 1. create a socket
        DatagramSocket socket = new DatagramSocket(9080);

        // 2. create a package
        String msg = "hello";
        InetAddress address = InetAddress.getByName("localhost");
        int port = 9090;
        DatagramPacket packet = new DatagramPacket(msg.getBytes(), 0, msg.getBytes().length, address, port);

        // 3. send package
        socket.send(packet);

        // close stream
        socket.close();
    }
}
