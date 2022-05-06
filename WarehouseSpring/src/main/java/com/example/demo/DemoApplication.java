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

	@Bean
	CommandLineRunner lookup(Client quoteClient) {
		return args -> {
			System.err.println("Test Err 0");
			if (args.length > 0) {
				System.out.println("args>0" + Arrays.toString(args));
				System.err.println("Test Err 1" );
				if(Objects.equals(args[0], "test")){
					System.out.println("arg0 was test");
				}else if (Objects.equals(args[0], "getInventory")){
					GetInventoryResponse response = quoteClient.getInventory();
					//System.err.println(response.getGetInventoryResult());
					System.out.println(response.getGetInventoryResult());
					System.err.println(response.getGetInventoryResult());
					returnString = response.getGetInventoryResult();
				}else if (Objects.equals(args[0], "insertItem")){
					InsertItemResponse response = quoteClient.insertItem(args[1], Integer.parseInt(args[2]));
					System.out.println(response.getInsertItemResult());
					returnString = response.getInsertItemResult();
				}else if (Objects.equals(args[0], "pickItem")){
					PickItemResponse response = quoteClient.pickItem(Integer.parseInt(args[1]));
					System.out.println(response.getPickItemResult());
					returnString = response.getPickItemResult() ;
				}
			}

		};
	}

	public static void main(String[] args){
		SpringApplication.run(DemoApplication.class, args);
	}

	public static void test(String[] args){
		main(args);
	}
}
