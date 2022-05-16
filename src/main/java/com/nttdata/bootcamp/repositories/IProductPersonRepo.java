package com.nttdata.bootcamp.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.nttdata.bootcamp.models.ProductPerson;

import reactor.core.publisher.Mono;

public interface IProductPersonRepo extends ReactiveMongoRepository<ProductPerson, String> {
	
	public Mono<ProductPerson> findByIdCustomerPerson(String idCustomerPerson);

}
