package com.nttdata.bootcamp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

import com.nttdata.bootcamp.models.BusinessCredit;
import com.nttdata.bootcamp.models.CurrentAccount;
import com.nttdata.bootcamp.models.FixedTermAccount;
import com.nttdata.bootcamp.models.PersonalCredit;
import com.nttdata.bootcamp.models.ProductEnterprise;
import com.nttdata.bootcamp.models.ProductPerson;
import com.nttdata.bootcamp.models.SavingAccount;
import com.nttdata.bootcamp.repositories.IProductEnterpriseRepo;
import com.nttdata.bootcamp.repositories.IProductPersonRepo;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
@SpringBootApplication
public class BootcampServiceProductApplication implements CommandLineRunner {
	
	@Autowired
	IProductPersonRepo personRepo;
	
	@Autowired
	IProductEnterpriseRepo enterpriseRepo;

	@Autowired
	ReactiveMongoTemplate mongoTemplate;

	public static void main(String[] args) {
		SpringApplication.run(BootcampServiceProductApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		mongoTemplate.dropCollection("product_persons").subscribe();
		
		PersonalCredit pc = PersonalCredit.builder().accountingBalance("100").availableBalance("100").build();
		SavingAccount sa = SavingAccount.builder().accountingBalance("100").maintenance("2").movementLimit("2").build();
		CurrentAccount  ca = CurrentAccount.builder().accountingBalance("150").maintenance("5").build();
		FixedTermAccount fta = FixedTermAccount.builder().accountingBalance("133").movementDay("01").build();
		List<FixedTermAccount> lfta = new ArrayList<>();
		lfta.add(fta);
		
		Flux.just(ProductPerson.builder()
				.personalCredit(pc)
				.savingAccount(sa)
				.currentAccount(ca)
				.fixedTermAccounts(lfta).build()).flatMap(c->{
					return personRepo.save(c);
				}).subscribe(p->log.info("Se ingreso productperson: "+p));

		
		mongoTemplate.dropCollection("product_enterprises").subscribe();
		
		List<BusinessCredit> businessCredits = new ArrayList<>();
		BusinessCredit bc1 = BusinessCredit.builder().accountingBalance("524").availableBalance("543").build();
		BusinessCredit bc2 = BusinessCredit.builder().accountingBalance("524").availableBalance("543").build();
		businessCredits.add(bc1);
		businessCredits.add(bc2);
		List<CurrentAccount> currentAccounts = new ArrayList<>();
		CurrentAccount ca1 = CurrentAccount.builder().accountingBalance("159").maintenance("456").build();
		CurrentAccount ca2 = CurrentAccount.builder().accountingBalance("159").maintenance("456").build();
		currentAccounts.add(ca1);
		currentAccounts.add(ca2);
		
		Flux.just(ProductEnterprise.builder()
				.businessCredits(businessCredits)
				.currentAccounts(currentAccounts)
				.build()).flatMap(z->{
					return enterpriseRepo.save(z); 
				}).subscribe(p->log.info("se inserto product enterprise:"+ p));
		
	}

}
