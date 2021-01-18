package org.braham.clientservice;

import org.braham.clientservice.entity.Client;
import org.braham.clientservice.repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class ClientServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ClientRepository clientRepository){
		return args -> {
			getAllClient().stream().forEach(client -> {
				clientRepository.save(client);
			});


		};
	}

	public static List<Client> getAllClient(){
		return Stream.of(
				new Client(null, "Saif","saif.braham@gmail.com", Arrays.asList(22897419,73897419),"Rue Ahmed Zeki"),
				new Client(null, "Malek","malek.braham@gmail.com", Arrays.asList(29661122,73661122),"Rue Abraham mlincon"),
				new Client(null, "Ryan","ryan.braham@gmail.com", Arrays.asList(22123456),"Rue Adolf hitler"),
				new Client(null, "Aylan","aylan.braham@gmail.com", Arrays.asList(22526341),"Rue habib bourguiba"),
				new Client(null, "Ryana","ryana.braham@gmail.com", Arrays.asList(22526341),"6em Avenue ")


		).collect(Collectors.toList());
	}

}
