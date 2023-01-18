package javasenior.Web;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPtest2 {
    @Test
    public void client() throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9900);

        OutputStream outputStream = socket.getOutputStream();
        FileInputStream fileInputStream = new FileInputStream("test_image.jpg");
        byte[] buffer = new byte[1024];
        int len;
        while ((len = fileInputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, len);
        }

        fileInputStream.close();
        outputStream.close();
        socket.close();
    }

    @Test
    public void server() throws IOException {
        ServerSocket serverSocket = new ServerSocket(9900);
        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();

        FileOutputStream fileOutputStream = new FileOutputStream("test_image_TCP.jpg");

        byte[] buffer = new byte[1024];
        int len;
        while ((len = inputStream.read(buffer)) != -1) {
            fileOutputStream.write(buffer, 0, len);
        }

        fileOutputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
