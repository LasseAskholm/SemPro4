package org.openjfx;



import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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


        String filename = String.valueOf(getClass().getResource("/WarehouseSpring-0.0.1-SNAPSHOT.jar"));
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

        Process process = Runtime.getRuntime().exec("java -jar WarehouseSpring-0.0.1-SNAPSHOT.jar getInventory");
        InputStream in = process.getInputStream();
        InputStream err = process.getErrorStream();

        


    }
}
