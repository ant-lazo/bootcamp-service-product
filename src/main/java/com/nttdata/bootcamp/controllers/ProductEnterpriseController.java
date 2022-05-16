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

import com.nttdata.bootcamp.models.ProductEnterprise;
import com.nttdata.bootcamp.services.IServiceProductEnterprise;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/product-enterprise")
public class ProductEnterpriseController {
	
	@Autowired
	IServiceProductEnterprise enterpriseRepo;
	
	@GetMapping("/find-all")
	public Flux<ProductEnterprise> findAll() {
		Flux<ProductEnterprise> persons = enterpriseRepo.findAll();
		log.info("all product enterprises were consulted");
		return persons;
	}
	
	@GetMapping("/find-by-id/{id}")
	public Mono<ProductEnterprise> findById(@PathVariable String id){
		Mono<ProductEnterprise> person = enterpriseRepo.findById(id);
		log.info("one product enterprise was consulted by id");
		return person;
	}
	
	@GetMapping("/find-by-idEnterprisePerson/{id}")
	public Mono<ProductEnterprise> findByIdCustomerEnterprise(@PathVariable String id){
		Mono<ProductEnterprise> enterprise = enterpriseRepo.findByIdCustomerEnterprise(id);
		log.info("one product enterprises was consulted by idEnterprisePerson");
		return enterprise;
	}
	
	@PutMapping("/update")
	public Mono<ProductEnterprise> update(@RequestBody ProductEnterprise productEnterprise){
		return enterpriseRepo.findById(productEnterprise.getIdCustomerEnterprise()).flatMap(c->{
			c.setBusinessCredits(productEnterprise.getBusinessCredits());
			c.setCurrentAccounts(productEnterprise.getCurrentAccounts());
			log.info("product enterprise was updated");
			return enterpriseRepo.save(c);
		});
		
	}
	
	@PostMapping("/create")
	public Mono<ProductEnterprise> save(@RequestBody ProductEnterprise productPerson){
		log.info("product enterprise was created");
		return enterpriseRepo.save(productPerson);
	}
	
	@DeleteMapping("/delete/{id}")
	public Mono<Void> delete(@PathVariable String id){
		return enterpriseRepo.findById(id).flatMap(c->{
			log.info("product enterprise was deleted");
			return enterpriseRepo.delete(c);
		});
	}
}
