package com.nttdata.bootcamp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.bootcamp.models.ProductPerson;
import com.nttdata.bootcamp.services.IServiceProductPerson;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/product-person")
public class ProductPersonController {
	
	@Autowired
	IServiceProductPerson personRepo;
	
	@GetMapping("/find-all")
	public Flux<ProductPerson> findAll() {
		Flux<ProductPerson> persons = personRepo.findAll();
		log.info("all product persons were consulted");
		return persons;
	}
	
	@GetMapping("/find-by-id/{id}")
	public Mono<ProductPerson> findById(@PathVariable String id){
		Mono<ProductPerson> person = personRepo.findById(id);
		log.info("one product enterprises was consulted by id");
		return person;
	}
	
	@GetMapping("/find-by-idCustomerPerson/{id}")
	public Mono<ProductPerson> findByIdCustomerPerson(@PathVariable String id){
		Mono<ProductPerson> person = personRepo.findByIdCustomerPerson(id);
		log.info("one product enterprises was consulted by idCustomerPerson");
		return person;
	}
	
	@PutMapping("/update")
	public Mono<ProductPerson> update(@RequestBody ProductPerson productPerson){
		return personRepo.findById(productPerson.getIdCustomerPerson()).flatMap(c->{
			c.setPersonalCredit(productPerson.getPersonalCredit());
			c.setSavingAccount(productPerson.getSavingAccount());
			c.setCurrentAccount(productPerson.getCurrentAccount());
			c.setFixedTermAccounts(productPerson.getFixedTermAccounts());
			log.info("product person was updated");
			return personRepo.save(c);
		});
		
	}
	
	@PostMapping("/create")
	public Mono<ProductPerson> save(@RequestBody ProductPerson productPerson){
		log.info("product person was created");
		return personRepo.save(productPerson);
	}
	
	@DeleteMapping("/delete/{id}")
	public Mono<Void> delete(@PathVariable String id){
		return personRepo.findById(id).flatMap(c->{
			log.info("product person was deleted");
			return personRepo.delete(c);
		});
	}

}
