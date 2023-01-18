package com.shangguigu.io;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class IOTest {
  @Test
  public void test1() {
     Set<String> set = new HashSet<>();
     StringBuilder sb = new StringBuilder();
     FileReader fr = null;

    try {
      File file = new File("hello.txt");
      fr = new FileReader(file);
      int data = fr.read();
      while (data != -1) {
         if ((char)data == ',') {
           set.add(sb.toString());

           sb = new StringBuilder();
           data = fr.read();
           continue;
         }

         sb.append((char)data);
         data = fr.read();

      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    } finally {
      if (fr != null) {
        try {
          fr.close();
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
    }

    FileWriter fw = null;


    try {
      File outputFile = new File("output.txt");

      fw = new FileWriter(outputFile);

      for (String email : set) {
        System.out.println(email.toString());
        fw.write(email + ", ");
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    } finally {
      if (fw != null) {
        try {
          fw.close();
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
    }


  }

}
