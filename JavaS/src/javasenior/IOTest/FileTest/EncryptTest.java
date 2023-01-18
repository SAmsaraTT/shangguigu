package javasenior.IOTest.FileTest;

import org.junit.Test;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class EncryptTest {
    public void encryptFile(String srcStr, String desStr) {
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
                for (int i = 0; i < len; i++) {
                    buffer[i] = (byte)(buffer[i] ^ 5);
                }
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
    public void testEncrypt() {
        encryptFile("test_image.jpg", "encrypted_image.jpg");
        encryptFile("encrypted_image.jpg", "ori_image.jpg");
    }
}
