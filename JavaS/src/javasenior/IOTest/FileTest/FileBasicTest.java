package javasenior.IOTest.FileTest;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileBasicTest {
    @Test
    public void testIO() {
        FileReader fr = null;
        try {
            File file = new File("hello.txt");
            fr = new FileReader(file);
            int data = 0;
            data = fr.read();
            while (data != -1) {
                System.out.print((char) data);
                data = fr.read();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test
    public void testIO2() {
        FileReader fr = null;
        try {
            File file = new File("hello.txt");
            fr = new FileReader(file);
            char[] cbuf = new char[5];
            int len;
            while ((len = fr.read(cbuf)) != -1) {
                for (int i = 0; i < len; i++) {
                    System.out.print(cbuf[i]);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test
    public void testFileReader() throws IOException {
        File file = new File("hello1.txt");
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("I have a car!");
        fileWriter.close();
    }

    @Test
    public void testReadWrite() {
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            File srcFile = new File("hello.txt");
            File outFile = new File("hello2.txt");

            fileReader = new FileReader(srcFile);
            fileWriter = new FileWriter(outFile);

            char[] cbuf = new char[5];
            int len;

            while ((len = fileReader.read(cbuf)) != -1) {
                fileWriter.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
