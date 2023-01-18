package javasenior.Web;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPtest3 {
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

        socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buffer1 = new byte[20];
        int len1;

        while ((len1 = inputStream.read(buffer1)) != -1) {
            byteArrayOutputStream.write(buffer1, 0, len1);
        }

        System.out.println(byteArrayOutputStream.toString());

        byteArrayOutputStream.close();
        inputStream.close();
        fileInputStream.close();
        outputStream.close();
        socket.close();
    }

    @Test
    public void server() throws IOException {
        ServerSocket serverSocket = new ServerSocket(9900);
        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();

        FileOutputStream fileOutputStream = new FileOutputStream("test_image_TCP1.jpg");

        byte[] buffer = new byte[1024];
        int len;
        while ((len = inputStream.read(buffer)) != -1) {
            fileOutputStream.write(buffer, 0, len);
        }

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("server has received the image from client!".getBytes());

        outputStream.close();
        fileOutputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
