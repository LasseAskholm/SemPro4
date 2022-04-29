import com.example.demo.DemoApplication;

public class TestClass {

    public static void main(String[] args) {

        /* Keywords
        getInventory    :   arg[0] = "getInventory"

        insertItem      :   arg[0] = "insertItem"
                            arg[1] = name (String)
                            arg[2] = trayID (int)

        pickItem        :   arg[0] = "pickItem"
                            arg[1] = trayID (int)
         */


        String[] inventoryRequest = {"getInventory"};
        String[] insertItemRequest = {"insertItem", "Test Name", "2"};
        String[] pickItemRequest = {"pickItem", "2"};

        System.out.println("Initial Inventory");
        DemoApplication.getResponse(inventoryRequest);

        DemoApplication.getResponse(pickItemRequest);

        System.out.println("Inventory after picked item");
        DemoApplication.getResponse(inventoryRequest);

        DemoApplication.getResponse(insertItemRequest);

        System.out.println("Inventory after insert item");
        DemoApplication.getResponse(inventoryRequest);

    }
}
