package com.example.demo;

import com.example.consumingwebservice.wsdl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;


public class Client extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(Client.class);

    public GetInventoryResponse getInventory() {

        GetInventory request = new GetInventory();

        log.info("Requesting inventory ");

        GetInventoryResponse response = (GetInventoryResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8081/Service.asmx", request);

        return response;
    }

    public InsertItemResponse insertItem(String name, int trayID) {

        InsertItem request = new InsertItem();
        request.setName(name);
        request.setTrayId(trayID);

        log.info("Request Insert Item " + request.toString());

        InsertItemResponse response = (InsertItemResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8081/Service.asmx", request);

        return response;
    }

    public PickItemResponse pickItem(int trayID) {

        PickItem request = new PickItem();
        request.setTrayId(trayID);

        log.info("Request Pick Item " + request.toString());

        PickItemResponse response = (PickItemResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8081/Service.asmx", request);

        return response;
    }

    public static void main(String[] args) {
        Client client = new Client();
        System.out.println(client.getInventory());
    }

}
