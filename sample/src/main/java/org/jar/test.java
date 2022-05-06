package org.jar;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class test {

    public static void main(String[] args) throws IOException {
        test();
    }

    private static void test() throws IOException {
        Process process = Runtime.getRuntime().exec("java -jar /home/atj/github/remake/SemPro4/sample/src/main/java/org/jar/WarehouseSpring-0.0.1-SNAPSHOT.jar getInventory");
        InputStream in = process.getInputStream();
        InputStream err = process.getErrorStream();

        StringBuilder sb = new StringBuilder();
        for (int ch; (ch = err.read()) != -1; ) {
            sb.append((char) ch);
        }

        System.out.println(sb.toString());
    }

}
