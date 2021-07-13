package lession03.chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class ChatReceiver implements Runnable {
    DatagramSocket socket = null;

    private int fromPort;

    public ChatReceiver(int fromPort) {
        this.fromPort = fromPort;
        try {
            socket = new DatagramSocket(fromPort);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true)
        {
            try {
                byte[] buffer = new byte[1024];
                DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
                socket.receive(packet);

                byte[] data = packet.getData();
                String dataStr = new String(data, 0, packet.getLength());
                System.out.println(packet.getAddress() + ": " + dataStr);
                if (dataStr.equals("close")) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        socket.close();
    }
}
