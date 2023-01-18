package javasenior.Web;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPtest {
    public static void main(String[] args) {
        try {
            InetAddress ip1 = InetAddress.getByName("192.160.10.14");
            System.out.println(ip1);
            InetAddress ip2 = InetAddress.getByName("www.atguigu.com");
            System.out.println(ip2);

            InetAddress ip3 = InetAddress.getByName("127.0.0.1");
            System.out.println(ip3);

            InetAddress ip4 = InetAddress.getLocalHost();
            System.out.println(ip4);

            System.out.println(ip2.getHostName());
            System.out.println(ip2.getHostAddress());
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}
