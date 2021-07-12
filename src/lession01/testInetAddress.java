package lession01;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class testInetAddress {
    public static void main(String[] args)  {
        try {
            // get local address
            InetAddress address01 = InetAddress.getByName("127.0.0.1");
            System.out.println(address01);
            // or
            InetAddress address03 = InetAddress.getByName("localhost");
            System.out.println(address03);

            InetAddress address04 = InetAddress.getLocalHost();
            System.out.println(address04);

            // get external IP address
            InetAddress address02 = InetAddress.getByName("www.google.com");
            System.out.println(address02);

            // common methods
            System.out.println(address02.getAddress());
            System.out.println(address02.getCanonicalHostName());
            System.out.println(address02.getHostAddress());
            System.out.println(address02.getHostName());


        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
