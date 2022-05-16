package com.nttdata.bootcamp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.bootcamp.models.ProductPerson;
import com.nttdata.bootcamp.repositories.IProductPersonRepo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductPersonImp implements IServiceProductPerson {
	
	@Autowired
	IProductPersonRepo personRepo;

	@Override
	public Flux<ProductPerson> findAll() {
		return personRepo.findAll();
	}

	@Override
	public Mono<ProductPerson> findById(String id) {
		return personRepo.findById(id);
	}

	@Override
	public Mono<ProductPerson> findByIdCustomerPerson(String idCustomerPerson) {
		return personRepo.findByIdCustomerPerson(idCustomerPerson);
	}

	@Override
	public Mono<ProductPerson> save(ProductPerson productPerson) {
		return personRepo.save(productPerson);
	}

	@Override
	public Mono<Void> delete(ProductPerson productPerson) {
		return personRepo.delete(productPerson);
	}

}
