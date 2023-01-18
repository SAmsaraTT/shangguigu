package javasenior.IOTest.FileTest;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIOStreamTest {
    @Test
    public void testFileIOStream() {

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            File src = new File("test_image.jpg");
            File des = new File("test_image2.jpg");

            fileInputStream = new FileInputStream(src);
            fileOutputStream = new FileOutputStream(des);

            byte[] buffer = new byte[5];

            int len;
            while ((len = fileInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fileInputStream != null)
                    fileInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try {
                if (fileOutputStream != null)
                    fileOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void copyFile(String srcStr, String desStr) {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            File src = new File(srcStr);
            File des = new File(desStr);

            fileInputStream = new FileInputStream(src);
            fileOutputStream = new FileOutputStream(des);

            byte[] buffer = new byte[1024];

            int len;
            while ((len = fileInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fileInputStream != null)
                    fileInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try {
                if (fileOutputStream != null)
                    fileOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test
    public void testCopy() {
        long start = System.currentTimeMillis();
        copyFile("d", "d");
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    @Test
    public void test3() {
        System.out.println(('a' - 'z') % 26);

    }
}
