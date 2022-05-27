package com.example.AGV;

import com.example.AGV.state.StatusController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.util.Arrays;
import java.util.Objects;

@SpringBootApplication
public class AgvApplication {

	StatusController con = new StatusController();
	private static String returnString;

	public static void main(String[] args) {
		SpringApplication.run(AgvApplication.class, args);
	}

	@Bean
	CommandLineRunner lookup(StatusController con) {
		return args -> {
			System.err.println("Test Err 0");
			if (args.length > 0) {
				System.out.println("args>0" + Arrays.toString(args));
				System.err.println("Test Err 1");
				if (Objects.equals(args[0], "test")) {
					System.out.println("arg0 was test");

				} else if (Objects.equals(args[0], "MoveToChargerOperation")) {
					con.moveToChargerOperation();

				} else if (Objects.equals(args[0], "MoveToAssemblyOperation")) {
					con.moveToAssemblyOperation();

				} else if (Objects.equals(args[0], "MoveToStorageOperation")) {
					con.moveToStorageOperation();

				} else if (Objects.equals(args[0], "PutAssemblyOperation")) {
					con.putAssemblyOperation();

				} else if (Objects.equals(args[0], "PickAssemblyOperation")) {
					con.pickAssemblyOperation();

				} else if (Objects.equals(args[0], "PickWarehouseOperation")) {
					con.pickWarehouseOperation();

				} else if (Objects.equals(args[0], "PutWarehouseOperation")) {
					con.putWarehouseOperation();

				} else if (Objects.equals(args[0], "GetStatus")) {
					System.out.println(con.getStatusRequest());
					System.exit(1);
				}
			}
		};
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
