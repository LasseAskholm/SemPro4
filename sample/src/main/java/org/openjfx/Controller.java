package org.openjfx;



import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.jar.JarFile;


public class Controller {


    public void initialize() throws IOException, InterruptedException {

        callWarehouse();

    }

    private void callWarehouse() throws IOException, InterruptedException {

        /**
         *      getInventory    :   arg[0] = "getInventory"
         *
         *         insertItem      :   arg[0] = "insertItem"
         *                             arg[1] = name (String)
         *                             arg[2] = trayID (int)
         *
         *         pickItem        :   arg[0] = "pickItem"
         *                             arg[1] = trayID (int)
         */


        URL file = getClass().getResource("/WarehouseSpring-0.0.1-SNAPSHOT.jar");
        //String filename = "WarehouseSpring-0.0.1-SNAPSHOT.jar";
        String[] args = new String[]{"getInventory"};

/*
        ProcessBuilder pb = new ProcessBuilder("java", "-jar", filename, "getInventory");
        Process p = pb.start();

        System.out.println(p.info());

        InputStream in = p.getInputStream();
        InputStream err = p.getErrorStream();

        System.out.println(in.available());
        */

        Process process = Runtime.getRuntime().exec("java -jar " + file.getPath() + " getInventory");
        InputStream in = process.getInputStream();
        InputStream err = process.getErrorStream();


        StringBuilder sb = new StringBuilder();
        for (int ch; (ch = err.read()) != -1; ) {
            sb.append((char) ch);
        }

        System.out.println(sb.toString());


    }
}
