package javasenior.IOTest.FileTest;


import org.testng.annotations.Test;

import java.io.*;

public class BufferTest {
   @Test
   public void BufferstreamTest() {
       copyFile("test_image.jpg", "test_image3.jpg");
   }

    public void copyFile(String srcStr, String desStr) {
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            File src = new File(srcStr);
            File des = new File(desStr);

            FileInputStream fileInputStream = new FileInputStream(src);
            FileOutputStream fileOutputStream = new FileOutputStream(des);
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            byte[] buffer = new byte[1024];

            int len;
            while ((len = bufferedInputStream.read(buffer)) != -1) {
                bufferedOutputStream.write(buffer, 0, len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (bufferedInputStream != null)
                    bufferedInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try {
                if (bufferedOutputStream != null)
                    bufferedOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
