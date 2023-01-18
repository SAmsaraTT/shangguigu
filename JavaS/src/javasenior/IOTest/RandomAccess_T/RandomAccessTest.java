package javasenior.IOTest.RandomAccess_T;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessTest {
    @Test
    public void test1() throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("hello_rac.txt", "rw");
        randomAccessFile.seek(3);

        byte[] buff = new byte[1024];
        int len;
        StringBuilder sb = new StringBuilder();

        while ((len = randomAccessFile.read(buff)) != -1) {
            sb.append(new String(buff, 0, len));
        }

        randomAccessFile.seek(3);
        randomAccessFile.write("xyz".getBytes());
        randomAccessFile.write(sb.toString().getBytes( ));

        randomAccessFile.close();
    }
}
