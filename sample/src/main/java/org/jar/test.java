package org.jar;

import java.io.IOException;
import java.io.InputStream;

public class test {

    public static void main(String[] args) throws IOException {
        test();
    }

    private static void test() throws IOException {
        Process process = Runtime.getRuntime().exec("java -jar WarehouseSpring-0.0.1-SNAPSHOT.jar getInventory");
        InputStream in = process.getInputStream();
        InputStream err = process.getErrorStream();

        System.out.println(err.available());
    }

}
