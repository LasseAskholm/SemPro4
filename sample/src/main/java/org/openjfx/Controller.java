package org.openjfx;



import javafx.scene.control.TextArea;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;


public class Controller {


    public TextArea text;

    public void initialize() throws IOException, InterruptedException {

        String answer = getInventory();

        this.text.setText(answer);

    }

    private String getInventory() throws IOException, InterruptedException {

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


        File file = new File("../SemPro4/sample/src/main/resources/WarehouseSpring-0.0.1-SNAPSHOT.jar");
        String filePath = file.getPath();

        String[] args = new String[]{"getInventory"};

        Process process = Runtime.getRuntime().exec("java -jar "+ filePath +" " + args[0]);
        InputStream in = process.getInputStream();
        InputStream err = process.getErrorStream();

        return new String(err.readAllBytes(), StandardCharsets.UTF_8);

    }
}
