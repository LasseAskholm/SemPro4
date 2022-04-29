package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.example.consumingwebservice.wsdl.GetInventoryResponse;
import com.example.consumingwebservice.wsdl.GetInventory;


public class Client extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(Client.class);

    public GetInventoryResponse getInventory() {

        GetInventory request = new GetInventory();

        log.info("Requesting inventory ");

        GetInventoryResponse response = (GetInventoryResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8081/Service.asmx", request);

        return response;
    }

    public static void main(String[] args) {
        Client client = new Client();
        System.out.println(client.getInventory());
    }

}
