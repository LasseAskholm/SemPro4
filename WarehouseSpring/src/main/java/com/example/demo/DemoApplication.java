package com.example.demo;

import com.example.consumingwebservice.wsdl.GetInventoryResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	// 	to generate classes run:
	//  ./mvnw compile
	//  https://spring.io/guides/gs/consuming-web-service/

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}

	@Bean
	CommandLineRunner lookup(Client quoteClient) {
		return args -> {

			if (args.length > 0) {
				if(args[0] == "test"){
					System.out.println("arg0 was test");
				}else{
					System.out.println("hit else");
				}
				if(args[1] == "inventory"){
					GetInventoryResponse response = quoteClient.getInventory();
					System.err.println(response.getGetInventoryResult());
					System.out.println(response.getGetInventoryResult());
				}

			}

		};
	}

	public static void getInventory(String[] args){
		SpringApplication.run(DemoApplication.class, args);

	}
}
