import SOAPServices.IEmulatorService;
import SOAPServices.IEmulatorService_Service;

public class SoapClient{

    private IEmulatorService_Service service;
    private IEmulatorService emulatorService;
    public SoapClient() {


        service = new IEmulatorService_Service();

        emulatorService = service.getBasicHttpBindingIEmulatorService();

        System.out.println(emulatorService.getInventory());


    }

    public static void main(String[] args) {
        SoapClient soapClient = new SoapClient();
    }

}
