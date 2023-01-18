package javasenior.Web;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPTest {
    @Test
    public void sender() throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket();

        String str = "UDP test!";
        byte[] data = str.getBytes();
        InetAddress localHost = InetAddress.getLocalHost();
        DatagramPacket datagramPacket = new DatagramPacket(data, 0, data.length, localHost, 9090);

        datagramSocket.send(datagramPacket);

        datagramSocket.close();
    }

    @Test
    public void receiver() throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(9090);
        byte[] buffer = new byte[100];


        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
        datagramSocket.receive(packet);

        System.out.println(new String(packet.getData(), 0, packet.getLength()));

        datagramSocket.close();

    }
}
