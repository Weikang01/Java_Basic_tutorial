package lession03.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class ChatSender implements Runnable {
    DatagramSocket socket = null;
    BufferedReader reader = null;

    private int fromPort;
    private String toIP;
    private int toPort;

    public ChatSender(int fromPort, String toIP, int toPort) {
        this.fromPort = fromPort;
        this.toIP = toIP;
        this.toPort = toPort;

        try {
            socket = new DatagramSocket(fromPort);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public ChatSender(DatagramSocket socket)
    {
        this.socket = socket;
    }

    @Override
    public void run() {
        String data = null;
        while (true)
        {
            try {
                data = reader.readLine();
                byte[] bytes = data.getBytes();
                DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length, new InetSocketAddress(this.toIP, this.toPort));
                socket.send(packet);
                if (data.equals("close"))
                    break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        socket.close();
    }
}
