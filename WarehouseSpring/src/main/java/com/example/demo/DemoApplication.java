package com.example.demo;

import com.example.consumingwebservice.wsdl.GetInventoryResponse;
import com.example.consumingwebservice.wsdl.InsertItemResponse;
import com.example.consumingwebservice.wsdl.PickItemResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {


	// 	to generate classes run:
	//  ./mvnw compile
	// på windows : mvnw compile
	//  https://spring.io/guides/gs/consuming-web-service/

	private static String returnString;

	@Bean
	CommandLineRunner lookup(Client quoteClient) {
		return args -> {
			if (args.length > 0) {
				if(args[0].equals("test")){
					//System.out.println("arg0 was test");
				}else if (args[0].equals("getInventory")){
					GetInventoryResponse response = quoteClient.getInventory();
					//System.err.println(response.getGetInventoryResult());
					//System.out.println(response.getGetInventoryResult());
					returnString = response.getGetInventoryResult();
				}else if (args[0].equals("insertItem")){
					InsertItemResponse response = quoteClient.insertItem(args[1], Integer.parseInt(args[2]));
					//System.out.println(response.getInsertItemResult());
					returnString = response.getInsertItemResult();
				}else if (args[0].equals("pickItem")){
					PickItemResponse response = quoteClient.pickItem(Integer.parseInt(args[1]));
					//System.out.println(response.getPickItemResult());
					returnString = response.getPickItemResult() ;
				}
			}

		};
	}

	public static String getResponse(String[] args){
		SpringApplication.run(DemoApplication.class, args);
		return returnString;
	}

	public static void main(String[] args) {
		String response = getResponse(args);

		System.out.println("Ran success" );
		System.out.println(response);

	}
}
