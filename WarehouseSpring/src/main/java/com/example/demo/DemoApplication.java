package com.example.demo;

import com.example.consumingwebservice.wsdl.GetInventoryResponse;
import com.example.consumingwebservice.wsdl.InsertItemResponse;
import com.example.consumingwebservice.wsdl.PickItemResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.Objects;

@SpringBootApplication
public class DemoApplication {

	// 	to generate classes run:
	//  ./mvnw compile
	// på windows : mvnw compile
	//  https://spring.io/guides/gs/consuming-web-service/

	private static String returnString;

	//Checks the arguments in the commandline when run and executes appropriate actions.
	@Bean
	CommandLineRunner lookup(Client quoteClient) {
		return args -> {
			if (args.length > 0) {
				if (Objects.equals(args[0], "getInventory")){
					System.err.println("Received inventory operation.");
				}else if (Objects.equals(args[0], "insertItem")){
					InsertItemResponse response = quoteClient.insertItem(args[1], Integer.parseInt(args[2]));
					System.err.println(response.getInsertItemResult());
				}else if (Objects.equals(args[0], "pickItem")){
					PickItemResponse response = quoteClient.pickItem(Integer.parseInt(args[1]));
					System.err.println(response.getPickItemResult());
				}
				GetInventoryResponse response = quoteClient.getInventory();
				System.err.println(response.getGetInventoryResult());
			}
		};
	}
	public static void main(String[] args){
		SpringApplication.run(DemoApplication.class, args);
	}
}
