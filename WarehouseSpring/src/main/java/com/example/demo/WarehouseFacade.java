package com.example.demo;

public class WarehouseFacade {

    private static WarehouseFacade singleton;

    public static WarehouseFacade getInstance(){
        if(singleton == null){
            singleton = new WarehouseFacade();
        }
        return singleton;
    }

    public String getInventory(){
        String[] inventoryRequest = {"getInventory"};
        return DemoApplication.getResponse(inventoryRequest);
    }

    public String pickItem(int trayID){
        String[] pickItemRequest = {"pickItem", String.valueOf(trayID)};
        return DemoApplication.getResponse(pickItemRequest);
    }

    public String insertItem(String name, int trayID){
        String[] insertItemRequest = {"insertItem", name, String.valueOf(trayID)};
        return DemoApplication.getResponse(insertItemRequest);
    }

    public static void main(String[] args) {

        /* Keywords
        getInventory    :   arg[0] = "getInventory"

        insertItem      :   arg[0] = "insertItem"
                            arg[1] = name (String)
                            arg[2] = trayID (int)

        pickItem        :   arg[0] = "pickItem"
                            arg[1] = trayID (int)

        All args must be passed as strings. Type conversion is handled in application.
        getResponse returns a String, where only getInventory is data.
        Pick and insert response is success or faliure

        Have not tested edgecases/faulty input for args
         */

        String[] inventoryRequest = {"getInventory"};
        String[] insertItemRequest = {"insertItem", "Test Name", "2"};
        String[] pickItemRequest = {"pickItem", "2"};

        System.out.println("Initial Inventory");
        DemoApplication.getResponse(inventoryRequest);

        String pick = DemoApplication.getResponse(pickItemRequest);

        System.out.println("Inventory after picked item");

        DemoApplication.getResponse(inventoryRequest);

        String insert = DemoApplication.getResponse(insertItemRequest);

        System.out.println("Inventory after insert item");
        String inventoryString = DemoApplication.getResponse(inventoryRequest);

        System.out.println(pick);
        System.out.println(insert);
        System.out.println(inventoryString);
    }
}
