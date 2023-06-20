package com.infolog.InfologServices;

import com.infolog.InfologServices.model.Account;
import com.infolog.InfologServices.model.Client;
import com.infolog.InfologServices.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class InfologServicesApplication implements CommandLineRunner {

	@Autowired
	private ClientService service;

	public static void main(String[] args) {
		SpringApplication.run(InfologServicesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Client client = new Client();
		client.setName("AHMANY DAN-BAIBE");

		Account account = new Account();
		account.setType("current account");
		account.setBalance(BigDecimal.valueOf(50));
		account.setNumber("X00B01D20171");
		Account account1 = new Account();
		account1.setType("saving account");
		account1.setBalance(BigDecimal.valueOf(60));
		account1.setNumber("X00B01D20172");

		client.addAccount(account);
		client.addAccount(account1);

		//Client client1 = service.saveClient(client);


		//System.out.println(client1);

		System.out.println("It's Ok!");
		System.out.println("c'est du n'importe quoi là!");
	}
}
